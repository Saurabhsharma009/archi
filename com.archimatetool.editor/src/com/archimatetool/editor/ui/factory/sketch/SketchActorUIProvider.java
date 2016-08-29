/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui.factory.sketch;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import com.archimatetool.editor.diagram.sketch.editparts.SketchActorEditPart;
import com.archimatetool.editor.ui.IArchimateImages;
import com.archimatetool.editor.ui.factory.AbstractGraphicalObjectUIProvider;
import com.archimatetool.model.IArchimatePackage;



/**
 * Sketch Actor UI Provider
 * 
 * @author Phillip Beauvoir
 */
public class SketchActorUIProvider extends AbstractGraphicalObjectUIProvider {

    public EClass providerFor() {
        return IArchimatePackage.eINSTANCE.getSketchModelActor();
    }
    
    @Override
    public EditPart createEditPart() {
        return new SketchActorEditPart();
    }

    @Override
    public String getDefaultName() {
        return Messages.SketchActorUIProvider_0;
    }

    @Override
    public Dimension getDefaultSize() {
        return new Dimension(75, 100);
    }

    @Override
    public Image getImage() {
        return IArchimateImages.ImageFactory.getImage(IArchimateImages.ICON_ACTOR_16);
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return IArchimateImages.ImageFactory.getImageDescriptor(IArchimateImages.ICON_ACTOR_16);
    }

    @Override
    public Color getDefaultColor() {
        return ColorConstants.black;
    }
    
    @Override
    public boolean shouldExposeFeature(EObject instance, EAttribute feature) {
        if(feature == IArchimatePackage.Literals.TEXT_ALIGNMENT__TEXT_ALIGNMENT ||
                feature == IArchimatePackage.Literals.LINE_OBJECT__LINE_COLOR) {
            return false;
        }
        return super.shouldExposeFeature(instance, feature);
    }
}
