
package Vue;

import Controleur.SlideListener;
import Modele.Application;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
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

        String[] textSizes = { "15", "30", "42", "60", "72" };
        JComboBox sizeList = new JComboBox(textSizes);
        ActionListener sizeListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int k = Integer.parseInt((String)sizeList.getSelectedItem());
                app.setTextSize(k);
            }        
        };
        sizeList.addActionListener(sizeListListener);
        this.add(sizeList);
        
        JButton swag4 = new JButton("k4");
        JButton swag5 = new JButton("k5");



        this.add(swag4);
        this.add(swag5);

    }
    
}
