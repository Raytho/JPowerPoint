

package Vue;

import Controleur.BinaryFileTools;
import Modele.Presentation;
import Observe.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Menu extends JMenuBar{
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Insertion");
    private MainFrame mainFrame;
    
    
    public Menu(MainFrame mainFrame){  
        this.mainFrame = mainFrame;
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem newF = new JMenuItem("New", KeyEvent.VK_N);
        fileMenu.add(newF);
        
        JMenuItem openF = new JMenuItem("Open", KeyEvent.VK_O);
        ActionListener OpenListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser loadFile = new JFileChooser();
                int action = loadFile.showOpenDialog(null);
                if(action == loadFile.APPROVE_OPTION){
                    File file = loadFile.getSelectedFile();
                    Presentation presentationLoad = BinaryFileTools.LoadPresentation(file.toString());
                    //System.out.println(presentationLoad.getSlideById(0).getHighlight());
                    presentationLoad.setListObserver(new ArrayList<Observer>());
                    mainFrame.getContentPane().removeAll();
                    mainFrame.setPresentation(presentationLoad);
                    
                    mainFrame.newToolbar();
                    mainFrame.newMiniaturesView();
                    
                    mainFrame.newCurrentSlideView();
                    mainFrame.invalidate();
                    mainFrame.revalidate();
                    mainFrame.repaint();
                    presentationLoad.notifyObserver();
                    System.out.println(mainFrame.getPresentation().getSlideById(0).getItemsMiniSlide().size());
                }
            }
        };
        openF.addActionListener(OpenListener);
        fileMenu.add(openF);
        
        JMenuItem saveF = new JMenuItem("Save", KeyEvent.VK_S);
        ActionListener SaveListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JFileChooser saveFile = new JFileChooser();
                    saveFile.setSelectedFile(new File("newPresentation.ser"));
                    saveFile.showSaveDialog(saveFile);
                    BinaryFileTools.SavePresentation(saveFile.getSelectedFile().toString(), mainFrame.getPresentation());
                }
        };       
        saveF.addActionListener(SaveListener);
        fileMenu.add(saveF);
        
        this.add(fileMenu);
        
        
        editMenu.setMnemonic(KeyEvent.VK_I);
        JMenu rectI = new JMenu("Rectangle");
        
        editMenu.add(rectI);
        JMenu ellipseI = new JMenu("Ellipse");
        
        editMenu.add(ellipseI);
        
        this.add(editMenu);
    
}
}
