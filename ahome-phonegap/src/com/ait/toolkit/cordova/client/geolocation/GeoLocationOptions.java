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

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

public class GeoLocationOptions extends JsObject {

    public GeoLocationOptions() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * Provides a hint that the application would like to receive the best
     * possible results
     * 
     * @param value
     */
    public void setEnableHighAccuracy(boolean value) {
        JsoHelper.setAttribute(jsObj, "enableHighAccuracy", value);
    }

    /**
     * The maximum length of time (millis) that is allowed to pass from the call
     * to geolocation.getCurrentPosition or geolocation.watchPosition until the
     * corresponding geolocationSuccess callback is invoked
     * 
     * @param value
     */
    public void setTimeout(double value) {
        JsoHelper.setAttribute(jsObj, "timeout", value);
    }

    /**
     * Accept a cached position whose age is no greater than the specified time
     * in milliseconds
     * 
     * @param value
     */
    public void setMaximumAge(double value) {
        JsoHelper.setAttribute(jsObj, "maximumAge", value);
    }
}
