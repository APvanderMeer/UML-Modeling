/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.uml2.properties.uml.components;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

import org.obeonetwork.dsl.uml2.properties.uml.parts.LiteralUnlimitedNaturalPropertiesEditionPart;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;


/**
 * @author <a href="mailto:cedric.brun@obeo.fr">Cédric Brun</a>
 * @generated
 */
public class LiteralUnlimitedNaturalPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	/**
	 * @generated
	 */
	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for clientDependency ReferencesTable
	 */
	private ReferencesTableSettings clientDependencySettings;
	
	/**
	 * Settings for owningTemplateParameter EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings owningTemplateParameterSettings;
	
	/**
	 * Settings for templateParameter EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings templateParameterSettings;
	
	/**
	 * Settings for type EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings typeSettings;
	
	
	/**
	 * Default constructor
	 * @generated
	 */
	public LiteralUnlimitedNaturalPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject literalUnlimitedNatural, String editing_mode) {
    super(editingContext, literalUnlimitedNatural, editing_mode);
    parts = new String[] { BASE_PART };
    repositoryKey = UmlViewsRepository.class;
    partKey = UmlViewsRepository.LiteralUnlimitedNatural.class;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * @generated
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
    setInitializing(true);
    if (editingPart != null && key == partKey) {
      editingPart.setContext(elt, allResource);
      
      final LiteralUnlimitedNatural literalUnlimitedNatural = (LiteralUnlimitedNatural)elt;
      final LiteralUnlimitedNaturalPropertiesEditionPart basePart = (LiteralUnlimitedNaturalPropertiesEditionPart)editingPart;
      // init values
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.name))
        basePart.setName(EEFConverterUtil.convertToString(UMLPackage.Literals.STRING, literalUnlimitedNatural.getName()));
      
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.visibility)) {
        basePart.initVisibility(EEFUtils.choiceOfValues(literalUnlimitedNatural, UMLPackage.eINSTANCE.getNamedElement_Visibility()), literalUnlimitedNatural.getVisibility());
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.clientDependency)) {
        clientDependencySettings = new ReferencesTableSettings(literalUnlimitedNatural, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
        basePart.initClientDependency(clientDependencySettings);
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.owningTemplateParameter)) {
        // init part
        owningTemplateParameterSettings = new EObjectFlatComboSettings(literalUnlimitedNatural, UMLPackage.eINSTANCE.getParameterableElement_OwningTemplateParameter());
        basePart.initOwningTemplateParameter(owningTemplateParameterSettings);
        // set the button mode
        basePart.setOwningTemplateParameterButtonMode(ButtonsModeEnum.BROWSE);
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.templateParameter)) {
        // init part
        templateParameterSettings = new EObjectFlatComboSettings(literalUnlimitedNatural, UMLPackage.eINSTANCE.getParameterableElement_TemplateParameter());
        basePart.initTemplateParameter(templateParameterSettings);
        // set the button mode
        basePart.setTemplateParameterButtonMode(ButtonsModeEnum.BROWSE);
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.type)) {
        // init part
        typeSettings = new EObjectFlatComboSettings(literalUnlimitedNatural, UMLPackage.eINSTANCE.getTypedElement_Type());
        basePart.initType(typeSettings);
        // set the button mode
        basePart.setTypeButtonMode(ButtonsModeEnum.BROWSE);
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.value)) {
        basePart.setValue(EEFConverterUtil.convertToString(UMLPackage.Literals.UNLIMITED_NATURAL, literalUnlimitedNatural.getValue()));
      }
      
      // init filters
      
      
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.clientDependency)) {
        basePart.addFilterToClientDependency(new ViewerFilter() {
        
          /**
           * {@inheritDoc}
           * 
           * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
           */
          public boolean select(Viewer viewer, Object parentElement, Object element) {
            if (element instanceof EObject)
              return (!basePart.isContainedInClientDependencyTable((EObject)element));
            return element instanceof Resource;
          }
        
        });
        basePart.addFilterToClientDependency(new EObjectFilter(UMLPackage.Literals.DEPENDENCY));
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.owningTemplateParameter)) {
        basePart.addFilterToOwningTemplateParameter(new ViewerFilter() {
        
          /**
           * {@inheritDoc}
           * 
           * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
           */
          public boolean select(Viewer viewer, Object parentElement, Object element) {
            return (element instanceof String && element.equals("")) || (element instanceof TemplateParameter); //$NON-NLS-1$ 
          }
          
        });
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.templateParameter)) {
        basePart.addFilterToTemplateParameter(new ViewerFilter() {
        
          /**
           * {@inheritDoc}
           * 
           * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
           */
          public boolean select(Viewer viewer, Object parentElement, Object element) {
            return (element instanceof String && element.equals("")) || (element instanceof TemplateParameter); //$NON-NLS-1$ 
          }
          
        });
      }
      if (isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.type)) {
        basePart.addFilterToType(new ViewerFilter() {
        
          /**
           * {@inheritDoc}
           * 
           * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
           */
          public boolean select(Viewer viewer, Object parentElement, Object element) {
            return (element instanceof String && element.equals("")) || (element instanceof Type); //$NON-NLS-1$ 
          }
          
        });
      }
      
      // init values for referenced views
      
      // init filters for referenced views
      
    }
    setInitializing(false);
  }










	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == UmlViewsRepository.LiteralUnlimitedNatural.Properties.name) {
			return UMLPackage.eINSTANCE.getNamedElement_Name();
		}
		if (editorKey == UmlViewsRepository.LiteralUnlimitedNatural.Properties.visibility) {
			return UMLPackage.eINSTANCE.getNamedElement_Visibility();
		}
		if (editorKey == UmlViewsRepository.LiteralUnlimitedNatural.Properties.clientDependency) {
			return UMLPackage.eINSTANCE.getNamedElement_ClientDependency();
		}
		if (editorKey == UmlViewsRepository.LiteralUnlimitedNatural.Properties.owningTemplateParameter) {
			return UMLPackage.eINSTANCE.getParameterableElement_OwningTemplateParameter();
		}
		if (editorKey == UmlViewsRepository.LiteralUnlimitedNatural.Properties.templateParameter) {
			return UMLPackage.eINSTANCE.getParameterableElement_TemplateParameter();
		}
		if (editorKey == UmlViewsRepository.LiteralUnlimitedNatural.Properties.type) {
			return UMLPackage.eINSTANCE.getTypedElement_Type();
		}
		if (editorKey == UmlViewsRepository.LiteralUnlimitedNatural.Properties.value) {
			return UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * @generated
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
    LiteralUnlimitedNatural literalUnlimitedNatural = (LiteralUnlimitedNatural)semanticObject;
    if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.name == event.getAffectedEditor()) {
      literalUnlimitedNatural.setName((java.lang.String)EEFConverterUtil.createFromString(UMLPackage.Literals.STRING, (String)event.getNewValue()));
    }
    if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.visibility == event.getAffectedEditor()) {
      literalUnlimitedNatural.setVisibility((VisibilityKind)event.getNewValue());
    }
    if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.clientDependency == event.getAffectedEditor()) {
      if (event.getKind() == PropertiesEditionEvent.ADD) {
        if (event.getNewValue() instanceof Dependency) {
          clientDependencySettings.addToReference((EObject) event.getNewValue());
        }
      } else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
        clientDependencySettings.removeFromReference((EObject) event.getNewValue());
      } else if (event.getKind() == PropertiesEditionEvent.MOVE) {
        clientDependencySettings.move(event.getNewIndex(), (Dependency) event.getNewValue());
      }
    }
    if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.owningTemplateParameter == event.getAffectedEditor()) {
      if (event.getKind() == PropertiesEditionEvent.SET) {
        owningTemplateParameterSettings.setToReference((TemplateParameter)event.getNewValue());
      } else if (event.getKind() == PropertiesEditionEvent.ADD) {
        TemplateParameter eObject = UMLFactory.eINSTANCE.createTemplateParameter();
        EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
        PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
        if (provider != null) {
          PropertiesEditingPolicy policy = provider.getPolicy(context);
          if (policy != null) {
            policy.execute();
          }
        }
        owningTemplateParameterSettings.setToReference(eObject);
      }
    }
    if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.templateParameter == event.getAffectedEditor()) {
      if (event.getKind() == PropertiesEditionEvent.SET) {
        templateParameterSettings.setToReference((TemplateParameter)event.getNewValue());
      } else if (event.getKind() == PropertiesEditionEvent.ADD) {
        TemplateParameter eObject = UMLFactory.eINSTANCE.createTemplateParameter();
        EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
        PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
        if (provider != null) {
          PropertiesEditingPolicy policy = provider.getPolicy(context);
          if (policy != null) {
            policy.execute();
          }
        }
        templateParameterSettings.setToReference(eObject);
      }
    }
    if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.type == event.getAffectedEditor()) {
      if (event.getKind() == PropertiesEditionEvent.SET) {
        typeSettings.setToReference((Type)event.getNewValue());
      } else if (event.getKind() == PropertiesEditionEvent.ADD) {
        EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, typeSettings, editingContext.getAdapterFactory());
        PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
        if (provider != null) {
          PropertiesEditingPolicy policy = provider.getPolicy(context);
          if (policy instanceof CreateEditingPolicy) {
            policy.execute();
          }
        }
      }
    }
    if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.value == event.getAffectedEditor()) {
      literalUnlimitedNatural.setValue((EEFConverterUtil.createIntFromString(UMLPackage.Literals.UNLIMITED_NATURAL, (String)event.getNewValue())));
    }
  }

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			LiteralUnlimitedNaturalPropertiesEditionPart basePart = (LiteralUnlimitedNaturalPropertiesEditionPart)editingPart;
			if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(UMLPackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.visibility))
				basePart.setVisibility((VisibilityKind)msg.getNewValue());
			
			if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature())  && isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.clientDependency))
				basePart.updateClientDependency();
			if (UMLPackage.eINSTANCE.getParameterableElement_OwningTemplateParameter().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.owningTemplateParameter))
				basePart.setOwningTemplateParameter((EObject)msg.getNewValue());
			if (UMLPackage.eINSTANCE.getParameterableElement_TemplateParameter().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.templateParameter))
				basePart.setTemplateParameter((EObject)msg.getNewValue());
			if (UMLPackage.eINSTANCE.getTypedElement_Type().equals(msg.getFeature()) && basePart != null && isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.type))
				basePart.setType((EObject)msg.getNewValue());
			if (UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(UmlViewsRepository.LiteralUnlimitedNatural.Properties.value)) {
				if (msg.getNewValue() != null) {
					basePart.setValue(EcoreUtil.convertToString(UMLPackage.Literals.UNLIMITED_NATURAL, msg.getNewValue()));
				} else {
					basePart.setValue("");
				}
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			UMLPackage.eINSTANCE.getNamedElement_Name(),
			UMLPackage.eINSTANCE.getNamedElement_Visibility(),
			UMLPackage.eINSTANCE.getNamedElement_ClientDependency(),
			UMLPackage.eINSTANCE.getParameterableElement_OwningTemplateParameter(),
			UMLPackage.eINSTANCE.getParameterableElement_TemplateParameter(),
			UMLPackage.eINSTANCE.getTypedElement_Type(),
			UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * @generated
	 */
	public boolean isRequired(Object key, int kind) {
    return key == UmlViewsRepository.LiteralUnlimitedNatural.Properties.value;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * @generated
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
    Diagnostic ret = Diagnostic.OK_INSTANCE;
    if (event.getNewValue() != null) {
      try {
        if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.name == event.getAffectedEditor()) {
          Object newValue = event.getNewValue();
          if (newValue instanceof String) {
            newValue = EEFConverterUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), (String)newValue);
          }
          ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
        }
        if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.visibility == event.getAffectedEditor()) {
          Object newValue = event.getNewValue();
          if (newValue instanceof String) {
            newValue = EEFConverterUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), (String)newValue);
          }
          ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
        }
        if (UmlViewsRepository.LiteralUnlimitedNatural.Properties.value == event.getAffectedEditor()) {
          Object newValue = event.getNewValue();
          if (newValue instanceof String) {
            newValue = EEFConverterUtil.createFromString(UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value().getEAttributeType(), (String)newValue);
          }
          ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value().getEAttributeType(), newValue);
        }
      } catch (IllegalArgumentException iae) {
        ret = BasicDiagnostic.toDiagnostic(iae);
      } catch (WrappedException we) {
        ret = BasicDiagnostic.toDiagnostic(we);
      }
    }
    return ret;
  }


	

}