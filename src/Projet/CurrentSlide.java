package Projet;
import Observe.Observer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CurrentSlide extends JPanel implements Observer{
    private Slide slide;
    //private Application app;
    
    public CurrentSlide(Slide slide) {
        this.slide = slide;
        this.setPreferredSize(new Dimension(950,600));
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
        this.addMouseListener(new SlideListener());
        for(Component current : this.slide.getItemsCopy()) { 
            this.add(current);
        }
        this.validate();
        this.repaint();
        //app.notifyObserver();      
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    public Slide getSlide() {
        return slide;
    }


    @Override
    public void update(Application app) {
        this.removeAll();
        for(Component current : this.slide.getItemsCopy()) { 
            this.add(current);
        }
        this.validate();
        this.repaint();
    }
}
