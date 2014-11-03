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
package com.ait.toolkit.cordova.client.capture;

public enum CaptureErrorCode {

    CAPTURE_INTERNAL_ERROR(0), 
    CAPTURE_APPLICATION_BUSY(1), 
    CAPTURE_INVALID_ARGUMENT(2), 
    CAPTURE_NO_MEDIA_FILES(3), 
    CAPTURE_NOT_SUPPORTED(4)
    ;

    @SuppressWarnings("unused")
    private int value;

    private CaptureErrorCode(int status) {
        this.value = status;
    }

    public static CaptureErrorCode fromValue(int code) {
        CaptureErrorCode[] values = CaptureErrorCode.values();
        
        if (code < 0 || code > values.length - 1) {
            return CAPTURE_INTERNAL_ERROR; 
        }
        
        return values[code];
    }

}
