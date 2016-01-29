package Projet;
import Observe.Observer;
import javax.swing.JPanel;

public class MainSlidePanel extends JPanel implements Observer{
    
    public void displayMainSlide() {
       
    }

    @Override
    public void update() {
        this.displayMainSlide();
    }
    
}
