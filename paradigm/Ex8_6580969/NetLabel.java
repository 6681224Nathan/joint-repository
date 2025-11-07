/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex8_6580969;
//Veerapat Leepiboonsawat 6580969
//Nathan Tanaboriboon 6681224

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author User
 */
public class NetLabel extends BaseLabel implements MouseMotionListener, MouseListener {

    private FishLabel fish;
    private BowlLabel bowl;
    private int lastMouseX, lastMouseY;

    public NetLabel(String file1, int w, int h, Mainapplication pf, FishLabel fish, BowlLabel bowl) {
        super(file1, null, w, h, pf);
        this.fish = fish;
        this.bowl = bowl;
        addMouseMotionListener(this);
        addMouseListener(this);

    }

    @Override
    public void updateLocation() {  
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
        lastMouseX = e.getXOnScreen();
        lastMouseY = e.getYOnScreen();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int newMouseX = e.getXOnScreen();
        int newMouseY = e.getYOnScreen();

        
        int dx = newMouseX - lastMouseX;
        int dy = newMouseY - lastMouseY;

        
        curX = getX() + dx;
        curY = getY() + dy;

        
        setLocation(curX, curY);

        
        lastMouseX = newMouseX;
        lastMouseY = newMouseY;

        if (this.getBounds().intersects(fish.getBounds())) {
            if(!fish.isCaught()){
            fish.setCaught(true);
            parentFrame.setTitle("Fish is caught");
            }
           
            fish.setLocation(curX, curY);
            
            if (this.getBounds().intersects(bowl.getBounds()) &&
            fish.getBounds().intersects(bowl.getBounds())) {
            bowl.setAltIcon(); 
        }

        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
   



    

