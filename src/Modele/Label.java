package Modele;

import javax.swing.JLabel;

public class Label extends Item{
    private JLabel myLabel;
    
    public Label(String text) {
        this.myLabel = new JLabel(text);
        this.add(this.myLabel);
    }

    public String getText() {
        return this.myLabel.getText();
    }

    public void setText(String text) {
        this.myLabel.setText(text);
    }

    public JLabel getMyLabel() {
        return myLabel;
    }
}
