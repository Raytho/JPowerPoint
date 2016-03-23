
package Vue;

import Modele.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
    MouseListener tzal = null;
    
    
    public Toolbar(Application app){
      this.setRollover(true);
      
      JButton selectButton = new JButton("select");
      ActionListener selectButtonListener = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
            if(tzal != null) {
                app.getCurrentSlide().removeMouseListener(tzal);
                tzal = null;
            }
          }        
      };
      selectButton.addActionListener(selectButtonListener);
      this.add(selectButton);
      
      JButton textZoneButton = new JButton("text");
      ActionListener textZoneButtonListener = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
             tzal = new SlideListener(app);
             app.getCurrentSlide().addMouseListener(tzal);
          }        
      };
      textZoneButton.addActionListener(textZoneButtonListener);
      this.add(textZoneButton);
      
      
      
      JButton swag2 = new JButton("k2");
      JButton swag3 = new JButton("k3");
      JButton swag4 = new JButton("k4");
      JButton swag5 = new JButton("k5");
      
      
      
      
      this.add(swag2);
      this.add(swag3);
      this.add(swag4);
      this.add(swag5);
      
    }
    
}
