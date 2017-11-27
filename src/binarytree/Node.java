/* Node class that store values and the neighbour Nodes
 */
package binarytree;

public class Node
{
    protected int id;
    protected double value;
    protected Node leftNode;
    protected Node rightNode;
    
    //Default Constructor
    public Node()
    {
        //Empty 
    }
    
    public Node(int inId, double inValue)
    {
        setId(inId);
        setValue(inValue);
    }
   
    // Setter
    public void setId(int inId)
    {
        id = inId;
    }
    
    public void setValue(double inValue)
    {
        value = inValue;
    }
    
    public void setLeftNode(Node inLeftNode)
    {
        leftNode = inLeftNode;
    }
    
    public void setRightNode(Node inRightNode)
    {
        rightNode = inRightNode;
    }
    
    // Getter
    public int getId()
    {
        return id;
    }
    
    public double getValue()
    {
        return value;
    }
    
    public Node getLeftNode()
    {
        return leftNode;
    }
    
    public Node getRightNode()
    {
        return rightNode;
    }
    
}
