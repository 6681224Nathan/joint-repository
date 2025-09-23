/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex8_6580969;
//Veerapat Leepiboonsawat 6580969
//Nathan Tanaboriboon 6681224

import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author User
 */
public class Mainapplication extends JFrame implements KeyListener, MyConstants{

    /**
     * @param args the command line arguments
     */
      private JLabel      contentpane;
      private FishLabel   fishLabel;
      private NetLabel    netLabel;
      private BowlLabel   bowlLabel;
    
    private int frameWidth   = MyConstants.FRAME_WIDTH;
    private int frameHeight  = MyConstants.FRAME_HEIGHT;
    private int separatorY   = MyConstants.SEPARATOR_Y;
    private int labelWidth   = MyConstants.LABEL_WIDTH;
    private int labelHeight  = MyConstants.LABEL_HEIGHT;
    
    
    public static void main(String[] args) {
        new Mainapplication();
    }
    
    public Mainapplication()
    {
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fish is swimming");
        
        setContentPane(contentpane = new JLabel(new ImageIcon(FILE_BG)));
        contentpane.setLayout(null);
        setVisible(true);
        
        bowlLabel = new BowlLabel(FILE_BOWL_MAIN, FILE_BOWL_ALT,labelWidth, labelHeight, this);
        bowlLabel.setInitialLocation(500, separatorY-labelHeight-30);        
        bowlLabel.setMoveConditions(true, false);
        
        fishLabel = new FishLabel(FILE_FISH_LEFT, FILE_FISH_RIGHT, labelWidth, labelHeight, this, bowlLabel);
        fishLabel.setInitialLocation(200,separatorY+50);
        fishLabel.setMoveConditions(true, true);
        fishLabel.setVerticalBounds(separatorY, contentpane.getHeight() );
        
        netLabel = new NetLabel(FILE_NET_MAIN, labelWidth, labelHeight, this,fishLabel, bowlLabel);     
        netLabel.setInitialLocation(500, separatorY+20);
        netLabel.setMoveConditions(true, true);
        
        
        contentpane.add( bowlLabel );
        contentpane.add(fishLabel);        
        contentpane.add( netLabel );
       
        repaint();

       
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    
    }
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
@Override
public void keyTyped(KeyEvent e) {
    // Called when a key is typed (a Unicode character is input)
}

@Override
public void keyPressed(KeyEvent e) {
    // Called when a key is pressed down
     int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                fishLabel.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                fishLabel.moveRight();
                break;
            case KeyEvent.VK_UP:
                fishLabel.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                fishLabel.moveDown();
                break;
            case KeyEvent.VK_ESCAPE:
                fishLabel.escape();
                break;
            case KeyEvent.VK_A:
                bowlLabel.moveLeft();
                break;
             case KeyEvent.VK_D:
                bowlLabel.moveRight();
                break;    
        }
}

@Override
public void keyReleased(KeyEvent e) {
    // Called when a key is released
}
    
    
    
    
}
