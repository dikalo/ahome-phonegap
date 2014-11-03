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
import com.ait.toolkit.core.client.JsoHelper;

/**
 * An optional parameter to customize the retrieval of the accelerometer.
 */
public class AccelerometerOptions extends JsObject {

	public AccelerometerOptions() {
		jsObj = JsoHelper.createObject();
	}

	public AccelerometerOptions(double frequency) {
		this();
		setFrequency(frequency);
	}

	/**
	 * How often to retrieve the Acceleration in milliseconds. (Default: 10000)
	 * 
	 * @param value
	 */
	public void setFrequency(double value) {
		JsoHelper.setAttribute(jsObj, "frequency", value);
	}

}
