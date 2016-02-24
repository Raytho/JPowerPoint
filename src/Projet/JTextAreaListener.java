/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    
    @Override
    public void mouseClicked(MouseEvent me) {
        TextZone tz = (TextZone)me.getSource();
        tz.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
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
