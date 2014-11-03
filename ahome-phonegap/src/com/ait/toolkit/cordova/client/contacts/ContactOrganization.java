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

import java.util.List;

/**
 * Contains organization properties of a Contact object.
 */
public class ContactOrganization extends JsObject {

    public ContactOrganization() {
        jsObj = JsoHelper.createObject();
    }

    ContactOrganization(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * A string that tells you what type of field this is (example: 'home')
     * 
     * @param value
     */
    public void setType(String value) {
        JsoHelper.setAttribute(jsObj, ContactOrganizationProperty.TYPE.getValue(), value);
    }

    /**
     * A string that tells you what type of field this is (example: 'home')
     * 
     * @return
     */
    public String getType() {
        return JsoHelper.getAttribute(jsObj, ContactOrganizationProperty.TYPE.getValue());
    }

    /**
     * The name of the organization.
     * 
     * @param value
     */
    public void setName(String value) {
        JsoHelper.setAttribute(jsObj, ContactOrganizationProperty.NAME.getValue(), value);
    }

    /**
     * The name of the organization.
     * 
     * @return
     */
    public String getName() {
        return JsoHelper.getAttribute(jsObj, ContactOrganizationProperty.NAME.getValue());
    }

    /**
     * The department the contract works for.
     * 
     * @param value
     */
    public void setDepartment(String value) {
        JsoHelper.setAttribute(jsObj, ContactOrganizationProperty.DEPARTMENT.getValue(), value);
    }

    /**
     * The department the contract works for.
     * 
     * @return
     */
    public String getDepartment() {
        return JsoHelper.getAttribute(jsObj, ContactOrganizationProperty.DEPARTMENT.getValue());
    }

    /**
     * The contacts title at the organization.
     * 
     * @return
     */
    public String getTitle() {
        return JsoHelper.getAttribute(jsObj, ContactOrganizationProperty.TITLE.getValue());
    }

    /**
     * The contacts title at the organization.
     * 
     * @param value
     */
    public void setTitle(String value) {
        JsoHelper.setAttribute(jsObj, ContactOrganizationProperty.TITLE.getValue(), value);
    }

    /**
     * Set to true if this ContactOrganization contains the user's preferred
     * value
     * 
     * @param value
     */
    public void setPref(boolean value) {
        JsoHelper.setAttribute(jsObj, ContactOrganizationProperty.PREFERRED.getValue(), value);
    }

    /**
     * Set to true if this ContactField contains the user's preferred value*
     * 
     * @return
     */
    public boolean isPref() {
        return JsoHelper.getAttributeAsBoolean(jsObj, ContactOrganizationProperty.PREFERRED.getValue());
    }

    static JsArray<JavaScriptObject> toJsArray(List<ContactOrganization> fields) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (ContactOrganization field : fields) {
            array.push(field.getJsObj());
        }
        return array;
    }

    static JsArray<JavaScriptObject> toJsArray(ContactOrganization... fields) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (ContactOrganization field : fields) {
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
