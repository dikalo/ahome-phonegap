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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Create native device modules
 */
public class ModuleFactory {

    private ModuleFactory() {

    }

    public static native JavaScriptObject createNativeAcceleromater()/*-{
		return $wnd.navigator.accelerometer;
    }-*/;

    public static native JavaScriptObject createNativeCamera()/*-{
		return $wnd.navigator.camera;
    }-*/;

    public static native JavaScriptObject createNativeNotification()/*-{
		return $wnd.navigator.notification;
    }-*/;

    public static native JavaScriptObject createNativeCapture()/*-{
		return $wnd.navigator.device.capture;
    }-*/;

    public static native JavaScriptObject createNativeCompass()/*-{
		return $wnd.navigator.compass;
    }-*/;

    public static native JavaScriptObject createNativeConnection()/*-{
		return $wnd.navigator.connection;
    }-*/;

    public static native JavaScriptObject createNativeContacts()/*-{
		return $wnd.navigator.contacts;
    }-*/;

    public static native JavaScriptObject createNativeDevice()/*-{
		return $wnd.device;
    }-*/;

    public static native JavaScriptObject createNativeGeoLocation()/*-{
		return $wnd.navigator.geolocation;
    }-*/;
    
    public static native JavaScriptObject createNativeGlobalization()/*-{
        return $wnd.navigator.globalization;
    }-*/;
    
    public static native JavaScriptObject createNativeSplashScreen()/*-{
        return $wnd.navigator.splashscreen;
    }-*/;

    public static native JavaScriptObject createNativeInAppBrowser()/*-{
        return $wnd.window;
    }-*/;
}
