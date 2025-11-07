package Ex9_6580969;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainApplication extends JFrame implements MyConstants
{
    // components
    private JPanel            contentpane;
    private JLabel            drawpane;
    private JComboBox         combo;
    private JToggleButton     []tb;
    private ButtonGroup       bgroup;
    private JButton           moveButton, stopButton, itemButton;
    private JTextField        fruitCountText, starCountText;
    private MyImageIcon       backgroundImg;    
    private MySoundEffect     themeSound;
    
    private GirlLabel         girlLabel;
    private MainApplication   currentFrame;

    private int framewidth  = MyConstants.FRAME_WIDTH;
    private int frameheight = MyConstants.FRAME_HEIGHT;
    private int fruitCount, starCount;
    private Thread girlThread, itemThread; 

    public static void main(String[] args) 
    {
        new MainApplication();
    }    

    //--------------------------------------------------------------------------
    public MainApplication()
    {   
        setTitle("Falling Fruit Game");
	setSize(framewidth, frameheight); 
        setLocationRelativeTo(null);
	setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        currentFrame = this;
       

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                themeSound.stop();
                girlLabel.setMove(false);
                if (girlThread != null && girlThread.isAlive()) girlThread.interrupt();

                JOptionPane.showMessageDialog(null,
                    "Final Fruit Count: " + fruitCount + "\nFinal Star Count: " + starCount,
                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        

	contentpane = (JPanel)getContentPane();
	contentpane.setLayout( new BorderLayout() );        
        AddComponents();
        setVisible(true);
    } 
    
    //--------------------------------------------------------------------------
    public void AddComponents()
    {    
        // leave some space for frame's north + south panels
	backgroundImg = new MyImageIcon(MyConstants.FILE_BG).resize(framewidth, frameheight-100); 
	drawpane = new JLabel();
	drawpane.setIcon(backgroundImg);
        drawpane.setLayout(null);

	themeSound = new MySoundEffect(MyConstants.FILE_THEME); 
        themeSound.playLoop(); themeSound.setVolume(0.3f);
        
        girlLabel = new GirlLabel(currentFrame);
        drawpane.add(girlLabel);
        
        
        // (2) Add ActionListener (anonymous class) to moveButton
        //     - If Girl isn't moving, create girlThread to make it move
	moveButton = new JButton("Move");
        moveButton.addActionListener(e -> {
        if (girlThread == null || !girlThread.isAlive()) setGirlThread();
        girlLabel.setMove(true);
        });
        
        
        // (3) Add ActionListener (anonymous class) to stopButton
        //     - Stop girlThread, i.e. make it return from method run
	stopButton = new JButton("Stop");
        stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> girlLabel.setMove(false));

        
	// (4) Add ItemListener (anonymouse class) to combo 
        //     - Set Girl's speed, i.e. sleeping time for girlThread
        String[] speed = { "fast", "medium", "slow"};
        combo = new JComboBox(speed);
	combo.setSelectedIndex(1);
         combo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String s = (String) combo.getSelectedItem();
                int val = s.equals("fast") ? 50 : (s.equals("medium") ? 100 : 150);
                girlLabel.setSpeed(val);
            }
        });

        
	// (5) Add ItemListener (anonymouse class) to tb[i]
        //     - Set whether there are left/right walls or not
        //     - Make sure that only 1 radio button is selected at a time
        tb = new JToggleButton[2];
        bgroup = new ButtonGroup();      
        tb[0] = new JRadioButton("No wall");           
        tb[0].setName("NoWall");
        tb[1] = new JRadioButton("Left-right walls");  
        tb[1].setName("Walls"); 
	tb[0].setSelected(true);
        bgroup.add(tb[1]);
        bgroup.add(tb[0]);

        tb[0].addItemListener(e -> girlLabel.setwalls(!tb[0].isSelected()));
        tb[1].addItemListener(e -> girlLabel.setwalls(tb[1].isSelected()));

        
        // (6) Add ActionListener (anonymous class) to itemButton
        //     - Create a new itemThread with ItemLabel
	itemButton = new JButton("More Item");
        itemButton.addActionListener(e -> setItemThread());

        
	fruitCountText = new JTextField("0", 5);		
	fruitCountText.setEditable(false);
        
        starCountText = new JTextField("0", 5);
        starCountText.setEditable(false);

        JPanel controlNorth = new JPanel();
	controlNorth.add(new JLabel("Girl control : "));
        controlNorth.add(moveButton);
        controlNorth.add(stopButton);
        controlNorth.add(combo);
        controlNorth.add(tb[0]);
        controlNorth.add(tb[1]);
        
        JPanel controlSouth = new JPanel();
	controlSouth.add(new JLabel("Item control : "));
	controlSouth.add(itemButton);
	controlSouth.add(new JLabel("             "));
	controlSouth.add(new JLabel("Fruit count : "));
	controlSouth.add(fruitCountText);
        controlSouth.add(new JLabel("             "));
	controlSouth.add(new JLabel("Star count : "));
	controlSouth.add(starCountText);        
        
        contentpane.add(controlNorth, BorderLayout.NORTH);
        contentpane.add(drawpane, BorderLayout.CENTER); 
        contentpane.add(controlSouth, BorderLayout.SOUTH);        
        
        revalidate();
        repaint();
    }    

    //--------------------------------------------------------------------------
    public void setGirlThread()
    {
         girlThread = new Thread() {
            public void run() 
            {
                while (girlLabel.isMove())
                {
                    girlLabel.updateLocation();
                }          
            } // end run
        }; // end thread creation
        girlThread.start();
    }
    //--------------------------------------------------------------------------
    public void setItemThread()
    {
       Thread thread = new Thread() {
        public void run() {
            ItemLabel item = new ItemLabel(currentFrame);
            drawpane.add(item);
            drawpane.repaint();

            while (true) {
                if (item.getType() == 0) {
                    
                    item.setLocation(item.getX(), item.getY() + 10);

                    if (item.getBounds().intersects(girlLabel.getBounds())) {
                        if (!girlLabel.isBouncing()) {
                           
                            item.playHitSound();
                            updateFruitCount(item.getHitPoints());
                            drawpane.remove(item);
                            drawpane.repaint();
                            break;
                        } else {
                            
                            item.switchType();
                            item.playHitSound();
                            updateStarCount(item.getHitPoints());
                        }
                    } else if (item.getY() > frameheight) {
                        
                        drawpane.remove(item);
                        drawpane.repaint();
                        break;
                    }

                } else {
                   
                    item.setLocation(item.getX(), item.getY() - 10);

                    if (item.getY() < -ITEM_HEIGHT) {
                        drawpane.remove(item);
                        drawpane.repaint();
                        break;
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        } // end run
    }; // end new Thread
    thread.start();  
    }
    //--------------------------------------------------------------------------
    // (9) Update must be synchronized since it can be done by >1 itemThreads
    public synchronized void updateFruitCount(int hp) {
        fruitCount += hp;
        fruitCountText.setText("" + fruitCount);
    }

    public synchronized void updateStarCount(int hp) {
        starCount += hp;
        starCountText.setText("" + starCount);
    }

} // end class MainApplication
