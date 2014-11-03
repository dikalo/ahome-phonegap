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

import java.util.Date;

/**
 * This object contains attributes of a single file.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_file_file.md.html>
 *      http://docs.phonegap.com/en/2.7.0/cordova_file_file.md.html</a>
 */
public class File extends JsObject {

    private File(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The name of the file
     * 
     * @return
     */
    public String getName() {
        return JsoHelper.getAttribute(jsObj, "name");
    }

    /**
     * The full absolute path from the root to the FileEntry
     * 
     * @return
     */
    public String getFullPath() {
        return JsoHelper.getAttribute(jsObj, "fullPath");
    }

    /**
     * The mime type of the file.
     * 
     * @return
     */
    public String getType() {
        return JsoHelper.getAttribute(jsObj, "type");
    }

    /**
     * The last time the file was modified.
     * 
     * @return
     */
    public Date getLastModifiedDate() {
        return JsoHelper.getAttributeAsDate(jsObj, "lastModifiedDate");
    }

    /**
     * The size of the file in bytes
     * 
     * @return
     */
    public double getSize() {
        return JsoHelper.getAttributeAsDouble(jsObj, "size");
    }

    /**
     * Returns a new File object, for which FileReader will return only the
     * specified portion of the file. Negative values for start or end are
     * measured from the end of the file. The indexes are always relative to the
     * current slice.
     * 
     * @param start
     *            The index of the first byte to read, inclusive.
     * @param end
     *            The index of the byte after the last one to read.
     */
    public native File slice(int start, int end) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.slice(start, end);
		return @com.ait.toolkit.cordova.client.file.File::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;
}
