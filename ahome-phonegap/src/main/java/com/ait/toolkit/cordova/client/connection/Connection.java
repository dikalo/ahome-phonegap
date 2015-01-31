/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.cordova.client.connection;

import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;

/**
 * The connection module gives access to the device's cellular and wifi
 * connection information.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_connection_connection.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_connection_connection.md.html</a>
 */
public class Connection extends Module {

    private static Connection instance = null;

    /**
     * Gets the single connection instance.
     */
    public static Connection get() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    private Connection() {
        createPeer();
    }

    /**
     * Checks the active network connection that is being used. This property is
     * a fast way to determine the device's network connection state, and type
     * of connection.
     * 
     * @return ConnectionType
     */
    public ConnectionType getType() {
        return ConnectionType.fromValue(_getType());
    }

    private native String _getType()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.type;
    }-*/;

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeConnection();
    }

}
