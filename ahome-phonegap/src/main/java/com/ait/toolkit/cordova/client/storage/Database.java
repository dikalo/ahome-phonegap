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
package com.ait.toolkit.cordova.client.storage;

import com.ait.toolkit.cordova.client.core.handlers.storage.DatabaseHandler;
import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Contains methods that allow the user to manipulate the Database
 */
public class Database extends JsObject {

	Database(JavaScriptObject obj) {
		jsObj = obj;
	}

	/**
	 * Runs a database transaction.
	 * 
	 * @param handler
	 */
	public native void transaction(DatabaseHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.transaction(
						$entry(function(tx) {
							var transaction = @com.ait.toolkit.cordova.client.storage.SQLTransaction::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tx);
							handler.@com.ait.toolkit.cordova.client.core.handlers.storage.DatabaseHandler::execute(Lcom/ait/toolkit/cordova/client/storage/SQLTransaction;)(transaction);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.storage.SQLError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.storage.DatabaseHandler::onError(Lcom/ait/toolkit/cordova/client/storage/SQLError;)(errorObject);
						}),
						$entry(function() {
							handler.@com.ait.toolkit.cordova.client.core.handlers.storage.DatabaseHandler::onSuccess()();
						}));
	}-*/;

	/**
	 * This method allows scripts to atomically verify the version number and
	 * change it at the same time as doing a schema update.
	 * 
	 * @param oldVersion
	 * @param newVersion
	 */
	public native void changeVersion(String oldVersion, String newVersion)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.changeVersion(oldVersion, newVersion);
	}-*/;

}
