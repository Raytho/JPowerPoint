
package Vue;

import Controleur.SlideListener;
import Modele.Application;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
    MouseListener tzal = null;
    Application app;
    
    public Toolbar(Application app){
        this.setRollover(true);
        this.app = app;

        JButton selectButton = new JButton("select");
        ActionListener selectButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              if(tzal != null) {
                  app.getCurrentSlide().removeMouseListener(tzal);
                  tzal = null;
              }
            }        
        };
        selectButton.addActionListener(selectButtonListener);
        this.add(selectButton);

        JButton textZoneButton = new JButton("text");
        ActionListener textZoneButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               tzal = new SlideListener(app);
               app.getCurrentSlide().addMouseListener(tzal);
            }        
        };
        textZoneButton.addActionListener(textZoneButtonListener);
        this.add(textZoneButton);


        JButton textColorButton = new JButton("");
        textColorButton.setBackground(Color.black);
        ActionListener colorButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               Color newColor = JColorChooser.showDialog(null, "Change background color",textColorButton.getBackground());
               if(newColor != null){
                   textColorButton.setBackground(newColor);
                   app.setTextColor(newColor);
               }
            }        
        };
        textColorButton.addActionListener(colorButtonListener);
        this.add(textColorButton);
        
        String[] fonts = { "Arial", "Calibri", "Vladimir Script", "Times New Roman", "Sylfaen"};
        JComboBox fontsList = new JComboBox(fonts);
        ActionListener fontsListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                app.setFont(new Font((String)fontsList.getSelectedItem(), Font.PLAIN, app.getTextSize()));
            }        
        };
        fontsList.addActionListener(fontsListListener);
        
        String[] textSizes = { "15", "30", "42", "60", "72" };
        JComboBox sizeList = new JComboBox(textSizes);
        sizeList.setSelectedIndex(1);
        ActionListener sizeListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int k = Integer.parseInt((String)sizeList.getSelectedItem());
                app.setTextSize(k);
                app.setFont(new Font((String)fontsList.getSelectedItem(), Font.PLAIN,k));
            }        
        };
        sizeList.addActionListener(sizeListListener);
        
        this.add(sizeList);
        this.add(fontsList);
        
        JButton launch = new JButton("Launch presentation");
        ActionListener launcher = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame presentation = new JFrame();
                presentation.add(app.getCurrentSlide());
                presentation.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                presentation.setUndecorated(true);
                presentation.setVisible(true);
            }        
        };
        launch.addActionListener(launcher);
        this.add(launch);

    }
    
}
