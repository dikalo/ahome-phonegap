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

package com.ait.toolkit.cordova.client.globalization;

import com.ait.toolkit.core.client.JsoHelper;
import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;
import com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler;
import com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationLanguageHandler;
import com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationLocaleHandler;
import com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationNameHandler;
import com.google.gwt.core.client.JavaScriptObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The globalization object obtains information and performs operations specific
 * to the user's locale and timezone.
 *
 * @see <a http://docs.phonegap.com/en/2.7.0/cordova_globalization_globalization.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_globalization_globalization.md.html</a>
 */
public class Globalization extends Module {
    private static Globalization instance = null;

    public static Globalization get() {
        if (instance == null) {
            instance = new Globalization();
        }
        return instance;
    }

    private Globalization() {
        createPeer();
    }

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeGlobalization();
    }

    /**
     * Gets the string identifier for the client's current language.
     * 
     * @param handler
     */
    public native void getPreferredLanguage(GlobalizationLanguageHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getPreferredLanguage(
						$entry(function(language) {
							var prefLang = @com.ait.toolkit.cordova.client.globalization.GlobalizationLanguage::new(Lcom/google/gwt/core/client/JavaScriptObject;)(language);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationLanguageHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationLanguage;)(prefLang);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationLanguageHandler::onError()();
						}));
    }-*/;

    /**
     * Gets the String identifier for the client's current locale setting.
     * 
     * @param handler
     */
    public native void getLocale(GlobalizationLocaleHandler handler) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getLocaleName(
						$entry(function(l) {
							var locale = @com.ait.toolkit.cordova.client.globalization.GlobalizationLocale::new(Lcom/google/gwt/core/client/JavaScriptObject;)(l);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationLocaleHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationLocale;)(locale);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationLocaleHandler::onError()();
						}));
    }-*/;

    /**
     * Returns a date formatted as a string according to the client's locale and
     * timezone.
     * 
     * @param handler
     */
    public native void dateToString(Date date, GlobalizationDateHandler handler) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.dateToString(
						date,
						$entry(function(gd) {
							var dateJso = @com.ait.toolkit.cordova.client.globalization.GlobalizationDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(gd);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationDate;)(dateJso);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onError()();
                        }));
    }-*/;

    /**
     * Returns a date formatted as a string according to the client's locale and
     * timezone.
     * 
     * @param handler
     * @param options
     */
    public native void dateToString(Date date, GlobalizationDateHandler handler, GlobalizationOptions options) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.dateToString(
						date,
						$entry(function(gd) {
							var dateJso = @com.ait.toolkit.cordova.client.globalization.GlobalizationDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(gd);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationDate;)(dateJso);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onError()();
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Parses a date formatted as a string according to the client's user
     * preferences and calendar using the time zone of the client and returns
     * the corresponding date object.
     * 
     * @param dateString
     * @param handler
     */
    public native void stringToDate(String dateString, GlobalizationDateHandler handler) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.stringToDate(
						dateString,
						$entry(function(date) {
							var dateJso = @com.ait.toolkit.cordova.client.globalization.GlobalizationDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(date);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationDate;)(dateJso);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onError()();
						}));
    }-*/;

    /**
     * Parses a date formatted as a string according to the client's user
     * preferences and calendar using the time zone of the client and returns
     * the corresponding date object.
     * 
     * @param dateString
     * @param handler
     * @param options
     */
    public native void stringToDate(String dateString, GlobalizationDateHandler handler, GlobalizationOptions options) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.stringToDate(
						dateString,
						$entry(function(date) {
							var dateJso = @com.ait.toolkit.cordova.client.globalization.GlobalizationDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(date);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationDate;)(dateJso);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onError()();
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Returns a pattern string for formatting and parsing dates according to
     * the client's user preferences.
     * 
     * @param handler
     */
    public native void getDatePattern(GlobalizationDateHandler handler) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getDatePattern(
						$entry(function(date) {
							var dateJso = @com.ait.toolkit.cordova.client.globalization.GlobalizationDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(date);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationDate;)(dateJso);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onError()();
						}));
    }-*/;

    /**
     * Returns a pattern string for formatting and parsing dates according to
     * the client's user preferences.
     * 
     * @param handler
     * @param options
     */
    public native void getDatePattern(GlobalizationDateHandler handler, GlobalizationOptions options) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getDatePattern(
						$entry(function(date) {
							var dateJso = @com.ait.toolkit.cordova.client.globalization.GlobalizationDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(date);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationDate;)(dateJso);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onError()();
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    /**
     * Returns an array of either the names of the months or days of the week
     * according to the client's user preferences and calendar.
     */
    public native void getDateNames(GlobalizationNameHandler handler) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getDataNames(
						$entry(function(names) {
							var nameList = @com.ait.toolkit.cordova.client.globalization.Globalization::fromListOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(names);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationNameHandler::onSuccess(Ljava/util/List;)(nameList);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationNameHandler::onError()();
						}));
    }-*/;

    /**
     * Returns an array of either the names of the months or days of the week
     * according to the client's user preferences and calendar.
     */
    public native void getDateNames(GlobalizationNameHandler handler, GlobalizationOptions options) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getDataNames(
						$entry(function(names) {
							var nameList = @com.ait.toolkit.cordova.client.globalization.Globalization::fromListOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(names);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationNameHandler::onSuccess(Ljava/util/List;)(nameList);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationNameHandler::onError()();
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    public native void isDayLightSavingsTime(Date date, GlobalizationDateHandler handler) /*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.getDatePattern(
						new $wnd.Date(date.getTime()),
						$entry(function(gd) {
							var dateJso = @com.ait.toolkit.cordova.client.globalization.GlobalizationDate::new(Lcom/google/gwt/core/client/JavaScriptObject;)(gd);
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onSuccess(Lcom/ait/toolkit/cordova/client/globalization/GlobalizationDate;)(dateJso);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.globalization.GlobalizationDateHandler::onError()();
						}));
    }-*/;

    private static List<String> fromListOfString(JavaScriptObject jsArrayString) {
        List<String> toReturn = new ArrayList<String>();
        int size = JsoHelper.arrayLength(jsArrayString);
        for (int i = 0; i < size; i++) {
            toReturn.add(JsoHelper.getStringValueFromJavaScriptObjectArray(jsArrayString, i));
        }
        return toReturn;
    }

}
