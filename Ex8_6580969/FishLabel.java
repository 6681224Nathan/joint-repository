/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex8_6580969;
//Veerapat Leepiboonsawat 6580969
//Nathan Tanaboriboon 6681224

import java.util.Random;
import javax.swing.*;

/**
 *
 * @author User
 */
public class FishLabel extends BaseLabel {
    
    private BowlLabel bowl;
    protected int upperBound, lowerBound;
    protected boolean caught;
    private boolean facingRight = true;

    public FishLabel(String file1, String file2, int w, int h, Mainapplication pf, BowlLabel bowl) {
        super(file1, file2, w, h, pf);
        this.bowl = bowl;
    }

    public boolean isCaught() {
        return caught;
    }

    public void setCaught(boolean c) {
        caught = c;
    }

    public void setVerticalBounds(int up, int lo) {
        upperBound = up;
        lowerBound = lo;
    }

    public void moveUp() {
     if(!caught){
        if (verticalMove && curY - 10 >= upperBound) {
            curY -= 10;
            setLocation(curX, curY);
        }
     } 
    }

    public void moveDown() {
     if(!caught){
        if (verticalMove && curY + 10 + height <= lowerBound) {
            curY += 10;
            setLocation(curX, curY);
        }
     }
    }

    public void moveLeft() {
     if(!caught){
        if (horizontalMove) {
            curX -= 10;
            if (curX + width < 0) {
                curX = parentFrame.getWidth();
            }
            setLocation(curX, curY);
            if (facingRight) {
                setMainIcon();
                facingRight = false;
            }
        }
     }
    }

    public void moveRight() {
      if(!caught){  
        if (horizontalMove) {
            curX += 10;
            if (curX > parentFrame.getWidth()) {
                curX = -width;
            }
            setLocation(curX, curY);
            if (!facingRight) {
                setAltIcon(); 
                facingRight = true;
            }
        }
      }
    }

    public void escape() {
        if (caught) {
            Random rand = new Random();

            int MaxX = parentFrame.getWidth() - width;
            int MaxY = (lowerBound - height);

            curX = rand.nextInt(1, MaxX);
            curY = rand.nextInt(upperBound, (MaxY));

            setLocation(curX, curY);

            parentFrame.setTitle("Fish is swimming");
            
            
            
        }
        this.setCaught(false);
        bowl.setMainIcon();

    }

    @Override
    public void updateLocation() {
        setLocation(curX, curY);
    }

}
