/* The Launcher that does all the logical thinking
 */
package binarytree;

import java.util.Scanner;
import java.util.Random;

public class BinaryTreeLauncher
{
    // Declaring component
    Scanner inputScanner = new Scanner(System.in);
    Tree theTree = new Tree();
    
    public BinaryTreeLauncher()
    {
        // Empty
    }
    
    // This function will run the entire program
    public int run()
    {
        int menuInput = 0; // user input on menu selection
        
        generateTree();
        
        try
        {
            do
            {
                theTree.displayTree();
                System.out.println("==============================================");
                
                menu();
                System.out.println("Please enter the index number: ");
                menuInput = inputScanner.nextInt();
                
                switch(menuInput)
                {
                    case 1: // Regenerate new Tree
                        generateTree();
                        break;
                    case 2: // Inserting New Node
                        insertNode();
                        break;
                    case 3: // Deleting Node
                        deleteNode();
                        break;
                    case 4: // Find Node
                        findNode();
                        break;
                    case 0: // Exit the loop
                        break;
                    default:
                        break;
                    
                } // END switch
            } while(menuInput != 0);
        } // END try
        catch (Exception exception)
        {
            System.err.println(exception.getMessage());
        } // END catch
        
        return menuInput;
    }
    
    protected void menu()
    {
        System.out.println("           Welcome to BinaryTree!");
        System.out.println("==============================================");
        System.out.println("Please enter index number for actions:");
        System.out.println("(1) - Regenerate Tree");
        System.out.println("(2) - Insert Node");
        System.out.println("(3) - Delete Node");
        System.out.println("(4) - Find Node");
        System.out.println("(0) - Exit");
    } // END menu()
    
    // Simple function to return a random integer between 101 ~ 199
    protected int generateRandomInt()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(98);
        
        return randomNum + 101;
    } // END generateRandomInt()
    
    // Simple function   to return a random double betwween
    protected double generateRandomDouble()
    {
        Random rand = new Random();
        int randomInt = rand.nextInt(98) + 1;
        double randomDouble = rand.nextDouble();
        
        return (randomInt + randomDouble);
    } // END generateRandomDouble()
    
    // This function will be called when the program first launch
    // It will generate 7 nodes in random.
    protected void generateTree()
    {
        int randomInt = 0, previousInt = 0;
        double randomDouble = 0.0;
        int rightCount = 0, leftCount = 0; // Keep track of right left branches
        
        theTree = new Tree(); // Reset tree when fucntion is called
        
        // To generate 7 random Nodes
        for (int count = 0; count <= 7; count++)
        {
            randomInt = generateRandomInt();
            randomDouble = generateRandomDouble();
            
            // Verifying Node Id
            // Avoid similar number to be generated
            // Avoid Right Left branch exceeded 15 Nodes
            if (theTree.getRootNode() != null)
            {
                // If generate similar number as Root Node
                if (randomInt == theTree.getRootNode().getId())
                {
                    do
                    {
                        randomInt = generateRandomInt();
                    } while(randomInt == theTree.getRootNode().getId());
                }
                
                // If generated similiar number twices
                if (randomInt == previousInt)
                {
                    do
                    {
                        randomInt = generateRandomInt();
                    } while(randomInt == previousInt);
                }
                
                // If right branches exceeded 15 nodes in total, vice verse
                if (rightCount == 15 && randomInt < theTree.getRootNode().getId())
                {
                    do
                    {
                        randomInt = generateRandomInt();
                    } while(randomInt < theTree.getRootNode().getId());
                } // END IF
                else if (leftCount == 15 && randomInt > theTree.getRootNode().getId())
                {
                    do
                    {
                        randomInt = generateRandomInt();
                    } while (randomInt > theTree.getRootNode().getId());
                }
                
                // Keep track of number nodes in right left branches
                if (randomInt < theTree.getRootNode().getId())
                {
                    rightCount += 1;
                }
                else if(randomInt > theTree.getRootNode().getId())
                {
                    leftCount += 1;
                }
            }
            
            previousInt = randomInt; // Keep record of previoud generated Int
            theTree.insert(randomInt, randomDouble); // Insert into tree
        } // END for
    } // END regenerateTree()
    
    protected void insertNode()
    {
        int nodeId = 0;
        double nodeValue = 0.0;
        
        System.out.println("Please enter the Node ID (integer)");
        nodeId = inputScanner.nextInt();
        
        System.out.println("Please enter the Node value (double)");
        nodeValue = inputScanner.nextDouble();
        
        theTree.insert(nodeId, nodeValue);
    } // END insertNode()
    
    protected void findNode()
    {
        int nodeIdToFind =0;
        Node resultNode = new Node();
        
        System.out.println("Please enter the Node Id (integer) to find");
        nodeIdToFind = inputScanner.nextInt();
        
        // Do search
        resultNode = theTree.search(nodeIdToFind);
        
        System.out.println("\n=============Search Result=============");
        
        // If no result
        if (resultNode == null)
        {
            System.out.println("No Node found!");
        }
        else // Display information
        {
            System.out.println("Node ID [" + nodeIdToFind + "] found!");
            System.out.println("It contains value: " + resultNode.getValue());
            
            // If no Left Node
            if (resultNode.getLeftNode()== null)
            {
                System.out.println("It doesn't has a Left Node!");
            }
            else
            {
                System.out.print("It has a Left Node with ID: " + resultNode.leftNode.getId() + ", ");
                System.out.println("Values: " + resultNode.leftNode.getValue());
            }
            
            // If no Right Node
            if (resultNode.getRightNode() == null)
            {
                System.out.println("It doesn't has a Right Node!");
            }
            else
            {
                System.out.print("It has a Right Node with ID: " + resultNode.rightNode.getId() + ", ");
                System.out.println("Values: " + resultNode.rightNode.getValue());
            }
        } // END IF
        
        System.out.println("===========End Search Result===========\n");
    } // END findNode()
    
    protected void deleteNode()
    {
        int nodeIdToDelete = 0;
        
        System.out.println("Please enter the Node Id you wish to be deleted");
        nodeIdToDelete = inputScanner.nextInt();
        
        System.out.println("\n=============Delete Result=============");
        
        if (theTree.delete(nodeIdToDelete))
        {
            System.out.println("Node [" + nodeIdToDelete + "] deleted!");
        }
        else
        {
            System.out.println("Delete Failed! No Node [" + nodeIdToDelete + "] found!");
        }
        
        System.out.println("===========End Delete Result===========\n");
    }
}
