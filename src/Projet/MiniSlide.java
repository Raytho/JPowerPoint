package Projet;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MiniSlide extends JPanel{
    private Slide slide;
    
    public MiniSlide(Slide slide) {
        this.slide = slide;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
