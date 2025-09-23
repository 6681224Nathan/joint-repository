/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex8_6580969;
//Veerapat Leepiboonsawat 6580969
//Nathan Tanaboriboon 6681224
/**
 *
 * @author User
 */
class BowlLabel extends BaseLabel {

   

    public BowlLabel(String file1, String file2, int w, int h, Mainapplication pf) {
        super(file1, file2, w, h, pf);
        
    }

    public void moveLeft() {
        if (horizontalMove) {
            curX -= 10;
            
            
            if (curX + width < 0) {
                curX = parentFrame.getWidth();
            }
            setLocation(curX, curY);
        }
    }

    public void moveRight() {
        if (horizontalMove) {
            curX += 10;
            
            if (curX > parentFrame.getWidth()) {
                curX = -width;
            }
            setLocation(curX, curY);
        }
    }
    


    @Override
    public void updateLocation() {
        setLocation(curX, curY);
    }
}
