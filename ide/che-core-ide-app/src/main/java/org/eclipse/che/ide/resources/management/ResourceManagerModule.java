/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.resources.management;

import com.google.common.annotations.Beta;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * Gin module for configuring resource management component.
 *
 * TODO: component should be included when resource management will be refactored
 *
 * @author Vlad Zhukovskyi
 * @since 5.0.0
 */
@Beta
public class ResourceManagerModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(PathKeyProvider.class).to(HashCodeBasedKeyProvider.class).in(Singleton.class);
        bind(ResourceStorage.class).to(MemoryResourceStorage.class).in(Singleton.class);
    }
}