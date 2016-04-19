package Vue;

import Controleur.CurrentSlideListener;
import Modele.Presentation;
import Tools.ToolOval;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
    private MouseListener slideListener = null;
    private Presentation presentation;
    private MainFrame mainFrame;
    private Color mainColor = Color.BLACK;
    private Color borderColor = Color.BLACK;
    
    
    public Toolbar(Presentation presentation, MainFrame mainFrame){
        this.setRollover(true);
        this.presentation = presentation;
        this.mainFrame = mainFrame;

        JButton selectButton = new JButton("select");
        ActionListener selectButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              if(slideListener != null) {
                  mainFrame.getCurrentSlideView().removeMouseListener(slideListener);
                  slideListener = null;
              }
            }        
        };
        selectButton.addActionListener(selectButtonListener);
        this.add(selectButton);

        JButton textZoneButton = new JButton("text");
        ActionListener textZoneButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               slideListener = new CurrentSlideListener(presentation);
               mainFrame.getCurrentSlideView().addMouseListener(slideListener);
               System.out.println(mainFrame.getCurrentSlideView());
            }        
        };
        textZoneButton.addActionListener(textZoneButtonListener);
        this.add(textZoneButton);


        JButton mainColorButton = new JButton();
        mainColorButton.setBackground(Color.black);
        ActionListener mainColorButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               Color newColor = JColorChooser.showDialog(null, "Change background color",mainColorButton.getBackground());
               if(newColor != null){
                   mainColorButton.setBackground(newColor);
                   presentation.setTextColor(newColor);
                   mainColor = newColor;
               }
            }        
        };
        mainColorButton.addActionListener(mainColorButtonListener);
        this.add(mainColorButton);
        
        JButton borderColorButton = new JButton();
        borderColorButton.setBackground(Color.black);
        ActionListener borderColorButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               Color newColor = JColorChooser.showDialog(null, "Change background color",borderColorButton.getBackground());
               if(newColor != null){
                   borderColorButton.setBackground(newColor);
                   borderColor = newColor;
               }
            }        
        };
        borderColorButton.addActionListener(borderColorButtonListener);
        this.add(borderColorButton);
        
        ToolOval toolOval = new ToolOval(this.mainFrame);
        this.add(toolOval);
        
        String[] fonts = { "Arial", "Calibri", "Vladimir Script", "Times New Roman", "Sylfaen"};
        JComboBox fontsList = new JComboBox(fonts);
        ActionListener fontsListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                presentation.setFont(new Font((String)fontsList.getSelectedItem(), Font.PLAIN, presentation.getTextSize()));
            }        
        };
        fontsList.addActionListener(fontsListListener);
        
        String[] textSizes = { "15", "30", "42", "60", "72" };
        JComboBox sizeList = new JComboBox(textSizes);
        sizeList.setSelectedIndex(1);
        ActionListener sizeListListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int selectedSize = Integer.parseInt((String)sizeList.getSelectedItem());
                presentation.setTextSize(selectedSize);
                presentation.setFont(new Font((String)fontsList.getSelectedItem(), Font.PLAIN,selectedSize));
            }        
        };
        sizeList.addActionListener(sizeListListener);
        
        this.add(sizeList);
        this.add(fontsList);
    } 

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Color getMainColor() {
        return mainColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }
}
