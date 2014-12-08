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
 * A handle to the popover dialog created by camera.getPicture.
 *
 * Supported platforms:
 * iOS
 */
public class CameraPopoverHandle extends JsObject
{

    /**
     * Constructor.
     */
    public CameraPopoverHandle()
    {
        jsObj = JsoHelper.createObject();
    }

    /**
     * Set the position of the popover.
     * 
     * @param value
     */
    public native void setPosition(CameraPopoverOptions value)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
                .setPosition(value.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;
}
