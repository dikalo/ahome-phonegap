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

/**
 * Contains name properties of a Contact object.
 */
public class ContactName extends JsObject {

    public ContactName() {
        jsObj = JsoHelper.createObject();
    }

    ContactName(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * The complete name of the contact.
     * 
     * @param value
     */
    public void setFormatted(String value) {
        JsoHelper.setAttribute(jsObj, "formatted", value);
    }

    /**
     * The complete name of the contact.
     * 
     * @return
     */
    public String getFormatted() {
        return JsoHelper.getAttribute(jsObj, "formatted");
    }

    /**
     * The contacts family name
     * 
     * @param value
     */
    public void setFamilyName(String value) {
        JsoHelper.setAttribute(jsObj, "familyName", value);
    }

    /**
     * The value of the field (such as a phone number or email address)
     * 
     * @return
     */
    public String getFamilyName() {
        return JsoHelper.getAttribute(jsObj, "familyName");
    }

    /**
     * The contacts given name
     * 
     * @param value
     */
    public void setGivenName(String value) {
        JsoHelper.setAttribute(jsObj, "givenName", value);
    }

    /**
     * The contacts given name
     * 
     * @return
     */
    public String getGivenName() {
        return JsoHelper.getAttribute(jsObj, "givenName");
    }

    /**
     * The contacts middle name
     * 
     * @param value
     */
    public void setMiddleName(String value) {
        JsoHelper.setAttribute(jsObj, "middleName", value);
    }

    /**
     * The contacts middle name
     * 
     * @return
     */
    public String getMiddleName() {
        return JsoHelper.getAttribute(jsObj, "midleName");
    }

    /**
     * The contacts prefix (example Mr. or Dr.)
     * 
     * @param value
     */
    public void setHonorificPrefix(String value) {
        JsoHelper.setAttribute(jsObj, "honorificPrefix", value);
    }

    /**
     * The contacts prefix (example Mr. or Dr.)
     * 
     * @return
     */
    public String getHonorificPrefix() {
        return JsoHelper.getAttribute(jsObj, "honorificPrefix");
    }

    /**
     * The contacts prefix (example Mr. or Dr.)
     * 
     * @param value
     */
    public void setHonorificSuffix(String value) {
        JsoHelper.setAttribute(jsObj, "honorificSuffix", value);
    }

    /**
     * The contacts prefix (example Mr. or Dr.)
     * 
     * @return
     */
    public String getHonorificSuffix() {
        return JsoHelper.getAttribute(jsObj, "honorificSuffix");
    }

}
