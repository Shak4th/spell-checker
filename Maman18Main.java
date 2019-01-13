import java.io.*;
import java.util.*;
import java.util.Scanner;
/**
 * Maman18Main class - Checks if the words inside txt file exist in the dictionary. Prints the suspect,as incorrect, words.
 * 
 * @author Pavel Shulga 
 * @version 4.3.15
 */
public class Maman18Main{
        

    /**
     * The main method checks if the words inside testext.txt file match with the words in the dictionary.
     * Prints the unfound words.
     */    
    public static void main(String[] args){

        ReadFile file= new ReadFile();
        HashTable dictionary = new HashTable();
        RedBlackTree wordfilter =new RedBlackTree();
             
        
        //creating Dictionary via hash table.
        file.openDictionary();
        while (file.hasnextWord()){
            String newWord=file.nextWord();
            dictionary.hashTable(newWord.toLowerCase());
        }
        file.closeFile();
        
        //creating Red Black Tree with text's words.
        file.openText();
        while (file.hasnextWord()){
            String text=file.nextWord();            
            wordfilter.insert(text.toLowerCase());

        }
        file.closeFile();
        

        TreeNode minNode= wordfilter.minimum(wordfilter.root);
        TreeNode maxNode = wordfilter.maximum(wordfilter.root);
        
        while((minNode.getValue()).compareTo(maxNode.getValue())<0){
         
            if (((minNode.getValue()).compareTo((wordfilter.successor(minNode)).getValue())==0)&&(wordfilter.successor(minNode)!=wordfilter.nullNode)){
                wordfilter.delete(minNode);
                minNode= wordfilter.minimum(wordfilter.root);
            }else{
                
                if (dictionary.search(minNode.getValue()))
                    wordfilter.delete(minNode);
                minNode=wordfilter.successor(minNode);
            }

        }
        System.out.println("The following words dont exist in the Dictionary and suspected as incorrect:");
        System.out.println();
        wordfilter.inOrder(wordfilter.root);// prints the suspected words

    }
}
