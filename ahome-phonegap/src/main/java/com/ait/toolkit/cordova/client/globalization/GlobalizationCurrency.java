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
package com.ait.toolkit.cordova.client.globalization;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A pattern string for formatting and parsing currency values according 
 * to the client's user preferences and ISO 4217 currency code.
 */
public class GlobalizationCurrency extends JsObject {
    GlobalizationCurrency(JavaScriptObject obj) {
        jsObj = obj;
    }
    
    /**
     * The currency pattern for formatting and parsing currency values. 
     * The patterns follow Unicode Technical Standard #35. 
     * 
     * @ee <a href=http://unicode.org/reports/tr35/tr35-4.html>
     * http://unicode.org/reports/tr35/tr35-4.html</a>
     * 
     * @return String
     */
    public String getPattern() {
        return JsoHelper.getAttribute(jsObj, "pattern");
    }
    
    /**
     * The ISO 4217 currency code for the pattern.
     * 
     * @return String
     */
    public String getCode() {
        return JsoHelper.getAttribute(jsObj, "code");
    }
    
    /**
     * The number of fractional digits to use when parsing and formatting currency.
     * 
     * @return double
     */
    public double getFraction() {
        return JsoHelper.getAttributeAsDouble(jsObj, "fraction");
    }
    
    /**
     * The rounding increment to use when parsing and formatting.
     * 
     * @return double
     */
    public double getRounding() {
        return JsoHelper.getAttributeAsDouble(jsObj, "rounding");
    }
    
    /**
     * The decimal symbol to use for parsing and formatting.
     * 
     * @return String
     */
    public String getDecimal() {
        return JsoHelper.getAttribute(jsObj, "decimal");
    }
    
    /**
     * The grouping symbol to use for parsing and formatting.
     * 
     * @return String
     */
    public String getGrouping() {
        return JsoHelper.getAttribute(jsObj, "grouping");
    }
    
}
