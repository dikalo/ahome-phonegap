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
import com.ait.toolkit.cordova.client.core.handlers.file.DirectoryReaderHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An object that lists files and directories in a directory.
 */
public class DirectoryReader extends JsObject {

    DirectoryReader(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * Read the entries in this directory.
     * 
     * @param handler
     */
    public native void readEntries(DirectoryReaderHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.readEntries(
						$entry(function(entries) {
							var entryList = @com.ait.toolkit.cordova.client.file.EntryBase::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(entries);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryReaderHandler::onSuccess(Ljava/util/List;)(entryList);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryReaderHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

}
