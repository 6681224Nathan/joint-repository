// Don't forget to rename the package
package Ex8;

import java.awt.event.*;
import javax.swing.*;


class MainApplication extends JFrame  //implements KeyListener
{
    private JLabel      contentpane;
    private FishLabel   fishLabel;
    private NetLabel    netLabel;
    private BowlLabel   bowlLabel;
    
    private int frameWidth   = MyConstants.FRAME_WIDTH;
    private int frameHeight  = MyConstants.FRAME_HEIGHT;
    private int separatorY   = MyConstants.SEPARATOR_Y;
    private int labelWidth   = MyConstants.LABEL_WIDTH;
    private int labelHeight  = MyConstants.LABEL_HEIGHT;

    public static void main(String[] args) 
    {
	new MainApplication();
    }	    
    
    
    public MainApplication()
    {      
	setSize(frameWidth, frameHeight); 
        setLocationRelativeTo(null);
	setVisible(true);
	setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE ); 
        setTitle("Fish is swimming");

	// set background image by using JLabel as contentpane
	setContentPane(contentpane = new JLabel());
	MyImageIcon background = new MyImageIcon(MyConstants.FILE_BG).resize(frameWidth, frameHeight);
	contentpane.setIcon( background );
	contentpane.setLayout( null );        

        
	fishLabel = new FishLabel(MyConstants.FILE_FISH_LEFT, MyConstants.FILE_FISH_RIGHT,
                                  labelWidth, labelHeight, this);       
        fishLabel.setInitialLocation(200, separatorY+50); 
        fishLabel.setMoveConditions(true, true);
        fishLabel.setVerticalBounds(separatorY, contentpane.getHeight());

        
        netLabel = new NetLabel(MyConstants.FILE_NET_MAIN, labelWidth, labelHeight, this);     
        netLabel.setInitialLocation(500, separatorY+20);
        netLabel.setMoveConditions(true, true);

        
        bowlLabel = new BowlLabel(MyConstants.FILE_BOWL_MAIN, MyConstants.FILE_BOWL_ALT, 
                                  labelWidth, labelHeight, this);
        bowlLabel.setInitialLocation(500, separatorY-labelHeight-30);        
        bowlLabel.setMoveConditions(true, false);

        
        // first added label is at the front, last added label is at the back
        contentpane.add( netLabel );
        contentpane.add( fishLabel );
        contentpane.add( bowlLabel );

	repaint();
    }
    
    public FishLabel getFishLabel()     { return fishLabel; }
    public NetLabel  getNetLabel()      { return netLabel;  }
    public BowlLabel getBowlLabel()     { return bowlLabel; }
    
    // (6) Implement keyPressed to handle event & add KeyListener to frame
    //     - Call methods moveUp/moveDown/moveLeft/moveRight of fishLabel
    //       (if fish is not caught) or bowlLabel
    //
    //     - Call methods to let fishLabel escape & reset bowlLabel's icon
}
