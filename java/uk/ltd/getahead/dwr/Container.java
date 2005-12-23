/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ltd.getahead.dwr;

/**
 * A very basic IoC container
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public interface Container
{
    /**
     * Get an instance of a bean of a given type.
     * @param id The type to get an instance of
     * @return The object of the given type
     * @throws IllegalArgumentException If the given id does not refer to a bean
     */
    Object getBean(String id) throws IllegalArgumentException;

    /**
     * It might be good if we could allow components to re-configure DWR on the
     * fly, however Spring makes it a bit hard by hiding this behind an
     * ConfigurableBeanFactory interface which isn't the default. There is
     * probably a good reason for this, so we'll hold off this for now.
     * @param id The name to register a bean against
     * @param bean The object to register
     */
    //void setBean(String id, Object bean);
}
