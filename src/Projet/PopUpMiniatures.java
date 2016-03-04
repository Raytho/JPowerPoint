package Projet;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class PopUpMiniatures extends JPopupMenu{
    JMenuItem deleteItem, duplicateItem;
    public PopUpMiniatures(){
        deleteItem = new JMenuItem("Delete");
        add(deleteItem);
        duplicateItem = new JMenuItem("Duplicate");
        add(duplicateItem);
    }
}
