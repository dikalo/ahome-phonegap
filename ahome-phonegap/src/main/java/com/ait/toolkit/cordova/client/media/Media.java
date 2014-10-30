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
package com.ait.toolkit.cordova.client.media;

import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.handlers.media.MediaHandler;
import com.ait.toolkit.cordova.client.core.handlers.media.MediaPositionHandler;
import com.ait.toolkit.cordova.client.core.handlers.media.MediaStatusHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Media object provides the ability to record and play back audio files on
 * a device.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_media_media.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_media_media.md.html</a>
 */
public class Media extends Module {

    public Media(String src, MediaHandler callBack) {
        jsObj = create(src, callBack);
    }
    
    public Media(String src, MediaHandler callBack, MediaStatusHandler statusCallback) {
        jsObj = create(src, callBack, statusCallback);
    }

    @Override
    public void createPeer() {
    }

    /**
     * Returns the current position within an audio file.
     * 
     * @param handler
     */
    public native void getCurrentPosition(MediaPositionHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getCurrentPosition(
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.media.MediaPositionHandler::onSuccess()();
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.media.MediaError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.media.MediaPositionHandler::onError(Lcom/ait/toolkit/cordova/client/media/MediaError;)(errorObject);
						}));

    }-*/;

    /**
     * Returns the duration of an audio file.
     * 
     * @return
     */
    public native int getDuration()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.getDuration();
    }-*/;

    /**
     * synchronous function that pauses playing an audio file.
     */
    public native void pause()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.pause();
    }-*/;

    /**
     * Starts or resumes playing an audio file.
     */
    public native void play()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.play();
    }-*/;

    /**
     * Releases the underlying operating systems audio resources.
     */
    public native void release()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.release();
    }-*/;

    /**
     * Sets the current position within an audio file.
     */
    public native void seekTo(int milliseconds)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.seekTo(milliseconds);
    }-*/;

    /**
     * synchronous function that starts recording an audio file.
     */
    public native void startRecord()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.startRecord();
    }-*/;

    /**
     * Stops playing an audio file.
     */
    public native void stop()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.stop();
    }-*/;

    /**
     * Stops recording an audio file.
     */
    public native void stopRecord()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.stopRecord();
    }-*/;

    private native JavaScriptObject create(String src, MediaHandler handler)/*-{
		var media = new $wnd.Media(
				src,
				$entry(function() {
					handler.@com.ait.toolkit.cordova.client.core.handlers.media.MediaHandler::onSuccess()();
				}),
				$entry(function(error) {
					var errorObject = @com.ait.toolkit.cordova.client.media.MediaError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
					handler.@com.ait.toolkit.cordova.client.core.handlers.media.MediaHandler::onError(Lcom/ait/toolkit/cordova/client/media/MediaError;)(errorObject);
				}));
		return media
    }-*/;
    
    private native JavaScriptObject create(String src, MediaHandler handler, MediaStatusHandler statusHandler)/*-{
        var media = new $wnd.Media(
                src,
                $entry(function() {
                    handler.@com.ait.toolkit.cordova.client.core.handlers.media.MediaHandler::onSuccess()();
                }),
                $entry(function(error) {
                    var errorObject = @com.ait.toolkit.cordova.client.media.MediaError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
                    handler.@com.ait.toolkit.cordova.client.core.handlers.media.MediaHandler::onError(Lcom/ait/toolkit/cordova/client/media/MediaError;)(errorObject);
                }),
                $entry(function(status) {
                    var statusObject = @com.ait.toolkit.cordova.client.media.MediaStatus::new(Lcom/google/gwt/core/client/JavaScriptObject;)(status);
                    statusHandler.@com.ait.toolkit.cordova.client.core.handlers.media.MediaStatusHandler::onStatusUpdate(Lcom/ait/toolkit/cordova/client/media/MediaStatus;)(statusObject);
                }));
        return media
    }-*/;

}
