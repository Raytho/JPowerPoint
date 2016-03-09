package Projet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
                if(current instanceof Resizable) {
                    Resizable zr = (Resizable)current;
                    if(zr.image == null){
                        
                        zr.setBorder(BorderFactory.createEmptyBorder());                
                        Font font = zr.textZone.getFont();
                        
                        JLabel labelOnMiniSlide = new JLabel(zr.textZone.getText());
                        labelOnMiniSlide.setSize(zr.getSize().height*10/45, zr.getSize().width*10/45);
                        labelOnMiniSlide.setLocation(zr.getX()*10/45, zr.getY()*10/45);
                        labelOnMiniSlide.setFont(new Font("Serif", font.getStyle(), font.getSize()*20/45));
                        currentSlide.getSlide().getItemsMiniSlide().add(labelOnMiniSlide);
                        
                        this.app.notifyObserver();
                    }
                }
            }


            Resizable zr = new Resizable(5, 20, me.getX(), me.getY(), currentSlide, null);
            zr.setBorder(BorderFactory.createTitledBorder(""));
            currentSlide.getSlide().addCurrentSlideComponent(zr);

            currentSlide.add(zr);
            currentSlide.add(zr.dragTopLeft);
            currentSlide.add(zr.dragTopRight);
            currentSlide.add(zr.dragBotLeft);
            currentSlide.add(zr.dragBotRight);
            currentSlide.setComponentZOrder(zr, 1);
            currentSlide.setComponentZOrder(zr.dragTopLeft, 0);
            currentSlide.setComponentZOrder(zr.dragTopRight, 0);
            currentSlide.setComponentZOrder(zr.dragBotLeft, 0);
            currentSlide.setComponentZOrder(zr.dragBotRight, 0);
            currentSlide.validate();
            currentSlide.repaint();
        }
    }
    
}
