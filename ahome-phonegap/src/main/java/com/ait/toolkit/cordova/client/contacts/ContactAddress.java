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
 * Contains address properties for a Contact object.
 * 
 */
public class ContactAddress extends JsObject {

    public ContactAddress() {
        jsObj = JsoHelper.createObject();
    }

    ContactAddress(JavaScriptObject obj) {
        jsObj = obj;
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
     * The full address formatted for display.
     * 
     * @param value
     */
    public void setFormatted(String value) {
        JsoHelper.setAttribute(jsObj, "formatted", value);
    }

    /**
     * The full address formatted for display.
     * 
     * @return
     */
    public String getFormatted() {
        return JsoHelper.getAttribute(jsObj, "formatted");
    }

    /**
     * The full address formatted for display.
     * 
     * @param value
     */
    public void setStreetAddress(String value) {
        JsoHelper.setAttribute(jsObj, "streetAddress", value);
    }

    /**
     * The full address formatted for display.
     * 
     * @return
     */
    public String getStreetAddress() {
        return JsoHelper.getAttribute(jsObj, "streetAddress");
    }

    /**
     * The city or locality.
     * 
     * @param value
     */
    public void setLocality(String value) {
        JsoHelper.setAttribute(jsObj, "locality", value);
    }

    /**
     * The city or locality.
     * 
     * @return
     */
    public String getLocality() {
        return JsoHelper.getAttribute(jsObj, "locality");
    }

    /**
     * The state or region.
     * 
     * @param value
     */
    public void setRegion(String value) {
        JsoHelper.setAttribute(jsObj, "region", value);
    }

    /**
     * The state or region.
     * 
     * @return
     */
    public String getRegion() {
        return JsoHelper.getAttribute(jsObj, "region");
    }

    /**
     * The zip code or postal code.
     * 
     * @param value
     */
    public void setPostalCode(String value) {
        JsoHelper.setAttribute(jsObj, "postalCode", value);
    }

    /**
     * The zip code or postal code.
     * 
     * @return
     */
    public String getPostalCode() {
        return JsoHelper.getAttribute(jsObj, "postalCode");
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

    /**
     * The country name.
     * 
     * @return
     */
    public String getCountry() {
        return JsoHelper.getAttribute(jsObj, "country");
    }

    /**
     * The country name.
     * 
     * @param value
     */
    public void setCountry(String value) {
        JsoHelper.setAttribute(jsObj, "country", value);
    }

    static ArrayList<ContactAddress> fromJsArray(JsArray<JavaScriptObject> array) {
        ArrayList<ContactAddress> fields = new ArrayList<ContactAddress>();
        for (int i = 0; i < array.length(); i++) {
            fields.add(new ContactAddress(array.get(i)));
        }
        return fields;
    }

    static JsArray<JavaScriptObject> toJsArray(List<ContactAddress> fields) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (ContactAddress field : fields) {
            array.push(field.getJsObj());
        }
        return array;
    }

    static JsArray<JavaScriptObject> toJsArray(ContactAddress... fields) {
        JsArray<JavaScriptObject> array = JsArray.createArray().cast();
        for (ContactAddress field : fields) {
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
