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
import com.ait.toolkit.cordova.client.core.handlers.file.FileReaderHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The FileReader object is a way to read files from the devices file system.
 * Files can be read as text or as a base64 data encoded string. Users register
 * their own event listners to receive the loadstart, progress, load, loadend,
 * error and abort events.
 */
public class FileReader extends JsObject {

    public static final int EMPTY = 0;
    public static final int LOADING = 1;
    public static final int DONE = 2;

    private FileReader(JavaScriptObject obj) {
        jsObj = obj;
    }

    public FileReader() {
        jsObj = createPeer();
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
     * The contents of the file that has been read.
     * 
     * @return
     */
    public String getResult() {
        return JsoHelper.getAttribute(jsObj, "result");
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
     * Aborts reading file.
     */
    public native void abort()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.abort();
    }-*/;

    /**
     * Read file and return data as a base64 encoded data url.
     */
    public native void readAsDataUrl(File file)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.readAsDataUrl(file.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Reads text file.
     */
    public native void readAsText(File file)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.readAsText(file.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Read file and return data as a base64 encoded data url.
     */
    public native void readAsDataUrl(DirectoryEntry file)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.readAsDataUrl(file.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Reads text file.
     */
    public native void readAsText(DirectoryEntry file)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.readAsText(file.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Reads file as binary and returns a binary string.
     *
     * @param file
     */
    public native void readAsBinaryString(DirectoryEntry file)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
            .readAsBinaryString(file.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Reads file as an ArrayBuffer.
     *
     * @param file
     */
    public native void readAsArrayBuffer(DirectoryEntry file)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
            .readAsArrayBuffer(file.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Called when the read starts
     * 
     * @param handler
     */
    public native void onLoadStart(FileReaderHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onloadStart = $entry(function(reader) {
			var readerObject = @com.ait.toolkit.cordova.client.file.FileReader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(reader);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileReaderHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileReader;)(readerObject);
		});
    }-*/;

    /**
     * Called when the read has successfully completed
     * 
     * @param handler
     */
    public native void onLoad(FileReaderHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onload = $entry(function(reader) {
			var readerObject = @com.ait.toolkit.cordova.client.file.FileReader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(reader);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileReaderHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileReader;)(readerObject);
		});
    }-*/;

    /**
     * Called when the read has been aborted. For instance, by invoking the
     * abort() method
     * 
     * @param handler
     */
    public native void onAbort(FileReaderHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onabort = $entry(function(reader) {
			var readerObject = @com.ait.toolkit.cordova.client.file.FileReader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(reader);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileReaderHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileReader;)(readerObject);
		});
    }-*/;

    /**
     * Called when the read has failed.
     * 
     * @param handler
     */
    public native void onError(FileReaderHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onerror = $entry(function(reader) {
			var readerObject = @com.ait.toolkit.cordova.client.file.FileReader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(reader);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileReaderHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileReader;)(readerObject);
		});
    }-*/;

    /**
     * Called when the request has completed (either in success or failure)
     * 
     * @param handler
     */
    public native void onLoadEnd(FileReaderHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.onloadEnd = $entry(function(reader) {
			var readerObject = @com.ait.toolkit.cordova.client.file.FileReader::new(Lcom/google/gwt/core/client/JavaScriptObject;)(reader);
			handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileReaderHandler::onEvent(Lcom/ait/toolkit/cordova/client/file/FileReader;)(readerObject);
		});
    }-*/;

    private native JavaScriptObject createPeer()/*-{
		return new $wnd.FileReader();
    }-*/;

}
