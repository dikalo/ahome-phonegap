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

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides access to a W3C Storage interface
 * (http://dev.w3.org/html5/webstorage/#the-localstorage-attribute)
 */
public class LocalStorage extends JsObject {

    LocalStorage(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Returns the name of the key at the position specified
     * 
     * @param position
     * @return
     */
    public native String getKey(int position)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.key(position);
    }-*/;

    /**
     * Saves and item at the key provided.
     */
    public native void setItem(String key, Object item)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.setItem(key, item);
    }-*/;

    /**
     * Returns the item identified by it's key
     * 
     * @return T
     */
    public native <T> T getItem(String key)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.getItem(key);
    }-*/;

    /**
     * Removes the item identified by it's key
     */
    public native void removeItem(String key)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.removeItem(key);
    }-*/;

    /**
     * Removes all of the key value pairs
     */
    public native void clear()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.clear();
    }-*/;

}
