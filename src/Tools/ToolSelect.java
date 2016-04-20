package Tools;

import Controleur.SelectCurrentPanelListener;
import Modele.MyShape;
import Modele.Presentation;
import Vue.MainFrame;
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
        for(MyShape current : this.mainFrame.getCurrentSlideView().getSlide().getShapesTab()) {
            JPanel panel = (JPanel)current;
            panel.addMouseListener(this);
            panel.addMouseMotionListener(this);
        }  
        this.mainFrame.getCurrentSlideView().addMouseListener(new SelectCurrentPanelListener(presentation));
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("yay");
        MyShape myShape = (MyShape)me.getSource();
        for(MyShape current : myShape.getSlide().getShapesTab()) {
            current.setSelected(false);
        }
        myShape.setSelected(true);
        myShape.getSlide().getShapesTab().remove(myShape);
        myShape.getSlide().getShapesTab().add(myShape);
        //myShape.getSlide().getPresentation().notifyObserver();
        this.xFirstClick = me.getX();
        this.yFirstClick = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        this.mainFrame.getPresentation().notifyObserver();
        this.mainFrame.getPresentation().notifyObserver();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.mainFrame.getPresentation().notifyObserver();
        this.mainFrame.getPresentation().notifyObserver();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //System.out.println("yay");
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
        else if(myShape.getType().equalsIgnoreCase("Line_D") || myShape.getType().equalsIgnoreCase("Line_M")){
            Line2D temp = (Line2D) myShape.getShapeForeground();
            shapeBackground = null;
            Double diffx =Math.abs(temp.getX1()-temp.getX2())/2;
            Double diffy =Math.abs(temp.getY1()-temp.getY2())/2;
            Double x2=x+diffx;
            Double y2=y+diffy;
            //descendant
            if(myShape.getType().equalsIgnoreCase("Line_M")){
                shapeForeground = new Line2D.Double(x2-diffx,y2+diffy,x2+diffx,y2-diffy);
            }
            //montant
            else{
                shapeForeground = new Line2D.Double(x2-diffx,y2-diffy,x2+diffx,y2+diffy);
            }
        }
        else {
            shapeBackground = null;
            shapeForeground = null;
        }
        myShape.setShapeBackground(shapeBackground);
        myShape.setShapeForeground(shapeForeground);
        myShape.setSelected(false);
        myShape.getSlide().getPresentation().notifyObserver();
        myShape.setSelected(true);
        myShape.getSlide().getPresentation().notifyObserver();
        myShape.getSlide().getPresentation().notifyObserver();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
}
