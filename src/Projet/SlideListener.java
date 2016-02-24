package Projet;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;


public class SlideListener extends MouseInputAdapter {
    public SlideListener() {
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        CurrentSlide currentSlide = (CurrentSlide)me.getSource();
        //Slide slide = currentSlide.getSlide();
        
        
        TextZone tz = new TextZone("", 5, 20, me.getX(), me.getY());
        tz.setBorder(BorderFactory.createTitledBorder(""));
        
        currentSlide.add(tz);
        currentSlide.add(tz.dragTopLeft);
        currentSlide.add(tz.dragTopRight);
        currentSlide.add(tz.dragBotLeft);
        currentSlide.add(tz.dragBotRight);
        currentSlide.setComponentZOrder(tz, 1);
        currentSlide.setComponentZOrder(tz.dragTopLeft, 0);
        currentSlide.setComponentZOrder(tz.dragTopRight, 0);
        currentSlide.setComponentZOrder(tz.dragBotLeft, 0);
        currentSlide.setComponentZOrder(tz.dragBotRight, 0);
        currentSlide.revalidate();
        currentSlide.repaint();
    }
    
}
