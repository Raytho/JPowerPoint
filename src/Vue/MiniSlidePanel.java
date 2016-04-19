package Vue;
import Modele.Slide;
import Modele.Presentation;
import Modele.SlideItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MiniSlidePanel extends JPanel implements MouseListener{
    private Slide slide;
    private Presentation presentation;
    
    public MiniSlidePanel(Slide slide, Presentation presentation) {
        this.slide = slide;
        this.setLayout(null);
        this.presentation = presentation;
        for(Component current : this.slide.getItemsMiniSlide()) {
            this.add(current);
        }
        this.setPreferredSize(new Dimension(950*10/45,600*10/45)); //   /4.5 ratio
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
        addMouseListener(this);
    }

    public Slide getSlide(){
        return this.slide;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){
            for(Slide current : this.presentation.getSlides()){
                current.setHighlight(false);
            }
            this.slide.setHighlight(true);
            this.presentation.setCurrentSlideModel(slide);
            this.presentation.notifyObserver();
        }
        else if(me.getButton() == MouseEvent.BUTTON3){
            PopUpMiniatures menu = new PopUpMiniatures(this.presentation, this.slide);
            menu.show(this, me.getX(), me.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
}
