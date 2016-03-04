package Projet;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

public class EnterTextListener implements KeyListener{
    CurrentSlideView currentSlide;
    
    public EnterTextListener(CurrentSlideView currentSlide) {
        this.currentSlide = currentSlide;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        /*if(ke.getKeyChar() == KeyEvent.VK_ENTER){
            TextZone textZone = (TextZone)ke.getSource();
            JLabel nComp = new JLabel(textZone.getText());
            nComp.setSize(new Dimension(150,20));
            currentSlide.getSlide().getItems().add(nComp);
            JLabel nCompCopy = new JLabel(textZone.getText());
            nCompCopy.setSize(new Dimension(70,10));
            currentSlide.getSlide().getItemsCopy().add(nCompCopy);
            currentSlide.getApp().notifyObserver();
            System.out.println(currentSlide.getSlide().getItems().size());
            //System.out.println(textZone.getText());
        }*/
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
