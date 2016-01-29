package Projet;
import Observe.Observer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MiniatureSlidesPanel extends JPanel implements Observer{
    public MiniatureSlidesPanel() {
        setLayout(new GridLayout(5,5,5,5));
        setPreferredSize(new Dimension(200,300));
    }
    
    public void displayMiniaturesSlides(MiniatureSlides miniatureSlide) {
        int slidesNumber = miniatureSlide.getSlides().size();
        for(int i=0;i<=slidesNumber-1;i++) {
            JPanel miniSlide = new JPanel();
            miniSlide.setBorder(BorderFactory.createLineBorder(Color.black));
            add(miniSlide);
        }
    }

    @Override
    public void update() {
        //this.displayMiniaturesSlides();
    }
    
}
