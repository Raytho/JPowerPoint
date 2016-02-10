package Projet;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MiniSlide extends JPanel{
    private Slide slide;
    
    public MiniSlide(Slide slide) {
        this.slide = slide;
        this.setPreferredSize(new Dimension(150,150));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
