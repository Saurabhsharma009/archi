/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui.factory;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Color;


/**
 * Interface for Graphical Object UI Provider
 * 
 * @author Phillip Beauvoir
 */
public interface IGraphicalObjectUIProvider extends IObjectUIProvider {
    
    /**
     * @return The default colour to use for this object (usually a fill color)
     */
    Color getDefaultColor();

    /**
     * @return The default line colour to use for this object
     */
    Color getDefaultLineColor();
    
    /**
     * @return The default size width and height for this object
     */
    Dimension getDefaultSize();
    
}
