package Vue;
import Modele.Slide;
import Modele.Presentation;
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
    private Presentation presentation;
    
    public CurrentSlideView(Slide slide, Presentation presentation) {
        this.slide = slide;
        this.presentation = presentation;
        this.setPreferredSize(new Dimension(950,600));
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
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

    public Presentation getPresentation() {
        return presentation;
    }


    @Override
    public void update(Presentation presentation) {
        this.removeAll();
        for(Component current : this.slide.getItemsCurrentSlide()) { 
            this.add(current);
        }
        this.validate();
        this.repaint();
    }
}
