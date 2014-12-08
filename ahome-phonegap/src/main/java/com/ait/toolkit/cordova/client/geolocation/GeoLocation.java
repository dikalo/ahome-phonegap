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
package com.ait.toolkit.cordova.client.geolocation;

import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;
import com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler;

/**
 * Geolocation provides location information for the device, such as latitude and longitude. Common sources of location
 * information include Global Positioning System (GPS) and location inferred from network signals such as IP address,
 * RFID, WiFi and Bluetooth MAC addresses, and GSM/CDMA cell IDs. No guarantee is given that the API returns the
 * device's actual location.
 *
 * This API is based on the W3C Geolocation API Specification. Some devices (Android, BlackBerry, Bada, Windows Phone 7,
 * webOS and Tizen, to be specific) already provide an implementation of this spec. For those devices, the built-in
 * support is used instead of replacing it with Cordova's implementation. For devices that don't have geolocation
 * support, the Cordova implementation adheres to the W3C specification.
 *
 * @see <a http://docs.phonegap.com/en/2.7.0/cordova_geolocation_geolocation.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_geolocation_geolocation.md.html</a>
 */
public class GeoLocation extends Module {

    private static GeoLocation instance = null;

    public static GeoLocation get() {
        if (instance == null) {
            instance = new GeoLocation();
        }
        return instance;
    }

    private GeoLocation() {
        createPeer();
    }

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeGeoLocation();
    }

    /**
     * Returns the device's current position as a Position object.
     * geolocation.getCurrentPositon is an asynchronous function. It returns the
     * device's current position to the geolocationSuccess callback with a
     * Position object as the parameter. If there is an error, the
     * geolocationError callback is invoked with a PositionError object.
     * 
     * @param handler
     */
    public native void getCurrentLocation(GeoLocationHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getCurrentPosition(
						$entry(function(pos) {
							var positionObject = @com.ait.toolkit.cordova.client.geolocation.Position::new(Lcom/google/gwt/core/client/JavaScriptObject;)(pos);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onSuccess(Lcom/ait/toolkit/cordova/client/geolocation/Position;)(positionObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.geolocation.PositionError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onError(Lcom/ait/toolkit/cordova/client/geolocation/PositionError;)(errorObject);
						}));
    }-*/;

    /**
     * Returns the device's current position as a Position object.
     * geolocation.getCurrentPositon is an asynchronous function. It returns the
     * device's current position to the geolocationSuccess callback with a
     * Position object as the parameter. If there is an error, the
     * geolocationError callback is invoked with a PositionError object.
     * 
     * @param handler
     */
    public native void getCurrentLocation(GeoLocationHandler handler, GeoLocationOptions options)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getCurrentPosition(
						$entry(function(pos) {
							var positionObject = @com.ait.toolkit.cordova.client.geolocation.Position::new(Lcom/google/gwt/core/client/JavaScriptObject;)(pos);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onSuccess(Lcom/ait/toolkit/cordova/client/geolocation/Position;)(positionObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.geolocation.PositionError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onError(Lcom/ait/toolkit/cordova/client/geolocation/PositionError;)(errorObject);
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Watches for changes to the device's current position.
     * 
     * @param handler
     */
    public native String watchPosition(GeoLocationHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer
				.watchPosition(
						$entry(function(pos) {
							var positionObject = @com.ait.toolkit.cordova.client.geolocation.Position::new(Lcom/google/gwt/core/client/JavaScriptObject;)(pos);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onSuccess(Lcom/ait/toolkit/cordova/client/geolocation/Position;)(positionObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.geolocation.PositionError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onError(Lcom/ait/toolkit/cordova/client/geolocation/PositionError;)(errorObject);
						}));
    }-*/;

    /**
     * Watches for changes to the device's current position.
     * 
     * @param handler
     */
    public native String watchPosition(GeoLocationHandler handler, GeoLocationOptions options)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer
				.watchPosition(
						$entry(function(pos) {
							var positionObject = @com.ait.toolkit.cordova.client.geolocation.Position::new(Lcom/google/gwt/core/client/JavaScriptObject;)(pos);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onSuccess(Lcom/ait/toolkit/cordova/client/geolocation/Position;)(positionObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.geolocation.PositionError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.geolocation.GeoLocationHandler::onError(Lcom/ait/toolkit/cordova/client/geolocation/PositionError;)(errorObject);
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Stop watching for changes to the device's location referenced by the
     * watchID parameter.
     * 
     * @param watchId
     */
    public native void clearWatch(String watchId)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.clearWatch(watchId);
    }-*/;

}
