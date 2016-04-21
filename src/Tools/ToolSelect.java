package Tools;

import Controleur.SelectCurrentPanelListener;
import Modele.MyShape;
import Modele.Presentation;
import Modele.Slide;
import Vue.MainFrame;
import Vue.MiniSlidePanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolSelect extends JButton implements ActionListener, MouseListener, MouseMotionListener{
    private MainFrame mainFrame;
    private Presentation presentation;
    private String status;
    
    static int xFirstClick;
    static int yFirstClick;
    
    public ToolSelect(MainFrame mainFrame, Presentation presentation) {
        super("select");
        this.mainFrame = mainFrame;
        this.presentation = presentation;
        String toolType = this.getClass().getName();
        this.status = toolType.substring(10, toolType.length());
        
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mainFrame.getStatusPanel().setStatus(status);
        this.mainFrame.getCurrentSlideView().removeListeners();
        this.mainFrame.getCurrentSlideView().getPresentation().notifyObserver();
        for(Slide slide : this.presentation.getSlides()) {
            for(MyShape current : slide.getShapesTab()) {
            JPanel panel = (JPanel)current;
            panel.addMouseListener(this);
            panel.addMouseMotionListener(this);
            } 
        } 
        this.mainFrame.getCurrentSlideView().addMouseListener(new SelectCurrentPanelListener(presentation));
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        MyShape myShape = (MyShape)me.getSource();
        for(MyShape current : myShape.getSlide().getShapesTab()) {
            current.setSelected(false);
        }
        myShape.setSelected(true);
        myShape.getSlide().getItemsCurrentSlide().remove(myShape);
        myShape.getSlide().getItemsCurrentSlide().add(myShape);
        this.mainFrame.getCurrentSlideView().repaint();
        this.mainFrame.getCurrentSlideView().revalidate();
        for(MiniSlidePanel current : this.mainFrame.getMiniaturesView().getMiniSlides()) {
            current.repaint();
            current.revalidate();
        }
        this.xFirstClick = me.getX();
        this.yFirstClick = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        MyShape myShape = (MyShape)me.getSource();
        this.mainFrame.getCurrentSlideView().repaint();
        this.mainFrame.getCurrentSlideView().revalidate();
        for(MiniSlidePanel current : this.mainFrame.getMiniaturesView().getMiniSlides()) {
            current.repaint();
            current.revalidate();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //this.mainFrame.getPresentation().notifyObserver();
        //this.mainFrame.getPresentation().notifyObserver();
        this.mainFrame.getCurrentSlideView().repaint();
        this.mainFrame.getCurrentSlideView().revalidate();
        for(MiniSlidePanel current : this.mainFrame.getMiniaturesView().getMiniSlides()) {
            current.repaint();
            current.revalidate();
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        MyShape myShape = (MyShape)me.getSource();
        int x = myShape.getxOrigin()-this.xFirstClick+me.getX();
        myShape.setxOrigin(x);
        int y = myShape.getyOrigin()-this.yFirstClick+me.getY();
        myShape.setyOrigin(y);
        
        Shape shapeBackground;
        Shape shapeForeground;
        if(myShape.getType().equals("Ellipse")) {
           shapeBackground = new Ellipse2D.Float(x,y,(int)myShape.getShapeBackground().getBounds2D().getWidth(),(int)myShape.getShapeBackground().getBounds2D().getHeight());
           shapeForeground = new Ellipse2D.Float(x+4,y+4,(int)myShape.getShapeBackground().getBounds2D().getWidth()-8,(int)myShape.getShapeBackground().getBounds2D().getHeight()-8);
        }
        else if(myShape.getType().equalsIgnoreCase("Rectangle")){
            shapeBackground = new Rectangle2D.Float(x,y,(int)myShape.getShapeBackground().getBounds2D().getWidth(),(int)myShape.getShapeBackground().getBounds2D().getHeight());
            shapeForeground = new Rectangle2D.Float(x+4,y+4,(int)myShape.getShapeBackground().getBounds2D().getWidth()-8,(int)myShape.getShapeBackground().getBounds2D().getHeight()-8);
        }
        else {
            shapeBackground = null;
            shapeForeground = null;
        }
        myShape.setShapeBackground(shapeBackground);
        myShape.setShapeForeground(shapeForeground);
        myShape.setSelected(false);
        //myShape.getSlide().getPresentation().notifyObserver();
        this.mainFrame.getCurrentSlideView().repaint();
        this.mainFrame.getCurrentSlideView().revalidate();
        for(MiniSlidePanel current : this.mainFrame.getMiniaturesView().getMiniSlides()) {
            current.repaint();
            current.revalidate();
        }
        myShape.setSelected(true);
        //myShape.getSlide().getPresentation().notifyObserver();
        //myShape.getSlide().getPresentation().notifyObserver();
        this.mainFrame.getCurrentSlideView().repaint();
        this.mainFrame.getCurrentSlideView().revalidate();
        for(MiniSlidePanel current : this.mainFrame.getMiniaturesView().getMiniSlides()) {
            current.repaint();
            current.revalidate();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
}
