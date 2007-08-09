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
package org.getahead.dwrdemo.proxy.demo;

import java.util.Collection;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.getahead.dwrdemo.proxy.gi.Button;
import org.getahead.dwrdemo.proxy.gi.Form;
import org.getahead.dwrdemo.proxy.gi.GI;
import org.getahead.dwrdemo.proxy.gi.Server;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Test
{
    public static void main(String[] args)
    {
        ServerContext sctx = ServerContextFactory.get(null);
        Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage(null);
        Server server = GI.getServer(sessions, "appname");
        Button button = server.getJsxById("button", Button.class);
        button.setEnabled(Form.State.DISABLED, true);
    }
}
