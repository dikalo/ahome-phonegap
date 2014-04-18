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
package com.ait.toolkit.cordova.client.core;

import com.ait.toolkit.cordova.client.core.handlers.notification.ConfirmHandler;
import com.ait.toolkit.cordova.client.events.DeviceEvent;
import com.ait.toolkit.cordova.client.handlers.BackButtonEventHandler;
import com.ait.toolkit.cordova.client.handlers.BatteryCriticalEventHandler;
import com.ait.toolkit.cordova.client.handlers.BatteryLowEventHandler;
import com.ait.toolkit.cordova.client.handlers.BatteryStatusEventHandler;
import com.ait.toolkit.cordova.client.handlers.DeviceReadyEventHandler;
import com.ait.toolkit.cordova.client.handlers.EndCallButtonEventHandler;
import com.ait.toolkit.cordova.client.handlers.MenuButtonEventHandler;
import com.ait.toolkit.cordova.client.handlers.OfflineEventHandler;
import com.ait.toolkit.cordova.client.handlers.OnlineEventHandler;
import com.ait.toolkit.cordova.client.handlers.PauseEventHandler;
import com.ait.toolkit.cordova.client.handlers.ResumeEventHandler;
import com.ait.toolkit.cordova.client.handlers.SearchButtonEventHandler;
import com.ait.toolkit.cordova.client.handlers.StartCallButtonEventHandler;
import com.ait.toolkit.cordova.client.handlers.VolumeDownButtonEventHandler;
import com.ait.toolkit.cordova.client.handlers.VolumeUpButtonEventHandler;
import com.ait.toolkit.cordova.client.notification.Notification;
import com.ait.toolkit.core.client.Attribute;
import com.ait.toolkit.core.client.Function;
import com.ait.toolkit.core.client.JsoHelper;

/**
 * The device object describes the device's hardware and software.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_device_device.md.html>
 *      http://docs.phonegap.com/en/2.7.0/cordova_device_device.md.html</a>
 */
public class Device extends Module {

	private static Device instance = null;

	/**
	 * Gets the unique Device instance.
	 * 
	 * @return Device
	 */
	public static Device get() {
		if (instance == null) {
			instance = new Device();
		}
		return instance;
	}

	/**
	 * Get the device's model name.
	 * 
	 * @deprecated since version 2.3.0. Use getModel() instead.
	 * 
	 * @return
	 */
	public String getName() {
		return JsoHelper.getAttribute(jsObj, Attribute.NAME.getValue());
	}

	/**
	 * Returns the version of Cordova running on the device
	 * 
	 * @return
	 */
	public String getCordovaVersion() {
		return JsoHelper.getAttribute(jsObj, Attribute.CORDOVA.getValue());
	}

	/**
	 * Get the device's operating system name.
	 * 
	 * @return
	 */
	public String getPlatform() {
		return JsoHelper.getAttribute(jsObj, Attribute.PLATFORM.getValue());
	}

	/**
	 * Get the device's Universally Unique Identifier (UUID)
	 * 
	 * @return
	 */
	public String getUuId() {
		return JsoHelper.getAttribute(jsObj, Attribute.UUID.getValue());
	}

	/**
	 * Gets the device's operating system version.
	 * 
	 * @return String
	 */
	public String getVersion() {
		return JsoHelper.getAttribute(jsObj, Attribute.VERSION.getValue());
	}

	/**
	 * Gets the device's model.
	 * 
	 * @return String
	 */
	public String getModel() {
		return JsoHelper.getAttribute(jsObj, "model");
	}

	private Device() {
		createPeer();
	}

	@Override
	public void createPeer() {
		jsObj = ModuleFactory.createNativeDevice();
	}

	/**
	 * This method checks if the application is running natively or not. It also
	 * gives the user the ability to override any setting specified (or not) in
	 * the .html file. The global JavaScript variable that determines if an app
	 * is running natively or not is called EMITROM_NATIVE (all caps). Override
	 * this method with care, as it will take precedence over the EMITROM_NATIVE
	 * variable that may have been defined in the .html file.
	 * 
	 * @return boolean true if the application should wait for the device to
	 *         load; false otherwise.
	 */
	protected boolean isNative() {
		return isApplicationNative();
	}

	/**
	 * This method provides the ability to change an app from native to web
	 * without changing any code. By simply altering the variable at runtime,
	 * the app can be determined in what modality we are running.
	 * 
	 * @return boolean
	 */
	private native boolean isApplicationNative()/*-{
		if ($wnd.EMITROM_NATIVE) {
			return true;
		}
		return false;
	}-*/;

	/**
	 * Returns the status of Cordova.available or PhoneGap.available
	 * 
	 * @return boolean the value of PhoneGap.available
	 */
	public static native boolean isReady()/*-{
		if ($wnd.Cordova) {
			return true;
		}
		return false;
	}-*/;

	/**
	 * Add an eventListener to device wide events
	 * 
	 * @param event
	 * @param callBack
	 */
	public native static void addEventListener(String event, Function callBack)/*-{
		$doc.addEventListener(event, $entry(function() {
			callBack.@com.ait.toolkit.core.client.Function::execute()();
		}), false);
	}-*/;

	/**
	 * Adds the device ready event handler. This is an event that fires when
	 * PhoneGap is fully loaded.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addDeviceReadyEventHandler(
			DeviceReadyEventHandler callback) {
		addEventListener(DeviceEvent.DEVICE_READY.getValue(), callback);
	}

	/**
	 * Adds an application paused event handler. This is an event that fires
	 * when a PhoneGap application is put into the background.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addPauseEventHandler(PauseEventHandler callback) {
		addEventListener(DeviceEvent.PAUSE.getValue(), callback);
	}

	/**
	 * Adds an application resumed event handler. This is an event that fires
	 * when a PhoneGap application is retrieved from the background.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addResumeEventHandler(ResumeEventHandler callback) {
		addEventListener(DeviceEvent.RESUME.getValue(), callback);
	}

	/**
	 * Adds a network online event handler. When the application's network
	 * connection changes to being online, the online event is fired.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addOnlineEventHandler(OnlineEventHandler callback) {
		addEventListener(DeviceEvent.ONLINE.getValue(), callback);
	}

	/**
	 * Adds a network offline event handler. This is an event that fires when a
	 * PhoneGap application is offline (not connected to the Internet).
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addOfflineEventHandler(OfflineEventHandler callback) {
		addEventListener(DeviceEvent.OFFLINE.getValue(), callback);
	}

	/**
	 * Adds a back button pressed event handler. This is an event that fires
	 * when the user presses the back button. Not supported in iOS.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addBackButtonEventHandler(BackButtonEventHandler callback) {
		addEventListener(DeviceEvent.BACK_BUTTON.getValue(), callback);
	}

	/**
	 * Adds a battery critical event handler. This is an event that fires when a
	 * PhoneGap application detects the battery has reached the critical level
	 * threshold.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addBatteryCriticalEventHandler(
			BatteryCriticalEventHandler callback) {
		addEventListener(DeviceEvent.BATTERY_CRITICAL.getValue(), callback);
	}

	/**
	 * Adds a battery low event handler. This is an event that fires when a
	 * PhoneGap application detects the battery has reached the low level
	 * threshold.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addBatteryLowEventHandler(BatteryLowEventHandler callback) {
		addEventListener(DeviceEvent.BATTERY_LOW.getValue(), callback);
	}

	/**
	 * Adds a battery status change event handler. This is an event that fires
	 * when a PhoneGap application detects a change in the battery status.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addBatteryStatusEventHandler(
			BatteryStatusEventHandler callback) {
		addEventListener(DeviceEvent.BATTERY_STATUS.getValue(), callback);
	}

	/**
	 * Adds a menu button pressed event handler. This is an event that fires
	 * when the user presses the menu button. Not supported in iOS.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addMenuButtonEventHandler(MenuButtonEventHandler callback) {
		addEventListener(DeviceEvent.MENU_BUTTON.getValue(), callback);
	}

	/**
	 * Adds a search button pressed event handler. This is an event that fires
	 * when the user presses the search button. Only supported in Android.
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addSearchButtonEventHandler(
			SearchButtonEventHandler callback) {
		addEventListener(DeviceEvent.SEARCH_BUTTON.getValue(), callback);
	}

	/**
	 * Adds a start call event handler. This is an event that fires when the
	 * user presses the start call button. Only supported in BlackBerry WebWorks
	 * (5.0 or higher).
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addStartCallButtonEventHandler(
			StartCallButtonEventHandler callback) {
		addEventListener(DeviceEvent.START_CALL_BUTTON.getValue(), callback);
	}

	/**
	 * Adds an end call event handler. This is an event that fires when the user
	 * presses the end call button. Only supported in BlackBerry WebWorks (5.0
	 * or higher).
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addEndCallButtonEventHandler(
			EndCallButtonEventHandler callback) {
		addEventListener(DeviceEvent.START_CALL_BUTTON.getValue(), callback);
	}

	/**
	 * Adds a volume down button event handler. This is an event that fires when
	 * the user presses the volume down button. Only supported in BlackBerry
	 * WebWorks (5.0 or higher).
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addVolumeDownButtonEventHandler(
			VolumeDownButtonEventHandler callback) {
		addEventListener(DeviceEvent.VOLUME_DOWN_BUTTON.getValue(), callback);
	}

	/**
	 * Adds a volume up button event handler. This is an event that fires when
	 * the user presses the volume up button. Only supported in BlackBerry
	 * WebWorks (5.0 or higher).
	 * 
	 * @param callback
	 *            callback function to call when event fires
	 */
	public static void addVolumeUpButtonEventHandler(
			VolumeUpButtonEventHandler callback) {
		addEventListener(DeviceEvent.VOLUME_UP_BUTTON.getValue(), callback);
	}

	/**
	 * Shows a custom alert or dialog box.
	 * 
	 * @param message
	 *            , Dialog message
	 */
	public static void alert(String message) {
		Notification.get().alert(message);
	}

	/**
	 * Shows a custom alert or dialog box.
	 * 
	 * @param message
	 *            , Dialog message
	 * @param callback
	 */
	public static void alert(String message, Function callback) {
		Notification.get().alert(message, callback);
	}

	/**
	 * Shows a custom alert or dialog box.
	 * 
	 * @param message
	 *            , Dialog message
	 * @param title
	 *            , Dialog title
	 */
	public static void alert(String title, String message) {
		Notification.get().alert(title, message);
	}

	/**
	 * Shows a custom alert or dialog box.
	 * 
	 * @param message
	 *            , Dialog message
	 * @param title
	 *            , Dialog title
	 * @param callback
	 */
	public static void alert(String title, String message, Function callback) {
		Notification.get().alert(title, message, callback);
	}

	/**
	 * Shows a custom alert or dialog box.
	 * 
	 * @param message
	 *            , Dialog message
	 * @param title
	 *            , Dialog title
	 * @param buttonLabels
	 *            , Button name
	 */
	public static void alert(String title, String message, String buttonLabels) {
		Notification.get().alert(title, message, buttonLabels);
	}

	/**
	 * Shows a custom alert or dialog box.
	 * 
	 * @param message
	 *            , Dialog message
	 * @param title
	 *            , Dialog title
	 * @param buttonLabels
	 *            , Button name
	 * @param callback
	 */
	public static void alert(String title, String message, String buttonLabels,
			Function callback) {
		Notification.get().alert(title, message, buttonLabels, callback);
	}

	/**
	 * Displays a native dialog box that is more customizable than the browser's
	 * confirm function.
	 * 
	 * @param message
	 * @param callback
	 */
	public static void confirm(String message, ConfirmHandler callback) {
		Notification.get().confirm(message, callback);
	}

	/**
	 * Displays a native dialog box that is more customizable than the browser's
	 * confirm function.
	 * 
	 * @param message
	 * @param title
	 * @param callback
	 */
	public static void confirm(String title, String message,
			ConfirmHandler callback) {
		Notification.get().confirm(title, message, callback);
	}

	/**
	 * Displays a native dialog box that is more customizable than the browser's
	 * confirm function.
	 * 
	 * @param message
	 *            , Dialog message
	 * @param callback
	 *            , Callback to invoke with index of button pressed (1, 2 or 3)
	 */
	public static void confirm(String title, String message,
			String buttonLabels, ConfirmHandler callback) {
		Notification.get().confirm(title, message, buttonLabels, callback);
	}

	/**
	 * The device will play a beep sound for the specified amount of time.
	 * 
	 * @param times
	 */

	public static void beep(int times) {
		Notification.get().beep(times);
	}

	/**
	 * Vibrates the device for the specified amount of time.
	 * 
	 * @param times
	 */

	public static void vibrate(int times) {
		Notification.get().vibrate(times);
	}

	/**
	 * Vibrates the device for 1 second.
	 */

	public static void vibrate() {
		Notification.get().vibrate();
	}

	public static native boolean pluginExists(String pluginName)/*-{
		if (!$wnd.plugins)
			return false;
		if (!$wnd.plugins[pluginName])
			return false;
		return true;
	}-*/;

}
