
package Projet;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
    
    //private ArrayList<JButton> buttons;
    
    public Toolbar(){
      this.setRollover(true);
      
      JButton swag = new JButton("k");
      JButton swag1 = new JButton("k1");
      JButton swag2 = new JButton("k2");
      JButton swag3 = new JButton("k3");
      JButton swag4 = new JButton("k4");
      JButton swag5 = new JButton("k5");
      
      
      this.add(swag);
      this.add(swag1);
      this.add(swag2);
      this.add(swag3);
      this.add(swag4);
      this.add(swag5);
      
    }
    
}
