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

public class CurrentSlideView extends JPanel implements Observer{
    private Slide slide;
    private Application app;
    
    public CurrentSlideView(Slide slide, Application app) {
        this.slide = slide;
        this.app = app;
        this.setPreferredSize(new Dimension(950,600));
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
        //this.addMouseListener(new SlideListener(this.app));
        for(Component current : this.slide.getItemsCurrentSlide()) { 
            this.add(current);
        }
        this.validate();
        this.repaint();     
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    public Slide getSlide() {
        return slide;
    }

    public Application getApp() {
        return app;
    }


    @Override
    public void update(Application app) {
        this.removeAll();
        for(Component current : this.slide.getItemsCurrentSlide()) { 
            this.add(current);
        }
        this.validate();
        this.repaint();
    }
}
