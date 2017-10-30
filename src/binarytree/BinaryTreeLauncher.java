/*
 */
package binarytree;

import java.util.Scanner;
import java.util.Random;

public class BinaryTreeLauncher
{
    Scanner inputScanner = new Scanner(System.in);
    Tree theTree = new Tree();
    
    public BinaryTreeLauncher()
    {
        // Empty
    }
    
    public void run()
    {
        int menuInput = 0;
        
        try
        {
            do
            {
                menu();
                menuInput = inputScanner.nextInt();
                
                switch(menuInput)
                {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 0:
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
    }
    
    
    protected int generateRandomInt()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(98);
        
        return randomNum + 101;
    } // END generateRandomInt()
    
    protected double generateRandomDouble()
    {
        Random rand = new Random();
        int randomInt = rand.nextInt(98) + 1;
        double randomDouble = rand.nextDouble();
        
        return (randomInt + randomDouble);
    } // END generateRandomDouble()
    
    protected void onStart()
    {
        for (int count = 0;count <= 15; count++)
        {
            theTree.insert(generateRandomInt(), generateRandomDouble());
        } // END for
    } // END onStart()
}
