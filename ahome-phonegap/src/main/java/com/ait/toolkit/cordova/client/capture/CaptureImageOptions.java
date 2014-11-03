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

/**
 * Encapsulates image capture configuration options.
 * 
 */
public class CaptureImageOptions extends JsObject {

    public CaptureImageOptions() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * Sets the maximum number of audio clips the device user can record in a single
     * capture operation. The value must be greater than or equal to 1 (defaults
     * to 1).
     * 
     * @param value 
     */
    public void seLimit(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Limit must be greater than or equal to 1");
        }
        
        JsoHelper.setAttribute(jsObj, "limit", value);
    }

    /**
     * Gets the maximum number of audio clips the device user can record in a single
     * capture operation. The value must be greater than or equal to 1 (defaults
     * to 1).
     * @return
     */
    public int getLimit() {
        return JsoHelper.getAttributeAsInt(jsObj, "limit");
    }
}
