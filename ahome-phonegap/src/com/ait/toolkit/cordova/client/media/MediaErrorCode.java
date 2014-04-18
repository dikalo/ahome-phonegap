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
package com.ait.toolkit.cordova.client.media;

public enum MediaErrorCode {

    MEDIA_ERR_ABORTED(0), 
    MEDIA_ERR_NETWORK(1), 
    MEDIA_ERR_DECODE(2), 
    MEDIA_ERR_NONE_SUPPORTED(3)
    ;

    private int value;

    private MediaErrorCode(int code) {
        this.value = code;
    }
    
    public int getValue() {
        return value;
    }

    public static MediaErrorCode fromValue(int code) {
        MediaErrorCode[] values = MediaErrorCode.values();
        
        if (code < 0 || code > values.length - 1) {
            return MEDIA_ERR_NONE_SUPPORTED;
        }
        
        return values[code];
    }

}
