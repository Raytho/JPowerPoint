package Modele;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Slide implements Comparable, Serializable{
    private Presentation presentation;
    private int id;
    private ArrayList<Item> itemsMiniSlide = new ArrayList<Item>(); 
    private ArrayList<Item> itemsCurrentSlide = new ArrayList<Item>();
    //private ArrayList<MyShape> shapesTab = new ArrayList<MyShape>();
    private boolean isHighlighted = false;
    
    public Slide(int id, Presentation presentation) {
        this.id = id;
        this.presentation = presentation;
        //addComponent();
    }
    
    /*public void addComponent(){
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
    }*/
    
    public void addCurrentSlideComponent (Item item) {
        this.itemsCurrentSlide.add(item);
    }

    public ArrayList<Item> getItemsMiniSlide() {
        return itemsMiniSlide;
    }
    
    public ArrayList<Item> getItemsCurrentSlide() {
        return itemsCurrentSlide;
    }

    /*public ArrayList<MyShape> getShapesTab() {
        return shapesTab;
    }*/

    public int getId() {
        return id;
    }
    
    public ArrayList<MyShape> getShapesTab() {
        ArrayList<MyShape> shapesTab = new ArrayList<MyShape>();
        for(Item current : this.itemsCurrentSlide) {
            if(current instanceof MyShape) {
                MyShape myShape = (MyShape)current;
                shapesTab.add(myShape);
            }
        }
        return shapesTab;
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

    public Presentation getPresentation() {
        return presentation;
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
