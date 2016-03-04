package Projet;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.BUTTON1;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;


public class SlideListener extends MouseInputAdapter {
    private Application app;
    
    public SlideListener(Application app) {
        this.app = app;
    }
    
    @Override
    public void mousePressed(MouseEvent me) {   
        if(me.getButton() == BUTTON1){
            CurrentSlideView currentSlide = (CurrentSlideView)me.getSource();
            
            
            for(int i=0;i<=currentSlide.getSlide().getItemsCurrentSlide().size()-1;i++) {
                Component current = currentSlide.getSlide().getItemsCurrentSlide().get(i);
                if(current instanceof TextZone) {
                    TextZone zone = (TextZone)current;
                    JLabel label = new JLabel(zone.getText());
                    label.setSize(zone.getSize());
                    label.setLocation(zone.getX(), zone.getY());
                    currentSlide.getSlide().getItemsCurrentSlide().add(label);
                    
                    currentSlide.getSlide().getItemsCurrentSlide().remove(i);
                    this.app.notifyObserver();
                    //i--;
                    break;
                }
            }


            TextZone tz = new TextZone("", 5, 20, me.getX(), me.getY(), currentSlide);
            tz.setBorder(BorderFactory.createTitledBorder(""));
            currentSlide.getSlide().addCurrentSlideComponent(tz);

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
            currentSlide.validate();
            currentSlide.repaint();
        }
    }
    
}
