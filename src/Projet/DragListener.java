package Projet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.event.MouseInputAdapter;


public class DragListener implements MouseListener, MouseMotionListener{
    TextZone tz;
    int width, height, x, y, xtr, ytr, xtl, ytl, xbr, ybr, xbl, ybl;  //t = top, b=bot, r=right, l=left;
    public DragListener(TextZone tz) {
        this.tz = tz;
    }
    
    @Override
    public void mouseMoved(MouseEvent me){
        
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        JButton button = (JButton)me.getSource();
        if(button == tz.dragBotRight && (width+me.getX()>5 && height+me.getY()>5)){
            tz.setSize(width+me.getX(), height+me.getY());
            tz.dragTopRight.setLocation(xtr+me.getX(), ytr);
            tz.dragBotLeft.setLocation(xbl, ybl+me.getY());
        }else if(button == tz.dragTopLeft && (width-me.getX() > 5 && height-me.getY() > 5)){
            tz.setSize(width-me.getX(), height-me.getY());
            tz.setLocation(x+me.getX(),y+me.getY());
            tz.dragTopRight.setLocation(xtr, ytr+me.getY());
            tz.dragBotLeft.setLocation(xbl+me.getX(), ybl);
        }else if(button == tz.dragTopRight && (width+me.getX()>5 && height-me.getY()>5)){
            tz.setSize(width+me.getX(), height-me.getY());
            tz.setLocation(x,y+me.getY());
            tz.dragTopLeft.setLocation(xtl, ytl+me.getY());
            tz.dragBotRight.setLocation(xbr+me.getX(),ybr);
        }else if(button == tz.dragBotLeft && (width-me.getX()>5 & height+me.getY()>5)){
            tz.setSize(width-me.getX(), height+me.getY());
            tz.setLocation(x+me.getX(),y);
            tz.dragTopLeft.setLocation(xtl+me.getX(),ytl);
            tz.dragBotRight.setLocation(xbr, ybr+me.getY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        width = tz.getWidth();
        height = tz.getHeight();
        x = tz.getX();
        y = tz.getY();
        xtr = tz.dragTopRight.getX();
        ytr = tz.dragTopRight.getY();
        xtl = tz.dragTopLeft.getX();
        ytl = tz.dragTopLeft.getY(); 
        xbr = tz.dragBotRight.getX();
        ybr = tz.dragBotRight.getY();
        xbl = tz.dragBotLeft.getX();
        ybl = tz.dragBotLeft.getY();  
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        JButton button = (JButton)me.getSource();
        if(button == tz.dragBotRight){
            tz.dragBotRight.setLocation(tz.dragTopRight.getX(), tz.dragBotLeft.getY());
        }else if(button == tz.dragTopLeft){
            tz.dragTopLeft.setLocation(tz.dragBotLeft.getX(), tz.dragTopRight.getY());
        }else if(button == tz.dragTopRight){
            tz.dragTopRight.setLocation(tz.dragBotRight.getX(), tz.dragTopLeft.getY());
        }else if(button == tz.dragBotLeft){
            tz.dragBotLeft.setLocation(tz.dragTopLeft.getX(), tz.dragBotRight.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
