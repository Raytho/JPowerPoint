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
    private Application app;
    
    public CurrentSlide(Slide slide) {
        this.slide = slide;
        this.setPreferredSize(new Dimension(950,600));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
        //app.notifyObserver();      
    }

    @Override
    public void update(Application app) {
        this.removeAll();
        for(Component current : this.slide.getItems()) { 
            JLabel jl = new JLabel();
            if (current instanceof JLabel){               
                
            }
            this.add(jl);
        }
        this.repaint();
    }
}
