import java.io.*;
import java.util.*;
import java.util.Scanner;
/**
 * ReadFile class, executing words from .txt file
 * 
 * @author Pavel Shulga 
 * @version 4/3/15
 */
public class ReadFile {
    private static Scanner file;
    private String text;
    
    /**
    * Opens testext.txt - text file.
    * 
    * @param Scanner file 
    */
    public void openText(){
        
        try{
            file = new Scanner(new File("testext.txt"));
        }
        catch(Exception e){
            System.out.println("Could not find testext.txt");
        }
    }
    /**
    * Opens Dictionary.txt - list of words.
    * 
    * @param Scanner file 
    */
    public void openDictionary(){
        
        try{
            file = new Scanner(new File("Dictionary.txt"));
        }
        catch(Exception e){
            System.out.println("Could not find Dictionary.txt");
        }
    }
    /**
    * Read and prints words inside .txt file.
    * 
    */
    public void read(){
        while (file.hasNext()){
            text=file.next();
            System.out.print(text+" ");
        }
        
    }
    /**
    * an Override version of .hasNext() 
    * 
    */
    public boolean hasnextWord(){
        while (file.hasNext())
            return true;
        return false;
    }
    /**
    * Returns the next String word.
    *  
    */
    public String nextWord(){
        return file.next();
    }
    /**
    * Closes an open file.
    *  
    */
    public void closeFile(){
        
        file.close();
    }
}
