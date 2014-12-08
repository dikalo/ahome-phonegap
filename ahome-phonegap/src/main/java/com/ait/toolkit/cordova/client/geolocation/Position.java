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
import com.google.gwt.core.client.JavaScriptObject;

import java.util.Date;

/**
 * Contains Position coordinates that are created by the geolocation API.
 * 
 */
public class Position extends JsObject {

    Position(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * A set of geographic coordinates
     * 
     * @return
     */
    public Coordinates getCoords() {
        return new Coordinates(_getCoords());
    }

    private JavaScriptObject _getCoords() {
        return JsoHelper.getAttributeAsJavaScriptObject(jsObj, "coords");
    }
    
    /**
     * Creation timestamp for coords
     * 
     * @return
     */
    public Date getTimeStamp() {
        return JsoHelper.getAttributeAsDate(jsObj, "timestamp");
    }    
}
