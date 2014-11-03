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
package com.ait.toolkit.cordova.client.plugins.blackberry.pushwoosh;

public interface PushWooshBlackBerryRegisterCallback {
	public static final int REGISTER_SUCCESS = 0;				//We have success registering the push notification
	public static final int REGISTER_ERR_NETWORK = 1;			//We have a network error
	public static final int REGISTER_ERR_SERVER = 2;			//We were rejected by the server
	public static final int REGISTER_ERR_INVALID_PARAMETERS = 3;//Invalid parameters were sent
	public static final int REGISTER_ERR_GENERAL = -1;			//Unspecified error occurred
	
	public void onError(int status);
	public void onSuccess(String text);
}
