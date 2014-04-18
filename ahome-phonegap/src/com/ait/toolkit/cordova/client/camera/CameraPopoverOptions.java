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

package com.ait.toolkit.cordova.client.camera;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

/**
 * Parameters only used by iOS to specify the anchor element location and 
 * arrow direction of popover used on iPad when selecting images from the 
 * library or album.
 * 
 * Note that the size of the popover may change to adjust to the direction 
 * of the arrow and orientation of the screen. Make sure to account for 
 * orientation changes when specifying the anchor element location.
 */
public class CameraPopoverOptions extends JsObject
{

    /**
     * Constructor.
     */
    public CameraPopoverOptions()
    {
        jsObj = JsoHelper.createObject();
    }

    /**
     * Sets the X pixel coordinate of the element on the screen to anchor popover onto.
     * 
     * @param value
     */
    public void setX(double value)
    {
        JsoHelper.setAttribute(jsObj, "x", value);
    }

    /**
     * Sets the Y pixel coordinate of the element on the screen to anchor popover onto.
     * 
     * @param value
     */
    public void setY(double value)
    {
        JsoHelper.setAttribute(jsObj, "y", value);
    }

    /**
     * Sets the width, in pixels, of the element on the screen to anchor popover onto.
     * 
     * @param value
     */
    public void setWidth(double value)
    {
        JsoHelper.setAttribute(jsObj, "width", value);
    }

    /**
     * Sets the height, in pixels, of the element on the screen to anchor popover onto.
     * 
     * @param value
     */
    public void setHeight(double value)
    {
        JsoHelper.setAttribute(jsObj, "height", value);
    }

    /**
     * Sets the direction the arrow on the popover should point.
     * 
     * @param value
     */
    public void setArrowDirection(PopoverArrowDirection value)
    {
        JsoHelper.setAttribute(jsObj, "arrowDir", value.getValue());
    }
}
