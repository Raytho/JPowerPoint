package Vue;
import Modele.Slide;
import Modele.Presentation;
import Observe.Observer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MiniaturesView extends JPanel implements Observer{
    private Presentation presentation;
    private ArrayList<MiniSlidePanel> miniSlides = new ArrayList<MiniSlidePanel>();
    
    public MiniaturesView(Presentation presentation) {
        this.presentation = presentation;
        this.setPreferredSize(new Dimension(220,300));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.MiniSlidesInit();
        for(MiniSlidePanel current : this.miniSlides) {
           this.add(Box.createRigidArea(new Dimension(5,5)));
           current.getSlide().setHighlight(true);
           current.setBorder(BorderFactory.createLineBorder(Color.red, 2));
           this.add(current);
        }
        JButton add = new JButton("Add");
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                presentation.addSlide();
                System.out.println(presentation.getSlideById(0).getItemsMiniSlide().size());
            }
        };
        add.addActionListener(buttonListener);
        this.add(add);
    }
    
    
    private void MiniSlidesInit() {
       for(Slide current : presentation.getSlides()) {
           this.miniSlides.add(new MiniSlidePanel(current, presentation));
       }     
    }
    

    @Override
    public void update(Presentation presentation) {
        this.presentation = presentation;
        this.miniSlides.removeAll(miniSlides);    
        this.MiniSlidesInit();     
        this.removeAll();
        for(MiniSlidePanel current : this.miniSlides) {
           this.add(Box.createRigidArea(new Dimension(5,5)));
           this.add(current);
        }
        this.invalidate();
        JButton addButton = new JButton("Add");
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                presentation.addSlide();
                System.out.println(presentation.getSlideById(0).getItemsMiniSlide().size());
            }
        };
        int nbSlide = this.miniSlides.size();
        addButton.addActionListener(buttonListener);
        this.add(addButton);
        this.setPreferredSize(new Dimension(180,180*nbSlide));
        for(MiniSlidePanel current : this.miniSlides){
            if(current.getSlide().getHighlight() == true){
                current.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            }
            else {
                current.setBorder(BorderFactory.createLineBorder(Color.black));
            }
        }
        this.revalidate();
        this.repaint();
    }

    public ArrayList<MiniSlidePanel> getMiniSlides() {
        return miniSlides;
    }
    
    
}
