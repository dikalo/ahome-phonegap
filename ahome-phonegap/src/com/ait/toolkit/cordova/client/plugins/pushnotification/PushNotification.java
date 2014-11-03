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

import com.ait.toolkit.cordova.client.core.Device;
import com.ait.toolkit.cordova.client.plugins.Plugin;

/**
 * Java binding for PushNotification.js
 * 
 * @see <a href=https://github.com/phonegap-build/PushPlugin>https://github.com/
 *      phonegap-build/PushPlugin</a>
 */
public class PushNotification implements Plugin {

    private static final PushNotification INSTANCE = new PushNotification();

    public static PushNotification get() {
        return INSTANCE;
    }

    private PushNotification() {
        init();
    }

    @Override
    public void init() {
        if (!Device.pluginExists("pushNotification")) {
            throw new IllegalStateException(
                            "Can not find PushNotification plugin - did you include PushNotification.js?");
        }
    }

    private native boolean pluginExists()/*-{
		if (!$wnd.plugins)
			return false;
		if (!$wnd.plugins.pushNotification)
			return false;
		return true;
    }-*/;

    public native void register(PushNotificationRegisterConfig config, PushNotificationRegisterCallback callback)/*-{
		$wnd.plugins.pushNotification
				.register(
						function(s) {
							callback.@com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationRegisterCallback::onSuccess(Ljava/lang/String;)(s);
						},
						function(e) {
							callback.@com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationRegisterCallback::onError(Ljava/lang/String;)(e);
						},
						config.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    public native void unregister(PushNotificationRegisterCallback callback)/*-{
		$wnd.plugins.pushNotification
				.register(
						function(s) {
							callback.@com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationRegisterCallback::onSuccess(Ljava/lang/String;)(s);
						},
						function(e) {
							callback.@com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationRegisterCallback::onError(Ljava/lang/String;)(e);
						});
    }-*/;

    /**
     * Set the badge count visible when the app is not running
     * 
     * @param badgeCount
     *            , an integer indicating what number should show up in the
     *            badge. Passing 0 will clear the badge.
     */
    public native void setApplicationBadgeNumber(PushNotificationRegisterCallback callback, int badgeCount)/*-{
		$wnd.plugins.pushNotification
				.setApplicationIconBadgeNumber(
						function(s) {
							callback.@com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationRegisterCallback::onSuccess(Ljava/lang/String;)(s);
						},
						function(e) {
							callback.@com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationRegisterCallback::onError(Ljava/lang/String;)(e);
						}, badgeCount);
    }-*/;

    /**
     * Set the badge count visible when the app is not running(IOS Only)
     * 
     * @param badgeCount
     *            , an integer indicating what number should show up in the
     *            badge. Passing 0 will clear the badge.
     */
    public native void setApplicationBadgeNumber(int badgeCount)/*-{
		$wnd.plugins.pushNotification.setApplicationIconBadgeNumber(
				function(s) {
				}, badgeCount);
    }-*/;

}
