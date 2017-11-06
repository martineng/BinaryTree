/*
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
                        break;
                    case 4: // Find Node
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
    // It will generate 15 nodes in random.
    protected void generateTree()
    {
        theTree = new Tree();
        
        for (int count = 0; count <= 15; count++)
        {
            theTree.insert(generateRandomInt(), generateRandomDouble());
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
}
