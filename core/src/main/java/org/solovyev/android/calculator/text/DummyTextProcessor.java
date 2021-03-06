/*
 * Copyright 2013 serso aka se.solovyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Contact details
 *
 * Email: se.solovyev@gmail.com
 * Site:  http://se.solovyev.org
 */

package org.solovyev.android.calculator.text;

import jscl.math.Generic;

import javax.annotation.Nonnull;

import org.solovyev.android.calculator.CalculatorParseException;

/**
 * User: serso
 * Date: 10/18/11
 * Time: 10:39 PM
 */
public enum DummyTextProcessor implements TextProcessor<String, Generic> {

	instance;

	@Nonnull
	@Override
	public String process(@Nonnull Generic s) throws CalculatorParseException {
		return s.toString();
	}
}
