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
package com.ait.toolkit.cordova.client.accelerometer;

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Contains Accelerometer data captured at a specific point in time. This object
 * is created and populated by Cordova, and returned by an Accelerometer method.
 * The x, y, z acceleration values include the effect of gravity (9.81 m/s^2),
 * so at when a device is lying flat on a table facing up, the value returned
 * should be x=0, y=0, z=9.81.<br/>
 * <br/>
 * Supported platforms:
 * <ul>
 * <li>Android</li>
 * <li>BlackBerry WebWorks (OS 5.0 and higher)</li>
 * <li>iOS</li>
 * <li>Windows Phone 7 and 8</li>
 * <li>webOS</li>
 * <li>Tizen</li>
 * </ul>
 */
public class Acceleration extends JsObject {

	private Acceleration(JavaScriptObject peer) {
		jsObj = peer;
	}

	/**
	 * Amount of acceleration on the x-axis. (in m/s^2)
	 * 
	 * @return double
	 */
	public native double getX()/*-{
								var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
								return peer.x;
								}-*/;

	/**
	 * Amount of acceleration on the y-axis. (in m/s^2)
	 * 
	 * @return double
	 */
	public native double getY()/*-{
								var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
								return peer.y;
								}-*/;

	/**
	 * Amount of acceleration on the z-axis. (in m/s^2)
	 * 
	 * @return double
	 */
	public native double getZ()/*-{
								var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
								return peer.z;
								}-*/;

	/**
	 * Gets the creation timestamp in millis.
	 * 
	 * @return double
	 */
	public native double getTimestamp()/*-{
										var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
										return peer.timestamp;
										}-*/;
}
