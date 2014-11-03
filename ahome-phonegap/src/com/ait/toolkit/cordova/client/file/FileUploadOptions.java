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
package com.ait.toolkit.cordova.client.file;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

import java.util.Map;

/**
 * A FileUploadOptions object can be passed to the FileTransfer objects upload
 * method in order to specify additional parameters to the upload script.
 * 
 */
public class FileUploadOptions extends JsObject {

    FileUploadOptions() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * The name of the form element. If not set defaults to "file"
     * 
     * @param value
     */
    public void setFileKey(String value) {
        JsoHelper.setAttribute(jsObj, "fileKey", value);
    }

    /**
     * The file name you want the file to be saved as on the server. If not set
     * defaults to "image.jpg"
     * 
     * @param value
     */
    public void setFileName(String value) {
        JsoHelper.setAttribute(jsObj, "fileName", value);
    }

    /**
     * The mime type of the data you are uploading. If not set defaults to
     * "image/jpeg"
     * 
     * @param value
     */
    public void setMimeType(String value) {
        JsoHelper.setAttribute(jsObj, "mimeType", value);
    }

    /**
     * A set of optional key/value pairs to be passed along in the HTTP request.
     * 
     * @param value
     */
    public void setParams(Map<String, String> value) {
        JsoHelper.setAttribute(jsObj, "params", value);
    }

    /**
     * Should the data be uploaded in chunked streaming mode. If not set
     * defaults to "true"
     * 
     * @param value
     */
    public void setChunkMode(boolean value) {
        JsoHelper.setAttribute(jsObj, "chunkMode", value);
    }
    
    /**
     *  A map of header name => header value. To specify multiple values for a
     *  header, use an array of values. 
     * 
     * @param value
     */
    public void setHeaders(Map<String, String> value) {
        JsoHelper.setAttribute(jsObj, "headers", value);
    }

}
