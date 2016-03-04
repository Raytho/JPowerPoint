package Projet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MiniSlide extends JPanel implements MouseListener{
    private Slide slide;
    private Application app;
    
    public MiniSlide(Slide slide, Application app) {
        this.slide = slide;
        this.setLayout(null);
        this.app = app;
        for(Component current : this.slide.getItemsMiniSlide()) {
            this.add(current);
        }
        this.setPreferredSize(new Dimension(194,120));
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
            for(Slide current : this.app.getSlides()){
                current.setHighlight(false);
            }
            this.slide.setHighlight(true);
            this.app.getCurrentSlide().setSlide(slide);
            this.app.notifyObserver();
        }else if(me.getButton() == MouseEvent.BUTTON3){
            PopUpMiniatures menu = new PopUpMiniatures();
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
