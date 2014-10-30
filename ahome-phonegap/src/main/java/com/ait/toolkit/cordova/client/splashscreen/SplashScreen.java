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
package com.ait.toolkit.cordova.client.splashscreen;

import com.ait.toolkit.cordova.client.core.Module;
import com.ait.toolkit.cordova.client.core.ModuleFactory;
import com.google.gwt.user.client.Timer;

/**
 * Enables developers to show/hide the application's splash screen.
 * 
 * @see <a href=http://docs.phonegap.com/en/2.7.0/cordova_splashscreen_splashscreen.md.html>
 * http://docs.phonegap.com/en/2.7.0/cordova_splashscreen_splashscreen.md.html</a>
 */
public class SplashScreen extends Module {
    private static SplashScreen instance = null;

    public static SplashScreen get() {
        if (instance == null) {
            instance = new SplashScreen();
        }
        return instance;
    }

    private SplashScreen() {
        createPeer();
    }

    @Override
    public void createPeer() {
        jsObj = ModuleFactory.createNativeSplashScreen();
    }
    
    /**
     * Displays the splash screen.
     */
    public native void show() /*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer.show();
    }-*/;
    
    /**
     * Shows the splash screen for the given number of seconds.
     * 
     * @param seconds
     */
    public void show(int seconds) {
        Timer t = new Timer() {
            @Override
            public void run() {
                hide();
            }
        };
        
        t.schedule(seconds * 1000);
    }

    /**
     * Hides the splash screen.
     */
    public native void hide() /*-{
        var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
        peer.hide();
    }-*/;
}
