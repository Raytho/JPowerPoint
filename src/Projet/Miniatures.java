package Projet;
import Observe.Observer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Miniatures extends JPanel implements Observer{
    private Application app;
    private ArrayList<MiniSlide> miniSlides = new ArrayList<MiniSlide>();
    
    public Miniatures(Application app) {
        this.app = app;
        this.setPreferredSize(new Dimension(180,180));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new GridLayout(5,5,5,5));
        this.MiniSlidesInit();
        for(MiniSlide current : this.miniSlides) {
           this.add(current);
        }
        JButton add = new JButton("Add");
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                app.addSlide();
            }
        };
        add.addActionListener(buttonListener);
        this.add(add);
    }
    
    
    private void MiniSlidesInit() {
       for(Slide current : app.getSlides()) {
           this.miniSlides.add(new MiniSlide(current));
       }     
    }
    

    @Override
    public void update(Application app) {
        this.app = app;
        this.miniSlides.removeAll(miniSlides);    
        this.MiniSlidesInit();
        
        for(Component current : this.getComponents()) {
            this.remove(current);
        }
        for(MiniSlide current : this.miniSlides) {
           this.add(current);
        }
        JButton add = new JButton("Add");
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                app.addSlide();
            }
        };
        add.addActionListener(buttonListener);
        this.add(add);
        System.out.println(app);
        this.repaint();
        this.revalidate();
    }
}
