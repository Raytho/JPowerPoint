package Projet;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.BUTTON1;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextPane;


public class TextZoneListener implements MouseListener{
    Resizable zr;
    Application app;
    public TextZoneListener(Resizable zr, Application app) {
        this.zr = zr;
        this.app = app;
    }

    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }
    

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.getButton() == BUTTON1 && zr.getBorder() == null){
            zr.setBorder(BorderFactory.createTitledBorder(""));
            CurrentSlideView currentSlide = zr.getCurrentSlideView();
            for(int i = currentSlide.getSlide().getItemsCurrentSlide().size()-1; i>=0; i--){
                Component previous = currentSlide.getSlide().getItemsCurrentSlide().get(i);
                if(previous instanceof Resizable) {
                    Resizable zr2 = (Resizable)previous;
                    if(zr2.getImage() == null){
                        if(zr2.getTextZone() != (JTextPane)me.getSource()){
                            zr2.setBorder(null);
                            zr2.repaint();
                            zr2.setSelected(false);
                        } 
                        Font font = zr2.getTextZone().getFont();
                        JLabel labelOnMiniSlide = new JLabel(zr2.getTextZone().getText());
                        labelOnMiniSlide.setSize(zr2.getSize().height*10/45, zr2.getSize().width*10/45);
                        labelOnMiniSlide.setLocation(zr2.getX()*10/45, zr2.getY()*10/45);
                        labelOnMiniSlide.setFont(new Font("Serif", font.getStyle(), font.getSize()*20/45));
                        currentSlide.getSlide().getItemsMiniSlide().add(labelOnMiniSlide);
                        this.app.notifyObserver();
                        zr.setSelected(false);
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
  
    }

    @Override
    public void mouseExited(MouseEvent me) {
       
    }
    
}
