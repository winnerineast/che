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
package org.eclipse.che.ide.command.explorer;

import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.ide.api.data.tree.AbstractTreeNode;
import org.eclipse.che.ide.api.data.tree.Node;

import java.util.List;

/**
 * //
 *
 * @author Artem Zatsarynnyi
 */
public class CommandNode extends AbstractTreeNode {

    private final String commandName;

    public CommandNode(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public String getName() {
        return commandName;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    protected Promise<List<Node>> getChildrenImpl() {
        return null;
    }
}