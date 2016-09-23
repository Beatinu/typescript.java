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
package ts.eclipse.ide.json.ui.internal.tsconfig;

import org.eclipse.osgi.util.NLS;

/**
 * tsconfig.json editor messages.
 *
 */
public class TsconfigEditorMessages extends NLS {

	private static final String BUNDLE_NAME = "ts.eclipse.ide.json.ui.internal.tsconfig.TsconfigEditorMessages"; //$NON-NLS-1$
	
	// Overview Page
	public static String OverviewPage_title;
	
	public static String OverviewPage_GeneralInformationSection_title;
	public static String OverviewPage_GeneralInformationSection_desc;
	public static String OverviewPage_compileOnSave_label;
	public static String OverviewPage_buildOnSave_label;
	public static String OverviewPage_module_label;
	public static String OverviewPage_moduleResolution_label;
	public static String OverviewPage_experimentalDecorators_label;
	
	public static String OverviewPage_DebuggingSection_title;
	public static String OverviewPage_DebuggingSection_desc;
	public static String OverviewPage_sourceMap_label;
	public static String OverviewPage_inlineSourceMap_label;
	public static String OverviewPage_inlineSources_label;
	
	public static String OverviewPage_OutputSection_title;
	public static String OverviewPage_OutputSection_desc;
	public static String OverviewPage_noEmit_label;
	public static String OverviewPage_noEmitHelpers_label;
	public static String OverviewPage_noEmitOnError_label;
	public static String OverviewPage_emitDecoratorMetadata_label;
	public static String OverviewPage_declaration_label;
	public static String OverviewPage_declarationDir_label;
	public static String OverviewPage_emitBOM_label;
	
	// Files page
	public static String FilesPage_title;
	public static String FilesPage_FilesSection_title;
	public static String FilesPage_FilesSection_desc;
	public static String FilesPage_ExcludeSection_title;
	public static String FilesPage_ExcludeSection_desc;
	public static String FilesPage_IncludeSection_title;
	public static String FilesPage_IncludeSection_desc;
	public static String FilesPage_ScopeSection_title;
	public static String FilesPage_ScopeSection_desc;

	// Buttons
	public static String Button_add;
	public static String Button_remove;
	public static String Button_open;
	public static String Button_browse;

	static {
		NLS.initializeMessages(BUNDLE_NAME, TsconfigEditorMessages.class);
	}
}