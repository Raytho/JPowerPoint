package Projet;
import Observe.Observer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class main{

    public static void main(String[] args) {
        Application app = new Application();
        
        MiniaturesView mini = new MiniaturesView(app);
        app.addObserver(mini);
        Toolbar tb = new Toolbar();
        Menu menu = new Menu();
        
        JFrame frame = new JFrame("PowerPoint");
        frame.setLayout(new BorderLayout(5,5));
        frame.setResizable(false);
        
        frame.setJMenuBar(menu);
        frame.add(tb, BorderLayout.NORTH);
        
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout(5,5));
        JScrollPane scroll = new JScrollPane(mini);
        scroll.setPreferredSize(new Dimension(230,500));
        leftPanel.add(scroll, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.WEST);
        
        CurrentSlideView currentSlide = new CurrentSlideView(app.getSlides().get(0), app);
        app.setCurrentSlide(currentSlide);
        app.addObserver(currentSlide);
        JPanel rightPanel = new JPanel();
        rightPanel.add(currentSlide);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.add(rightPanel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setVisible(true);
    }
    
}
