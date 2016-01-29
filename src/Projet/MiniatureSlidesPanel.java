package Projet;
import Observe.Observer;
import javax.swing.JPanel;

public class MiniatureSlidesPanel extends JPanel implements Observer{
    
    public void displayMiniaturesSlides() {
        
    }

    @Override
    public void update() {
        this.displayMiniaturesSlides();
    }
    
}
