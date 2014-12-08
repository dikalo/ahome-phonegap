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

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

/**
 * This object is used to supply arguments to the DirectoryEntry getFile and
 * getDirectory methods, which look up or create files and directories,
 * respectively.
 */
public class Flags extends JsObject {

    public Flags() {
        jsObj = JsoHelper.createObject();
    }

    public Flags(boolean create, boolean exclusive) {
        this();
        setCreate(create);
        setExclusive(exclusive);
    }

    /**
     * Used to indicate that the file or directory should be created, if it does
     * not exist.
     * 
     * @param value
     */
    public void setCreate(boolean value) {
        JsoHelper.setAttribute(jsObj, "create", value);
    }

    /**
     * By itself, exclusive has no effect. Used with create, it causes the file
     * or directory creation to fail if the target path already exists
     * 
     * @param value
     */
    public void setExclusive(boolean value) {
        JsoHelper.setAttribute(jsObj, "exclusive", value);
    }
}
