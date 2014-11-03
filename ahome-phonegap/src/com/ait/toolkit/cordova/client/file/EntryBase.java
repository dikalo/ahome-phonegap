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
import com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler;
import com.ait.toolkit.cordova.client.core.handlers.file.MetadataActionHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for FileEntry and DirectoryEntry
 * 
 */
public class EntryBase extends JsObject {

    protected EntryBase(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * always true
     * 
     * @return
     */
    public boolean isFile() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "isFile");
    }

    /**
     * always false for a FileEntry, true for a directory entry
     * 
     * @return
     */
    public boolean isDirectory() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "isDirectory");
    }

    /**
     * The name of the file entry, excluding the path leading to it
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
     * Look up metadata about a file.
     * 
     * @return
     */
    public native Metadata getMetadata()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.getMetadata();
		var toReturn = @com.ait.toolkit.cordova.client.file.Metadata::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;
    
    /**
     * Set metadata on a file.  Only works on iOS currently.
     * 
     * @param metadata
     * @param handler
     */
    public native void setMetadata(Metadata metadata, MetadataActionHandler handler)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
                .setMetadata(
                            $entry(function() {
                                handler.@com.ait.toolkit.cordova.client.core.handlers.file.MetadataActionHandler::onSuccess()();
                            }),
                            $entry(function() {
                                handler.@com.ait.toolkit.cordova.client.core.handlers.file.MetadataActionHandler::onError()();
                            }),
                            metatada.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Move a file to a different location on the file system. It is an error to
     * attempt to:
     * <ul>
     * <li>move a file into its parent if a name different from its current one
     * isn't provided</li>
     * <li>move a file to a path occupied by a directory</li>
     * </ul>
     * In addition, an attempt to move a file on top of an existing file must
     * attempt to delete and replace that file.
     * 
     * @param parent
     * @param newName
     * @param handler
     */
    public native void moveTo(DirectoryEntry parent, String newName, FileActionHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.moveTo(
						parent.@com.ait.toolkit.core.client.JsObject::getJsObj()(),
						newName,
						$entry(function(entry) {
							var entryObject = @com.ait.toolkit.cordova.client.file.EntryBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(entry);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/EntryBase;)(entryObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

    /**
     * Copy a file to a new location on the file system. It is an error to
     * attempt to:
     * <ul>
     * <li>copy a file into its parent if a name different from its current one
     * is not provided.</li>
     * </ul>
     * 
     * 
     * @param parent
     * @param newName
     * @param handler
     */
    public native void copyTo(DirectoryEntry parent, String newName, FileActionHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.copyTo(
						parent.@com.ait.toolkit.core.client.JsObject::getJsObj()(),
						newName,
						$entry(function(entry) {
							var entryObject = @com.ait.toolkit.cordova.client.file.EntryBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(entry);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/EntryBase;)(entryObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

    /**
     * Returns a URL that can be used to locate the file.
     * 
     * @return
     */
    public native String toURL()/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        return peer.toURL();
    }-*/;    

    /**
     * Deletes a file.
     */
    public native void remove(FileActionHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.remove(
						$entry(function(entry) {
							var entryObject = @com.ait.toolkit.cordova.client.file.EntryBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(entry);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/EntryBase;)(entryObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

    /**
     * Look up the parent DirectoryEntry containing the file.
     */
    public native void getParent(FileActionHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getParent(
						$entry(function(entry) {
							var entryObject = @com.ait.toolkit.cordova.client.file.EntryBase::new(Lcom/google/gwt/core/client/JavaScriptObject;)(entry);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/EntryBase;)(entryObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileActionHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileError;)(error);
						}));
    }-*/;

    public FileEntry asFileEntry() {
        return new FileEntry(jsObj);
    }

    public DirectoryEntry asDirectoryEntry() {
        return new DirectoryEntry(jsObj);
    }

    private static List<EntryBase> fromJsArray(JsArray<JavaScriptObject> values) {
        List<EntryBase> list = new ArrayList<EntryBase>();
        for (int i = 0; i < values.length(); i++) {
            list.add(new EntryBase(values.get(i)));
        }
        return list;
    }

}
