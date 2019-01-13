
/**
 * ListNode Class represents a node inside of linked list.
 * 
 * @author Pavel Shulga 
 * @version 4/3/15
 */
public class ListNode
{
    private String _data;
    private ListNode _next;
    /**
    * Constructor for list node.
    * 
    * @param String _data
    * @param ListNode _next
    */
    public ListNode(){
        _data = null;
        _next = null;
    }
    /**
    * Returns the next list node.
    * 
    */
    public ListNode getNext(){
        return _next;
    }
    /**
    * Sets the next list node.
    * 
    * @param ListNode
    */
    public void setNext(ListNode node){
        _next=node;
    }
    /**
    * Returns the value inside the list node.
    * 
    */
    public String getValue(){
        return _data;
    }
    /**
    * Sets string inside the list node.
    * 
    * @param String
    */
    public void setValue(String str){
        _data=str;
    }
    
}
