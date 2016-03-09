package Projet;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Slide implements Comparable{
    private int id;
    private ArrayList<Component> itemsMiniSlide = new ArrayList<Component>(); //Différents trucs bidules dans le slide
    private ArrayList<Component> itemsCurrentSlide = new ArrayList<Component>();
    private boolean isHighlighted = false;
    
    public void addComponent(){
        double nb = Math.random();
        String nbS = String.valueOf(nb);
        JLabel nComp = new JLabel(nbS); //TODO : class (Cloneable) JLabel 
        nComp.setSize(new Dimension(33,4));
        Font newLabelFont=new Font(nComp.getFont().getName(),nComp.getFont().getStyle(),5);
        nComp.setFont(newLabelFont);
        JLabel nCompCopy = new JLabel(nbS);
        nCompCopy.setSize(new Dimension(150,20));
        this.itemsMiniSlide.add(nComp);
        this.itemsCurrentSlide.add(nCompCopy);
    }
    
    public void addComponent(Component comp) {
        this.itemsMiniSlide.add(comp);
        this.itemsCurrentSlide.add(comp);
    }
    
    public void addCurrentSlideComponent (Component comp) {
        this.itemsCurrentSlide.add(comp);
    }
    
    public Slide(int id) {
        this.id = id;
        addComponent();
    }

    public ArrayList<Component> getItemsMiniSlide() {
        return itemsMiniSlide;
    }
    
    public ArrayList<Component> getItemsCurrentSlide() {
        return itemsCurrentSlide;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setHighlight(boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
    }
    
    public boolean getHighlight(){
        return this.isHighlighted;
    }
    @Override
    public int compareTo(Object t) {
        Slide other = (Slide)t;
        int currentId = this.getId();
        int otherId = other.getId();
        if(currentId < otherId) {
            return -1;
        }
        else if(currentId > otherId) {
            return 1;
        }
        else {
            return 0;
        }
    }    
}
