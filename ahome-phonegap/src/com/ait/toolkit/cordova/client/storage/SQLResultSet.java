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

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * When the executeSql method of a SQLTransaction is called it will invoke it's
 * callback with a SQLResultSet.
 * 
 */
public class SQLResultSet extends JsObject {

    SQLResultSet(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * the row ID of the row that the SQLResultSet object's SQL statement
     * inserted into the database
     * 
     * @return
     */
    public native int getInsertId()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.insertId;
    }-*/;

    /**
     * the number of rows that were changed by the SQL statement. If the
     * statement did not affect any rows then it is set to 0.
     * 
     * @return
     */
    public native int getRowAffected()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.rowAffected;
    }-*/;

    /**
     * A SQLResultSetRowList representing the rows returned. If no rows are
     * returned the object will be empty.
     * 
     * @return
     */
    public native SQLResultSetRowList getRows()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.rows;
		var toReturn = @com.ait.toolkit.cordova.client.storage.SQLResultSetRowList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;
}
