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
import com.google.inject.util.ToStringBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Partial implementation of {@link ContextScope}. Concrete implementations
 * must pass the context identifier type to this super-constructor and define
 * {@code get()} to return the current context identifier.
 * @author Tim Peierls [tim at peierls dot net]
 */
public abstract class AbstractContextScope<C> implements ContextScope<C>
{        
    public <T> Provider<T> scope(final Key<T> key, final Provider<T> creator) 
    {
        return new Provider<T>() 
        {
            public T get() 
            {
                C context = getContext(key);
                ConcurrentMap<Key<T>, Future<T>> instanceMap = getInstanceMap(context);
                Future<T> future = getFuture(instanceMap);
                return getValueFromFuture(future);
            }

            public String toString() 
            {
                return new ToStringBuilder(this.getClass())
                    .add("type", type)
                    .add("key", key)
                    .add("creator", creator)
                    .toString();
            }

            private ConcurrentMap<Key<T>, Future<T>> getInstanceMap(C context)
            {
                @SuppressWarnings("unchecked")
                ConcurrentMap<Key<T>, Future<T>> instanceMap =
                    (ConcurrentMap<Key<T>, Future<T>>) map.get(context);

                if (instanceMap == null) 
                {
                    ConcurrentMap<Key<T>, Future<T>> emptyMap = 
                        new ConcurrentHashMap<Key<T>, Future<T>>();
                    instanceMap = map.putIfAbsent(context, emptyMap);
                    if (instanceMap == null) 
                    {
                        instanceMap = emptyMap;
                    }
                }

                return instanceMap;
            }

            private Future<T> getFuture(ConcurrentMap<Key<T>, Future<T>> instanceMap)
            {
                Future<T> future = instanceMap.get(key);
                
                if (future == null) {
                    FutureTask<T> futureTask = new FutureTask<T>(new Callable<T>() 
                    {
                        public T call() 
                        {
                            return creator.get(); 
                        }
                    });
                    future = instanceMap.putIfAbsent(key, futureTask);
                    if (future == null) 
                    { 
                        future = futureTask;
                        futureTask.run(); 
                        if (Thread.currentThread().isInterrupted()) 
                        {
                            instanceMap.remove(key, futureTask);
                        }
                    }
                }

                return future;
            }
            
            private T getValueFromFuture(Future<T> future)
            {
                try 
                {
                    return future.get();
                } 
                catch (InterruptedException e) 
                {
                    Thread.currentThread().interrupt();
                    return null;
                } 
                catch (ExecutionException ex) 
                {
                    Throwable e = ex.getCause();
                    if (e instanceof RuntimeException)
                    {
                        throw (RuntimeException) e;
                    }
                    else
                    {
                        throw new IllegalStateException("unexpected Exception", e);
                    }
                }
            }
        };
    }

    public abstract C get();


    public Class<C> type() 
    {
        return type;
    }

    
    protected AbstractContextScope(Class<C> type) 
    {
        this.type = type;
    }

    
    private C getContext(Key<?> key)
    {
        C context = null;
        RuntimeException caught = null;
        try
        {
            context = get();
        }
        catch (RuntimeException ex)
        {
            caught = ex;
        }
        if (context == null)
        {
            throw new OutOfScopeException(this, key, caught);
        }
        
        return context;
    }
    
    private final Class<C> type;
    
    private final ConcurrentMap<C, ConcurrentMap> map =
          new ConcurrentHashMap<C, ConcurrentMap>();
}
