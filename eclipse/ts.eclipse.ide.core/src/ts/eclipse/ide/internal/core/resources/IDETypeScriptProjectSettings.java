/**
 *  Copyright (c) 2015-2016 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package ts.eclipse.ide.internal.core.resources;

import java.io.File;

import org.eclipse.core.resources.IProject;

import ts.eclipse.ide.core.TypeScriptCorePlugin;
import ts.eclipse.ide.core.nodejs.IEmbeddedNodejs;
import ts.eclipse.ide.core.preferences.TypeScriptCorePreferenceConstants;
import ts.eclipse.ide.core.resources.AbstractTypeScriptSettings;
import ts.eclipse.ide.core.resources.IIDETypeScriptProjectSettings;
import ts.repository.ITypeScriptRepository;
import ts.resources.SynchStrategy;
import ts.utils.StringUtils;

/**
 * IDE TypeScript project settings.
 *
 */
public class IDETypeScriptProjectSettings extends AbstractTypeScriptSettings implements IIDETypeScriptProjectSettings {

	public IDETypeScriptProjectSettings(IProject project) {
		super(project, TypeScriptCorePlugin.PLUGIN_ID);
	}

	/**
	 * Returns true if JSON request/response can be traced inside Eclipse
	 * console and false otherwise.
	 * 
	 * @param project
	 * @return true if JSON request/response can be traced inside Eclipse
	 *         console and false otherwise.
	 */
	@Override
	public boolean isTraceOnConsole() {
		return super.getBooleanPreferencesValue(TypeScriptCorePreferenceConstants.TRACE_ON_CONSOLE, false);
	}

	@Override
	public IEmbeddedNodejs getEmbeddedNodejs() {
		String id = super.getStringPreferencesValue(TypeScriptCorePreferenceConstants.NODEJS_EMBEDDED, null);
		return TypeScriptCorePlugin.getNodejsInstallManager().findNodejsInstall(id);
	}

	@Override
	public File getNodejsInstallPath() {
		if (super.getBooleanPreferencesValue(TypeScriptCorePreferenceConstants.USE_NODEJS_EMBEDDED, false)) {
			// Use Embedded nodejs.
			IEmbeddedNodejs embed = getEmbeddedNodejs();
			return embed != null ? embed.getPath() : null;
		}

		// Use Installed node.js
		String path = super.getStringPreferencesValue(TypeScriptCorePreferenceConstants.NODEJS_PATH, null);
		if (!StringUtils.isEmpty(path)) {
			return new File(path);
		}
		return null;
	}

	@Override
	public SynchStrategy getSynchStrategy() {
		return SynchStrategy.CHANGE;
	}

	@Override
	public File getTscFile() {
		ITypeScriptRepository repository = getRepository(TypeScriptCorePreferenceConstants.TSC_REPOSITORY);
		return (repository != null) ? repository.getTscFile() : null;
	}
	
	@Override
	public File getTsserverFile() {
		ITypeScriptRepository repository = getRepository(TypeScriptCorePreferenceConstants.TSSERVER_REPOSITORY);
		return (repository != null) ? repository.getTsserverFile() : null;
	}

	private ITypeScriptRepository getRepository(String preferenceName) {
		String name = super.getStringPreferencesValue(preferenceName, null);
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		return TypeScriptCorePlugin.getTypeScriptRepositoryManager().getRepository(name);
	}

}
