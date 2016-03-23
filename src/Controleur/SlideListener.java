package Controleur;

import Modele.Application;
import Vue.CurrentSlideView;
import Vue.Resizable;
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
                    
                    if(zr.isSelected() && zr.getImage() == null){
                        
                        if(!zr.getTextZone().getText().isEmpty()) {
                            zr.setBorder(null);                
                            Font font = zr.getTextZone().getFont();

                            JLabel labelOnMiniSlide = new JLabel(zr.getTextZone().getText());
                            labelOnMiniSlide.setSize(zr.getSize().height*10/45, zr.getSize().width*10/45);
                            labelOnMiniSlide.setLocation(zr.getX()*10/45, zr.getY()*10/45);
                            labelOnMiniSlide.setFont(new Font("Serif", font.getStyle(), font.getSize()*20/45));
                            if(zr.getText() == null) {
                                currentSlide.getSlide().getItemsMiniSlide().add(labelOnMiniSlide);
                                zr.setText(labelOnMiniSlide);
                            }
                            else {
                                currentSlide.getSlide().getItemsMiniSlide().remove(zr.getText());
                                zr.setText(labelOnMiniSlide);
                                currentSlide.getSlide().getItemsMiniSlide().add(zr.getText());
                            }
                            

                            this.app.notifyObserver();
                            zr.setSelected(false);
                        }
                        else {
                            currentSlide.getSlide().getItemsMiniSlide().remove(zr.getText());
                            currentSlide.getSlide().getItemsCurrentSlide().remove(zr);
                            this.app.notifyObserver();
                        }
                        return;
                    }
                }
            }


            Resizable zr = new Resizable(5, 20, me.getX(), me.getY(), currentSlide, null, app);
            zr.setBorder(BorderFactory.createTitledBorder(""));
            currentSlide.getSlide().addCurrentSlideComponent(zr);

            currentSlide.add(zr);
            currentSlide.add(zr.getDragTopLeft());
            currentSlide.add(zr.getDragTopRight());
            currentSlide.add(zr.getDragBotLeft());
            currentSlide.add(zr.getDragBotRight());
            currentSlide.setComponentZOrder(zr, 1);
            currentSlide.setComponentZOrder(zr.getDragTopLeft(), 0);
            currentSlide.setComponentZOrder(zr.getDragTopRight(), 0);
            currentSlide.setComponentZOrder(zr.getDragBotLeft(), 0);
            currentSlide.setComponentZOrder(zr.getDragBotRight(), 0);
            currentSlide.validate();
            currentSlide.repaint();
        }
    }
    
}
