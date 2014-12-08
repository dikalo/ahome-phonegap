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

public enum FileTransferErrorCode {
    FILE_NOT_FOUND_ERR(0), 
    INVALID_URL_ERR(1), 
    CONNECTION_ERR(2), 
    ABORT_ERR(3);

    @SuppressWarnings("unused")
    private int value;

    private FileTransferErrorCode(int code) {
        this.value = code;
    }

    public static FileTransferErrorCode fromValue(int code) {
        FileTransferErrorCode[] values = FileTransferErrorCode.values();
        
        if (code < 0 || code > values.length - 1) {
            return FILE_NOT_FOUND_ERR;
        }
        
        return values[code];
    }
}
