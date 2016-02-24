package Projet;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

/***************
 * @author ISEN THOMAS
 */




public class TextZone extends JTextArea{
    JButton dragTopLeft, dragTopRight, dragBotLeft, dragBotRight;
    
    public TextZone(String string, int i, int i1, int x, int y) {
        super(string, i, i1);
        Dimension size = this.getPreferredSize();
        this.setBounds(x,y, size.width, size.height); 

        dragTopLeft = new JButton();
        dragTopLeft.setBounds(x, y, 9, 9); 
        dragTopLeft.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        dragTopLeft.setContentAreaFilled(false);
        dragTopLeft.setBorderPainted(false);
        
        dragTopRight = new JButton();
        dragTopRight.setBounds(x+size.width-9, y, 9, 9);
        dragTopRight.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
        dragTopRight.setContentAreaFilled(false);
        dragTopRight.setBorderPainted(false);
        
        dragBotLeft = new JButton();
        dragBotLeft.setBounds(x, y+size.height-9, 9, 9);
        dragBotLeft.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
        dragBotLeft.setContentAreaFilled(false);
        dragBotLeft.setBorderPainted(false);
        
        dragBotRight = new JButton();
        dragBotRight.setBounds(x+size.width-9, y+size.height-9, 9, 9); 
        dragBotRight.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        dragBotRight.setContentAreaFilled(false);
        dragBotRight.setBorderPainted(false);

        DragListener dl = new DragListener(this);
        dragTopLeft.addMouseMotionListener(dl);
        dragTopLeft.addMouseListener(dl);
        dragBotRight.addMouseMotionListener(dl);
        dragBotRight.addMouseListener(dl);
        dragTopRight.addMouseMotionListener(dl);
        dragTopRight.addMouseListener(dl);
        dragBotLeft.addMouseMotionListener(dl);
        dragBotLeft.addMouseListener(dl);
       
        this.addMouseListener(new JTextAreaListener());
    }
    
}
