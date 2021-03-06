// TeleTeachingTool - Presentation Recording With Automated Indexing
//
// Copyright (C) 2003-2008 Peter Ziewer - Technische Universit�t M�nchen
// 
//    This file is part of TeleTeachingTool.
//
//    TeleTeachingTool is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    TeleTeachingTool is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with TeleTeachingTool.  If not, see <http://www.gnu.org/licenses/>.

/*
 * Created on 16.03.2006
 *
 * Author: Peter Ziewer, TU Munich, Germany - ziewer@in.tum.de
 */
package ttt.player;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import ttt.Constants;
import static ttt.Constants.highResIcon;
import ttt.gui.GradientPanel;
import ttt.messages.Annotation;



public class PaintControls extends GradientPanel {

    private JToggleButton activateButton;
    private JToggleButton[] colorButtons;

    private AbstractButton mouseButton;
    private AbstractButton textButton;
    private AbstractButton highlightButton;
    private AbstractButton freeButton;
    private AbstractButton rectangleButton;
    private AbstractButton lineButton;
    private AbstractButton deleteButton;
    private JButton deleteAllButton;

    private AbstractButton whiteboardEnable;
    private JButton whiteboardNext, whiteboardPrevious;

    private PaintListener paintListener;

    public PaintControls(PaintListener paintListener) {
    	super(SwingConstants.VERTICAL);
        this.paintListener = paintListener;
        paintListener.setPaintControls(this);

        // initialize GUI
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static final String HIGHLIGHT = "highlight";
    static final String RECTANGLE = "rectangle";
    static final String LINE = "line";
    static final String FREEHAND = "freehand";
    static final String DELETE = "delete";
    static final String DELETE_ALL = "delete all";

    private void jbInit() throws Exception {
      
    	
        activateButton = new JToggleButton(Constants.highResIcon("check.png","Enable_active16.gif"));
        //activateButton.setIcon(Constants.getIcon("Enable16.gif"));        
        //activateButton.setSelectedIcon(Constants.getIcon("Enable_active16.gif"));
        activateButton.setToolTipText("Activate painting");
        activateButton.setFocusable(false);
        
        colorButtons = new JToggleButton[5];
        for (int i = 0; i < colorButtons.length; i++) {
            colorButtons[i] = new JToggleButton();
        }

        Icon colorIcon = Constants.highResIcon("colorblack.png","color_button24.gif");
        Icon colorActiveIcon = Constants.getIcon("color_button_active24.gif");
        Icon colorRolloverIcon = Constants.getIcon("color_button_rollover24.gif");
        
        // color buttons
        
        colorButtons[0].setBackground(Color.RED);
        //colorButtons[0].setBorder(BorderFactory.createEmptyBorder());
        colorButtons[0].setToolTipText("Choose Color");
        //colorButtons[0].setIcon(colorIcon);
        colorButtons[0].setIcon(Constants.highResIcon("colorred.png","color_button24.gif"));
        //colorButtons[0].setRolloverIcon(colorRolloverIcon);
        colorButtons[0].setFocusable(false);
        colorButtons[0].setOpaque(true);

        colorButtons[1].setBackground(Color.BLUE);
        //colorButtons[1].setBorder(BorderFactory.createEmptyBorder());
        colorButtons[1].setToolTipText("Choose Color");
        //colorButtons[1].setIcon(colorIcon);
        colorButtons[1].setIcon(Constants.highResIcon("colorblue.png","color_button24.gif"));
        //colorButtons[1].setRolloverIcon(colorRolloverIcon);
        colorButtons[1].setFocusable(false);
        colorButtons[1].setOpaque(true);

        colorButtons[2].setBackground(Color.GREEN);
        //colorButtons[2].setBorder(BorderFactory.createEmptyBorder());
        colorButtons[2].setToolTipText("Choose Color");
        //colorButtons[2].setIcon(colorIcon);
        colorButtons[2].setIcon(Constants.highResIcon("colorgreen.png","color_button24.gif"));
        //colorButtons[2].setRolloverIcon(colorRolloverIcon);
        colorButtons[2].setFocusable(false);
        colorButtons[2].setOpaque(true);

        colorButtons[3].setBackground(Color.YELLOW);
        //colorButtons[3].setBorder(BorderFactory.createEmptyBorder());
        colorButtons[3].setToolTipText("Choose Color");
        //colorButtons[3].setIcon(colorIcon);
        colorButtons[3].setIcon(Constants.highResIcon("coloryellow.png","color_button24.gif"));
        //colorButtons[3].setRolloverIcon(colorRolloverIcon);
        colorButtons[3].setFocusable(false);
        colorButtons[3].setOpaque(true);

        colorButtons[4].setBackground(Color.BLACK);
        //colorButtons[4].setBorder(BorderFactory.createEmptyBorder());
        colorButtons[4].setToolTipText("Choose Color");
        //colorButtons[4].setIcon(colorIcon);
        colorButtons[4].setIcon(Constants.highResIcon("colorblack.png","color_button24.gif"));
        //colorButtons[4].setRolloverIcon(colorRolloverIcon);
        colorButtons[4].setFocusable(false);
        colorButtons[4].setOpaque(true);

        ButtonGroup colorGroup = new ButtonGroup();
        for (int i = 0; i < colorButtons.length; i++)
            colorGroup.add(colorButtons[i]);

        // paint modes
        
        mouseButton = new JToggleButton(highResIcon("mouse.png","mouse24.png"));
        mouseButton.setToolTipText("Mouse");
        //mouseButton.setBorder(BorderFactory.createEmptyBorder());
        //mouseButton.setIcon(Constants.getIcon("mouse24.png"));
        //mouseButton.setIcon(loadIcon("mouse.png","mouse24.png"));
        //mouseButton.setSelectedIcon(loadIcon("mouse.png","mouse_active24.png"));
        //mouseButton.setRolloverIcon(loadIcon("mouse.png","mouse_rollover24.png"));
        mouseButton.setSelected(true);
        mouseButton.setFocusable(false);
        //Dimension dim = mouseButton.getPreferredSize();
        //dim.setSize(Math.max(dim.getWidth(),60),Math.max(60,dim.getHeight()));

        
        textButton = new JToggleButton(highResIcon("text.png","text24.png"));
        textButton.setToolTipText("Text");
        //textButton.setBorder(BorderFactory.createEmptyBorder());
        //textButton.setIcon(loadIcon("text.png","text24.png"));
        //textButton.setSelectedIcon(loadIcon("text.png","text_active24.png"));
        //textButton.setRolloverIcon(loadIcon("text.png","text_rollover24.png"));
        textButton.setFocusable(false);
        
        highlightButton = new JToggleButton(highResIcon("highlight.png","Highlight24_new.gif"));
        highlightButton.setToolTipText("Highlight");
        //highlightButton.setBorder(BorderFactory.createEmptyBorder());
        //highlightButton.setIcon(loadIcon("highlight.png","Highlight24_new.gif"));
        //highlightButton.setSelectedIcon(loadIcon("highlight.png","Highlight_active24_new.gif"));
        //highlightButton.setRolloverIcon(loadIcon("highlight.png","Highlight_rollover24_new.gif"));
        highlightButton.setFocusable(false);

        freeButton = new JToggleButton(highResIcon("freehand.png","Freehand24_new.gif"));
        freeButton.setToolTipText("Freehand");
        //freeButton.setBorder(BorderFactory.createEmptyBorder());
        //freeButton.setIcon(loadIcon("freehand.png","Freehand24_new.gif"));
        //freeButton.setSelectedIcon(loadIcon("freehand.png","Freehand_active24_new.gif"));
        //freeButton.setRolloverIcon(loadIcon("freehand.png","Freehand_rollover24_new.gif"));
        freeButton.setFocusable(false);

        rectangleButton = new JToggleButton(highResIcon("framing.png","Rectangle24_new.gif"));
        rectangleButton.setToolTipText("Rectangle");
        //rectangleButton.setBorder(BorderFactory.createEmptyBorder());
        //rectangleButton.setIcon(Constants.getIcon("Rectangle24_new.gif"));
        //rectangleButton.setSelectedIcon(Constants.getIcon("Rectangle_active24_new.gif"));
        //rectangleButton.setRolloverIcon(Constants.getIcon("Rectangle_rollover24_new.gif"));
        rectangleButton.setFocusable(false);

        lineButton = new JToggleButton(highResIcon("line.png","Line24.gif"));
        lineButton.setToolTipText("Line");
        //lineButton.setBorder(BorderFactory.createEmptyBorder());
        //lineButton.setIcon(loadIcon("line.png","Line24.gif"));
        //lineButton.setSelectedIcon(loadIcon("line.png","Line_active24.gif"));
        //lineButton.setRolloverIcon(loadIcon("line.png","Line_rollover24.gif"));
        lineButton.setFocusable(false);

        deleteButton = new JToggleButton(highResIcon("delete.png","Delete24.gif"));
        deleteButton.setToolTipText("Delete");
        //deleteButton.setBorder(BorderFactory.createEmptyBorder());
        //deleteButton.setIcon(loadIcon("delete.png","Delete24.gif"));
        //deleteButton.setSelectedIcon(loadIcon("delete.png","Delete_active24.gif"));
        //deleteButton.setRolloverIcon(loadIcon("delete.png","Delete_rollover24.gif"));
        deleteButton.setFocusable(false);

        deleteAllButton = new JButton(highResIcon("deleteall.png","Delete_all16.gif"));
        deleteAllButton.setToolTipText("Delete all");
        //deleteAllButton.setBorder(BorderFactory.createEmptyBorder());
        //deleteAllButton.setIcon(loadIcon("deleteall.png","Delete_all16.gif"));
        //deleteAllButton.setSelectedIcon(loadIcon("deleteall.png","Delete_all_active16.gif"));
        deleteAllButton.setFocusable(false);

        ButtonGroup modeButtons = new ButtonGroup();
        modeButtons.add(mouseButton);
        modeButtons.add(textButton);
        modeButtons.add(lineButton);
        modeButtons.add(rectangleButton);
        modeButtons.add(freeButton);
        modeButtons.add(highlightButton);
        modeButtons.add(deleteButton);

        // create whiteboard controls
        whiteboardEnable = new JToggleButton(highResIcon("edit.png","Edit24.gif"));
        //whiteboardEnable.setMargin(new Insets(0, 0, 0, 0));
        whiteboardEnable.setActionCommand("switch");
        whiteboardEnable.setToolTipText("Switch between desktop and whiteboard");
        whiteboardEnable.setFocusable(false);

        whiteboardPrevious = new JButton(highResIcon("up.png","Back24.gif"));
        whiteboardPrevious.setActionCommand("previous");
        whiteboardPrevious.setToolTipText("previous whiteboard page");
        whiteboardPrevious.setFocusable(false);

        whiteboardNext = new JButton(highResIcon("down.png","Forward24.gif"));
        whiteboardNext.setActionCommand("next");
        whiteboardNext.setToolTipText("next whiteboard page");
        whiteboardNext.setFocusable(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(activateButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(colorButtons[0]);
        add(colorButtons[1]);
        add(colorButtons[2]);
        add(colorButtons[3]);
        add(colorButtons[4]);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(mouseButton);
        add(textButton);
        add(freeButton);
        add(highlightButton);
        add(rectangleButton);
        add(lineButton);
        add(deleteButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(deleteAllButton);
        add(Box.createRigidArea(new Dimension(0, 10)));

        add(whiteboardPrevious);
        add(whiteboardEnable);
        add(whiteboardNext);
        add(Box.createGlue());

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	
            	//If the mouseButton gets disabled reactivate the last drawing mode
            	 if(mouseButton.isSelected() && event.getSource() != mouseButton){
            	       switch(  paintListener.getPaintMode()){
            		case Constants.AnnotationText:
            			textButton.setSelected(true);
            			break;
            		case Constants.AnnotationHighlight:
            			highlightButton.setSelected(true);
            			break;
            		case Constants.AnnotationFreehand:
            			freeButton.setSelected(true);
            			break;
            		case Constants.AnnotationRectangle:
            			rectangleButton.setSelected(true);
            			break;
            		case Constants.AnnotationLine:
            			lineButton.setSelected(true);
            			break;
            		case Constants.AnnotationDelete:
            			deleteButton.setSelected(true);
            			break;
            		default:
            		    paintListener.setPaintMode(Constants.AnnotationFreehand);
            			freeButton.setSelected(true);
            		}
            	 }
            	
            	
                // enable/disable painting
                if (event.getSource() == activateButton){
                    paintListener.setActivated(activateButton.isSelected());
                    mouseButton.setSelected(!activateButton.isSelected());                   
                }
                
                // automatically enable painting
                else if (event.getSource() != deleteAllButton) {
                    activateButton.setSelected(true);
                    paintListener.setActivated(true);
                    
                }

                // set paint mode
                if (event.getSource() == textButton) {
                	paintListener.setPaintMode(Constants.AnnotationText);
                	highlightButton.setSelected(false);
                    freeButton.setSelected(false);
                    lineButton.setSelected(false);
                    rectangleButton.setSelected(false);
                    deleteButton.setSelected(false);
                    mouseButton.setSelected(false);
                } else if (event.getSource() == highlightButton) {
                    paintListener.setPaintMode(Constants.AnnotationHighlight);
                    textButton.setSelected(false);
                    freeButton.setSelected(false);
                    lineButton.setSelected(false);
                    rectangleButton.setSelected(false);
                    deleteButton.setSelected(false);
                    mouseButton.setSelected(false);
                } else if (event.getSource() == freeButton) {
                    paintListener.setPaintMode(Constants.AnnotationFreehand);
                    textButton.setSelected(false);
                    highlightButton.setSelected(false);
                    lineButton.setSelected(false);
                    rectangleButton.setSelected(false);
                    deleteButton.setSelected(false);
                    mouseButton.setSelected(false);
                } else if (event.getSource() == rectangleButton) {
                    paintListener.setPaintMode(Constants.AnnotationRectangle);
                    textButton.setSelected(false);
                    highlightButton.setSelected(false);
                    freeButton.setSelected(false);
                    lineButton.setSelected(false);
                    deleteButton.setSelected(false);
                    mouseButton.setSelected(false);
                } else if (event.getSource() == lineButton) {
                    paintListener.setPaintMode(Constants.AnnotationLine);
                    textButton.setSelected(false);
                    highlightButton.setSelected(false);
                    freeButton.setSelected(false);
                    rectangleButton.setSelected(false);
                    deleteButton.setSelected(false);
                    mouseButton.setSelected(false);
                } else if (event.getSource() == deleteButton) {
                    paintListener.setPaintMode(Constants.AnnotationDelete);
                    textButton.setSelected(false);
                    highlightButton.setSelected(false);
                    freeButton.setSelected(false);
                    lineButton.setSelected(false);
                    rectangleButton.setSelected(false);
                    mouseButton.setSelected(false);
                } else if (event.getSource() == mouseButton) {    
                    textButton.setSelected(false);
                    highlightButton.setSelected(false);                  
                    lineButton.setSelected(false);
                    rectangleButton.setSelected(false);
                    deleteButton.setSelected(false);
                    activateButton.setSelected(false);
                    freeButton.setSelected(false);
                    
                    paintListener.setActivated(false);
                }
                else if (event.getSource() == deleteAllButton){
                    paintListener.setPaintMode(Constants.AnnotationDeleteAll);
                }                 
                // set color
                else if (event.getSource() == colorButtons[0]){
                    paintListener.setColor(Annotation.Red);
                    }
                else if (event.getSource() == colorButtons[1]){
                    paintListener.setColor(Annotation.Blue);
                    }
                else if (event.getSource() == colorButtons[2]){
                    paintListener.setColor(Annotation.Green);
                    }
                else if (event.getSource() == colorButtons[3]){
                    paintListener.setColor(Annotation.Yellow);
                    }
                else if (event.getSource() == colorButtons[4]){
                    paintListener.setColor(Annotation.Black);
                    }

                else if (event.getSource() == whiteboardEnable){
                    paintListener.enableWhiteboard(whiteboardEnable.isSelected());
                    if(mouseButton.isSelected()){
                    	freeButton.setSelected(true);
                    }
                }
                else if (event.getSource() == whiteboardPrevious){
                    if (whiteboardEnable.isSelected()) {
                    	paintListener.previousWhiteboard();
                    	if(mouseButton.isSelected()){
                    		freeButton.setSelected(true);
                    	}
                    }
                    else
                    {
                    	paintListener.setPaintMode(Constants.AnnotationDeleteAll);
                    	paintListener.triggerPageUp();
                    }
                }
                else if (event.getSource() == whiteboardNext){
                	if (whiteboardEnable.isSelected()) {
                		paintListener.nextWhiteboard();
                		if(mouseButton.isSelected()){
                			freeButton.setSelected(true);
                		}
                	}
                	else
                	{
                		paintListener.setPaintMode(Constants.AnnotationDeleteAll);
                		paintListener.triggerPageDown();
                	}
                }
            }
        };

        activateButton.addActionListener(actionListener);

        textButton.addActionListener(actionListener);
        highlightButton.addActionListener(actionListener);
        freeButton.addActionListener(actionListener);
        rectangleButton.addActionListener(actionListener);
        lineButton.addActionListener(actionListener);
        deleteButton.addActionListener(actionListener);
        mouseButton.addActionListener(actionListener);
        deleteAllButton.addActionListener(actionListener);

        whiteboardEnable.addActionListener(actionListener);
        whiteboardPrevious.addActionListener(actionListener);
        whiteboardNext.addActionListener(actionListener);

        for (int i = 0; i < colorButtons.length; i++)
            colorButtons[i].addActionListener(actionListener);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    void setWhiteboardSelected(boolean selected) {
        whiteboardEnable.setSelected(selected);
    }

    // update GUI
    public void updateActivatedState(boolean activated) {
        activateButton.setSelected(activated);
    }

    public void selectColorButton(int color) {
        switch (color) {
        case Annotation.Red:
            colorButtons[0].setSelected(true);
            break;
        case Annotation.Blue:
            colorButtons[1].setSelected(true);
            break;
        case Annotation.Green:
            colorButtons[2].setSelected(true);
            break;
        case Annotation.Yellow:
            colorButtons[3].setSelected(true);
            break;
        case Annotation.Black:
            colorButtons[4].setSelected(true);
            break;
        default:
            break;
        }
    }

    public void selectPaintModeButton(int paintMode) {
        switch (paintMode) {
        case Constants.AnnotationText:
        	textButton.setSelected(true);
        	break;
        case Constants.AnnotationFreehand:
            freeButton.setSelected(true);
            break;
        case Constants.AnnotationHighlight:
            highlightButton.setSelected(true);
            break;
        case Constants.AnnotationLine:
            lineButton.setSelected(true);
            break;
        case Constants.AnnotationRectangle:
            rectangleButton.setSelected(true);
            break;
        case Constants.AnnotationDelete:
            deleteButton.setSelected(true);
            break;
        default:
            break;
        }
    }
    @Override
    public Dimension getPreferredSize() {
    	Dimension dim = super.getPreferredSize();
    	dim.setSize(Math.max(60, dim.getWidth()),dim.getHeight());
    	return dim;
    }
}
