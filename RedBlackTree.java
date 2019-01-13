
/**
 * RedBlackTree class represent Red Black Tree data structure.
 * 
 * @author Pavel Shulga 
 * @version 4/3/15
 */
public class RedBlackTree
{
    /**
    * Tree Root.
    * 
    * @param  TreeNode root 
    */
    protected TreeNode root;
    /**
    * Tree Null node.
    * 
    * @param  TreeNode nullNode 
    */
    protected static TreeNode nullNode;
    /**
    * Value for RED color.
    * 
    * @param  int RED 
    */
    private final int RED=0;
    /**
    * Value for BLACK color.
    * 
    * @param  int BLACK 
    */
    private final int BLACK=1;

    
    /**
     * Constructor for objects of class RedBlackTree, creates root and null node.
     */
    public RedBlackTree()
    {
        root = new TreeNode(null, nullNode, nullNode, nullNode);
        nullNode = new TreeNode(null, nullNode, nullNode, nullNode);
    }
     /**
     * Returns true if the Tree is empty, false otherwise. 
     */
    public boolean isEmpty(){
        if (root==nullNode){
            return true;
        }
        return false;
    }
     /**
     * Inserts the word into the Tree. 
     * 
     * @param String word
     */
    public void insert(String word){
        TreeNode tempNull= new TreeNode(null, nullNode, nullNode, nullNode);
        TreeNode tempRoot= new TreeNode(null, nullNode, nullNode, nullNode);
        TreeNode newnode= new TreeNode(word, nullNode, nullNode, nullNode);
        
        tempNull=nullNode;
        tempRoot=root;
        while (tempRoot!=nullNode&&tempRoot.getValue()!=null){
            tempNull=tempRoot;
            if (tempRoot.getValue()!=null){
                if((newnode.getValue()).compareTo(tempRoot.getValue())<0)
                    tempRoot=tempRoot.getLeft();
                    else tempRoot=tempRoot.getRight();
            }
        }
        newnode.setParent(tempNull);
        if (tempNull==nullNode)
            root= newnode;
            else if ((newnode.getValue()).compareTo(tempNull.getValue())<0)
                        tempNull.setLeft(newnode);
                        else tempNull.setRight(newnode);
        newnode.setLeft(nullNode);
        newnode.setRight(nullNode);
        newnode.setColor(RED);
        insertFixup(newnode);
           
    }
     /**
     * Balancing the Tree by setting the right color in the right node. 
     * 
     * @param TreeNode newnode
     */
    private void insertFixup(TreeNode newnode){
        TreeNode tempNode = new TreeNode(null, nullNode, nullNode, nullNode);
        
        while ((newnode.getParent()).getColor()==RED){
            
            if (newnode.getParent() == ((newnode.getParent()).getParent()).getLeft()){
                tempNode = ((newnode.getParent()).getParent()).getRight();
                
                if (tempNode.getColor() == RED){
                    (newnode.getParent()).setColor(BLACK);
                    tempNode.setColor(BLACK);
                    ((newnode.getParent()).getParent()).setColor(RED);
                    newnode= (newnode.getParent()).getParent();
                }
                else {
                    if (newnode == (newnode.getParent()).getRight()){
                        newnode = newnode.getParent();
                        leftRotate(newnode);
                    }
                    (newnode.getParent()).setColor(BLACK);
                    ((newnode.getParent()).getParent()).setColor(RED);
                    rightRotate((newnode.getParent()).getParent());
                    
                }
            }else{
                tempNode = ((newnode.getParent()).getParent()).getLeft();
                
                if (tempNode.getColor() == RED){
                    (newnode.getParent()).setColor(BLACK);
                    tempNode.setColor(BLACK);
                    ((newnode.getParent()).getParent()).setColor(RED);
                    newnode= (newnode.getParent()).getParent();
                }
                else {
                    if (newnode == (newnode.getParent()).getLeft()){
                        newnode = newnode.getParent();
                        rightRotate(newnode);//maybr rotate othe side
                    }
                    (newnode.getParent()).setColor(BLACK);
                    ((newnode.getParent()).getParent()).setColor(RED);
                    leftRotate((newnode.getParent()).getParent());// here too
                    
                }
            
            }
                
        }
        root.setColor(BLACK);
    }
     /**
     * Delete the node from the Tree.
     * 
     * @param TreeNode node
     */
    public TreeNode delete(TreeNode node){
        
        TreeNode tempNode= new TreeNode();
        TreeNode tempNode2= new TreeNode();
        
        if (node.getLeft()==nullNode||node.getRight()==nullNode)
            tempNode= node;
        else tempNode = successor(node);
        if (tempNode.getLeft()!=nullNode)
            tempNode2= tempNode.getLeft();
        else tempNode2=tempNode.getRight();
        tempNode2.setParent(tempNode.getParent());
        if (tempNode.getParent()==nullNode)
            root=tempNode2;
        else{
                if (tempNode==(tempNode.getParent()).getLeft())
                    (tempNode.getParent()).setLeft(tempNode2);
                else (tempNode.getParent()).setRight(tempNode2);
        }
        if (tempNode!=node)
            node.setValue(tempNode.getValue());
        if (tempNode.getColor()==BLACK)
            deleteFixup(tempNode2);
        return tempNode;        
        
    }
     /**
     * Balancing the delete action on the Tree, setting links and colors.
     * 
     * @param TreeNode node
     */
    public void deleteFixup(TreeNode node){
        TreeNode tempNode= new TreeNode();
        TreeNode tempNode2= new TreeNode();
        
        while( node!=root&&node.getColor()==BLACK){
            if (node== (node.getParent()).getLeft()){
                tempNode=(node.getParent()).getRight();
                if (tempNode.getColor()==RED){
                    tempNode.setColor(BLACK);
                    (node.getParent()).setColor(RED);
                    leftRotate(node.getParent());
                    tempNode= (node.getParent()).getRight();
                }
                if ((tempNode.getLeft()).getColor()==BLACK&&(tempNode.getRight()).getColor()==BLACK){
                    tempNode.setColor(RED);
                    node= node.getParent();
                }else{
                    if((tempNode.getRight()).getColor()==BLACK){
                        (tempNode.getLeft()).setColor(BLACK);
                        tempNode.setColor(RED);
                        rightRotate(tempNode);
                        tempNode=(node.getParent()).getRight();
                    }
                    tempNode.setColor((node.getParent()).getColor());
                    (node.getParent()).setColor(BLACK);
                    (tempNode.getRight()).setColor(BLACK);
                    leftRotate(node.getParent());
                    node=root;
                }
                
                    
            }else{
                tempNode=(node.getParent()).getLeft();
                if (tempNode.getColor()==RED){
                    tempNode.setColor(BLACK);
                    (node.getParent()).setColor(RED);
                    rightRotate(node.getParent());
                    tempNode= (node.getParent()).getLeft();
                }
                if ((tempNode.getLeft()).getColor()==BLACK&&(tempNode.getRight()).getColor()==BLACK){
                    tempNode.setColor(RED);
                    node= node.getParent();
                }else{
                    if((tempNode.getLeft()).getColor()==BLACK){
                        (tempNode.getRight()).setColor(BLACK);
                        tempNode.setColor(RED);
                        leftRotate(tempNode);
                        tempNode=(node.getParent()).getLeft();
                    }
                    tempNode.setColor((node.getParent()).getColor());
                    (node.getParent()).setColor(BLACK);
                    (tempNode.getLeft()).setColor(BLACK);
                    rightRotate(node.getParent());
                    node=root;
                }
            }
        }
        node.setColor(BLACK);
    }
     /**
     * Returns the minimum node of the Tree.
     * 
     * @param TreeNode node
     */
    public TreeNode minimum(TreeNode node){
        while (node.getLeft()!=nullNode){
            node=node.getLeft();
        }
        return node;
    }
     /**
     * Returns the maximum node of the Tree.
     * 
     * @param TreeNode node
     */
    public TreeNode maximum(TreeNode node){
        while (node.getRight()!=nullNode){
            node=node.getRight();
        }
        return node;
    }
     /**
     * Returns the successor node of the node.
     * 
     * @param TreeNode node
     */
    public TreeNode successor(TreeNode node){
        if (node.getRight()!=nullNode)
            return minimum(node.getRight());
        TreeNode tempNode = node.getParent();
        while (tempNode!=nullNode&&node==tempNode.getRight()){
            node= tempNode;
            tempNode=tempNode.getParent();
        }
        return tempNode;
        
    }
     /**
     * Preform left rotation on the node.
     * 
     * @param TreeNode node
     */
    private void leftRotate(TreeNode node){
        TreeNode tempNode= new TreeNode(null, nullNode, nullNode, nullNode);
        tempNode = node.getRight();// the right tree of node
        node.setRight(tempNode.getLeft()); // left son of tempnode is right son of node
        if(tempNode.getLeft()!=nullNode)
            (tempNode.getLeft()).setParent(node);
        tempNode.setParent(node.getParent());
        if (node.getParent()==nullNode){
            root=tempNode;
        }
        else if (node==(node.getParent()).getLeft())
            (node.getParent()).setLeft(tempNode);
            else (node.getParent()).setRight(tempNode);
        tempNode.setLeft(node);
        node.setParent(tempNode);         
    }
     /**
     * Preform right rotation on the node.
     * 
     * @param TreeNode node
     */
    private void rightRotate(TreeNode node){
        TreeNode tempNode= new TreeNode(null, nullNode, nullNode, nullNode);
        tempNode = node.getLeft();
        node.setLeft(tempNode.getRight()); 
        if(tempNode.getRight()!=nullNode)
            (tempNode.getRight()).setParent(node);
        tempNode.setParent(node.getParent());
        if (node.getParent()==nullNode){
            root=tempNode;
        }
        else if (node==(node.getParent()).getRight())
            (node.getParent()).setRight(tempNode);
            else (node.getParent()).setLeft(tempNode);
        tempNode.setRight(node);
        node.setParent(tempNode);         
    }
     /**
     * Prints the values of the tree in a sorted order/
     * 
     * @param TreeNode node
     */
    public void inOrder(TreeNode node){
        if (node!=nullNode){
            inOrder(node.getLeft());
                System.out.println(node.getValue());
            inOrder(node.getRight());
        }
        
    }

}
