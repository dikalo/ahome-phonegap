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
package com.ait.toolkit.cordova.client.events;

/**
 * Device lifecycle events.
 */
public enum DeviceEvent {
    
    DEVICE_READY("deviceready"),
    PAUSE("pause"),
    RESUME("resume"),
    ONLINE("online"),
    OFFLINE("offline"),
    BACK_BUTTON("backbutton"),
    BATTERY_CRITICAL("batterycritical"),
    BATTERY_LOW("batterylow"),
    BATTERY_STATUS("batterystatus"),
    MENU_BUTTON("menubutton"),
    SEARCH_BUTTON("searchbutton"),
    START_CALL_BUTTON("startcallbutton"),
    END_CALL_BUTTON("endcallbutton"),
    VOLUME_DOWN_BUTTON("volumedownbutton"),
    VOLUME_UP_BUTTON("volumeupbutton"),
    ;
    
    private String value;
    
    private DeviceEvent(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}
