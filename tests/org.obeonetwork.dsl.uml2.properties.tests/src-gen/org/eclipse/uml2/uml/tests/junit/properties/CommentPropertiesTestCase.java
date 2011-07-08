/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.uml2.uml.tests.junit.properties;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.uml2.uml.UMLPackage;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;
/**
 * TestCase for Comment
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class CommentPropertiesTestCase extends SWTBotEEFTestCase {

	/**
	 * The EClass of the type to edit
	 */
	private EClass commentMetaClass = UMLPackage.eINSTANCE.getComment();

	/**
	 * The type to edit
	 */
	private EObject comment;

	/**
	 * The reference value for the reference class annotatedElement
	 */
	private Object referenceValueForAnnotatedElement;
	/**
	 * The EClass of the reference to edit
	 */
	private EClass elementMetaClass = UMLPackage.eINSTANCE.getElement();
	/**
	 * The eObjects list contained in widgets
	 */
	private List allInstancesOf;
	/**
	 * Updated value of the feature
	 */
	private static final String UPDATED_VALUE = "value2";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelName()
	 */
	protected String getExpectedModelName() {
		return "expected.uML";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelFolder()
	 */
	protected String getInputModelFolder() {
		return "input";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelName()
	 */
	protected String getInputModelName() {
		return "input.uML";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getTestsProjectName()
	 */
	protected String getTestsProjectName() {
		return "org.obeonetwork.dsl.uml2.properties.tests";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelFolder()
	 */
	protected String getExpectedModelFolder() {
		// The project that contains models for tests
		return "expected";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getImportModelsFolder()
	 */
	protected String getImportModelsFolder() {
		return  "models";
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCommentBody() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject comment = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, commentMetaClass);
		if (comment == null)
			throw new InputModelInvalidException(commentMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, comment, UMLPackage.eINSTANCE.getComment_Body(), UPDATED_VALUE));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCommentBody() throws Exception {

		// Import the input model
		initializeInputModel();

		comment = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), commentMetaClass);
		if (comment == null)
			throw new InputModelInvalidException(commentMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCommentBody();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF properties view to edit the Comment element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), commentMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(commentMetaClass.getName());
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf, null);

		// Change value of the body feature of the Comment element 
				bot.editPropertyEEFText(propertiesView, UmlViewsRepository.Comment.Properties.body, UPDATED_VALUE, bot.selectNode(modelEditor, firstInstanceOf));

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}




}
