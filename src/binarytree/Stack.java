/* This is the Stack structure used to when displaying tree
 */
package binarytree;

public class Stack
{
    Node[] stackArray;
    int top, maxSize;
    
    // Constructor
    public Stack()
    {
       maxSize = 50;
       stackArray = new Node[maxSize];
       top = -1;
    }
    
    public Stack(int inMaxSize)
    {
        maxSize = inMaxSize;
        stackArray = new Node[inMaxSize];
        top = -1; // Empty Stack
    }
    
       // Insert the object at the top
    public void push(Node inNode)
    {
        stackArray[++top] = inNode;
    }
    
    //Take item from the top
    public Node pop()
    {
        return stackArray[top--];
    }
    
    //Peek at the top stack
    public Node peek()
    {
        return stackArray[top];
    }
    
    // true if stack is empty
    public boolean isEmpty()
    {
        return (top == -1);
    }
    
    // true if stack is full
    public boolean isFull()
    {
        return (top == maxSize - 1);
    }
    
    public int getTop()
    {
        return top;
    }
    
}
