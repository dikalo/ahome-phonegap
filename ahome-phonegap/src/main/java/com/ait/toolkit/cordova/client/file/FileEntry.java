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

import com.ait.toolkit.cordova.client.core.handlers.file.FileHandler;
import com.ait.toolkit.cordova.client.core.handlers.file.FileWriterCreationHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This object represents a file on a file system. It is defined in the W3C
 * Directories and Systems specification.
 * 
 */
public class FileEntry extends EntryBase {

    protected FileEntry(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * Create a FileWriter object associated with the file that the FileEntry
     * represents.
     */
    public native void createWriter(FileWriterCreationHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.createWriter(
						$entry(function(w) {
							var writerObject = @com.ait.toolkit.cordova.client.file.FileWriter::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileWriterCreationHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/FileWriter;)(writerObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileWriterCreationHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

    /**
     * Return a File object that represents the current state of the file that
     * this FileEntry represents.
     */
    public native void getFile(FileHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.file(
						$entry(function(file) {
							var fileObject = @com.ait.toolkit.cordova.client.file.File::new(Lcom/google/gwt/core/client/JavaScriptObject;)(file);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/File;)(fileObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

}
