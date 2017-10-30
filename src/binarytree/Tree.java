/*
 */
package binarytree;

public class Tree
{
    private Node rootNode;
    
    public Tree()
    {
        rootNode = null;
    }
    
    public void setRootNode(Node inRootNode)
    {
        rootNode = inRootNode;
    }
    
    public Node getRootNode()
    {
        return rootNode;
    }
    
    /* Search specific node using ID */
    public Node search(int inId)
    {
        Node currentNode = getRootNode(); // From the root
        
        while (currentNode.getId() != inId) // While searching
        {
            if (inId < currentNode.getId()) // Go left
            {
                currentNode = currentNode.getLeftNode();
            }
            else // Go right
            {
                currentNode = currentNode.getRightNode();
            } // END IF
            
            if (currentNode == null) // Return null when Not Found
            {
                return null;
            } // END IF
        } // END WHILE
        
        return currentNode; // Node Found
    } // END searchNode()
    
    /* Insert New Node to the Tree */
    public void insert(int inId, double inValue)
    {
        Node newNode = new Node(inId, inValue);
        
        if (getRootNode() == null) // If it's Empty Tree
        {
            setRootNode(newNode);
        }
        else
        {
            Node currentNode = getRootNode(); // Starting from root
            Node parentNode = new Node();
            
            do // Loop until the End of Tree
            {
                parentNode = currentNode;
                
                if (inId < currentNode.getId()) // Go Left
                {
                    currentNode  = currentNode.getLeftNode();
                    
                    if (currentNode == null) // If at the End of Tree
                    {
                        parentNode.setLeftNode(newNode); // Insert on Left
                    }
                }
                else // Go Right 
                {
                    currentNode = currentNode.getRightNode();
                    
                    if (currentNode == null) // If at the End of Tree
                    {
                        parentNode.setRightNode(newNode); // Insert on Right
                    }
                }
               
            } while (currentNode != null); // END Do-While
        }
        
    } // END insert()
    
    /* Delete Node with specific key*/
    public boolean delete(int inId)
    {
        Node currentNode = getRootNode();
        Node parentNode = getRootNode();
        boolean isLeftNode =  false;
        
        while (currentNode.getId() != inId) // Search for the Node
        {
            parentNode = currentNode;
            
            if (inId < currentNode.getId()) // Go Left
            {
                isLeftNode = true;
                currentNode = currentNode.getLeftNode();
            }
            else // Go Right
            {
                isLeftNode = false;
                currentNode = currentNode.getRightNode();
            }
            
            if (currentNode == null) // If End of Tree
            {
                return false; // Node Not Found
            }
        } // END WHILE
        
        // If No Children, Destory it
        if (currentNode.getLeftNode() == null && 
            currentNode.getRightNode() == null)
        {
            if (currentNode == getRootNode()) // If Root
            {
                setRootNode(null); // Tree is now empty
            }
            else if (isLeftNode)
            {
                parentNode.setLeftNode(null); // Cut off relation with Parent
            }
            else
            {
                parentNode.setRightNode(null);
            }
        } // END IF No Children
        else if(currentNode.getRightNode() == null) // IF No Right Node
        {
            // Replace with the Left Subtree
            if (currentNode == getRootNode())
            {
                setRootNode(currentNode.getLeftNode());
                
            }
            else if (isLeftNode)
            {
                parentNode.setLeftNode(currentNode.getLeftNode());
            }
            else
            {
                parentNode.setRightNode(currentNode.getLeftNode());
            }
        } // END IF No Right Node
        else if (currentNode.getLeftNode() == null) // IF No Left Node
        {
            // Replace with the Right subtree
            if (currentNode == getRootNode())
            {
                setRootNode(currentNode.getRightNode());
            }
            else if (isLeftNode)
            {
                parentNode.setLeftNode(currentNode.getRightNode());
            }
            else
            {
                parentNode.setRightNode(currentNode.getRightNode());
            }
        } // END IF No Left Node
        else // IF Have Children Node
        {
            // Getting the next node to delete the currentNode
            Node nextNode = rearrange(currentNode);
            
            // Create relationship of currentNode's parentNode to nextNode
            if (currentNode == rootNode)
            {
                rootNode = nextNode;
            }
            else if (isLeftNode)
            {
                parentNode.setLeftNode(nextNode);
            }
            else
            {
                parentNode.setRightNode(nextNode);
            }
            
            // Create relationship for nextNode to currentNode's Left Node
            nextNode.setLeftNode(currentNode.getLeftNode());
        } // END IF Have Two Children Node
        
        return true; // Delete Successful
    } // END delete()
    
    /* This function will return the next highest value after the deletingNode 
       shift to the right, then the right node's left node*/
    protected Node rearrange(Node deletingNode)
    {
        Node nextNodeParent = deletingNode;
        Node nextNode = deletingNode;
        Node currentNode = deletingNode.getRightNode(); 
        
        while (currentNode != null) // While the Right Node has Left Node
        {
            nextNodeParent = nextNode;
            nextNode = currentNode;
            currentNode = currentNode.getLeftNode(); // To the Left Node
        }
        
        if (nextNode != deletingNode.getRightNode())
        {
            nextNodeParent.setLeftNode(nextNode.getRightNode());
            nextNode.setRightNode(deletingNode.getRightNode());
        }
        
        return nextNode;
    } // END rearrange()
    
    public void displayTree()
    {
        int blank = 32;
        boolean isRowEmpty = false;
        
        Stack theStack = new Stack();
        theStack.push(getRootNode());
        
        while (!isRowEmpty)
        {
            Stack tempStack = new Stack();
            isRowEmpty = true;
            
            for (int blankCount = 0; blankCount < blank; blankCount++)
            {
                System.out.print(' ');
                
                while (!theStack.isEmpty())
                {
                    Node tempNode = theStack.pop();
                    
                    if (tempNode!= null)
                    {
                        System.out.print(tempNode.getId());
                        tempStack.push(tempNode.getLeftNode());
                        tempStack.push(tempNode.getRightNode());
                        
                        if (tempNode.getLeftNode() == null &&
                            tempNode.getRightNode() == null)
                        {
                            isRowEmpty = false;
                        }
                    }
                    else
                    {
                        System.out.print("--");
                        tempStack.push(null);
                        tempStack.push(null);
                    }
                    
                    for (int nodeCount = 0; nodeCount < blank*2-2; nodeCount++)
                    {
                        System.out.print(' ');
                    }
                } // END WHILE (!theStack.isEmpty())          
            }
        }
        
    }
}
