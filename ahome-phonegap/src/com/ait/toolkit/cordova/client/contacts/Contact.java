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
import com.ait.toolkit.cordova.client.core.handlers.contacts.ContactRemoveHandler;
import com.ait.toolkit.cordova.client.core.handlers.contacts.ContactSaveHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Contains properties that describe a contact, such as a user's personal or
 * business contact.
 * 
 */
public class Contact extends JsObject {

    /**
     * Creates a new Contact object. 
     * To persist the Contact object to the device, invoke the save() method.
     */
    public Contact() {
        jsObj = Contacts.createNative();
    }

    Contact(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * Sets a globally unique identifier
     * 
     * @param value
     */
    public void setId(String value) {
        JsoHelper.setAttribute(jsObj, ContactProperty.ID.getValue(), value);
    }

    /**
     * Gets a globally unique identifier
     * 
     * @return String
     */
    public String getId() {
        return JsoHelper.getAttribute(jsObj, ContactProperty.ID.getValue());
    }

    /**
     * Sets the name of this Contact, suitable for display to end-users
     * 
     * @param value
     */
    public void setDisplayName(String value) {
        JsoHelper.setAttribute(jsObj, ContactProperty.DISPLAY_NAME.getValue(), value);
    }

    /**
     * Gets the name of this Contact, suitable for display to end-users
     * 
     * @return String
     */
    public String getDisplayName() {
        return JsoHelper.getAttribute(jsObj, ContactProperty.DISPLAY_NAME.getValue());
    }

    /**
     * Sets the contact's name.
     * 
     * @param value
     */
    public void setName(ContactName value) {
        JsoHelper.setAttribute(jsObj, ContactProperty.NAME.getValue(), value.getJsObj());
    }

    /**
     * Gets the contact's name.
     * 
     * @return {@link ContactName}
     */
    public ContactName getName() {
        JavaScriptObject obj = JsoHelper.getAttributeAsJavaScriptObject(jsObj, ContactProperty.NAME.getValue());
        return new ContactName(obj);
    }

    /**
     * Sets a casual name for the contact.
     * 
     * @param value
     */
    public void setNickName(String value) {
        JsoHelper.setAttribute(jsObj, ContactProperty.NICKNAME.getValue(), value);
    }

    /**
     * Gets the casual name of the contact.
     * 
     * @return String
     */
    public String getNickName() {
        return JsoHelper.getAttribute(jsObj, ContactProperty.NICKNAME.getValue());
    }

    /**
     * Sets the list of all the contact's phone numbers
     * 
     * @param values
     */
    public void setPhoneNumbers(List<ContactField> values) {
        _setPhoneNumbers(ContactField.toJsArray(values));
    }

    /**
     * Sets the list of all the contact's phone numbers
     * 
     * @param values
     */
    public void setPhoneNumbers(ContactField... values) {
        _setPhoneNumbers(ContactField.toJsArray(values));
    }

    private native void _setPhoneNumbers(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.phoneNumbers = values;
    }-*/;

    /**
     * Gets the list of all the contact's phone numbers
     * 
     * @return List<ContactField>
     */
    public List<ContactField> getPhoneNumbers() {
        List<ContactField> list = new ArrayList<ContactField>();
        JavaScriptObject phoneNumbers = _getPhoneNumbers();
        if (phoneNumbers != null) {
            int size = ContactField.getSize(phoneNumbers);
            for (int i = 0; i < size; i++) {
                list.add(new ContactField(ContactField.get(phoneNumbers, i)));
            }
        }
        return list;
    }

    private native JavaScriptObject _getPhoneNumbers()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.phoneNumbers;
    }-*/;

    /**
     * Sets the list of all the contact's email addresses
     * 
     * @param values
     */
    public void setEmails(List<ContactField> values) {
        _setEmails(ContactField.toJsArray(values));
    }

    /**
     * Sets the list of all the contact's email addresses
     * 
     * @param values
     */
    public void setEmails(ContactField... values) {
        _setEmails(ContactField.toJsArray(values));
    }

    private native void _setEmails(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.emails = values;
    }-*/;

    /**
     * Gets the list of all the contact's email addresses
     * 
     * @return List<ContactField>
     */
    public List<ContactField> getEmails() {
        List<ContactField> list = new ArrayList<ContactField>();
        JavaScriptObject emails = _getEmails();
        if (emails != null) {
            int size = ContactField.getSize(emails);
            for (int i = 0; i < size; i++) {
                list.add(new ContactField(ContactField.get(emails, i)));
            }
        }
        return list;
    }

    private native JavaScriptObject _getEmails()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.emails;
    }-*/;

    /**
     * Sets the list of all the contact's addresses
     * 
     * @param values
     */
    public void setAddresses(List<ContactAddress> values) {
        _setAddresses(ContactAddress.toJsArray(values));
    }

    /**
     * Sets the list of all the contact's addresses.
     * 
     * @param values
     */
    public void setAddresses(ContactAddress... values) {
        _setAddresses(ContactAddress.toJsArray(values));
    }

    private native void _setAddresses(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.addresses = values;
    }-*/;

    /**
     * Gets the list of all the contact's addresses
     * 
     * @return List<ContactAddress>
     */
    public List<ContactAddress> getAddresses() {
        List<ContactAddress> list = new ArrayList<ContactAddress>();
        JavaScriptObject addresses = _getAddresses();
        if (addresses != null) {
            int size = ContactAddress.getSize(addresses);
            for (int i = 0; i < size; i++) {
                list.add(new ContactAddress(ContactAddress.get(addresses, i)));
            }
        }
        return list;
    }

    private native JavaScriptObject _getAddresses()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.addresses;
    }-*/;

    /**
     * Sets the list of the contact's IM addresses
     * 
     * @param values
     */
    public void setIms(List<ContactField> values) {
        _setIms(ContactField.toJsArray(values));
    }

    /**
     * Sets the list of the contact's IM addresses
     * 
     * @param values
     */
    public void setIms(ContactField... values) {
        _setEmails(ContactField.toJsArray(values));
    }

    private native void _setIms(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.ims = values;
    }-*/;

    /**
     * Gets a list of the contact's IM addresses
     * 
     * @return List<ContactField>
     */
    public List<ContactField> getIms() {
        List<ContactField> list = new ArrayList<ContactField>();
        JavaScriptObject ims = _getIms();
        if (ims != null) {
            int size = ContactField.getSize(ims);
            for (int i = 0; i < size; i++) {
                list.add(new ContactField(ContactField.get(ims, i)));
            }
        }

        return list;
    }

    private native JavaScriptObject _getIms()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.ims;
    }-*/;

    /**
     * Gets a list of the contact's IM organizations.  See {@link ContactOrganization}
     * 
     * @return List<ContactOrganization>
     */
    public List<ContactOrganization> getOrganizations() {
        List<ContactOrganization> list = new ArrayList<ContactOrganization>();
        JavaScriptObject organisations = _getOrganizations();
        if (organisations != null) {
            int size = ContactOrganization.getSize(organisations);
            for (int i = 0; i < size; i++) {
                list.add(new ContactOrganization(ContactOrganization.get(organisations, i)));
            }
        }
        return list;
    }

    private native JavaScriptObject _getOrganizations()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.organizations;
    }-*/;

    /**
     * Sets the contact's organizations.  See {@link ContactOrganization}
     * 
     * @param values
     */
    public void setOrganizations(List<ContactOrganization> values) {
        _setIms(ContactOrganization.toJsArray(values));
    }

    /**
     * Sets the contact's organizations.  See {@link ContactOrganization}
     * 
     * @param values
     */
    public void setOrganizations(ContactOrganization... values) {
        _setOrganizations(ContactOrganization.toJsArray(values));
    }

    private native void _setOrganizations(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.organizations = values;
    }-*/;

    /**
     * Sets the birthday of this contact.
     * 
     * @param value
     */
    public void setBirthDay(Date value) {
        JsoHelper.setAttribute(jsObj, ContactProperty.BIRTHDAY.getValue(), value);
    }

    /**
     * Gets the birthday of this contact.
     * 
     * @return Date
     */
    public Date getBirthDay() {
        return (Date) JsoHelper.getAttributeAsObject(jsObj, ContactProperty.BIRTHDAY.getValue());
    }

    /**
     * Sets a note about the contact.
     * 
     * @param value
     */
    public void setNote(String value) {
        JsoHelper.setAttribute(jsObj, ContactProperty.NOTE.getValue(), value);
    }

    /**
     * Gets the note about the contact.
     * 
     * @return String
     */
    public String getNote() {
        return JsoHelper.getAttribute(jsObj, ContactProperty.NOTE.getValue());
    }

    /**
     * Sets a list of photos for this contact.
     * 
     * @param values
     */
    public void setPhotos(List<ContactField> values) {
        _setPhotos(ContactField.toJsArray(values));
    }

    /**
     * Sets a list of photos for this contact.
     * 
     * @param values
     */
    public void setPhotos(ContactField... values) {
        _setPhotos(ContactField.toJsArray(values));
    }

    private native void _setPhotos(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.photos = values;
    }-*/;

    /**
     * Gets a list of photos for this contact.
     * 
     * @return List<ContactField>
     */
    public List<ContactField> getPhotos() {
        List<ContactField> list = new ArrayList<ContactField>();
        JavaScriptObject photos = _getPhotos();
        if (photos != null) {
            int size = ContactField.getSize(photos);
            for (int i = 0; i < size; i++) {
                list.add(new ContactField(ContactField.get(photos, i)));
            }
        }
        return list;
    }

    private native JavaScriptObject _getPhotos()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.photos;
    }-*/;

    /**
     * Sets a list of user-defined categories for this contact.
     * 
     * @param values
     */
    public void setCategories(List<ContactField> values) {
        _setCategories(ContactField.toJsArray(values));
    }

    /**
     * Sets a list of user-defined categories for this contact.
     * 
     * @param values
     */
    public void setCategories(ContactField... values) {
        _setCategories(ContactField.toJsArray(values));
    }

    private native void _setCategories(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.categories = values;
    }-*/;

    /**
     * Gets the list of user-defined categories for this contact.
     * 
     * @return List<ContactField>
     */
    public List<ContactField> getCategories() {
        List<ContactField> list = new ArrayList<ContactField>();
        JavaScriptObject categories = _getCategories();
        if (categories != null) {
            int size = ContactField.getSize(categories);
            for (int i = 0; i < size; i++) {
                list.add(new ContactField(ContactField.get(categories, i)));
            }
        }
        return list;
    }

    /**
     * Sets a list of web pages associated with this contact.
     * 
     * @param values
     */
    public void setUrls(List<ContactField> values) {
        _setUrls(ContactField.toJsArray(values));
    }

    /**
     * Sets a list of web pages associated with this contact.
     * 
     * @param values
     */
    public void setUrls(ContactField... values) {
        _setUrls(ContactField.toJsArray(values));
    }

    private native void _setUrls(JsArray<JavaScriptObject> values)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.urls = values;
    }-*/;

    /**
     * Gets a list of web pages associated with this contact.
     * 
     * @return List<ContactField>
     */
    public List<ContactField> getUrls() {
        List<ContactField> list = new ArrayList<ContactField>();
        JavaScriptObject urls = _getUrls();
        if (urls != null) {
            int size = ContactField.getSize(urls);
            for (int i = 0; i < size; i++) {
                list.add(new ContactField(ContactField.get(urls, i)));
            }
        }
        return list;
    }

    private native JavaScriptObject _getUrls()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.urls;
    }-*/;

    private native JavaScriptObject _getCategories()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.categories;
    }-*/;

    /**
     * Returns a new Contact object that is a deep copy of the calling object,
     * with the id property set to null
     * 
     * @param contact
     * @return Contact
     */
    public native Contact clone(Contact contact)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = peer.clone();
		var toReturn = @com.ait.toolkit.cordova.client.contacts.Contact::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Removes the contact from the device contacts database. An error callback
     * is called with a ContactError object if the removal is unsuccessful.
     * 
     * @param callBack
     */
    public native void remove(ContactRemoveHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.remove(
						$entry(function() {
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactRemoveHandler::onSuccess()();
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.contacts.ContactError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactRemoveHandler::onError(Lcom/ait/toolkit/cordova/client/contacts/ContactError;)(errorObject);
						}));
    }-*/;

    /**
     * Saves a new contact to the device contacts database, or updates an
     * existing contact if a contact with the same id already exists.
     * 
     * @param callBack
     */
    public native void save(ContactSaveHandler callBack)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer
				.save(
						$entry(function(contact) {
							var contactObject = @com.ait.toolkit.cordova.client.contacts.Contact::new(Lcom/google/gwt/core/client/JavaScriptObject;)(contact);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactSaveHandler::onSuccess(Lcom/ait/toolkit/cordova/client/contacts/Contact;)(contactObject);
						}),
						$entry(function(error) {
							var errorObject = @com.ait.toolkit.cordova.client.contacts.ContactError::new(Lcom/google/gwt/core/client/JavaScriptObject;)(error);
							callBack.@com.ait.toolkit.cordova.client.core.handlers.contacts.ContactSaveHandler::onError(Lcom/ait/toolkit/cordova/client/contacts/ContactError;)(errorObject);
						}));
    }-*/;

}
