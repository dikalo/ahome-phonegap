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
package com.ait.toolkit.cordova.client.storage;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides access to the devices storage options.
 * 
 * This API is based on the W3C Web SQL Database Specification and W3C Web
 * Storage API Specification. Some devices already provide an implementation of
 * this spec. For those devices, the built-in support is used instead of
 * replacing it with PhoneGap's implementation. For devices that don't have
 * storage support, PhoneGap's implementation should be compatible with the W3C
 * specification.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_storage_storage.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_storage_storage.md.html</a>
 * 
 */
public class Storage {

    private static Storage instance = null;
    private LocalStorage localStorage = null;

    public static Storage get() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    private Storage() {
    }

    /**
     * Creates a new database instance.
     * 
     * @param name
     * @param version
     * @param displayName
     * @param size
     * @return Database
     */
    public Database createDatabase(String name, String version, String displayName, double size) {
        return new Database(_createDatabase(name, version, displayName, size));

    }

    /**
     * Gets an intance to the local storage.
     * 
     * @return {@link LocalStorage}
     */
    public LocalStorage getLocalStorage() {
        if (localStorage == null) {
            localStorage = new LocalStorage(_getLocalStorage());
        }
        return localStorage;
    }

    private native JavaScriptObject _createDatabase(String name, String version, String displayName, double size)/*-{
		return $wnd.openDatabase(name, version, displayName, size);
    }-*/;

    private static native JavaScriptObject _getLocalStorage()/*-{
		return $wnd.localStorage;
    }-*/;

}
