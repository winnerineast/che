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
package org.eclipse.che.ide.command.manager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.api.core.model.machine.Command;
import org.eclipse.che.api.machine.shared.dto.CommandDto;
import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.ide.api.command.CommandImpl;
import org.eclipse.che.ide.api.command.CommandManager2;
import org.eclipse.che.ide.api.command.CommandType;
import org.eclipse.che.ide.api.resources.Project;
import org.eclipse.che.ide.dto.DtoFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.eclipse.che.api.project.shared.Constants.COMMANDS_ATTRIBUTE_NAME;

/**
 * Responsible for managing the commands which are stored with projects.
 *
 * @author Artem Zatsarynnyi
 */
@Singleton
class ProjectCommandManagerDelegate {

    private final DtoFactory dtoFactory;

    private final Map<Project, Map<String, CommandImpl>> projectCommands;

    @Inject
    ProjectCommandManagerDelegate(DtoFactory dtoFactory) {
        this.dtoFactory = dtoFactory;

        projectCommands = new HashMap<>();
    }

    /**
     * Returns commands.
     *
     * @param project
     */
    List<CommandImpl> getCommands(Project project) {
        List<String> attributeValues = project.getAttributes(COMMANDS_ATTRIBUTE_NAME);
        if (attributeValues == null) {
            return emptyList();
        }

        Map<String, CommandImpl> commands = new HashMap<>(attributeValues.size());

        for (String commandJson : attributeValues) {
            Command command = dtoFactory.createDtoFromJson(commandJson, CommandDto.class);

            commands.put(command.getName(), new CommandImpl(command));
        }

        // TODO: rework it. Need to read all projects's commands on manager start-up
        projectCommands.put(project, commands);

        return new ArrayList<>(commands.values());
    }

    /**
     * Creates new command of the specified type.
     * <p><b>Note</b> that command's name will be generated by {@link CommandManager2}
     * and command line will be provided by an appropriate {@link CommandType}.
     */
    Promise<CommandImpl> createCommand(Project project, String type) {
        return null;
    }

    /**
     * Creates new command with the specified arguments.
     * <p><b>Note</b> that name of the created command may differ from
     * the specified {@code desirableName} in order to prevent name duplication.
     */
    Promise<CommandImpl> createCommand(String desirableName,
                                       String commandLine,
                                       String type,
                                       Map<String, String> attributes) {
        return null;
    }

    /**
     * Updates the command with the specified {@code name} by replacing it with the given {@code command}.
     * <p><b>Note</b> that name of the updated command may differ from the name provided by the given {@code command}
     * in order to prevent name duplication.
     */
    Promise<CommandImpl> updateCommand(String name, CommandImpl command) {
        return null;
    }

    /** Removes the command with the specified {@code commandName}. */
    Promise<Void> removeCommand(String commandName) {
        return null;
    }
}
