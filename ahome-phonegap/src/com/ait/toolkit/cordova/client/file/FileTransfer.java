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
import com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler;
import com.ait.toolkit.cordova.client.core.handlers.file.FileTransferProgressHandler;
import com.google.gwt.core.client.JavaScriptObject;

import java.util.Map;

/**
 * The FileTransfer object provides a way to upload files to a remote server
 * using an HTTP multi-part POST request. Both HTTP and HTTPS protocols are
 * supported. Optional parameters can be specified by passing a
 * FileUploadOptions object to the upload method. On successful upload, the
 * success callback will be called with a FileUploadResult object. If an error
 * occurs, the error callback will be invoked with a FileTransferError object.
 * It is also possible to download a file from remote and save it on the device
 * (only iOS and Android).
 */
public class FileTransfer extends JsObject {

    public FileTransfer() {
        jsObj = createPeer();
    }

    /**
     * Called whenever a new chunk of data is transferred.
     * 
     * @param handler
     */
    public native void addFileTransferProgressHandler(FileTransferProgressHandler handler)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer.onprogress = $entry(function(progressEvent) {
            var progressObject = @com.ait.toolkit.cordova.client.file.FileTransferProgress::new(Lcom/google/gwt/core/client/JavaScriptObject;)(progressEvent);
            handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferProgressHandler::onProgress(Lcom/ait/toolkit/cordova/client/file/FileTransferProgress;)(progressEvent);
        });
    }-*/;
    
    /**
     * sends a file to a server.
     * 
     * @param filePath
     * @param server
     * @param handler
     */
    public native void upload(String filePath, String server, FileTransferHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.upload(
						filePath,
						server,
						$entry(function(r) {
							var result = @com.ait.toolkit.cordova.client.file.FileUploadResult::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
							hander.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/FileUploadResult;)(result);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileTransferError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileTransferError;)(errorObject);
						}));
    }-*/;

    /**
     * sends a file to a server.
     * 
     * @param filePath
     * @param server
     * @param handler
     * @param options
     */
    public native void upload(String filePath, String server, FileTransferHandler handler, FileUploadOptions options)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.upload(
						filePath,
						server,
						$entry(function(r) {
							var result = @com.ait.toolkit.cordova.client.file.FileUploadResult::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
							hander.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/FileUploadResult;)(result);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileTransferError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileTransferError;)(errorObject);
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * sends a file to a server.
     *
     * @param filePath
     * @param server
     * @param handler
     * @param options
     * @param trustAllHosts
     */
    public native void upload(String filePath, String server, FileTransferHandler handler, FileUploadOptions options, boolean trustAllHosts)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
            .upload(
                filePath,
                server,
                $entry(function(r) {
                    var result = @com.ait.toolkit.cordova.client.file.FileUploadResult::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
                    hander.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/FileUploadResult;)(result);
                }),
                $entry(function(error) {
                    var errorObject = @com.ait.toolkit.cordova.client.file.FileTransferError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
                    handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileTransferError;)(errorObject);
                }),
                options.@com.ait.toolkit.core.client.JsObject::getJsObj()(),
                trustAllHosts
            );
    }-*/;

    /**
     * download a file from a server.
     * 
     * @param source, URL of the server to receive the file
     * @param target, Full path of the file on the device
     * @param handler
     */
    public native void download(String source, String target, FileTransferHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.download(
						source,
						target,
						$entry(function(r) {
							var result = @com.ait.toolkit.cordova.client.file.FileUploadResult::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
							hander.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/FileUploadResult;)(result);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.file.FileTransferError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileTransferError;)(errorObject);
						}));
    }-*/;

    /**
     * download a file from a server.
     *
     * @param source, URL of the server to receive the file
     * @param target, Full path of the file on the device
     * @param handler
     * @param trustAllHosts  Optional parameter, defaults to false. If set to true then it will accept all security certificates. This is useful as Android rejects self signed security certificates.
     *                       Not recommended for production use.
     */
    public native void download(String source, String target, FileTransferHandler handler, boolean trustAllHosts)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
            .download(
                source,
                target,
                $entry(function(r) {
                    var result = @com.ait.toolkit.cordova.client.file.FileUploadResult::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
                    hander.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/FileUploadResult;)(result);
                }),
                $entry(function(error) {
                    var errorObject = @com.ait.toolkit.cordova.client.file.FileTransferError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
                    handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileTransferError;)(errorObject);
                }),
                trustAllHosts
            );
    }-*/;

    /**
     * download a file from a server.
     *
     * @param source, URL of the server to receive the file
     * @param target, Full path of the file on the device
     * @param handler
     * @param trustAllHosts  Optional parameter, defaults to false. If set to true then it will accept all security certificates. This is useful as Android rejects self signed security certificates.
     *                       Not recommended for production use.
     * @param options Optional parameters, currently only supports headers (such as Authorization (Basic Authentication), etc).
     */
    public native void download(String source, String target, FileTransferHandler handler, boolean trustAllHosts, Map<String, String> options)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
            .download(
                source,
                target,
                $entry(function(r) {
                    var result = @com.ait.toolkit.cordova.client.file.FileUploadResult::new(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
                    hander.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onSuccess(Lcom/ait/toolkit/cordova/client/file/FileUploadResult;)(result);
                }),
                $entry(function(error) {
                    var errorObject = @com.ait.toolkit.cordova.client.file.FileTransferError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
                    handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileTransferError;)(errorObject);
                }),
                trustAllHosts,
                options
            );
    }-*/;
    
    /**
     * Aborts an ongoing transfer.
     * 
     * @param handler
     */
    public native void abort(FileTransferHandler handler)/*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer
                .abort(
                        $entry(function(error) {
                            var errorObject = @com.ait.toolkit.cordova.client.file.FileTransferError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
                            handler.@com.ait.toolkit.cordova.client.core.handlers.file.FileTransferHandler::onError(Lcom/ait/toolkit/cordova/client/file/FileTransferError;)(errorObject);
                        }));
    }-*/;    

    private native JavaScriptObject createPeer()/*-{
		return new $wnd.FileTransfer();
    }-*/;

}
