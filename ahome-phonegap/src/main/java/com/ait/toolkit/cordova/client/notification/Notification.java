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
package com.ait.toolkit.cordova.client.notification;

import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;
import com.ait.toolkit.cordova.client.core.handlers.notification.ConfirmHandler;

/**
 * Visual, audible, and tactile device notifications.<br/>
 * 
 * @see <a
 *      href=http://docs.phonegap.com/en/2.7.0/cordova_notification_notification
 *      .md.html>
 *      http://docs.phonegap.com/en/2.7.0/cordova_notification_notification
 *      .md.html</a>
 */
public class Notification extends Module {

    private static Notification instance = null;

    public static Notification get() {
        if (instance == null) {
            instance = new Notification();
        }
        return instance;
    }

    private Notification() {
        createPeer();
    }

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeNotification();
    }

    /**
     * Shows a custom alert or dialog box.
     * 
     * @param message
     *            , Dialog message
     */
    public native void alert(String message)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.alert(message, $entry(function() {

		}));
    }-*/;

    /**
     * Shows a custom alert or dialog box.
     * 
     * @param message
     *            , Dialog message
     */
    public native void alert(String message, Function callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.alert(message, $entry(function() {
			callBack.@com.ait.toolkit.core.client.Function::execute()();
		}));
    }-*/;

    /**
     * Shows a custom alert or dialog box.
     * 
     * @param message
     *            , Dialog message
     * @param title
     *            , Dialog title
     */
    public native void alert(String title, String message)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.alert(message, $entry(function() {
		}), title);
    }-*/;

    /**
     * Shows a custom alert or dialog box.
     * 
     * @param message
     *            , Dialog message
     * @param title
     *            , Dialog title
     */
    public native void alert(String title, String message, Function callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.alert(message, $entry(function() {
			callBack.@com.ait.toolkit.core.client.Function::execute()();
		}), title);
    }-*/;

    /**
     * Shows a custom alert or dialog box.
     * 
     * @param message
     *            , Dialog message
     * @param title
     *            , Dialog title
     * @param button
     *            , Button name
     */
    public native void alert(String title, String message, String button)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.alert(message, $entry(function() {
		}), title, button);
    }-*/;

    /**
     * Shows a custom alert or dialog box.
     * 
     * @param message
     *            , Dialog message
     * @param title
     *            , Dialog title
     * @param button
     *            , Button name
     */
    public native void alert(String title, String message, String button, Function callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.alert(message, $entry(function() {
			callBack.@com.ait.toolkit.core.client.Function::execute()();
		}), title, button);
    }-*/;

    /**
     * displays a native dialog box that is more customizable than the browser's
     * confirm function.
     * 
     * @param message
     * @param callBack
     */
    public native void confirm(String message, ConfirmHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.confirm(
						message,
						$entry(function(button) {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.notification.ConfirmHandler::onConfirm(I)(button);
						}));
    }-*/;

    /**
     * displays a native dialog box that is more customizable than the browser's
     * confirm function.
     * 
     * @param message
     * @param callBack
     */
    public native void confirm(String title, String message, ConfirmHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.confirm(
						message,
						$entry(function(button) {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.notification.ConfirmHandler::onConfirm(I)(button);
						}), title);
    }-*/;

    /**
     * displays a native dialog box that is more customizable than the browser's
     * confirm function.
     * 
     * @param message
     *            , Dialog message
     * @param callBack
     *            , Callback to invoke with index of button pressed (1, 2 or 3)
     */
    public native void confirm(String title, String message, String buttonLabels, ConfirmHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.confirm(
						message,
						$entry(function(button) {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.notification.ConfirmHandler::onConfirm(I)(button);
						}), title, buttonLabels);
    }-*/;

    /**
     * The device will play a beep sound.
     * 
     * @param times
     */
    public native void beep(int times)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.beep(times);
    }-*/;

    /**
     * Vibrates the device for the specified amount of time.
     * 
     * @param time
     */
    public native void vibrate(int time)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.vibrate(time);
    }-*/;

    /**
     * Vibrates the device for 1 second.
     * 
     */
    public native void vibrate()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.vibrate(1000);
    }-*/;

}
