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

import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;
import com.ait.toolkit.cordova.client.core.handlers.contacts.ContactFindHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

import java.util.ArrayList;
import java.util.List;

/**
 * The contacts module provides access to the device contacts database.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_contacts_contacts.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_contacts_contacts.md.html</a>
 */
public class Contacts extends Module {

    private static Contacts instance = null;
    private List<Contact> pool;

    /**
     * Gets the single instance of the contacts database.
     * 
     * @return Contacts
     */
    public static Contacts get() {
        if (instance == null) {
            instance = new Contacts();
        }
        return instance;
    }

    private Contacts() {
        pool = new ArrayList<Contact>();
        createPeer();
    }

    /**
     * A synchronous method that returns a new Contact object.
     * 
     * This method does not persist the Contact object to the device contacts
     * database. To persist the Contact object to the device, invoke the
     * Contact.save() method.
     * 
     * @return Contact
     */
    public native Contact createContact()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.create();
		var toReturn = @com.ait.toolkit.cordova.client.contacts.Contact::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Finds one or more contact with the given fields.
     * 
     * @param callBack
     * @param contactFields
     */
    public void find(ContactFindHandler callBack, ContactProperty... contactFields) {
        List<String> properties = new ArrayList<String>();

        if (contactFields != null && contactFields.length > 0) {
            for (ContactProperty property : contactFields) {
                properties.add(property.getValue());
            }
        }

        find(properties, callBack);
    }

    /**
     * Finds one or more contacts with the given options and properties.
     * 
     * @param callBack
     * @param options
     * @param contactFields
     */
    public void find(ContactFindHandler callBack, ContactFindOptions options, ContactProperty... contactFields) {
        List<String> properties = new ArrayList<String>();

        if (contactFields != null && contactFields.length > 0) {
            for (ContactProperty property : contactFields) {
                properties.add(property.getValue());
            }
        }

        find(properties, callBack, options);
    }

    private native void find(List<String> contactFields, ContactFindHandler callBack)/*-{
		var me = this;
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var fields = @com.ait.toolkit.cordova.client.contacts.Contacts::fromListOfString(Ljava/util/List;)(contactFields);
		peer
				.find(
						fields,
						$entry(function(contacts) {
							for ( var i = 0; i < contacts.length; i++) {
								me.@com.ait.toolkit.cordova.client.contacts.Contacts::push(Lcom/google/gwt/core/client/JavaScriptObject;)(contacts[i]);
							}
							var list = me.@com.ait.toolkit.cordova.client.contacts.Contacts::pool;
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactFindHandler::onSuccess(Ljava/util/List;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.contacts.ContactError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactFindHandler::onError(Lcom/ait/toolkit/cordova/client/contacts/ContactError;)(errorObject);
						}));
    }-*/;

    private native void find(List<String> contactFields, ContactFindHandler callBack, ContactFindOptions options)/*-{
		var me = this;
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var fields = @com.ait.toolkit.cordova.client.contacts.Contacts::fromListOfString(Ljava/util/List;)(contactFields);
		peer
				.find(
						fields,
						$entry(function(contacts) {
							for ( var i = 0; i < contacts.length; i++) {
								me.@com.ait.toolkit.cordova.client.contacts.Contacts::push(Lcom/google/gwt/core/client/JavaScriptObject;)(contacts[i]);
							}
							var list = me.@com.ait.toolkit.cordova.client.contacts.Contacts::pool;
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactFindHandler::onSuccess(Ljava/util/List;)(list);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.contacts.ContactError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactFindHandler::onError(Lcom/ait/toolkit/cordova/client/contacts/ContactError;)(errorObject);
						}),
						options.@com.ait.toolkit.core.client.JsObject::getJsObj()());
    }-*/;

    static native JavaScriptObject createNative()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.create();
		return obj;
    }-*/;

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeContacts();
    }

    private static List<Contact> fromJsArray(JsArray<JavaScriptObject> array) {
        List<Contact> contacts = new ArrayList<Contact>();
        for (int i = 0; i < array.length(); i++) {
            contacts.add(new Contact(array.get(i)));
        }
        return contacts;
    }

    private static JsArrayString fromListOfString(List<String> values) {
        JsArrayString strings = JsArray.createArray().cast();
        for (String s : values) {
            strings.push(s);
        }
        return strings;
    }

    void push(JavaScriptObject nativeContact) {
        pool.add(new Contact(nativeContact));
    }

}
