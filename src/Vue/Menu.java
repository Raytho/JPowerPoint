

package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
        ActionListener SaveListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String filename = JOptionPane.showInputDialog("Name this file");
                    JFileChooser savefile = new JFileChooser();
                    savefile.setSelectedFile(new File(filename));
        savefile.showSaveDialog(savefile);
                }
        };       
        saveF.addActionListener(SaveListener);
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
