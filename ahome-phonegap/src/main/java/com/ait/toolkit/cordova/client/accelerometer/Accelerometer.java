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
package com.ait.toolkit.cordova.client.accelerometer;

import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;
import com.ait.toolkit.cordova.client.core.handlers.accelerometer.AccelerometerHandler;

/**
 * The accelerometer is a motion sensor that detects the change (delta) in
 * movement relative to the current device orientation. The accelerometer can
 * detect 3D movement along the x, y, and z axis.<br/>
 * 
 * The acceleration is returned using the AccelerometerSuccessHandler callback.<br/>
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_accelerometer_accelerometer.md.html#Accelerometer>
 * http://docs.phonegap.com/en/2.7.0/cordova_accelerometer_accelerometer.md.html#Accelerometer</a>
 */
public class Accelerometer extends Module {

    private static Accelerometer instance;

    public static Accelerometer get() {
        if (instance == null) {
            instance = new Accelerometer();
        }
        return instance;
    }

    /**
     * Gets the current acceleration along the x, y, and z axis.
     * 
     * @param callBack
     */
    public native void getCurrentAcceleration(AccelerometerHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getCurrentAcceleration(
						$entry(function(acceleration) {
							var object = @com.ait.toolkit.cordova.client.accelerometer.Acceleration::new(Lcom/google/gwt/core/client/JavaScriptObject;)(acceleration);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.accelerometer.AccelerometerHandler::onSuccess(Lcom/ait/toolkit/cordova/client/accelerometer/Acceleration;)(object);
						}),
						$entry(function() {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.accelerometer.AccelerometerHandler::onError()();
						}));
    }-*/;

    /**
     * At a regular interval, get the acceleration along the x, y, and z axis.
     * 
     * @param callBack
     */
    public native String watchAcceleration(AccelerometerHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer
				.watchAcceleration(
						$entry(function(acceleration) {
							var object = @com.ait.toolkit.cordova.client.accelerometer.Acceleration::new(Lcom/google/gwt/core/client/JavaScriptObject;)(acceleration);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.accelerometer.AccelerometerHandler::onSuccess(Lcom/ait/toolkit/cordova/client/accelerometer/Acceleration;)(object);
						}),
						$entry(function() {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.accelerometer.AccelerometerHandler::onError()();
						}));
    }-*/;

    /**
     * At a regular interval, get the acceleration along the x, y, and z axis.
     * 
     * @param callBack
     * @param options
     */
    public native String watchAcceleration(AccelerometerHandler callBack, AccelerometerOptions options)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer
				.watchAcceleration(
						$entry(function(acceleration) {
							var object = @com.ait.toolkit.cordova.client.accelerometer.Acceleration::new(Lcom/google/gwt/core/client/JavaScriptObject;)(acceleration);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.accelerometer.AccelerometerHandler::onSuccess(Lcom/ait/toolkit/cordova/client/accelerometer/Acceleration;)(object);
						}),
						$entry(function() {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.accelerometer.AccelerometerHandler::onError()();
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Stop watching the Acceleration referenced by the watch ID parameter.
     * 
     * @param watchId
     *            , The ID returned by Accelerometer.watchAcceleration.
     */
    public native void clearWatch(String watchId)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.clearWatch(watchId);
    }-*/;

    private Accelerometer() {
        createPeer();
    }

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeAcceleromater();
    }

}
