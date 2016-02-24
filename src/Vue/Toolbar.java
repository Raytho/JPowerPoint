package Vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Toolbar extends JMenuBar{
    JMenu File, Edit, Insert;
    JMenuItem Open, Close, Save, TextArea;
    public Toolbar(){
        File = new JMenu("File");
        Edit = new JMenu("Edit");
        Insert = new JMenu("Insert");
        Open = new JMenuItem("Open");
        Close = new JMenuItem("Close");
        Save = new JMenuItem("Save");
        TextArea = new JMenuItem("TextArea");
        File.add(Open);
        File.add(Close);
        File.add(Save);
        Insert.add(TextArea);
        this.add(File);
        this.add(Edit);
        this.add(Insert);
    }
}
