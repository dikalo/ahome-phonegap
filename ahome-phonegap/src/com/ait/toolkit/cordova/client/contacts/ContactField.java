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
package com.ait.toolkit.cordova.client.contacts;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Supports generic fields in a Contact object. Some properties that are stored
 * as ContactField objects include email addresses, phone numbers, and urls.
 * 
 */
public class ContactField extends JsObject {
    public ContactField() {
        jsObj = JsoHelper.createObject();
    }

    ContactField(JavaScriptObject obj) {
        jsObj = obj;
    }

    public ContactField(String type, String value, boolean pref) {
        this();
        setType(type);
        setValue(value);
        setPref(pref);
    }

    /**
     * A string that tells you what type of field this is (example: 'home')
     * 
     * @param value
     */
    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, "type", value);
    }

    /**
     * A string that tells you what type of field this is (example: 'home')
     * 
     * @return
     */
    public String getType() {
        return JsoHelper.getAttribute(jsObj, "type");
    }

    /**
     * The value of the field (such as a phone number or email address)
     * 
     * @param value
     */
    public void setValue(String value) {
        JsoHelper.setAttribute(jsObj, "value", value);
    }

    /**
     * The value of the field (such as a phone number or email address)
     * 
     * @return
     */
    public String getValue() {
        return JsoHelper.getAttribute(jsObj, "value");
    }

    /**
     * Set to true if this ContactField contains the user's preferred value
     * 
     * @param value
     */
    public void setPref(boolean value) {
        JsoHelper.setAttribute(jsObj, "pref", value);
    }

    /**
     * Set to true if this ContactField contains the user's preferred value*
     * 
     * @return
     */
    public boolean isPref() {
        return JsoHelper.getAttributeAsBoolean(jsObj, "pref");
    }

    static List<ContactField> fromJsArray(JsArray<JavaScriptObject> array) {
        List<ContactField> fields = new ArrayList<ContactField>();
        for (int i = 0; i < array.length(); i++) {
            fields.add(new ContactField(array.get(i)));
        }
        return fields;
    }

    static JsArray<JavaScriptObject> toJsArray(List<ContactField> fields) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (ContactField field : fields) {
            array.push(field.getJsObj());
        }
        return array;
    }

    static JsArray<JavaScriptObject> toJsArray(ContactField... fields) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (ContactField field : fields) {
            array.push(field.getJsObj());
        }
        return array;
    }

    static native int getSize(JavaScriptObject obj)/*-{
		return obj.length;
    }-*/;

    static native JavaScriptObject get(JavaScriptObject obj, int index)/*-{
		return obj[index];
    }-*/;

}
