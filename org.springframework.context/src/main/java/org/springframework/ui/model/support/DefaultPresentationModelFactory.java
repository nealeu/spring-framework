/*
 * Copyright 2004-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.ui.model.support;

import java.util.IdentityHashMap;
import java.util.Map;

import org.springframework.ui.model.PresentationModel;
import org.springframework.ui.model.PresentationModelFactory;

/**
 * Default PresentationModelFactory implementation that uses a {@link IdentityHashMap} to map domain models to PresentationModels.
 * @author Keith Donald
 * @since 3.0
 */
public class DefaultPresentationModelFactory implements PresentationModelFactory {

	private Map<Object, PresentationModel> presentationModels = new IdentityHashMap<Object, PresentationModel>();
	
	public void put(Object domainObject, PresentationModel presentationModel) {
		presentationModels.put(domainObject, presentationModel);
	}
	
	public PresentationModel getPresentationModel(Object domainObject) {
		PresentationModel factory = presentationModels.get(domainObject);
		if (factory == null) {
			factory = new DefaultPresentationModel(domainObject);
			presentationModels.put(domainObject, factory);
		}
		return factory;
	}

}