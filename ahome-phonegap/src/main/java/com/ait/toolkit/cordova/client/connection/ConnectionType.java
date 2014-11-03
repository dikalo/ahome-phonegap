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
package com.ait.toolkit.cordova.client.connection;

public enum ConnectionType {
    UNKNOWN("Unknown"),
    ETHERNET("Ethernet"),
    WIFI("WiFi"),
    CELL_2G("2G"),
    CELL_3G("3G"),
    CELL_4G("4G"),
    CELL("cell"),
    NONE("None");

    private String value;

    private ConnectionType(String type) {
        this.value = type;
    }

    public static ConnectionType fromValue(String value) {
        if (value.equalsIgnoreCase(ConnectionType.UNKNOWN.value)) {
            return ConnectionType.UNKNOWN;
        } else if (value.equalsIgnoreCase(ConnectionType.ETHERNET.value)) {
            return ConnectionType.ETHERNET;
        } else if (value.equalsIgnoreCase(ConnectionType.WIFI.value)) {
            return ConnectionType.WIFI;
        } else if (value.equalsIgnoreCase(ConnectionType.CELL_2G.value)) {
            return ConnectionType.CELL_2G;
        } else if (value.equalsIgnoreCase(ConnectionType.CELL_3G.value)) {
            return ConnectionType.CELL_3G;
        } else if (value.equalsIgnoreCase(ConnectionType.CELL_4G.value)) {
            return ConnectionType.CELL_4G;
        } else if (value.equalsIgnoreCase(ConnectionType.CELL.value)) {
            return ConnectionType.CELL;
        } else if (value.equalsIgnoreCase(ConnectionType.NONE.value)) {
            return ConnectionType.NONE;
        }
        return ConnectionType.UNKNOWN;
    }
    
    public String getValue() {
        return value;
    }
}
