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

public enum SQLErrorCode {

    UNKNOWN_ERR(0), 
    DATABASE_ERR(1), 
    VERSION_ERR(2), 
    TOO_LARGE_ERR(3),
    SYNTAX_ERR(4), 
    CONSTRAINT_ERR(5), 
    TIMEOUT_ERR(6);

    private int value;

    private SQLErrorCode(int code) {
        this.value = code;
    }
    
    public int getValue() {
        return value;
    }

    public static SQLErrorCode fromValue(int code) {
        SQLErrorCode[] values = SQLErrorCode.values();
        
        if (code < 0 || code > values.length - 1) {
            return UNKNOWN_ERR;
        }
        
        return values[code];
    }
}
