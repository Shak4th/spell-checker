
/**
 * TreeNode class represents a node of Red Black Tree data structure.
 * 
 * @author Pavel Shulga
 * @version 4/3/15
 */
public class TreeNode
{
    /**
    * Color, 1 for BLACK, 0 for RED.
    * 
    * @param int _color
    */
    private int _color;
    /**
    * Left son, right son and parent of a node.
    * 
    * @param TreeNode _left
    * @param TreeNode _Right
    * @param TreeNode _Parent
    */
    private TreeNode _left, _right, _parent;
    /**
    * String word value.
    * 
    * @param String _data
    */
    private String _data;
    /**
    * Constructor for a tree node. Sets color-BLACK and word-NULL.
    * 
    */
    public TreeNode(){
        _data=null;
        _color=1;
    }
    /**
    * Constructor for a tree node.
    * 
    * @param String word
    * @param TreeNode leftson
    * @param TreeNode rightson
    * @param TreeNode parent
    */
    public TreeNode(String word, TreeNode leftson, TreeNode rightson, TreeNode parent){ 
        _data = word;
        _left = leftson;
        _right = rightson;
        _parent = parent;
        _color = 1;
    }
    /**
    * Sets left son of the node.
    * 
    * @param TreeNode node
    */
    public void setLeft(TreeNode node){
        _left=node;
    }
    /**
    * Returns the left son of the node.
    * 
    */
    public TreeNode getLeft(){
        return _left;
    }
        /**
    * Sets the right son of the node.
    * 
    * @param TreeNode node
    */
    public void setRight(TreeNode node){
        _right = node;
    }
    /**
    * Returns the right son of the node.
    * 
    */
    public TreeNode getRight(){
        return _right;
    }
    /**
    * Sets the parent node of the node.
    * 
    * @param TreeNode node
    */
    public void setParent(TreeNode node){
        _parent = node;
    }
    /**
    * Returns the parent node of the node.
    * 
    */
    public TreeNode getParent(){
        return _parent;
    }
        /**
    * Sets word inside the node.
    * 
    * @param String word
    */
    public void setValue(String word){
        _data = word;
    }
    /**
    * Returns the word stored in the node.
    * 
    */
    public String getValue(){
        return _data;
    }
    /**
    * Sets the color of the node.
    * 
    * @param int color
    */
    public void setColor(int color){
        _color = color;
    }
    /**
    * Returns the color of the node.
    * 
    */
    public int getColor(){
        return _color;
    }
}
