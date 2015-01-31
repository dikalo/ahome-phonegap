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

public class PushNotificationRegisterConfig extends JsObject {

	public PushNotificationRegisterConfig() {
		jsObj = JsoHelper.createObject();
	}

	public void setSenderId(String value) {
		JsoHelper.setAttribute(jsObj, "senderId", value);
	}

	public void setEcb(PushNotificationCallback callback) {
		JsoHelper.setAttribute(jsObj, "ecb", getEcbHandler(callback));
	}

	public void setBadge(boolean value) {
		JsoHelper.setAttribute(jsObj, "badge", value);
	}

	public void setSound(boolean value) {
		JsoHelper.setAttribute(jsObj, "sound", value);
	}

	public void setAlert(boolean value) {
		JsoHelper.setAttribute(jsObj, "alert", value);
	}

	private native String getEcbHandler(PushNotificationCallback callback)/*-{
		return function(e) {
			var event = @com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			callback.@com.ait.toolkit.cordova.client.plugins.pushnotification.PushNotificationCallback::onEvent(Lcom/ait/toolkit/cordova/client/plugins/pushnotification/PushNotificationEvent;)(event);
		}.name;
	}-*/;

}
