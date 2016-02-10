

package Projet;

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
    /*JTextField rWidth = new JTextField("Rectangle Width");
    JTextField rLength = new JTextField("Rectangle Length");
    JTextField eX = new JTextField("Ellipse position X");
    JTextField eY = new JTextField("Ellipse position Y");
    JTextField eWidth = new JTextField("Ellipse width");
    JTextField eLength = new JTextField("Ellipse Length");*/
    
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
        /*JMenuItem createRect = new JMenuItem("Add");
        createRect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
            }
        });*/
        //rectI.add(createRect);
        //rectI.add(rWidth);
        //rectI.add(rLength);
        /*rectI.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
            }
        });
        */
        editMenu.add(rectI);
        JMenu ellipseI = new JMenu("Ellipse");
        /*ellipseI.add(eX);
        ellipseI.add(eY);
        ellipseI.add(eWidth);
        ellipseI.add(eLength);*/
        editMenu.add(ellipseI);
        
        this.add(editMenu);
    
}
}
