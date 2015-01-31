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
 * A FileTransferProgress object is returned via the success callback of the
 * FileTransfer onProgress method.
 */
public class FileTransferProgress extends JsObject {

    FileTransferProgress(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Can the length of the transfer be calculated.
     * On both Android an iOS, lengthComputable is false for downloads that use gzip encoding.
     * 
     * @return boolean
     */
    public boolean isLengthComputable() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "lengthComputable");
    }

    /**
     * Gets the number of bytes that have been loaded.
     * 
     * @return double
     */
    public double getBytesLoaded() {
        return JsoHelper.getAttributeAsDouble(jsObj, "loaded");
    }

    /**
     * Gets the total number of bytes to transfer.
     * 
     * @return double
     */
    public double getTotalBytes() {
        return JsoHelper.getAttributeAsDouble(jsObj, "total");
    }

    /**
     * Gets percentage of bytes transfered.
     * 
     * @return double
     */
    public double getPercentTransferred() {
        if (isLengthComputable()) {
            return 100 * (getBytesLoaded() / getTotalBytes());
        }
        
        return -1;
    }
    
}
