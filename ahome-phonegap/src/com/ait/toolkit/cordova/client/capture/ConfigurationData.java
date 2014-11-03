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
package com.ait.toolkit.cordova.client.capture;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Encapsulates a set of media capture parameters that a device supports.
 * 
 * This object is used to describe media capture modes supported by the device. 
 * The configuration data includes the MIME type, and capture dimensions (for video or image capture).
 * 
 * The MIME types should adhere to <a href=http://www.ietf.org/rfc/rfc2046.txt>RFC2046</a>. Examples:
 * <ul>
 * <li>video/3gpp</li>
 * <li>video/quicktime</li>
 * <li>image/jpeg</li>
 * <li>audio/amr</li>
 * <li>audio/wav</li>
 * </ul>
 */
public class ConfigurationData extends JsObject {
    
    private ConfigurationData(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Gets the media type.
     * 
     * @return String
     */
    public String getType() {
        return JsoHelper.getAttribute(jsObj, "type");
    }
    
    /**
     * Sets the media type.
     * 
     * @param value
     */
    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, "type", value);
    }

    /**
     * Gets the height of the image or video in pixels. In the case of a sound clip,
     * this attribute has value 0. has value 0
     * 
     * @return double
     */
    public double getHeight() {
        return JsoHelper.getAttributeAsDouble(jsObj, "height");
    }
    
    /**
     * Sets the height of the image or video in pixels. In the case of a sound clip,
     * this attribute has value 0. has value 0
     * 
     * @param value
     */
    public void setHeight(double value) {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    /**
     * Gets the width of the image or video in pixels. In the case of a sound clip,
     * this attribute has value 0. has value 0
     * 
     * @return double
     */
    public double getWidth() {
        return JsoHelper.getAttributeAsDouble(jsObj, "width");
    }
    
    /**
     * Sets the width of the image or video in pixels. In the case of a sound clip,
     * this attribute has value 0. has value 0
     * 
     * @param value
     */
    public void setWidth(double value) {
        JsoHelper.setAttribute(jsObj, "width", value);
    }    
}
