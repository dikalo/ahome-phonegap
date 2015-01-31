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

import com.ait.toolkit.cordova.client.core.handlers.file.DirectoryHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This object represents a directory on a file system. It is defined in the W3C
 * Directories and Systems specification.
 */
public class DirectoryEntry extends FileEntry {

    DirectoryEntry(JavaScriptObject obj) {
        super(obj);
    }

    /**
     * Creates a new DirectoryReader to read entries in a directory.
     * 
     * @return {@link DirectoryReader}
     */
    public native DirectoryReader createReader()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.createReader();
		var toReturn = @com.ait.toolkit.cordova.client.file.DirectoryReader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Creates or looks up an existing directory. It is an error to attempt to
     * create a directory whose immediate parent does not yet exist.
     * 
     * @param path
     * @param flags
     * @param handler
     */
    public native void getDirectory(String path, Flags flags, DirectoryHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getDirectory(
						path,
						flags.@com.ait.toolkit.core.client.JsObject::getJsObj()(),
						$entry(function(parent) {
							var parentObject = @com.ait.toolkit.cordova.client.file.DirectoryEntry::new(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/DirectoryEntry;)(parentObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

    /**
     * Creates or looks up an existing directory. It is an error to attempt to
     * create a directory whose immediate parent does not yet exist.
     * 
     * @param path
     * @param flags
     * @param handler
     */
    public native void getFile(String path, Flags flags, DirectoryHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getFile(
						path,
						flags.@com.ait.toolkit.core.client.JsObject::getJsObj()(),
						$entry(function(parent) {
							var parentObject = @com.ait.toolkit.cordova.client.file.DirectoryEntry::new(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/DirectoryEntry;)(parentObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

    /**
     * Deletes a directory and all of its contents. In the event of an error
     * (e.g. trying to delete a directory that contains a file that cannot be
     * removed), some of the contents of the directory may be deleted.
     * 
     * It is an error to attempt to delete the root directory of a filesystem.
     * 
     * @param handler
     */
    public native void removeRecursively(DirectoryHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.removeRecursively(
						$entry(function(parent) {
							var parentObject = @com.ait.toolkit.cordova.client.file.DirectoryEntry::new(Lcom/google/gwt/core/client/JavaScriptObject;)(parent);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/DirectoryEntry;)(parentObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.DirectoryHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

}
