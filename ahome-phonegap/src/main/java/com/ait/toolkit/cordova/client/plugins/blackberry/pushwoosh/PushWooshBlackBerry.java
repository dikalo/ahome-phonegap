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
package com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh;

import com.ait.toolkit.cordova.client.plugins.Plugin;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

/**
 * Based upon the PushWoosh Blackberry Phonegap/WebWorks plugin
 * https://github.com
 * /shaders/phonegap-cordova-push-notifications/blob/master/BlackBerry
 * /pushwoosh.js
 * http://www.pushwoosh.com/programming-push-notification/blackberry
 * -html5-webworks-push-notification-sdk/
 * 
 * @author mvniekerk
 * 
 */
public class PushWooshBlackBerry implements Plugin {
    private static final PushWooshBlackBerry INSTANCE = new PushWooshBlackBerry();

    public static PushWooshBlackBerry get() {
        return INSTANCE;
    }

    private String baseUrl = "https://cp.pushwoosh.com/json/1.3/";
    private String appId = "YOUR_APP_ID"; // PushWoosh APP ID
    private String bbAppId = "BB_APP_ID_FROM_REGISTRATION"; // BlackBerry APP ID
    public static final String BB_SERVER_URL = "http://pushapi.eval.blackberry.com";
    private int queueMax = 100;
    private int port = 80; // Blackberry port from app registration
    private String wakeupUrl = "";
    private PushWooshBlackBerryRegisterCallback registerCallback;
    private PushWooshBlackBerryDataHandler dataHandler;
    private PushWooshBlackBerrySimChangeHandler simChangeHandler;

    /**
     * Set the handler to run when the sim inside the phone was changed
     * 
     * @param simChangeHandler
     */
    public void setSimChangeHandler(PushWooshBlackBerrySimChangeHandler simChangeHandler) {
        this.simChangeHandler = simChangeHandler;
    }

    /**
     * Get the handler when the sim changed
     * 
     * @return
     */
    public PushWooshBlackBerrySimChangeHandler getSimChangeHandler() {
        return simChangeHandler;
    }

    /**
     * Get the handler that handles when push data was received
     * 
     * @return
     */
    public PushWooshBlackBerryDataHandler getDataHandler() {
        return dataHandler;
    }

    /**
     * Set the handler that handles when push data was received
     * 
     * @param dataHandler
     */
    public void setDataHandler(PushWooshBlackBerryDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    /**
     * Set a callback for registering
     * 
     * @param registerCallback
     */
    public void setRegisterCallback(PushWooshBlackBerryRegisterCallback registerCallback) {
        this.registerCallback = registerCallback;
    }

    /**
     * Handler for registering
     * 
     * @return
     */
    public PushWooshBlackBerryRegisterCallback getRegisterCallback() {
        return registerCallback;
    }

    /**
     * Get the max amount of notifications
     * 
     * @return
     */
    public int getQueueMax() {
        return queueMax;
    }

    /**
     * Set the max amount of notifications
     * 
     * @param queueMax
     */
    public void setQueueMax(int queueMax) {
        this.queueMax = queueMax;
    }

    /**
     * Get the BlackBerry App ID
     * 
     * @return
     */
    public String getBbAppId() {
        return bbAppId;
    }

    /**
     * Set the BlackBerry App ID
     * 
     * @param bbAppId
     */
    public void setBbAppId(String bbAppId) {
        this.bbAppId = bbAppId;
    }

    /**
     * Get the BlackBerry server URL
     * 
     * @return
     */
    public static String getBbServerUrl() {
        return BB_SERVER_URL;
    }

    /**
     * Set the PushWoosh base URL
     * 
     * @param baseUrl
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Get the base PushWoosh server URL
     * 
     * @return
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Get the BlackBerry server port
     * 
     * @return
     */
    public int getPort() {
        return port;
    }

    /**
     * Set the BlackBerry server port
     * 
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Set the PushWoosh app ID
     * 
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Get the PushWoosh app ID
     * 
     * @return
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Get the URL of the file that needs to be called upon wake-up from data
     * 
     * @return
     */
    public String getWakeupUrl() {
        return wakeupUrl;
    }

    /**
     * Get the URL of the file that needs to be called upon wake-up from data
     * 
     * @param wakeupUrl
     */
    public void setWakeupUrl(String wakeupUrl) {
        this.wakeupUrl = wakeupUrl;
    }

    private PushWooshBlackBerry() {
    }

    @Override
    public void init() {

    }

    /**
     * Get the BlackBerry token
     * 
     * @return
     */
    public static final native JavaScriptObject getToken() /*-{
		return blackberry.identity.PIN;
    }-*/;

    /**
     * Get the language of the BlackBerry phone's locale
     * 
     * @return
     */
    public static final native String getLanguage() /*-{
		var ret = $wnd.navigator.language;
		if (ret) {
			ret = ret.substring(0, 2);
		} else {
			ret = 'en';
		}
		return ret;
    }-*/;

    /**
     * Get the timezone offset
     * 
     * @return
     */
    public static final native int getTimezoneOffset() /*-{
		return new Data().getTimezoneOffset() * 60;
    }-*/;

    /**
     * Get the BlackBerry phone's hardware ID
     * 
     * @return
     */
    public static final native JavaScriptObject getHWID() /*-{
		return blackberry.identity.IMEI;
    }-*/;

    /**
     * Registers to the BlackBerry push service, then after that registers to
     * the PushWoosh push service
     */
    public native void onDeviceReady() /*-{
		var opts = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::packBisPushObject()();
		var onData = function(obj) {
			var rec = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getDataHandler()();
			rec.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerryDataHandler::onDataReceived(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		};
		var onRegister = function(status) {
			var callback = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getRegisterCallback()();
			if (status == 0) {
				this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::register()();
				callback.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerryRegisterCallback::onSuccess(Ljava/lang/String;)(status);
			} else {
				callback.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerryRegisterCallback::onError(I)(status);
			}
		};
		var onSimChange = function() {
			var cb = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getSimChangeHandler()();
			cb.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerrySimChangeHandler::onSimChange()();
		};
		blackberry.push.openBISPushListener(opts, onData, onRegister,
				onSimChange);
    }-*/;

    /**
     * Pack the BIS registration object
     * 
     * @return
     */
    private final native JavaScriptObject packBisPushObject() /*-{
		var port = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getPort()();
		var appId = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getAppId()();
		var serverUrl = @com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getBbServerUrl()();
		var wakeupPage = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getWakeupUrl()();
		var max = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getQueueMax()();
		var ret = {
			port : port,
			appId : appId,
			serverUrl : serverUrl,
			wakeUpPage : wakeupPage,
			maxQueueCap : max
		};
		return ret;
    }-*/;

    /**
     * Pack the PushWoosh registration object
     * 
     * @return
     */
    private final native String getPushWooshRegisterPayload() /*-{
		var appCode = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getAppId()();
		var token = @com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getToken()();
		var lang = @com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getLanguage()();
		var hwid = @com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getHWID()();
		var tz = @com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getTimezoneOffset()();
		var devicetype = 2;
		var params = {
			request : {
				application : appCode,
				push_token : token,
				language : lang,
				hwid : hwid,
				timezone : tz,
				device_type : devicetype
			}
		};
		return JSON.stringify(params);
    }-*/;

    private final native String getPushWooshUnregisterPayload() /*-{
		var appCode = this.@com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getAppId()();
		var hwid = @com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh.PushWooshBlackBerry::getHWID()();
		var params = {
			request : {
				application : appCode,
				hwid : hwid,
			}
		};
		return JSON.stringify(params);
    }-*/;

    public void register() {
        RequestBuilder req = new RequestBuilder(RequestBuilder.POST, getBaseUrl() + "registerDevice");
        req.setHeader("Content-type", "application/json; charset=utf-8");
        req.setRequestData(getPushWooshRegisterPayload());
        req.setCallback(new RequestCallback() {

            @Override
            public void onResponseReceived(Request request, Response response) {
                if (response.getStatusCode() == 200) {
                    registerCallback.onSuccess(response.getText());
                } else {
                    registerCallback.onError(-1);
                }
            }

            @Override
            public void onError(Request request, Throwable exception) {
                registerCallback.onError(-1);
            }
        });
        try {
            req.send();
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }

    public void unregister(final PushWooshBlackBerryRegisterCallback cb) {
        RequestBuilder req = new RequestBuilder(RequestBuilder.POST, getBaseUrl() + "unregisterDevice");
        req.setHeader("Content-type", "application/json; charset=utf-8");
        req.setRequestData(getPushWooshUnregisterPayload());
        req.setCallback(new RequestCallback() {

            @Override
            public void onResponseReceived(Request request, Response response) {
                if (response.getStatusCode() == 200) {
                    cb.onSuccess(response.getText());
                } else {
                    cb.onError(-1);
                }
            }

            @Override
            public void onError(Request request, Throwable exception) {
                cb.onError(-1);
            }
        });
    }

}
