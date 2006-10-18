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
package org.directwebremoting.contrib;

import java.util.ResourceBundle;

import org.directwebremoting.extend.Call;
import org.directwebremoting.extend.Calls;
import org.directwebremoting.extend.Replies;
import org.directwebremoting.extend.Reply;
import org.directwebremoting.impl.DefaultRemoter;
import org.directwebremoting.util.Logger;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutionException;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;

/**
 * Remoter implementation executing in parallel a group of remote calls
 * @author <a href="mailto:chussenet@yahoo.com">Claude Hussenet</a>
 */
public class ParallelDefaultRemoter extends DefaultRemoter
{
    class OneCall implements Callable
    {
        private Call call;

        public OneCall(Call call)
        {
            this.call = call;
        }

        public Object call()
        {
            return execute(call);
        }
    }

    /**
     * Execute a set of remote calls in parallel and generate set of reply data for later
     * conversion to whatever wire protocol we are using today.
     * @param calls The set of calls to execute in parallel
     * @return A set of reply data objects
     */
    public Replies execute(Calls calls)
    {
        Replies replies = new Replies();
        Future future[] = new Future[calls.getCallCount()];
        if (calls.getCallCount() == 1)
            return super.execute(calls);
        else
        {
            for (int callNum = 0; callNum < calls.getCallCount(); callNum++)
            {
                Call call = calls.getCall(callNum);
                future[callNum] = executorService.submit(new OneCall(call));
            }
            for (int callNum = 0; callNum < calls.getCallCount(); callNum++)
            {
                try
                {
                    Reply reply = (Reply) future[callNum].get(Long.parseLong(getString(TIMEOUT, DEFAULT_TIMEOUT)), TimeUnit.MILLISECONDS);
                    replies.addReply(reply);
                }
                catch (InterruptedException ex)
                {
                    log.warn("Method execution failed: ", ex);
                    replies.addReply(new Reply(calls.getCall(callNum).getId(), null, ex));
                }
                catch (ExecutionException ex)
                {
                    log.warn("Method execution failed: ", ex);
                    replies.addReply(new Reply(calls.getCall(callNum).getId(), null, ex));
                }
                catch (TimeoutException ex)
                {
                    log.warn("Method execution failed: ", ex);
                    replies.addReply(new Reply(calls.getCall(callNum).getId(), null, ex));
                }
            }
            return replies;
        }
    }

    private static String getString(String key, String defaultValue)
    {

        try
        {
            if (RESOURCE_BUNDLE == null)
                return defaultValue;
            String value = RESOURCE_BUNDLE.getString(key);
            if (value == null)
                return defaultValue;
            else
                return value;
        }
        catch (Exception e)
        {

        }
        return defaultValue;
    }

    private static final Logger log = Logger.getLogger(ParallelDefaultRemoter.class);

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("org.directwebremoting.impl.ParallelDefaultRemoter");

    private static final String DEFAULT_MIN_THREAD = "10";

    private static final String DEFAULT_MAX_THREAD = "100";

    private static final String DEFAULT_KEEP_ALIVE = "5000";

    private static final String DEFAULT_TIMEOUT = "10000";

    private static final String MIN_POOL_SIZE = "ExecutorService.minimumPoolsize";

    private static final String MAX_POOL_SIZE = "ExecutorService.maximumPoolsize";

    private static final String KEEP_ALIVE = "ExecutorService.keepAlive";

    private static final String TIMEOUT = "ExecutorService.timeout";

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    static
    {
        ((ThreadPoolExecutor) executorService).setCorePoolSize(Integer.parseInt(getString(MIN_POOL_SIZE, DEFAULT_MIN_THREAD)));
        ((ThreadPoolExecutor) executorService).setMaximumPoolSize(Integer.parseInt(getString(MAX_POOL_SIZE, DEFAULT_MAX_THREAD)));
        ((ThreadPoolExecutor) executorService).setKeepAliveTime(Integer.parseInt(getString(KEEP_ALIVE, DEFAULT_KEEP_ALIVE)), TimeUnit.MILLISECONDS);
        log.info(executorService.getClass().getName().indexOf("edu.emory.mathcs.backport") > -1 ? "Backport of java.util.concurrent package used !" : "java.util.concurrent package used !");
        log.info("CorePoolSize set at " + ((ThreadPoolExecutor) executorService).getCorePoolSize());
        log.info("MaximumPoolSize set at " + ((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        log.info("KeepAliveTime(ms) set at " + ((ThreadPoolExecutor) executorService).getKeepAliveTime(TimeUnit.MILLISECONDS));
        log.info("Timeout(ms) set at " + Long.parseLong(getString(TIMEOUT, DEFAULT_TIMEOUT)));
    }
}
