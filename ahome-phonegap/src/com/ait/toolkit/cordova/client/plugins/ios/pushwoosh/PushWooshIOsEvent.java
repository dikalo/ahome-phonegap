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
package com.ait.toolkit.cordova.client.plugins.ios.pushwoosh;

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

public class PushWooshIOsEvent extends JsObject {

    PushWooshIOsEvent(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native String getAlert()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.notification.aps.alert;
    }-*/;

    public native String getSound()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.notification.aps.sound;
    }-*/;

    public native PushWooshIOsObject getUserData()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.notification.u;
		return @com.ait.toolkit.cordova.client.plugins.ios.pushwoosh.PushWooshIOsObject::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

}
