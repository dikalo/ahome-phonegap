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
package com.ait.toolkit.cordova.client.inappbrowser;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.cordova.client.handlers.InAppBrowserEventHandler;
import com.ait.toolkit.cordova.client.handlers.InAppBrowserExecuteScriptHandler;
import com.ait.toolkit.cordova.client.handlers.InAppBrowserInsertCssHandler;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The InAppBrowser is a web-browser that is shown in your app when you use the
 * window.open call.
 * 
 * @see <a
 *      href=http://docs.phonegap.com/en/2.7.0/cordova_inappbrowser_inappbrowser
 *      .md.html>
 *      http://docs.phonegap.com/en/2.7.0/cordova_inappbrowser_inappbrowser
 *      .md.html</a>
 */
public class InAppBrowser extends JsObject {

    protected InAppBrowser(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Opens a new browser window. The "name" and "features" arguments are
     * specified <a href=
     * 'http://developer.mozilla.org/en/docs/DOM:window.open'>here</a>.
     * 
     * @param url
     *            the URL that the new window will display
     * @param name
     *            the name of the window (e.g. "_blank")
     * @param features
     *            the features to be enabled/disabled on this window
     */
    public static native InAppBrowser open(String url, String name, String features) /*-{
		var obj = $wnd.open(url, name, features);
		return @com.ait.toolkit.cordova.client.inappbrowser.InAppBrowser::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * Closes this InAppBrowser window.
     */
    public native void close() /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		jso.close();
    }-*/;

    /**
     * Injects JavaScript code into the InAppBrowser window
     * 
     * @param url
     *            the URL containing the script that will be executed
     */
    public native void executeScriptFromFile(String url) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		jso.executeScript({
			file : url
		});
    }-*/;

    /**
     * Injects JavaScript code into the InAppBrowser window
     * 
     * @param url
     *            , the URL containing the script that will be executed
     * @param handler
     * 
     */
    public native void executeScriptFromFile(String url, InAppBrowserExecuteScriptHandler handler) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		var result = jso
				.executeScript(
						{
							file : url
						},
						function(result) {
							handler.@com.ait.toolkit.cordova.client.handlers.InAppBrowserExecuteScriptHandler::onScriptFinished(Ljava/lang/Object;)(result);
						});

    }-*/;

    /**
     * Injects JavaScript code into the InAppBrowser window
     * 
     * @param script
     *            , text of the script to inject
     */
    public native void executeScriptFromCode(String script) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		jso.executeScript({
			code : script
		});
    }-*/;

    /**
     * Injects JavaScript code into the InAppBrowser window
     * 
     * @param script
     *            , text of the script to inject
     * @param handler
     */
    public native void executeScriptFromCode(String script, InAppBrowserExecuteScriptHandler handler) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		var result = jso
				.executeScript(
						{
							code : script
						},
						function(result) {
							handler.@com.ait.toolkit.cordova.client.handlers.InAppBrowserExecuteScriptHandler::onScriptFinished(Ljava/lang/Object;)(result);
						});

    }-*/;

    /**
     * Injects CSS into the InAppBrowser window
     * 
     * @param url
     *            , the URL of the stylesheet to inject
     */
    public native void insertCssFromUrl(String url) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		jso.insertCss({
			file : url
		});
    }-*/;

    /**
     * Injects CSS into the InAppBrowser window
     * 
     * @param url
     *            , the URL of the stylesheet to inject
     * 
     * @param handler
     */
    public native void insertCssFromUrl(String url, InAppBrowserInsertCssHandler handler) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		jso
				.insertCss(
						{
							file : url
						},
						function() {
							handler.@com.ait.toolkit.cordova.client.handlers.InAppBrowserInsertCssHandler::onCssInserted()();
						});
    }-*/;

    /**
     * Injects CSS into the InAppBrowser window
     * 
     * @param css
     *            , text of the stylesheet to inject
     */
    public native void insertCssFromCode(String css) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		jso.insertCss({
			code : css
		});
    }-*/;

    /**
     * Injects CSS into the InAppBrowser window
     * 
     * @param css
     *            , text of the stylesheet to inject
     * 
     * @param handler
     */
    public native void insertCssFromCode(String css, InAppBrowserInsertCssHandler handler) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		jso
				.insertCss(
						{
							code : css
						},
						function() {

							handler.@com.ait.toolkit.cordova.client.handlers.InAppBrowserInsertCssHandler::onCssInserted()();
						});

    }-*/;

    /**
     * event fired when the InAppBrowser starts to load a URL
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public InAppBrowserHandlerRegistration addLoadStartHandler(InAppBrowserEventHandler handler) {
        return addEventListener("loadstart", handler);
    }

    /**
     * event fired when the InAppBrowser finished loading a URL
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public InAppBrowserHandlerRegistration addLoadStopHandler(InAppBrowserEventHandler handler) {
        return addEventListener("loadstop", handler);
    }

    /**
     * event fired when the InAppBrowser encounters an error loading a URL
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public InAppBrowserHandlerRegistration addLoadErrorHandler(InAppBrowserEventHandler handler) {
        return addEventListener("loaderror", handler);
    }

    /**
     * event fired when the InAppBrowser window is closed
     * 
     * @param handler
     *            , the handler that will handle the event
     */
    public InAppBrowserHandlerRegistration addExitHandler(InAppBrowserEventHandler handler) {
        return addEventListener("exit", handler);
    }

    /**
     * Adds a listener for an event from the InAppBrowser.
     */
    private native InAppBrowserHandlerRegistration addEventListener(String event, InAppBrowserEventHandler handler) /*-{
		var jso = this.@com.ait.toolkit.core.client.JsObject::jsObj;
		var fn = function(e) {
			var event = @com.ait.toolkit.cordova.client.inappbrowser.InAppBrowserEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
			handler.@com.ait.toolkit.cordova.client.handlers.InAppBrowserEventHandler::onEvent(Lcom/ait/toolkit/cordova/client/inappbrowser/InAppBrowserEvent;)(event);
		};
		jso.addEventListener(event, fn);
		return @com.ait.toolkit.cordova.client.inappbrowser.InAppBrowserHandlerRegistration::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(jso, fn, event);
    }-*/;

}
