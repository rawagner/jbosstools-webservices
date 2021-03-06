/******************************************************************************* 
 * Copyright (c) 2008 - 2014 Red Hat, Inc. and others. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Xavier Coulon - Initial API and implementation 
 ******************************************************************************/

package org.jboss.tools.ws.jaxrs.ui.configuration;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.jboss.tools.ws.jaxrs.core.configuration.ProjectNatureUtils;
import org.jboss.tools.ws.jaxrs.ui.internal.utils.Logger;

/**
 * Action to remove the JAXRS Nature from a selected project.
 * 
 * @author xcoulon
 * 
 */
public class RemoveNatureAction extends AbstractJaxrsNatureConfigurationAction {
	
	/**
	 * Adds the JAXRS Nature to the current selection. Adding the nature
	 * triggers the add of the JAXRS builder.
	 * 
	 * @param project
	 *            the current project
	 * @throws CoreException
	 */
	@Override
	public final boolean configure(final IProject project) {
		if (project != null) {
			try {
				return ProjectNatureUtils.uninstallProjectNature(project, ProjectNatureUtils.JAXRS_NATURE_ID);
			} catch (CoreException e) {
				Logger.error("Error while removing the JAX-RS nature on project " + project.getName(), e);
			}
		}
		return false;
	}


}
