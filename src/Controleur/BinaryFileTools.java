package Controleur;

import Modele.Presentation;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryFileTools {
    public static void SavePresentation(String fileName, Presentation presentation){
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(presentation);
            oos.close();
            System.out.println("Save Success");
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void LoadPresentation() {
        
    }
}
