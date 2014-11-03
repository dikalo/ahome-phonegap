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
import com.ait.toolkit.cordova.client.core.handlers.file.FileWriterHandler;
import com.google.gwt.core.client.JavaScriptObject;

public class FileWriter extends JsObject {

    public static final int INIT = 0;
    public static final int WRITING = 1;
    public static final int DONE = 2;

    private FileWriter(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * One of the three states the reader can be in EMPTY, LOADING or DONE.
     * 
     * @return
     */
    public int getReadyState() {
        return JsoHelper.getAttributeAsInt(jsObj, "readyState");
    }

    /**
     * The name of the file to be written
     * 
     * @return
     */
    public String getFileName() {
        return JsoHelper.getAttribute(jsObj, "fileName");
    }

    /**
     * The length of the file to be written.
     * 
     * @return
     */
    public double getLength() {
        return JsoHelper.getAttributeAsDouble(jsObj, "length");
    }

    /**
     * The current position of the file pointer
     * 
     * @return
     */
    public double getPosition() {
        return JsoHelper.getAttributeAsDouble(jsObj, "position");
    }

    /**
     * An object containing errors
     * 
     * @return
     */
    public FileError getError() {
        return new FileError(JsoHelper.getAttributeAsJavaScriptObject(jsObj, "error"));
    }

    /**
     * Aborts writing file.
     */
    public native void abort()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.abort();
    }-*/;

    /**
     * Moves the file pointer to the byte specified.
     */
    public native void seek(int bytes)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.seek(bytes);
    }-*/;

    /**
     * Shortens the file to the length specified.
     */
    public native void truncate(int length)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.truncate(length);
    }-*/;

    /**
     * Writes data to the file.
     */
    public native void write(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.write(value);
    }-*/;

    /**
     * Called when the write starts
     * 
     * @param handler
     */
    public native void onWriteStart(FileWriterHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onwriteStart = $entry(function(w) {
			var writerObject = @com.ait.toolkit.cordova.client.file.FileWriter::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileWriterHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileWriter;)(writerObject);
		});
    }-*/;

    /**
     * Called when the request has completed successfully
     * 
     * @param handler
     */
    public native void onWrite(FileWriterHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onwrite = $entry(function(w) {
			var writerObject = @com.ait.toolkit.cordova.client.file.FileWriter::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileWriterHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileWriter;)(writerObject);
		});
    }-*/;

    /**
     * Called when the request has completed successfully
     * 
     * @param handler
     */
    public native void onAbort(FileWriterHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onabort = $entry(function(w) {
			var writerObject = @com.ait.toolkit.cordova.client.file.FileWriter::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileWriterHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileWriter;)(writerObject);
		});
    }-*/;

    /**
     * 
     * Called when the write has failed.
     * 
     * @param handler
     */
    public native void onError(FileWriterHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onerror = $entry(function(w) {
			var writerObject = @com.ait.toolkit.cordova.client.file.FileWriter::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileWriterHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileWriter;)(writerObject);
		});
    }-*/;

    /**
     * 
     * Called when the request has completed (either in success or failure).
     * 
     * @param handler
     */
    public native void onWriteEnd(FileWriterHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onwriteEnd = $entry(function(w) {
			var writerObject = @com.ait.toolkit.cordova.client.file.FileWriter::new(Lcom/google/gwt/core/client/JavaScriptObject;)(w);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileWriterHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileWriter;)(writerObject);
		});
    }-*/;
}
