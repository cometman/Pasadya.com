/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.jqwicket.ui.validationengine;

import static com.google.code.jqwicket.Utils.quote;

/**
 * Validation rule implementation defining javascript function to execute for
 * validation.
 * 
 * @author mkalina
 * 
 */
public class FuncValidationRule extends ValidationRule<FuncValidationRule> {

	private static final long serialVersionUID = 1L;

	private CharSequence funcName;

	private CharSequence funcDef;

	public FuncValidationRule(CharSequence name, CharSequence funcName,
			CharSequence funcDef, CharSequence... alertTextErrors) {
		super(name, alertTextErrors);
		this.funcName = funcName;
		this.funcDef = funcDef;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.validationengine.ValidationRule#customPayloadToJson()
	 */
	@Override
	protected CharSequence customPayloadToJson() {
		StringBuffer buf = new StringBuffer();
		buf.append(quote("nname")).append(":").append(quote(this.funcName));
		return buf;
	}

	/**
	 * @return the funcDef
	 */
	public CharSequence getFuncDef() {
		return funcDef;
	}

}
