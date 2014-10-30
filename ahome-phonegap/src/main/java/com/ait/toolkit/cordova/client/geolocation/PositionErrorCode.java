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
package com.ait.toolkit.cordova.client.geolocation;

public enum PositionErrorCode {

    PERMISSION_DENIED(0), 
    POSITION_UNAVAILABLE(1), 
    TIMEOUT(2)
    ;

    private int value;

    private PositionErrorCode(int code) {
        this.value = code;
    }
    
    public int getValue() {
        return value;
    }

    public static PositionErrorCode fromValue(int code) {
        PositionErrorCode[] values = PositionErrorCode.values();
        
        if (code < 0 || code > values.length - 1) {
            return POSITION_UNAVAILABLE;
        }
        
        return values[code];
    }
}
