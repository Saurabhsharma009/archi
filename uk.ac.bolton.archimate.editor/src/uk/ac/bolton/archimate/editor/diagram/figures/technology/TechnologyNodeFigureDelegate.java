/*******************************************************************************
 * Copyright (c) 2010 Bolton University, UK.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 *******************************************************************************/
package uk.ac.bolton.archimate.editor.diagram.figures.technology;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import uk.ac.bolton.archimate.editor.diagram.figures.AbstractFigureDelegate;
import uk.ac.bolton.archimate.editor.diagram.figures.IDiagramModelObjectFigure;
import uk.ac.bolton.archimate.editor.ui.ColorFactory;



/**
 * Technology Node Figure Delegate
 * 
 * @author Phillip Beauvoir
 */
public class TechnologyNodeFigureDelegate extends AbstractFigureDelegate {

    protected int FOLD_HEIGHT = 14;
    protected int SHADOW_OFFSET = 2;

    public TechnologyNodeFigureDelegate(IDiagramModelObjectFigure owner) {
        super(owner);
    }
    
    @Override
    public void drawFigure(Graphics graphics) {
        Rectangle bounds = getOwner().getBounds().getCopy();
        
        // Main Shadow
        graphics.setAlpha(100);
        graphics.setBackgroundColor(ColorConstants.black);
        int[] points = new int[] {
                bounds.x + SHADOW_OFFSET, bounds.y + FOLD_HEIGHT,
                bounds.x + FOLD_HEIGHT, bounds.y + SHADOW_OFFSET,
                bounds.x + bounds.width, bounds.y + SHADOW_OFFSET,
                bounds.x + bounds.width, bounds.y + bounds.height - FOLD_HEIGHT,
                bounds.x + bounds.width - FOLD_HEIGHT + SHADOW_OFFSET - 1, bounds.y + bounds.height,
                bounds.x + SHADOW_OFFSET, bounds.y + bounds.height
        };
        graphics.fillPolygon(points);

        // Fill front rectangle
        graphics.setAlpha(255);
        graphics.setBackgroundColor(getOwner().getFillColor());
        graphics.fillRectangle(bounds.x, bounds.y + FOLD_HEIGHT, bounds.width - FOLD_HEIGHT, bounds.height - FOLD_HEIGHT - SHADOW_OFFSET);

        graphics.setBackgroundColor(ColorFactory.getDarkerColor(getOwner().getFillColor()));

        // Angle 1
        int[] points1 = new int[] {
                bounds.x, bounds.y + FOLD_HEIGHT,
                bounds.x + FOLD_HEIGHT, bounds.y,
                bounds.x + bounds.width - SHADOW_OFFSET, bounds.y,
                bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + FOLD_HEIGHT
        };
        graphics.fillPolygon(points1);
        
        // Angle 1
        int[] points2 = new int[] {
                bounds.x + bounds.width - SHADOW_OFFSET, bounds.y,
                bounds.x + bounds.width - SHADOW_OFFSET, bounds.y + bounds.height - FOLD_HEIGHT - SHADOW_OFFSET - 1, 
                bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + bounds.height - SHADOW_OFFSET - 1,
                bounds.x + bounds.width - FOLD_HEIGHT - 1, bounds.y + FOLD_HEIGHT
        };
        graphics.fillPolygon(points2);

        // Line
        graphics.setBackgroundColor(ColorConstants.black);
        graphics.drawRectangle(bounds.x, bounds.y + FOLD_HEIGHT, bounds.width - FOLD_HEIGHT - 1, bounds.height - FOLD_HEIGHT - 3);
        graphics.drawPolygon(points1);
        graphics.drawPolygon(points2);
    }
    
    @Override
    public void drawTargetFeedback(Graphics graphics) {
        graphics.pushState();
        graphics.setForegroundColor(ColorConstants.blue);
        graphics.setLineWidth(2);
        Rectangle bounds = getOwner().getBounds().getCopy();
        graphics.drawRectangle(new Rectangle(bounds.x + 1, bounds.y + 1, bounds.width - SHADOW_OFFSET - 1, bounds.height - SHADOW_OFFSET - 1));
        graphics.popState();
    }

    @Override
    public Rectangle calculateTextControlBounds() {
        Rectangle bounds = getOwner().getBounds().getCopy();
        bounds.x += 20;
        bounds.y += 2 + FOLD_HEIGHT;
        bounds.width = bounds.width - 40;
        bounds.height -= 20;
        return bounds;
    }
}