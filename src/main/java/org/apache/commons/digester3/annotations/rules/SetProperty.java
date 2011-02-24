/* $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.digester3.annotations.rules;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.digester3.annotations.DigesterRule;
import org.apache.commons.digester3.annotations.DigesterRuleList;
import org.apache.commons.digester3.annotations.handlers.SetPropertiesHandler;
import org.apache.commons.digester3.rule.SetPropertiesRule;

/**
 * Fields annotated with {@code SetProperty} will be bound
 * with {@code SetPropertiesRule} digester rule.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@DigesterRule(
    reflectsRule = SetPropertiesRule.class,
    handledBy = SetPropertiesHandler.class
)
public @interface SetProperty {

    /**
     * The element matching pattern.
     *
     * @return the element matching pattern.
     */
    String pattern();

    /**
     * The namespace URI for which this Rule is relevant, if any.
     */
    String namespaceURI() default "";

    /**
     * The overridden parameter.
     *
     * @return the overridden parameter.
     */
    String attributeName() default "";

    /**
     * Defines several {@code @SetProperty} annotations on the same element.
     *
     * @see SetProperty
     */
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @DigesterRuleList
    @interface List {
        SetProperty[] value();
    }

}
