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
package com.ait.toolkit.cordova.client.file;

public enum FileErrorCode {
    NOT_FOUND_ERROR(0), 
    SECURITY_ERR(1), 
    ABORT_ERR(2), 
    NOT_READABLE_ERR(3), 
    ENCODING_ERR(4), 
    NO_MODIFICATION_ALLOWED_ERR(5), 
    INVALID_STATE_ERR(6), 
    SYNTAX_ERR(7), 
    INVALID_MODIFICATION_ERR(8), 
    QUOTA_EXCEEDED_ERR(9), 
    TYPE_MISSMATCH_ERR(10), 
    PATH_EXIST_ERR(11)
    ;

    private int value;

    private FileErrorCode(int code) {
        this.value = code;
    }

    public static FileErrorCode fromValue(int code) {
        FileErrorCode[] values = FileErrorCode.values();
        
        if (code < 0 || code > values.length - 1) {
            return NOT_FOUND_ERROR;
        }
        
        return values[code];
    }

    public int getValue() {
        return this.value;
    }
}
