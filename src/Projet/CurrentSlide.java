package Projet;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CurrentSlide extends JPanel{
    private Slide slide;
    
    public CurrentSlide(Slide slide) {
        this.slide = slide;
        this.setPreferredSize(new Dimension(1000,700));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
    }
}
