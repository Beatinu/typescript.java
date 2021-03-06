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
package ts.eclipse.ide.terminal.interpreter;

import java.util.List;

/**
 * Command interpreter factory API.
 *
 */
public interface ICommandInterpreterFactory {

	/**
	 * Create a command interpreter according the given parameters and null
	 * otherwise.
	 * 
	 * @param parameters
	 *            of the command.
	 * @param workingDir
	 *            working directory where command is executed.
	 * @return a command interpreter according the given parameters and null
	 *         otherwise.
	 */
	ICommandInterpreter create(List<String> parameters, String workingDir);

}
