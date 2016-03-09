/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;

/**
 *
 * @author ISEN
 */
public class ResizableListener implements MouseListener, MouseMotionListener{
    int x, y, xtr, ytr, xtl, ytl, xbr, ybr, xbl, ybl, xmouse, ymouse; 
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Resizable zr = (Resizable)me.getSource();
        zr.setBorder(BorderFactory.createTitledBorder(""));
        zr.repaint();
        System.out.println("zpfjeiorfj");    
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Resizable zr = (Resizable)me.getSource();
        x = zr.getX();
        y = zr.getY();
        xmouse = me.getXOnScreen();
        ymouse = me.getYOnScreen();
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
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
       Resizable zr = (Resizable)me.getSource();
       if(zr.getCursor().getType() == Cursor.MOVE_CURSOR){
           int movex = me.getXOnScreen() - xmouse;
           int movey = me.getYOnScreen() - ymouse;
           zr.setLocation(x+movex, y+movey);
           zr.dragTopLeft.setLocation(xtl+movex, ytl+movey);
           zr.dragTopRight.setLocation(xtr+movex, ytr+movey);
           zr.dragBotLeft.setLocation(xbl+movex, ybl+movey);
           zr.dragBotRight.setLocation(xbr+movex, ybr+movey);
       }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Resizable zr = (Resizable)me.getSource();
        if((me.getX() < 3) || (me.getX() > zr.getWidth()-3) || (me.getY() < 3) || (me.getY() > zr.getHeight()-3)){
            zr.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }else{
            zr.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
}
