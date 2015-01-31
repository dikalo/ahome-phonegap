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

import com.ait.toolkit.cordova.client.core.handlers.storage.SQLTransactionHandler;
import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

public class SQLTransaction extends JsObject {

	SQLTransaction(JavaScriptObject obj) {
		jsObj = obj;
	}

	public native void executeSql(String sql)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.executeSql(sql);
	}-*/;

	public native void executeSql(String sql, SQLTransactionHandler handler)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.executeSql(
						sql,
						[],
						$entry(function(tx, res) {
							var transaction = @com.ait.toolkit.cordova.client.storage.SQLTransaction::new(Lcom/google/gwt/core/client/JavaScriptObject;)(tx);
							var results = @com.ait.toolkit.cordova.client.storage.SQLResultSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(res);
							handler.@com.ait.toolkit.cordova.client.core.handlers.storage.SQLTransactionHandler::onSuccess(Lcom/ait/toolkit/cordova/client/storage/SQLTransaction;Lcom/ait/toolkit/cordova/client/storage/SQLResultSet;)(transaction,results);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.storage.SQLError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							handler.@com.ait.toolkit.cordova.client.core.handlers.storage.SQLTransactionHandler::onError(Lcom/ait/toolkit/cordova/client/storage/SQLError;)(errorObject);
						}));
	}-*/;

}
