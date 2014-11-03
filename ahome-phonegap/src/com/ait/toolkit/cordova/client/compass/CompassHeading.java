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
package com.ait.toolkit.cordova.client.compass;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A CompassHeading object is returned to the compassSuccess callback function
 * when an error occurs.
 */
public class CompassHeading extends JsObject {

    private CompassHeading(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Gets the heading in degrees from 0 - 359.99 at a single moment in time.
     * 
     * @return double
     */
    public double getMagneticHeading() {
        return JsoHelper.getAttributeAsDouble(jsObj, "magneticHeading");
    }

    /**
     * Gets the heading relative to the geographic North Pole in degrees 0 - 359.99
     * at a single moment in time. A negative value indicates that the true
     * heading could not be determined.
     * 
     * @return double
     */
    public double getTrueHeading() {
        return JsoHelper.getAttributeAsDouble(jsObj, "trueHeading");
    }

    /**
     * Gets the deviation in degrees between the reported heading and the true
     * heading.
     * 
     * @return
     */
    public double getHeadingAccuracy() {
        return JsoHelper.getAttributeAsDouble(jsObj, "headingAccuracy");
    }

    /**
     * Gets the time at which this heading was determined, in millis.
     * 
     * @return double
     */
    public double getTimeStamp() {
        return JsoHelper.getAttributeAsDouble(jsObj, "timestamp");
    }

}
