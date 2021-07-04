  
/**
 * ArrayStack creates a stack that stores integers in an array.
 * The array can push or pop an item at the tail of the array.
 *
 * @author JOSEPH MBOTE 
 * @
 * @version (a version number or a date)
 */
public class ArrayStack
{
    // instance variables
    private int[] dispenser;

    /**
     * Constructor for objects of class ArrayStack
     */
    public ArrayStack()
    {
        // initialise instance variables
        this.dispenser = new int[10];
    }
    /**
     * isEmpty() checks if the array has 0 items and 
     * returns true if the array is empty.
     *
     */
    public boolean isEmpty()
    {
        // Check if the first element in the array has a non-zero value
        if (this.dispenser[0] == 1)
        {
            // If yes, the array is still not empty
            return false;
        }
        // If the first element has a zero value, the array is empty
        return true;
    }
    /**
     * isFull() checks if the array has 10 items and 
     * returns true if the array is full.
     *
     */
    public boolean isFull()
    {
        // Check if the last element in the array has a zero value
        if (this.dispenser[9] == 0)
        {
            // If yes, the array is still not full
            return false;
        }
        // If the last element has a non-zero value, the array is full
        return true;
    }
    /**
     * push() checks if the array has space at the tail and 
     * adds an integer if the array is not full.
     *
     */
    public void push()
    {
        // If the array is not full, push an element at the back of the stack
        if(!this.isFull()){
            this.dispenser[this.getCount()] = 1;
        }else{
            System.err.print("Stack full.");
        }
    }
    /**
     * pop() checks if the array has more than 0 items and 
     * removes the last item in the array.
     *
     */
    public void pop()
    {
        // If the array is not empty, pop the element at the back of the stack
        if(!this.isEmpty()){
            this.dispenser[this.getCount()-1] = 0;
        }else{
            System.err.print("Stack empty.");
        }
    }
    public int getCount()
    {
        int count = 0;
        // Count the number of non-zero elements in the array
        for (int i=0; i<this.dispenser.length; i++)
        {
            if (this.dispenser[i] == 1)
            {
                count += 1;
            }
        }
        // Return the count of non zeros as the size of the stack
        return count;
    }
}
