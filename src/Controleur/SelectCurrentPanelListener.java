package Controleur;

import Modele.Label;
import Modele.Presentation;
import Vue.CurrentSlideView;
import Vue.Resizable;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;

public class SelectCurrentPanelListener extends MouseInputAdapter{
    private Presentation presentation;
    
    public SelectCurrentPanelListener(Presentation presentation) {
        this.presentation = presentation;
    }
    
    @Override
    public void mousePressed(MouseEvent me) {   
        CurrentSlideView currentSlide = (CurrentSlideView)me.getSource();
        
        for(int i=0;i<=currentSlide.getSlide().getItemsCurrentSlide().size()-1;i++) {
                Component current = currentSlide.getSlide().getItemsCurrentSlide().get(i);
                if(current instanceof Resizable) {
                    Resizable zr = (Resizable)current;
                    
                    if(zr.isSelected() && zr.getImage() == null){
                        
                        if(!zr.getTextZone().getText().isEmpty()) {
                            zr.setBorder(null);                
                            Font font = zr.getTextZone().getFont();

                            Label labelOnMiniSlide = new Label(zr.getTextZone().getText());
                            labelOnMiniSlide.getMyLabel().setSize(zr.getSize().height*10/45, zr.getSize().width*10/45);
                            labelOnMiniSlide.setSize(zr.getSize().height, zr.getSize().width*10/45);
                            labelOnMiniSlide.setLocation(zr.getX()*10/45, zr.getY()*10/45);
                            labelOnMiniSlide.getMyLabel().setFont(new Font("Serif", font.getStyle(), font.getSize()*20/45));
                            if(zr.getText() == null) {
                                currentSlide.getSlide().getItemsMiniSlide().add(labelOnMiniSlide);
                                zr.setText(labelOnMiniSlide);
                            }
                            else {
                                currentSlide.getSlide().getItemsMiniSlide().remove(zr.getText());
                                zr.setText(labelOnMiniSlide);
                                currentSlide.getSlide().getItemsMiniSlide().add(zr.getText());
                            }
                            
                            this.presentation.notifyObserver();
                            zr.setSelected(false);
                        }
                        else {
                            currentSlide.getSlide().getItemsMiniSlide().remove(zr.getText());
                            currentSlide.getSlide().getItemsCurrentSlide().remove(zr);
                            this.presentation.notifyObserver();
                        }
                    }
                }
            }

    }
}
