/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package net.sf.antcontrib.logic.condition;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.condition.Condition;
import org.apache.tools.ant.util.StreamUtils;

/**
 * &lt;not&gt; condition. Copy & Replace {@link org.apache.tools.ant.taskdefs.condition.And} to
 * implement {@link ContribConditionBase}
 *
 * @author <a href="mailto:msi@top-logic.com">msi</a>
 */
public class And extends ContribConditionBase implements Condition {

	/**
	 * @return true if all the contained conditions evaluates to true
	 * @exception BuildException
	 *            if an error occurs
	 */
	@Override
	public boolean eval() throws BuildException {
		return StreamUtils.enumerationAsStream(getConditions()).allMatch(Condition::eval);
	}
}
