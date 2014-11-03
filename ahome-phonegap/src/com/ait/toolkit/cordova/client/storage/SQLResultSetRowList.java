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
public class SQLResultSetRowList extends JsObject {

    SQLResultSetRowList(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * the number of rows returned by the SQL query
     * 
     * @return
     */
    public native int getLength()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.length;
    }-*/;

    /**
     * returns the row at the specified index. object.
     * 
     * @return
     */
    public native SQLResultSetRow getItem(int index)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.item(index);
		var toReturn = @com.ait.toolkit.cordova.client.storage.SQLResultSetRow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;
}
