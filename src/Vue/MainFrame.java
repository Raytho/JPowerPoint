package Vue;

import Modele.Presentation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{
    private Presentation presentation;
    private MiniaturesView miniaturesView;
    private CurrentSlideView currentSlideView;

    public MainFrame (Presentation presentation){
        super ("PowerPoint");
        this.presentation = presentation;
        this.setLayout(new BorderLayout(5,5));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        Toolbar toolbar = new Toolbar(presentation, this);
        this.add(toolbar, BorderLayout.NORTH);
        
        Menu menu = new Menu();
        this.setJMenuBar(menu);
        
        this.newMiniaturesView();
        this.newCurrentSlideView();
          
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 700);
        this.setVisible(true);
    }
    
    private void newMiniaturesView() {
        MiniaturesView miniaturesView = new MiniaturesView(this.presentation);
        this.presentation.addObserver(miniaturesView);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout(5,5));
        JScrollPane scroll = new JScrollPane(miniaturesView);
        scroll.setPreferredSize(new Dimension(230,600));
        leftPanel.add(scroll, BorderLayout.NORTH);
        this.miniaturesView = miniaturesView;
        this.add(leftPanel, BorderLayout.WEST);
    }
    
    private void newCurrentSlideView() {
        CurrentSlideView currentSlideView = new CurrentSlideView(this.presentation.getSlides().get(0), this.presentation);
        this.presentation.setCurrentSlideModel(currentSlideView.getSlide());
        this.presentation.addObserver(currentSlideView);
        JPanel rightPanel = new JPanel();
        rightPanel.add(currentSlideView);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.currentSlideView = currentSlideView;
        this.add(rightPanel, BorderLayout.CENTER);
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public MiniaturesView getMiniaturesView() {
        return miniaturesView;
    }

    public CurrentSlideView getCurrentSlideView() {
        return currentSlideView;
    }
}
