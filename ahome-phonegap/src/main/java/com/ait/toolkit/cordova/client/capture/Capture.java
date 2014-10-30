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
package com.ait.toolkit.cordova.client.capture;

import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;
import com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler;

/**
 * Provides access to the audio, image, and video capture capabilities of the
 * device.<br/><br/>
 * Supported Platforms:
 * <ul>
 * <li>Android</li>
 * <li>BlackBerry WebWorks (OS 5.0 and higher)</li>
 * <li>iOS</li>
 * <li>Windows Phone 7 (Mango)</li>
 * </ul>
 * <br/>
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_media_capture_capture.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_media_capture_capture.md.html</a>
 */
public class Capture extends Module {

    private static Capture instance = null;

    /**
     * Gets the unique instance of the Capture object.
     * 
     * @return 
     */
    public static Capture get() {
        if (instance == null) {
            instance = new Capture();
        }
        return instance;
    }

    private Capture() {
        createPeer();
    }

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeCapture();
    }

    /**
     * This method starts an asynchronous operation to capture audio recordings using 
     * the device's default audio recording application. The operation allows the device 
     * user to capture multiple recordings in a single session.
     * 
     * Supported Platforms:
     * <ul>
     * <li>Android</li>
     * <li>BlackBerry WebWorks (OS 5.0 and higher)</li>
     * <li>iOS</li>
     * <li>Windows Phone 7 (Mango)</li>
     * </ul>
     *
     * @param callBack
     */
    public native void captureAudio(CaptureHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.captureAudio(
						$entry(function(mediaFiles) {
							var list = @com.ait.toolkit.cordova.client.capture.MediaFile::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(mediaFiles);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onSucces(Ljava/util/ArrayList;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.capture.CaptureError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onError(Lcom/ait/toolkit/cordova/client/capture/CaptureError;)(errorObject);
						}));

    }-*/;

    /**
     * This method starts an asynchronous operation to capture audio recordings using 
     * the device's default audio recording application. The operation allows the device 
     * user to capture multiple recordings in a single session. 
     * 
     * The capture operation ends when either the user exits the audio recording application, 
     * or the maximum number of recordings, specified by the limit parameter in 
     * CaptureAudioOptions, has been reached. If no value is provided for the limit parameter, 
     * a default value of one (1) is used, and the capture operation will terminate after 
     * the user records a single audio clip.
     * 
     * Supported Platforms:
     * <ul>
     * <li>Android</li>
     * <li>BlackBerry WebWorks (OS 5.0 and higher)</li>
     * <li>iOS</li>
     * <li>Windows Phone 7 (Mango)</li>
     * </ul>
     * 
     * @param callBack
     * @param options
     */
    public native void captureAudio(CaptureHandler callBack, CaptureAudioOptions options)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.captureAudio(
						$entry(function(mediaFiles) {
							var list = @com.ait.toolkit.cordova.client.capture.MediaFile::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(mediaFiles);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onSucces(Ljava/util/ArrayList;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.capture.CaptureError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onError(Lcom/ait/toolkit/cordova/client/capture/CaptureError;)(errorObject);
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());

    }-*/;

    /**
     * This method starts an asynchronous operation to capture images using the device camera 
     * application. The operation allows the device user to capture multiple images in a single session.
     * 
     * @param callBack
     */
    public native void captureImage(CaptureHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.captureImage(
						$entry(function(mediaFiles) {
							var list = @com.ait.toolkit.cordova.client.capture.MediaFile::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(mediaFiles);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onSucces(Ljava/util/ArrayList;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.capture.CaptureError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onError(Lcom/ait/toolkit/cordova/client/capture/CaptureError;)(errorObject);
						}));

    }-*/;

    /**
     * This method starts an asynchronous operation to capture images using the device camera 
     * application. The operation allows the device user to capture multiple images in a single session.
     * 
     * The capture operation ends when either the user exits the camera application, or the 
     * maximum number of images, specified by the limit parameter in CaptureImageOptions, has been 
     * reached. If no value is provided for the limit parameter, a default value of one (1) is used, 
     * and the capture operation will terminate after the user captures a single image.
     * 
     * @param callBack
     * @param options
     */
    public native void captureImage(CaptureHandler callBack, CaptureImageOptions options)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.captureImage(
						$entry(function(mediaFiles) {
							var list = @com.ait.toolkit.cordova.client.capture.MediaFile::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(mediaFiles);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onSucces(Ljava/util/ArrayList;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.capture.CaptureError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onError(Lcom/ait/toolkit/cordova/client/capture/CaptureError;)(errorObject);
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());

    }-*/;

    /**
     * This method starts an asynchronous operation to capture video recordings using the device video 
     * recording application. The operation allows the device user to capture multiple recordings in a single session.
     * 
     * @param callBack
     */
    public native void captureVideo(CaptureHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.captureVideo(
						$entry(function(mediaFiles) {
							var list = @com.ait.toolkit.cordova.client.capture.MediaFile::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(mediaFiles);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onSucces(Ljava/util/ArrayList;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.capture.CaptureError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onError(Lcom/ait/toolkit/cordova/client/capture/CaptureError;)(errorObject);
						}));

    }-*/;

    /**
     * This method starts an asynchronous operation to capture video recordings using the device video 
     * recording application. The operation allows the device user to capture multiple recordings in a single session.
     *
     * The capture operation ends when either the user exits the video recording application, or the 
     * maximum number of recordings, specified by the limit parameter in CaptureVideoOptions, has been reached. 
     * If no value is provided for the limit parameter, a default value of one (1) is used, and the capture
     * operation will terminate after the user records a single video clip.
     * 
     * @param callBack
     * @param options
     */
    public native void captureVideo(CaptureHandler callBack, CaptureVideoOptions options)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.captureVideo(
						$entry(function(mediaFiles) {
							var list = @com.ait.toolkit.cordova.client.capture.MediaFile::fromJsArray(Lcom/google/gwt/core/client/JsArray;)(mediaFiles);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onSucces(Ljava/util/ArrayList;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.capture.CaptureError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.capture.CaptureHandler::onError(Lcom/ait/toolkit/cordova/client/capture/CaptureError;)(errorObject);
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());

    }-*/;

}
