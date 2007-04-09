/*
 * Copyright 2007 Tim Peierls
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.directwebremoting.guice;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

/**
 * A scope that looks up providers in a current context, using itself as a
 * provider for the context.
 * @author Tim Peierls [tim at peierls dot net]
 */
public interface ContextScope<C> extends Scope, Provider<C> 
{    
    /**
     * Returns a provider that finds the instance map corresponding to
     * the current context and returns the object associated
     * with the given key, creating it if it doesn't exist in that map.
     */
    <T> Provider<T> scope(final Key<T> key, final Provider<T> creator);

    /**
     * The context identifier used to look up Guice (key, creator) pairs. 
     * The value returned is a function of the current context.
     */
    C get();
    
    /**
     * The type of object used as a context identifier.
     */
    Class<C> type();    
}
