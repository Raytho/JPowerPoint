

package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Menu extends JMenuBar{
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Insertion");
    
    
    public Menu(){  
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem newF = new JMenuItem("New", KeyEvent.VK_N);
        fileMenu.add(newF);
        JMenuItem openF = new JMenuItem("Open", KeyEvent.VK_O);
        fileMenu.add(openF);
        JMenuItem saveF = new JMenuItem("Save", KeyEvent.VK_S);
        fileMenu.add(saveF);
        
        
        this.add(fileMenu);
        
        
        editMenu.setMnemonic(KeyEvent.VK_I);
        JMenu rectI = new JMenu("Rectangle");
        
        editMenu.add(rectI);
        JMenu ellipseI = new JMenu("Ellipse");
        
        editMenu.add(ellipseI);
        
        this.add(editMenu);
    
}
}
