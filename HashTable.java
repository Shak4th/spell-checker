import java.util.*;
/**
 * HashTable class represents a hash table data structure. Using hash function to determine the index of the word, inside the array that holds the values.
 * Words with the same index linked via unsorted linked list.
 * 
 * @author Pavel Shulga
 * @version 4/3/15
 */
public class HashTable
{
    /**
    * Array size.
    * @param int M
    */
    final int M=307;
    /**
    * Constructor for linked list object array.
    * @param ListNode[] wordslist
    */
    ListNode [] wordslist=new ListNode[M];    
    /**
    * Constractor: insert word into hash table.
    * 
    * @param String newWord
    */
    public void hashTable(String newWord){
        ListNode newNode= new ListNode();
        newNode.setValue(newWord);
        insert(newNode, hashFunc(newWord));
    }
    /**
    * Returns the hash value.
    * 
    * @param String newWord
    */
    public int hashFunc(String newWord){
        
        int hash = 0;
        for (int i = 0; i < newWord.length(); i++) {
             
            int charCode=newWord.charAt(i)-96;
            hash = (hash * 27 + charCode)%M;
                            
        }
        return hash;
    }
    /**
    * Inserts words inside the array. Each index inside the array treated as linked list.
    * 
    * @param String newWord
    */
    private void insert(ListNode node, int key){

        if(wordslist[key]!=null){
            ListNode current= new ListNode();
            ListNode prev= new ListNode();
            prev = wordslist[key];
            current=prev.getNext();
            while(current!=null){
                prev=current;
                current=current.getNext();

            }
            prev.setNext(node);
            
        }
        else{
            wordslist[key]= node;
        }
    }
    /**
    * Search for a word inside the hash table.
    * 
    * @param String strsearch
    */
    public boolean search(String strsearch){
        
        ListNode tempNode= new ListNode();
        tempNode=wordslist[hashFunc(strsearch)];
        
        while (tempNode!=null){
            if ((tempNode.getValue()).equals(strsearch)){
                return true;
            }
            tempNode=tempNode.getNext();    
        }
        return false;
    }
}
