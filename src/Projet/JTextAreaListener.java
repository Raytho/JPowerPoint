package Projet;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author ISEN
 */
public class JTextAreaListener implements MouseListener, MouseMotionListener{
    int x, y, xtr, ytr, xtl, ytl, xbr, ybr, xbl, ybl, xmouse, ymouse; 
    
    @Override
    public void mouseClicked(MouseEvent me) {
        TextZone tz = (TextZone)me.getSource();
        tz.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        TextZone tz = (TextZone)me.getSource();
        x = tz.getX();
        y = tz.getY();
        xmouse = me.getXOnScreen();
        ymouse = me.getYOnScreen();
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
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
       TextZone tz = (TextZone)me.getSource();
       if(tz.getCursor().getType() == Cursor.MOVE_CURSOR){
           int movex = me.getXOnScreen() - xmouse;
           int movey = me.getYOnScreen() - ymouse;
           tz.setLocation(x+movex, y+movey);
           tz.dragTopLeft.setLocation(xtl+movex, ytl+movey);
           tz.dragTopRight.setLocation(xtr+movex, ytr+movey);
           tz.dragBotLeft.setLocation(xbl+movex, ybl+movey);
           tz.dragBotRight.setLocation(xbr+movex, ybr+movey);
       }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        TextZone tz = (TextZone)me.getSource();
        if((me.getX() < 3) || (me.getX() > tz.getWidth()-3) || (me.getY() < 3) || (me.getY() > tz.getHeight()-3)){
             tz.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }else{
             tz.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
}
