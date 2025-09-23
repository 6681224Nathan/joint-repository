package Ex9_6580969;

import java.util.*;
import javax.swing.*;

////////////////////////////////////////////////////////////////////////////////
class GirlLabel extends JLabel
{
    private MainApplication  parentFrame;   
    private MyImageIcon      leftImg, rightImg;      
        
    private int width   = MyConstants.GIRL_WIDTH;
    private int height  = MyConstants.GIRL_HEIGHT;
    private int curY    = MyConstants.GROUND_Y;
    private int curX    = 300;
    private int speed   = 500;
     
            
    private boolean left    = true;     // left facing
    private boolean bounce  = false;    // bouncing effect
    private boolean move    = false;    // moving
    private boolean walls   = false;    // left-right walls

    
    public GirlLabel(MainApplication pf)
    {
        parentFrame = pf;
            
        leftImg  = new MyImageIcon(MyConstants.FILE_GIRL_LEFT).resize(width, height);
        rightImg = new MyImageIcon(MyConstants.FILE_GIRL_RIGHT).resize(width, height);
        setBounce(false);
        setBounds(curX, curY, width, height);
        setwalls (false);
    }
        
    public void    setSpeed(int s)       { speed = s; }
    public void    setMove(boolean m)    { move = m; }
    public boolean isMove()              { return move; }
    public void setwalls(boolean w)      {walls = w;}
    
    public void    turnLeft()            { setIcon(leftImg);  left = true;  bounce = false;  }
    public void    turnRight()           { setIcon(rightImg); left = false; bounce = true;   }
    public void    setBounce(boolean b)
    {
        bounce = b;
        if (bounce)  { setIcon(rightImg); left = false; }
        else         { setIcon(leftImg);  left = true;  }
    }
    public boolean isBouncing(){
        return bounce;
    }
    
  
    // (10) Add code such that when Girl reaches left/right border of the frame
    //      - If there is no wall, she'll appear on the opposite end
    //      - If there are walls, she'll turn back & walk in opposite direction
    public void updateLocation() {
    int step = 50;  // smooth movement

    if (left) {
       
        if (walls && (curX - step <= 0)) {
            curX = 0;
            turnRight();
        }
        
        else if (!walls && (curX - step <= -width)) {
            curX = parentFrame.getWidth();
        }
        else {
            curX -= step;
        }
    } else {
       
        if (walls && (curX + step + width >= parentFrame.getWidth())) {
            curX = parentFrame.getWidth() - width;
            turnLeft();
        }
        
        else if (!walls && (curX + step >= parentFrame.getWidth())) {
            curX = -width;
        }
        else {
            curX += step;
        }
    }

    setLocation(curX, curY);
    repaint();

    try {
        Thread.sleep(speed);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    
}
    
    // end class GirlLabel


////////////////////////////////////////////////////////////////////////////////
class ItemLabel extends JLabel 
{
    private MainApplication  parentFrame;   
    
    private int             type;                // 0 = fruit (fall down), 1 = star (float up)
    private MyImageIcon     []itemImgs;
    private MySoundEffect   []hitSounds;
    
    String [] imageFiles  = { MyConstants.FILE_FRUIT, MyConstants.FILE_STAR };        
    String [] soundFiles  = { MyConstants.FILE_COLLECT_FX, MyConstants.FILE_BOUNCE_FX };
    int    [] hitpoints   = { 2, 1 };

    private int width     = MyConstants.ITEM_WIDTH;
    private int height    = MyConstants.ITEM_HEIGHT;
    private int speed     = 600;    
    private int curX, curY;

    
    public ItemLabel(MainApplication pf)
    {
        parentFrame = pf;
        type = 0;
        
        Random rand = new Random();
        curX = rand.nextInt(10, parentFrame.getWidth()-100);
        curY = 0;
          
        itemImgs  = new MyImageIcon[2];
        hitSounds = new MySoundEffect[2];
        for (int i=0; i<2; i++)
        {
            itemImgs[i]  = new MyImageIcon(imageFiles[i]).resize(width, height);
            hitSounds[i] = new MySoundEffect(soundFiles[i]);
        }
        setIcon(itemImgs[0]);
        setBounds(curX, curY, width, height);
    }
        
    public void switchType()           { type = 1; setIcon(itemImgs[1]); }
    public int  getType()              { return type; }
    public void playHitSound()         { hitSounds[type].playOnce(); }
    public int  getHitPoints()         { return hitpoints[type]; }
        
} // end class ItemLabel
