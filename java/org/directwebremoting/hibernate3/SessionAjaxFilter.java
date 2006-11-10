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
package org.directwebremoting.hibernate3;

import java.lang.reflect.Method;

import javax.servlet.ServletContext;

import org.directwebremoting.AjaxFilter;
import org.directwebremoting.AjaxFilterChain;
import org.directwebremoting.WebContextFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 * An {@link AjaxFilter} that uses DWR Hibernate support classes to do a
 * {@link Session#beginTransaction()} before passing the control on to the chain
 * and a {@link Transaction#commit()} after.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class SessionAjaxFilter implements AjaxFilter
{
    /* (non-Javadoc)
     * @see org.directwebremoting.AjaxFilter#doFilter(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], org.directwebremoting.AjaxFilterChain)
     */
    public Object doFilter(Object object, Method method, Object[] params, AjaxFilterChain chain) throws Exception
    {
        ServletContext context = WebContextFactory.get().getServletContext();
        SessionFactory sessionFactory = (SessionFactory) context.getAttribute(ATTRIBUTE_SESSION);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Object reply = chain.doFilter(object, method, params);

        session.getTransaction().commit();

        return reply;
    }

    /**
     * Assigns a {@link SessionFactory} to a {@link ServletContext} so DWR knows
     * how to get hold of a {@link org.hibernate.Session}.
     * @param context The Servlet environment to store the ServletContext in
     * @param sessionFactory The Hibernate session factory to register
     */
    public static void setSessionFactory(ServletContext context, SessionFactory sessionFactory)
    {
        context.setAttribute(ATTRIBUTE_SESSION, sessionFactory);
    }

    /**
     * Under what name do we store the session factory?
     */
    protected static final String ATTRIBUTE_SESSION = "org.directwebremoting.hibernate3.SessionFactory";
}
