package Projet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.event.MouseInputAdapter;


public class DragListener implements MouseListener, MouseMotionListener{
    Resizable zr;
    int width, height, x, y, xtr, ytr, xtl, ytl, xbr, ybr, xbl, ybl;  //t = top, b=bot, r=right, l=left;
    public DragListener(Resizable zr) {
        this.zr = zr;
    }
    
    @Override
    public void mouseMoved(MouseEvent me){
        
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        JButton button = (JButton)me.getSource();
        if(button == zr.dragBotRight && (width+me.getX()>5 && height+me.getY()>5)){
            if(x+me.getX()<zr.currentSlideView.getWidth()){
                zr.setSize(width+me.getX(), height+me.getY());
                zr.textZone.setBounds(1,1, width+me.getX()-2, height+me.getY()-2);
                zr.dragTopRight.setLocation(xtr+me.getX(), ytr);
                zr.dragBotLeft.setLocation(xbl, ybl+me.getY());
            }
        }else if(button == zr.dragTopLeft && (width-me.getX() > 5 && height-me.getY() > 5)){
            if(x+me.getX()>0 || y+me.getY()>0){ //to prevent growing outside the slide
                zr.setSize(width-me.getX(), height-me.getY());
                zr.textZone.setBounds(1,1, width-me.getX()-2, height-me.getY()-2);
                zr.setLocation(x+me.getX(),y+me.getY());
                zr.dragTopRight.setLocation(xtr, ytr+me.getY());
                zr.dragBotLeft.setLocation(xbl+me.getX(), ybl);
            }
        }else if(button == zr.dragTopRight && (width+me.getX()>5 && height-me.getY()>5)){
            zr.setSize(width+me.getX(), height-me.getY());
            zr.textZone.setBounds(1,1, width+me.getX()-2, height-me.getY()-2);
            zr.setLocation(x,y+me.getY());
            zr.dragTopLeft.setLocation(xtl, ytl+me.getY());
            zr.dragBotRight.setLocation(xbr+me.getX(),ybr);
        }else if(button == zr.dragBotLeft && (width-me.getX()>5 & height+me.getY()>5)){
            zr.setSize(width-me.getX(), height+me.getY());
            zr.textZone.setBounds(1,1, width-me.getX()-2, height+me.getY()-2);
            zr.setLocation(x+me.getX(),y);
            zr.dragTopLeft.setLocation(xtl+me.getX(),ytl);
            zr.dragBotRight.setLocation(xbr, ybr+me.getY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        width = zr.getWidth();
        height = zr.getHeight();
        x = zr.getX();
        y = zr.getY();
        xtr = zr.dragTopRight.getX();
        ytr = zr.dragTopRight.getY();
        xtl = zr.dragTopLeft.getX();
        ytl = zr.dragTopLeft.getY(); 
        xbr = zr.dragBotRight.getX();
        ybr = zr.dragBotRight.getY();
        xbl = zr.dragBotLeft.getX();
        ybl = zr.dragBotLeft.getY();  
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        JButton button = (JButton)me.getSource();
        if(button == zr.dragBotRight){
            zr.dragBotRight.setLocation(zr.dragTopRight.getX(), zr.dragBotLeft.getY());
        }else if(button == zr.dragTopLeft){
            zr.dragTopLeft.setLocation(zr.dragBotLeft.getX(), zr.dragTopRight.getY());
        }else if(button == zr.dragTopRight){
            zr.dragTopRight.setLocation(zr.dragBotRight.getX(), zr.dragTopLeft.getY());
        }else if(button == zr.dragBotLeft){
            zr.dragBotLeft.setLocation(zr.dragTopLeft.getX(), zr.dragBotRight.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
