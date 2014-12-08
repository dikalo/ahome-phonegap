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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A FileUploadResult object is returned via the success callback of the
 * FileTransfer upload method.
 * 
 */
public class FileUploadResult extends JsObject {

    FileUploadResult(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Gets the number of bytes sent to the server as part of the upload
     * 
     * @return double
     */
    public double getBytesSent() {
        return JsoHelper.getAttributeAsDouble(jsObj, "bytesSent");
    }

    /**
     * Gets the HTTP response code returned by the server.
     * 
     * @return int
     */
    public int getResponseCode() {
        return JsoHelper.getAttributeAsInt(jsObj, "responseCode");
    }

    /**
     * The HTTP response returned by the server
     * 
     * @return String
     */
    public String getResponse() {
        return JsoHelper.getAttribute(jsObj, "response");
    }

}
