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
package com.ait.toolkit.cordova.client.plugins.pushnotification;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class PushNotificationEvent extends JsObject {

    protected PushNotificationEvent(JavaScriptObject obj) {
        jsObj = obj;
    }

    public String getAlert() {
        return JsoHelper.getAttribute(jsObj, "alert");
    }

    public String getSound() {
        return JsoHelper.getAttribute(jsObj, "sound");
    }

    public int getBadge() {
        return JsoHelper.getAttributeAsInt(jsObj, "badge");
    }

    public String getEvent() {
        return JsoHelper.getAttribute(jsObj, "event");
    }

    public boolean isForeground() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "foreground");
    }

    public boolean isColdStart() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "coldstart");
    }

    public String getRegID() {
        return JsoHelper.getAttribute(jsObj, "regID");
    }

}
