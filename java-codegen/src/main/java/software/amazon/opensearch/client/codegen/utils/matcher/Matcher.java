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
package software.amazon.opensearch.client.codegen.utils.matcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public interface Matcher<T> {
    boolean matches(T t);

    static <T> Matcher<T> all() {
        return t -> true;
    }

    static <T> Matcher<T> none() {
        return t -> false;
    }

    static <T> Matcher<T> not(Matcher<T> matcher) {
        return t -> !matcher.matches(t);
    }

    @SafeVarargs
    static <T> Matcher<T> or(Matcher<T>... matchers) {
        return t -> {
            for (Matcher<T> matcher : matchers) {
                if (matcher.matches(t)) {
                    return true;
                }
            }
            return false;
        };
    }

    @SafeVarargs
    static <T> Matcher<T> and(Matcher<T>... matchers) {
        return t -> {
            for (Matcher<T> matcher : matchers) {
                if (!matcher.matches(t)) {
                    return false;
                }
            }
            return true;
        };
    }

    static <T> Matcher<T> isNull() {
        return Objects::isNull;
    }

    static <T> Matcher<T> is(T value) {
        return v -> Objects.equals(v, value);
    }

    static <T> Matcher<T> isNot(T value) {
        return not(is(value));
    }

    @SafeVarargs
    static <T> Matcher<T> isOneOf(T... values) {
        var set = new HashSet<>(Arrays.asList(values));
        return set::contains;
    }

    @SafeVarargs
    static <T> Matcher<T> isNotOneOf(T... values) {
        return not(isOneOf(values));
    }
}
