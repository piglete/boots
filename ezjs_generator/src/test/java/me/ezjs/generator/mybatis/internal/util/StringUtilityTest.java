/**
 * Copyright 2006-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.ezjs.generator.mybatis.internal.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilityTest {

    @Test
    public void testNoCatalog() {
        String answer = StringUtility.composeFullyQualifiedTableName(null, "schema", "table", '.');
        assertEquals("schema.table", answer);
    }

    @Test
    public void testNoSchema() {
        String answer = StringUtility.composeFullyQualifiedTableName("catalog", null, "table", '.');
        assertEquals("catalog..table", answer);
    }

    @Test
    public void testAllPresent() {
        String answer = StringUtility.composeFullyQualifiedTableName("catalog", "schema", "table", '.');
        assertEquals("catalog.schema.table", answer);
    }

    @Test
    public void testTableOnly() {
        String answer = StringUtility.composeFullyQualifiedTableName(null, null, "table", '.');
        assertEquals("table", answer);
    }
}