package Projet;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {
        Application app = new Application();
        CurrentSlide currentSlide = new CurrentSlide(app.getSlides().get(0));
        Miniatures mini = new Miniatures(app);
        app.addObserver(mini);
        
        
        JFrame frame = new JFrame("PowerPoint");
        frame.setLayout(new BorderLayout(5,5));
        frame.add(currentSlide, BorderLayout.CENTER);
        frame.add(mini, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
}
