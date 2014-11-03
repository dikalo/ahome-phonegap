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
 * Optional parameters to customize the camera settings.
 */
public class CameraOptions extends JsObject {

    public CameraOptions() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * Quality of saved image. Range is [0, 100].
     * 
     * @param value
     */
    public void setQuality(double value) {
        JsoHelper.setAttribute(jsObj, "quality", value);
    }

    /**
     * Choose the format of the return value
     * 
     * @param value
     */
    public void setDestinationType(DestinationType value) {
        JsoHelper.setAttribute(jsObj, "destinationType", value.getValue());
    }

    /**
     * Set the source of the picture
     * 
     * @param value
     */
    public void setSourceType(PictureSourceType value) {
        JsoHelper.setAttribute(jsObj, "sourceType", value.getValue());
    }

    /**
     * Set the source of the picture
     * 
     * @param value
     */
    public void setAllowEdit(boolean value) {
        JsoHelper.setAttribute(jsObj, "allowEdit", value);
    }

    /**
     * Choose the encoding of the returned image file
     * 
     * @param value
     */
    public void setEncodingType(EncodingType value) {
        JsoHelper.setAttribute(jsObj, "encodingType", value.getValue());
    }

    /**
     * Width in pixels to scale image. Must be used with targetHeight. Aspect
     * ratio is maintained
     * 
     * @param value
     */
    public void setTargetWidth(double value) {
        JsoHelper.setAttribute(jsObj, "targetWidth", value);
    }

    /**
     * Height in pixels to scale image. Must be used with targetHeight. Aspect
     * ratio is maintained
     * 
     * @param value
     */
    public void setTargetHeight(double value) {
        JsoHelper.setAttribute(jsObj, "targetHeight", value);
    }

    /**
     * Set the type of media to select from. Only works when PictureSourceType
     * is PHOTOLIBRARY or SAVEDPHOTOALBUM.
     * 
     * @param value
     */
    public void setMediaType(MediaType value) {
        JsoHelper.setAttribute(jsObj, "mediaType", value.getValue());
    }

    /**
     * iOS only options to specify popover location in iPad. Defined in {@link CameraPopoverOptions} 
     * 
     * @param value
     */
    public void setPopoverOptions(CameraPopoverOptions value) {
        JsoHelper.setAttribute(jsObj, "popoverOptions", value);
    }
    
    /**
     *  Save the image to the photo album on the device after capture.
     *  
     *  @param value
     */
    public void setSaveToPhotoAlbum(boolean value) {
        JsoHelper.setAttribute(jsObj, "saveToPhotoAlbum", value);
    }

    /**
     * Choose the camera to use (front- or back-facing).
     *
     * @param value
     */
    public void setCameraDirection(CameraDirection value) {
        JsoHelper.setAttribute(jsObj, "cameraDirection", value.getValue());
    }
}
