package Vue;
import Modele.MyShape;
import Modele.Slide;
import Modele.Presentation;
import Modele.SlideItem;
import Observe.Observer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CurrentSlideView extends JPanel implements Observer{
    private Slide slide;
    private Presentation presentation;
    private MainFrame mainFrame;
    
    public CurrentSlideView(Slide slide, Presentation presentation, MainFrame mainFrame) {
        this.slide = slide;
        this.presentation = presentation;
        this.mainFrame = mainFrame;
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
    
    public void removeListeners() { //fonction qui permet de supprimer les listeners d'un JPanel
        for(MouseListener current : this.getMouseListeners()) { //supprime les mouseListeners du JPanel principal
            this.removeMouseListener(current);
        }
        for(MyShape current : this.slide.getShapesTab()) {    //supprime les MouseListeners des JPanel associés aux shapes
                JPanel panel = (JPanel)current;
                for(MouseListener ml : panel.getMouseListeners()) {
                    panel.removeMouseListener(ml);
                }
                for(MouseMotionListener mml : panel.getMouseMotionListeners()) {    //supprime les MouseMotionListeners des JPanel associés aux shapes
                    panel.removeMouseMotionListener(mml);
                }
                current.setSelected(false);
            }
    }
    
    public void paintComponent(Graphics g){ //dessine sur le JPanel principal
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        //ajout des panels de nos shapes au JPanel principal
        int i = this.slide.getShapesTab().size()-1;
        while(i!=-1) {  //on ajoute les JPanel dans le désordre car le 1er panel ajouté est celui pris en compte en cas de collision
            MyShape current = this.slide.getShapesTab().get(i);
            if(!current.getType().equals("Line_D") || !current.getType().equals("Line_M")) {    //on ajoute les lignes après les autres formes car les lignes sont petites (moins prioritaires)
                if(current.isSelected()) {  //si une forme est sélectionnée, on vérifie si elle a bougée
                    current.setLocation(new Point(current.getxOrigin(), current.getyOrigin()));
                    current.setBackground(new Color(0,0,0,0));
                }
                else {
                    this.remove(current);   //si elle n'est pas séléctionnée, on la supprime est la recrée
                    current.setBounds(current.getxOrigin(), current.getyOrigin(), (int)current.getShapeForeground().getBounds2D().getWidth(), (int)current.getShapeForeground().getBounds2D().getHeight());
                    this.add(current);
                }
            }
            i--;
        }
        
        i=this.slide.getShapesTab().size()-1;
        while(i!=-1) {  //on ajoute ici les panels de lignes (non prioritaires)
            MyShape current = this.slide.getShapesTab().get(i);
            if(current.getType().equals("Line_D") || current.getType().equals("Line_M")) {
                if(current.isSelected()) {
                    current.setLocation(new Point(current.getxOrigin(), current.getyOrigin()));
                    current.setBackground(new Color(0,0,0,0));
                }
                else {
                    current.setBounds(current.getxOrigin(), current.getyOrigin(), (int)current.getShapeForeground().getBounds2D().getWidth(), (int)current.getShapeForeground().getBounds2D().getHeight());
                    this.add(current);
                }
            }
            i--;
        }
        
        //ajout de nos shapes
        for(MyShape current : this.slide.getShapesTab()) { //on ajoute nos shapes au JPanel principal
            if(current.getShapeBackground() != null) {  //on met la couleur correspondant au contour 
                g2d.setPaint(current.getBackgroundColor());
                g2d.fill(current.getShapeBackground()); 
                g2d.draw(current.getShapeBackground());
            }
            
            if(current.isSelected()) {  //si la shape est sélectionnée, on change sa couleur en dark (l'intérieur)
                Color selectedColor = current.getForegroundColor();
                selectedColor = selectedColor.brighter();
                g2d.setPaint(current.getForegroundColor().darker());
            }
            else {
                g2d.setPaint(current.getForegroundColor());
            }
            g2d.fill(current.getShapeForeground());
            g2d.draw(current.getShapeForeground());
        }
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    


    @Override
    public void update(Presentation presentation) {
        this.slide = this.presentation.getCurrentSlideModel();
        for(Component current : this.slide.getItemsCurrentSlide()) { 
            this.remove(current);
            this.add(current);
        }
        this.revalidate();
        this.repaint();
    }
}
