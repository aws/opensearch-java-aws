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

    @Nonnull
    public static String toJavaDocHtml(@Nonnull String markdown) {
        var html = RENDERER.render(PARSER.parse(markdown)).strip();
        html = SITE_URL_PLACEHOLDER.matcher(html).replaceAll(SITE_URL_REPLACEMENT);
        html = SITE_BASE_URL_PLACEHOLDER.matcher(html).replaceAll(SITE_BASE_URL_REPLACEMENT);
        return html;
    }
}
