package Modele;
import Observe.*;
import Vue.CurrentSlideView;
import java.awt.Color;
import java.util.ArrayList;

public class Application implements Observable{
    private ArrayList<Slide> slides = new ArrayList<Slide>();
    private int slideNumber = 1;
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    private CurrentSlideView currentSlide;
    private Color textColor;
    private int textSize = 30;
    
    public Application() {
        this.slides.add(new Slide(0));  //par défaut on a un slide
    }
    
    public void addSlide() {
        this.slideNumber++;
        this.slides.add(new Slide(this.slideNumber-1));
        this.notifyObserver();
    }
    
    public void removeSlide(int id) {
        this.slideNumber--;
        this.slides.remove(id);
        for(int i=id;i<this.slideNumber;i++) {
            Slide current = this.slides.get(i);
            current.setId(i);
        }      
    }
    
    public void swapSlides(Slide s1, Slide s2) {
        int temp = s1.getId();
        s1.setId(s2.getId());
        s2.setId(temp);
        this.slides.sort(null);
    }
    
    public void swapSlides(int id1, int id2) {
        this.slides.get(id1).setId(id2);
        this.slides.get(id2).setId(id1);
        this.slides.sort(null);
    }

    public ArrayList<Slide> getSlides() {
        return slides;
    }
    
    public Slide getSlideById(int id) {
        for(Slide slide : this.getSlides()) {
            if(slide.getId() == id) {
                return slide;
            }
        }
        return null;
    }

    public int getSlideNumber() {
        return slideNumber;
    }

    public CurrentSlideView getCurrentSlide() {
        return currentSlide;
    }
    

    public void setCurrentSlide(CurrentSlideView currentSlide) {
        this.currentSlide = currentSlide;
    }
    

    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    @Override
    public void removeObserver() {
        this.listObserver = new ArrayList<Observer>();
    }

    @Override
    public void notifyObserver() {
        for(Observer obs : this.listObserver){
            obs.update(this);
        }
    }
    
    @Override
    public String toString() {
        String result = new String();
        for(Slide current : this.slides) {
            result += current.getId() + " ";
        }
        return result;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }
    
    
    
}
