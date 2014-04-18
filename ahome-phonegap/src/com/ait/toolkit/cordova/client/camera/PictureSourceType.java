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
package com.ait.toolkit.cordova.client.camera;

/**
 * Set the source of the picture
 */
public enum PictureSourceType {

    PHOTOLIBRARY(0), CAMERA(1), SAVEDPHOTOALBUM(2);

    private int value;

    private PictureSourceType(int type) {
        value = type;
    }

    public int getValue() {
        return value;
    }

    public static PictureSourceType fromValue(int value) {
        if (value == 1) {
            return PictureSourceType.CAMERA;
        } else if (value == 0) {
            return PictureSourceType.PHOTOLIBRARY;
        } else if (value == 2) {
            return PictureSourceType.SAVEDPHOTOALBUM;
        }
        return null;
    }
}
