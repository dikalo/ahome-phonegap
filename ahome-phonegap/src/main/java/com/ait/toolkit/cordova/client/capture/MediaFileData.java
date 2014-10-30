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
 * Encapsulates format information about a media file.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.2.0/cordova_media_capture_capture.md.html#MediaFileData>
 * http://docs.phonegap.com/en/2.2.0/cordova_media_capture_capture.md.html#MediaFileData</a>
 * 
 */
public class MediaFileData extends JsObject {

    private MediaFileData(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The actual format of the audio and video content.
     * 
     * @return
     */
    public String getCodes() {
        return JsoHelper.getAttribute(jsObj, "codecs");
    }

    /**
     * The average bitrate of the content. In case of an image, this attribute
     * has value 0
     * 
     * @return
     */
    public double getBitRate() {
        return JsoHelper.getAttributeAsDouble(jsObj, "bitrate");
    }

    /**
     * The height of the image or video in pixels. In the case of a sound clip,
     * this attribute has value 0. has value 0
     * 
     * @return
     */
    public double getHeight() {
        return JsoHelper.getAttributeAsDouble(jsObj, "height");
    }

    /**
     * The width of the image or video in pixels. In the case of a sound clip,
     * this attribute has value 0. has value 0
     * 
     * @return
     */
    public double getWidth() {
        return JsoHelper.getAttributeAsDouble(jsObj, "width");
    }

    /**
     * The length of the video or sound clip in seconds. In the case of an
     * image, this attribute has value 0
     * 
     * @return
     */
    public double getDuration() {
        return JsoHelper.getAttributeAsDouble(jsObj, "duration");
    }
}
