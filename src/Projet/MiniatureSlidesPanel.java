package Projet;
import Observe.Observer;
import java.awt.Dimension;
import javax.swing.JPanel;

public class MiniatureSlidesPanel extends JPanel implements Observer{
    public MiniatureSlidesPanel() {
        setPreferredSize(new Dimension(200,300));
    }
    
    public void displayMiniaturesSlides() {
        
    }

    @Override
    public void update() {
        this.displayMiniaturesSlides();
    }
    
}
