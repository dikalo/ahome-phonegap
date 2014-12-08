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

package com.ait.toolkit.cordova.client.inappbrowser;

import com.google.gwt.core.client.JavaScriptObject;

public class InAppBrowserHandlerRegistration {

    private JavaScriptObject iapp;
    private JavaScriptObject fn;
    private String eventName;

    public InAppBrowserHandlerRegistration(JavaScriptObject iapp, JavaScriptObject fn, String eventName) {
        super();
        this.iapp = iapp;
        this.fn = fn;
        this.eventName = eventName;
    }

    public native void unregister() /*-{
		var obj = this.@com.ait.toolkit.cordova.client.inappbrowser.InAppBrowserHandlerRegistration::iapp;
		var objjso = obj.@com.ait.toolkit.core.client.JsObject::jsObj;
		var action = this.@com.ait.toolkit.cordova.client.inappbrowser.InAppBrowserHandlerRegistration::eventName;
		var fn = this.@com.ait.toolkit.cordova.client.inappbrowser.InAppBrowserHandlerRegistration::fn;
		objjso.removeEventListener(action, fn);
    }-*/;

}
