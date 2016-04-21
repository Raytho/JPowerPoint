package Vue;

import Controleur.TextZoneListener;
import Controleur.ResizableListener;
import Controleur.DragListener;
import Modele.Presentation;
import Modele.Item;
import Modele.Label;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;


public class Resizable extends Item implements Serializable{
    private JButton dragTopLeft, dragTopRight, dragBotLeft, dragBotRight;
    private CurrentSlideView currentSlideView;
    private JTextPane textZone;
    private Image image;
    private Label text = null;
    int fontSize;
    Presentation presentation;
    
    public Resizable(int i, int i1, int x, int y, CurrentSlideView currentSlide, Image image, Presentation presentation){
        Dimension size = new Dimension(200,100);
        this.setBounds(x,y, size.width, size.height);
        this.setOpaque(false);
        this.currentSlideView = currentSlide;
        this.setLayout(null);
        this.presentation = presentation;
        this.setSelected(true);
        
        if(image==null){
            textZone = new JTextPane();
            textZone.setForeground(this.presentation.getTextColor());
            textZone.setFont(this.presentation.getFont());
            textZone.setBounds(1,1, size.width-2, size.height-2);
            textZone.setOpaque(false);
            this.add(textZone);
            this.image = null;
            TextZoneListener tzl = new TextZoneListener(this, currentSlideView.getPresentation());
            this.textZone.addMouseListener(tzl);
        }else{
            this.textZone = null;
            this.image = image;
            
        }

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
        
        ResizableListener jtal = new ResizableListener();
        this.addMouseListener(jtal);
        this.addMouseMotionListener(jtal);
    }

    public JButton getDragTopLeft() {
        return dragTopLeft;
    }

    public JButton getDragTopRight() {
        return dragTopRight;
    }

    public JButton getDragBotLeft() {
        return dragBotLeft;
    }

    public JButton getDragBotRight() {
        return dragBotRight;
    }

    public CurrentSlideView getCurrentSlideView() {
        return currentSlideView;
    }

    public JTextPane getTextZone() {
        return textZone;
    }

    public Image getImage() {
        return image;
    }

    public Label getText() {
        return text;
    }

    public void setText(Label text) {
        this.text = text;
    }
}
