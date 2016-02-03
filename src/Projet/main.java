package Projet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class main {

    public static void main(String[] args) {
        Application app = new Application();
        
        Miniatures mini = new Miniatures(app);
        app.addObserver(mini);
        
        
        JFrame frame = new JFrame("PowerPoint");
        frame.setLayout(new BorderLayout(5,5));
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout(5,5));
        JScrollPane scroll = new JScrollPane(mini);
        scroll.setPreferredSize(new Dimension(200,200));
        leftPanel.add(scroll, BorderLayout.CENTER);
        leftPanel.add(mini, BorderLayout.CENTER);
        frame.add(leftPanel, BorderLayout.WEST);
        
        CurrentSlide currentSlide = new CurrentSlide(app.getSlides().get(0));
        JPanel rightPanel = new JPanel();
        rightPanel.add(currentSlide);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.add(rightPanel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
}
