/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package software.amazon.opensearch.client.codegen.utils;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public final class Markdown {
    private Markdown() {}

    private static final Parser PARSER = Parser.builder().build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().escapeHtml(true).omitSingleParagraphP(true).build();

    private static final Pattern SITE_URL_PLACEHOLDER = Pattern.compile("\\{\\{site.url}}");
    private static final String SITE_URL_REPLACEMENT = "https://opensearch.org";
    private static final Pattern SITE_BASE_URL_PLACEHOLDER = Pattern.compile("\\{\\{site.baseurl}}");
    private static final String SITE_BASE_URL_REPLACEMENT = "/docs/latest";

    // Matches a leftover backslash-u sequence, which javac decodes into a
    // Unicode character before tokenizing (JLS 3.3). After escaping has run
    // there should be none left, so any match means text could still break out
    // of the generated comment.
    private static final Pattern UNICODE_ESCAPE = Pattern.compile("\\\\u");

    @Nonnull
    public static String toJavaDocHtml(@Nonnull String markdown) {
        var html = RENDERER.render(PARSER.parse(markdown)).strip();
        html = SITE_URL_PLACEHOLDER.matcher(html).replaceAll(SITE_URL_REPLACEMENT);
        html = SITE_BASE_URL_PLACEHOLDER.matcher(html).replaceAll(SITE_BASE_URL_REPLACEMENT);
        html = escapeJavaDoc(html);
        return html;
    }

    // The rendered text is written verbatim into a /* */ Javadoc comment, so it
    // must not be able to close the comment or contain a Unicode escape that
    // javac would decode into one. commonmark's HTML escaping only covers
    // & < > ", so neutralize the remaining comment-breaking sequences here.
    @Nonnull
    private static String escapeJavaDoc(@Nonnull String html) {
        // Escape every backslash first so no \\uXXXX escape can survive to be
        // decoded by javac into an arbitrary character (including */).
        var escaped = html.replace("\\", "&#92;");
        // Escape any literal comment terminator so it cannot end the Javadoc.
        escaped = escaped.replace("*/", "*&#47;");
        // Fail the build if a backslash-u somehow remains, rather than emit it.
        if (UNICODE_ESCAPE.matcher(escaped).find()) {
            throw new IllegalArgumentException("Refusing to emit Javadoc containing a \\u escape sequence: " + html);
        }
        return escaped;
    }
}
