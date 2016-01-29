package Projet;
import java.util.ArrayList;
import Observe.*;

public class MiniatureSlides implements Observable{
    private ArrayList<Slide> slides = new ArrayList<Slide>();
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    
    public MiniatureSlides() {
        this.slides.add(new Slide());
    }

    public ArrayList<Slide> getSlides() {
        return slides;
    }
    
    
    public void addSlide() {
        this.slides.add(new Slide());
        this.notifyObserver();
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
            obs.update();
        }
    }
    
}
