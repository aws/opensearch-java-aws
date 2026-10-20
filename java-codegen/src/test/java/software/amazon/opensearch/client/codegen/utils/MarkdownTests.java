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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MarkdownTests {
    @Test
    public void toJavaDocHtml_withLiteralCommentTerminator_shouldNeutralizeIt() {
        // A code span preserves literal text through commonmark, so the comment
        // terminator reaches the escaper verbatim (outside a code span, markdown
        // would consume the asterisks as emphasis).
        var input = "run `*/ static {} /*` now";
        var html = Markdown.toJavaDocHtml(input);
        assertFalse(html.contains("*/"), "comment terminator must not survive: " + html);
        assertTrue(html.contains("*&#47;"), "terminator should be escaped: " + html);
    }

    @Test
    public void toJavaDocHtml_withBackslash_shouldEscapeIt() {
        var html = Markdown.toJavaDocHtml("a\\b");
        assertFalse(html.contains("\\"), "backslash must not survive: " + html);
        assertEquals("a&#92;b", html);
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" must not break out of a Javadoc comment")
    @ValueSource(strings = {
        "plain description",
        "has */ terminator",
        "trailing backslash \\",
        "nested /* comment */ markers",
        "unicode-ish \\u0041 text" })
    public void toJavaDocHtml_shouldNeverEmitCommentTerminatorOrBackslash(String input) {
        var html = Markdown.toJavaDocHtml(input);
        assertFalse(html.contains("*/"), "comment terminator survived: " + html);
        assertFalse(html.contains("\\"), "backslash survived: " + html);
    }

    @Test
    public void toJavaDocHtml_withRegularMarkdown_shouldStillRender() {
        var html = assertDoesNotThrow(() -> Markdown.toJavaDocHtml("See the [docs]({{site.url}}{{site.baseurl}}/api/)."));
        assertFalse(html.contains("{{site.url}}"), "placeholder must be replaced");
        assertFalse(html.contains("*/"));
        assertFalse(html.contains("\\"));
    }

    @Test
    public void toJavaDocHtml_whenBackslashUWouldSurvive_shouldFailClosed() {
        // commonmark emits the raw text for a fenced code span, so a
        // backslash-then-u sequence inside backticks reaches the escaper.
        // Escaping the backslash removes it; this test asserts no such sequence
        // is ever emitted (it would otherwise be decoded by javac into a char).
        var html = Markdown.toJavaDocHtml("`\\u002a\\u002f`");
        assertFalse(html.contains("\\u"), "no backslash-then-u may be emitted: " + html);
    }

    @Test
    public void toJavaDocHtml_withPlainText_shouldNotThrow() {
        var html = assertDoesNotThrow(() -> Markdown.toJavaDocHtml("plain description text"));
        assertEquals("plain description text", html);
    }
}
