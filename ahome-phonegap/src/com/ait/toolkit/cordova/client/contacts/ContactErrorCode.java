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

public enum ContactErrorCode {

    UNKNOWN_ERROR(0, "Unknown"), 
    INVALID_ARGUMENT_ERROR(1, "Invalid Argument"),
    TIME_OUT_ERROR(2, "Timeout"), 
    PENDING_OPERATION_ERROR(3, "Pending Operation"), 
    IO_ERROR(4, "IO Error"), 
    NOT_SUPPORTED_ERROR(5, "Not Supported"), 
    PERMISSION_DENIED_ERROR(6, "Permission Denied");

    private int value;
    private String description;

    private ContactErrorCode(int status, String description) {
        this.value = status;
        this.description = description;
    }

    public static ContactErrorCode fromValue(int code) {
        ContactErrorCode[] values = ContactErrorCode.values();
        
        if (code < 0 || code > values.length - 1) {
            return UNKNOWN_ERROR;
        }
        
        return values[code];
    }
    
    public int getCode() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }
}
