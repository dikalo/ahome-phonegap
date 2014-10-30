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
import com.ait.toolkit.cordova.client.core.handlers.capture.MediaFileFormatDataHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.Date;

/**
 * Encapsulates properties of a media capture file.
 */
public class MediaFile extends JsObject {

    private MediaFile(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The name of the file, without path information
     * 
     * @return
     */
    public String getName() {
        return JsoHelper.getAttribute(jsObj, "name");
    }

    /**
     * The full path of the file, including the name.
     * 
     * @return
     */
    public String getFullPath() {
        return JsoHelper.getAttribute(jsObj, "fullPath");
    }

    /**
     * The mime type
     * 
     * @return
     */
    public String getType() {
        return JsoHelper.getAttribute(jsObj, "type");
    }

    /**
     * The date and time that the file was last modified
     * 
     * @return
     */
    public native Date getLastModifiedDate()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.lastModifiedDate;
    }-*/;

    /**
     * The size of the file, in bytes.
     * 
     * @return
     */
    public double getSize() {
        return JsoHelper.getAttributeAsDouble(jsObj, "size");
    }

    /**
     * Retrieves the format information of the media file
     * 
     * @param callBack
     */
    public native void getFormatData(MediaFileFormatDataHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getFormatData(
						$entry(function(data) {
							var object = @com.ait.toolkit.cordova.client.capture.MediaFileData::new(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.MediaFileFormatDataHandler::onSuccess(Lcom/ait/toolkit/cordova/client/capture/MediaFileData;)(object);
						}),
						$entry(function() {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.MediaFileFormatDataHandler::onError()();
						}));
    }-*/;

    private static ArrayList<MediaFile> fromJsArray(JsArray<JavaScriptObject> jsArray) {
        ArrayList<MediaFile> list = new ArrayList<MediaFile>();
        for (int i = 0; i < jsArray.length(); i++) {
            list.add(new MediaFile(jsArray.get(i)));
        }
        return list;
    }

}
