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
package ts.eclipse.ide.terminal.interpreter.internal;

import java.util.Map;

import org.eclipse.tm.terminal.connector.local.launcher.LocalLauncherDelegate;
import org.eclipse.tm.terminal.view.core.interfaces.ITerminalService.Done;
import org.eclipse.tm.terminal.view.core.interfaces.ITerminalServiceOutputStreamMonitorListener;
import org.eclipse.tm.terminal.view.core.interfaces.constants.ITerminalsConnectorConstants;

/**
 * Extends {@link LocalInterpreterLauncherDelegate} to add custom
 * {@link CommandInterpreterProcessor} by waiting for accept of
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=496109 (where the idea is to
 * add a checkbox "with interpreter?")
 *
 */
public class LocalInterpreterLauncherDelegate extends LocalLauncherDelegate {

	@Override
	public void execute(Map<String, Object> properties, Done done) {
		ITerminalServiceOutputStreamMonitorListener[] l = new ITerminalServiceOutputStreamMonitorListener[1];
		l[0] = new CommandInterpreterProcessor(properties);
		properties.put(ITerminalsConnectorConstants.PROP_STDOUT_LISTENERS, l);
		super.execute(properties, done);

	}

}
