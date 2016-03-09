package Projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;


public class PopUpMiniatures extends JPopupMenu{
    private JMenuItem deleteItem, duplicateItem;
    private Application app;
    private Slide slide;
    
    
    public PopUpMiniatures(Application app, Slide slide){
        this.app = app;
        this.slide = slide;
        deleteItem = new JMenuItem("Delete");
        ActionListener deleteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int id = slide.getId();
                if(app.getSlideNumber()-1 == 0) {
                    JOptionPane.showMessageDialog(null, "You can't delete the only slide", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    if(id == 0) {
                        app.removeSlide(id);
                        app.getCurrentSlide().setSlide(app.getSlideById(0));
                        app.getSlideById(0).setHighlight(true);
                    }
                    else {
                        app.removeSlide(id);
                        app.getCurrentSlide().setSlide(app.getSlideById(id-1));
                        app.getSlideById(id-1).setHighlight(true);
                    }
                    app.notifyObserver();
                }
            }          
        };
        deleteItem.addActionListener(deleteListener);
        add(deleteItem);
        
        duplicateItem = new JMenuItem("Duplicate");
        add(duplicateItem);
    }
}
