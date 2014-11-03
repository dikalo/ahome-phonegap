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
package com.ait.toolkit.cordova.client.plugins.android.pushwoosh;

import com.ait.toolkit.cordova.client.core.Device;
import com.ait.toolkit.cordova.client.plugins.Plugin;

public class PushWooshAndroid implements Plugin {

	private static final PushWooshAndroid INSTANCE = new PushWooshAndroid();

	public static PushWooshAndroid get() {
		return INSTANCE;
	}

	private PushWooshAndroid() {
		init();
	}

	@Override
	public void init() {
		if (!Device.pluginExists("pushNotification")) {
			throw new IllegalStateException(
					"Can not find PushNotification plugin - did you include PushNotification.js?");
		}
	}

	public native void onDeviceReady()/*-{
		$wnd.plugins.pushNotification.onDeviceReady();
	}-*/;

	/**
	 * register for push notifications and retreive a deviceToken
	 * 
	 * @param projectId
	 * @param appId
	 */
	public native void registerDevice(String id, String applicationId,
			PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.registerDevice(
						{
							'projectId' : id,
							'appId' : applicationId
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});
	}-*/;

	public native void unregisterDevice(PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.unregisterDevice(
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});
	}-*/;

	public native void setTags(PushWooshAndroidObject tags,
			PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.setTags(
						tags.@com.ait.toolkit.core.client.JsObject::getJsObj()(),
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});
	}-*/;

	public native void startGeoPushes(PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.startGeoPushes(

						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});
	}-*/;

	public native void startGeoPushes()/*-{
		$wnd.plugins.pushNotification.startGeoPushes(function(status) {
		}, function(status) {
		});
	}-*/;

	public native void stopGeoPushes(PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.stopGeoPushes(

						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});
	}-*/;

	public native void stopGeoPushes()/*-{
		$wnd.plugins.pushNotification.stopGeoPushes(function(status) {
		}, function(status) {
		});
	}-*/;

	public native void setMultiNotificationMode(
			PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.setMultiNotificationMode(

						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});
	}-*/;

	public native void setMultiNotificationMode()/*-{
		$wnd.plugins.pushNotification.setMultiNotificationMode(
				function(status) {
				}, function(status) {
				});
	}-*/;

	public native void setSingleNotificationMode(
			PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.setSingleNotificationMode(

						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});
	}-*/;

	public native void setSingleNotificationMode()/*-{
		$wnd.plugins.pushNotification.setSingleNotificationMode(
				function(status) {
				}, function(status) {
				});
	}-*/;

	public native void setSoundType(int type,
			PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.setSoundType(
						type,
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});

	}-*/;

	public native void setSoundType(int type)/*-{
		$wnd.plugins.pushNotification.setSoundType(type, function(status) {
		}, function(status) {
		});
	}-*/;

	public native void setVibrateType(int type,
			PushWooshAndroidEventHandler callback)/*-{
		$wnd.plugins.pushNotification
				.setVibrateType(
						type,
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onSuccess(Ljava/lang/String;)(status);
						},
						function(status) {
							callback.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEventHandler::onError(Ljava/lang/String;)(status);
						});

	}-*/;

	public native void setVibrateType(int type)/*-{
		$wnd.plugins.pushNotification.setVibrateType(type, function(status) {
		}, function(status) {
		});
	}-*/;

	public native void setLightScreenOnNotification(boolean value)/*-{
		$wnd.plugins.pushNotification.setLightScreenOnNotification(value,
				function(status) {
				}, function(status) {
				});
	}-*/;

	public native void sendLocation(double latitue, double longitude)/*-{
		$wnd.plugins.pushNotification.sendLocation({
			'lat' : latitude,
			'long' : longitude
		}, function(status) {
		}, function(status) {
		});
	}-*/;

	public native void addNotificationHandler(
			PushWooshAndroidNotificationHandler handler)/*-{
		$wnd.plugins.pushNotification
				.addEventListener(
						'push-notification',
						function(event) {
							var e = @com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
							handler.@com.ait.toolkit.cordova.client.plugins.android.pushwoosh.PushWooshAndroidNotificationHandler::onNotification(Lcom/ait/toolkit/cordova/client/plugins/android/pushwoosh/PushWooshAndroidEvent;)(e);
						});
	}-*/;

}
