

package Projet;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {

    JMenu fileMenu = new JMenu("File");
    JMenu insertionMenu = new JMenu("Insertion");
    
    public Menu(){
        
        
  
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem newF = new JMenuItem("New", KeyEvent.VK_N);
        fileMenu.add(newF);
        JMenuItem openF = new JMenuItem("Open", KeyEvent.VK_O);
        fileMenu.add(openF);
        JMenuItem saveF = new JMenuItem("Save", KeyEvent.VK_S);
        fileMenu.add(saveF);
        
        this.add(fileMenu);
        this.add(insertionMenu);
        
    }
    
}
