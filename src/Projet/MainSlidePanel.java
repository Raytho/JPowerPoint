package Projet;
import Observe.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainSlidePanel extends JPanel implements Observer{
    public MainSlidePanel() {
        JLabel text = new JLabel("Main Slide");
        this.add(text);
    }
    
    public void displayMainSlide() {
       
    }

    @Override
    public void update() {
        this.displayMainSlide();
    }
    
}
