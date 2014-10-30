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
package com.ait.toolkit.cordova.client.plugins.android;

import com.ait.toolkit.cordova.client.core.Device;
import com.ait.toolkit.cordova.client.plugins.Plugin;

/**
 * Java binding for Statusbarnotification
 * 
 * @see <a href=
 *      'https://github.com/phonegap/phonegap-plugins/tree/master/Android/StatusBarNotification'>https://github.com/phonegap/phonegap-plugins/tree/master/Android/StatusBarNotif
 *      i c a t i o n < / a >
 * 
 */
public class StatusBarNotification implements Plugin {

    public static final String FLAG_AUTO_CANCEL = "16";
    public static final String FLAG_NO_CLEAR = "32";

    private static final StatusBarNotification INSTANCE = new StatusBarNotification();

    public static StatusBarNotification get() {
        return INSTANCE;
    }

    private StatusBarNotification() {
        init();
    }

    @Override
    public void init() {
        if (!Device.pluginExists("statusBarNotification")) {
            throw new IllegalStateException(
                            "Can not find StatusBarNotification plugin - did you include statusBarNotification.js?");
        }

    }

    public native void display(String title, String message)/*-{
		$wnd.plugins.statusBarNotification.notify(title, message);
    }-*/;

    public void display(String message) {
        display("", message);
    }

}
