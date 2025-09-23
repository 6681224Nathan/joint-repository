/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex8_6580969;
//Veerapat Leepiboonsawat 6580969
//Nathan Tanaboriboon 6681224

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author User
 */
public abstract class BaseLabel extends JLabel
{
    protected MyImageIcon      iconMain, iconAlt;
    protected int              curX, curY, width, height;
    protected boolean          horizontalMove, verticalMove;
    protected Mainapplication  parentFrame;   
     
    public BaseLabel() { }
    public BaseLabel(String file1, String file2, int w, int h, Mainapplication pf)				
    { 
        width = w; height = h;
        iconMain = new MyImageIcon(file1).resize(width, height);  
	setIcon(iconMain);        
	setHorizontalAlignment(JLabel.CENTER);
        parentFrame = pf;  
        
        if (file2 != null)
            iconAlt = new MyImageIcon(file2).resize(width, height);
        else
            iconAlt = null;
    }

    public void setInitialLocation(int x, int y)
    {
        curX = x; curY = y; 
        setBounds(curX, curY, width, height);        
    }
    
    public void setMoveConditions(boolean hm, boolean vm)
    {
        horizontalMove = hm; verticalMove = vm;
    }
    
    abstract public void updateLocation(); 
    
    public void setMainIcon()      { setIcon(iconMain); }    
    public void setAltIcon()       { setIcon(iconAlt);  }
}

