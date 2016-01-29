package Projet;
import Observe.Observer;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    MiniatureSlides miniatureSlides = new MiniatureSlides();
    MainSlidePanel mainSlidePanel = new MainSlidePanel();
    MiniatureSlidesPanel miniatureSlidesPanel = new MiniatureSlidesPanel();
    
    
    public MainFrame() {
        super("PowerPoint");
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,750);
        this.setVisible(true);
    }
    
    
}
