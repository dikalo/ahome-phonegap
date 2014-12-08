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

/**
 * Convenience enum of fields the user is able to use when searching for a Contact.
 * 
 */
public enum ContactOrganizationProperty {
    TYPE("type"),
    NAME("name"),
    DEPARTMENT("department"),
    TITLE("title"),
    PREFERRED("pref"),
    ;
    
    private String value;
    
    private ContactOrganizationProperty(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
