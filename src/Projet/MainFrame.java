package Projet;
import Observe.Observer;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    MiniatureSlides miniatureSlides = new MiniatureSlides();
    JPanel mainSlidePanel = new MainSlidePanel();
    JPanel miniatureSlidesPanel = new MiniatureSlidesPanel();
    
    
    public MainFrame() {
        super("PowerPoint");
        this.setLayout(new BorderLayout(5, 5));
        this.miniatureSlides = new MiniatureSlides();
        this.mainSlidePanel = new MainSlidePanel();
        this.mainSlidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.miniatureSlidesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(this.mainSlidePanel, BorderLayout.CENTER);
        this.add(this.miniatureSlidesPanel, BorderLayout.WEST);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,750);
        this.setVisible(true);
    }
    
    
}
