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
package me.ezjs.generator.mybatis.config;

import me.ezjs.generator.mybatis.internal.util.messages.Messages;

import static me.ezjs.generator.mybatis.internal.util.messages.Messages.getString;

/**
 * Typesafe util of different model types
 *
 * @author Jeff Butler
 */
public enum ModelType {
    HIERARCHICAL("hierarchical"), //$NON-NLS-1$
    FLAT("flat"), //$NON-NLS-1$
    CONDITIONAL("conditional"); //$NON-NLS-1$

    private final String modelType;

    /**
     *
     */
    private ModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelType() {
        return modelType;
    }

    public static ModelType getModelType(String type) {
        if (HIERARCHICAL.getModelType().equalsIgnoreCase(type)) {
            return HIERARCHICAL;
        } else if (FLAT.getModelType().equalsIgnoreCase(type)) {
            return FLAT;
        } else if (CONDITIONAL.getModelType().equalsIgnoreCase(type)) {
            return CONDITIONAL;
        } else {
            throw new RuntimeException(Messages.getString(
                    "RuntimeError.13", type)); //$NON-NLS-1$
        }
    }
}
