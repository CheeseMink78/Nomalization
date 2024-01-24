
package controller_view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Normalization;

public class StringController extends Menu {

    private Normalization str;
    public StringController() {
        super("Normalization string", new String[] {"Print text", "Normalize text", "Save to file", "Exit"});
        str = new Normalization();
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                printText();
                break;
            case 2:
                normalizeText();
                break;
            case 3:
            {
                try {
                    saveText();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
                break;

            case 4:
                exitMenu();

        }
    }
    
    public void printText() {
        System.out.println(str.getInput());
    }
    
    public void normalizeText() {
        System.out.println("Normalize text successfully");
        str.normalizeInput();
    }
    
    public void saveText() throws IOException {
        System.out.println("Save file text successfully");
        str.saveFile("string.txt");
    }
    
    
}
