
/**
 * Write a description of class f here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListDemo
{
    SinglyLinkedList<Integer> myList;

    public ListDemo()
    {
        myList = new SinglyLinkedList<Integer>();
    }

    /**
     *  Creates a SinglyLinkedList of 5 Integer nodes
     */
    public void createList()
    {
        for (int k = 1; k <= 5; k++)
        {
            myList.addFirst(new Integer(k));
        }
    }

    /**
     *  Display the first element of the list
     */
    public void displayFirst()
    {
        System.out.println("First Element: " + myList.getFirst());
    }
    
    public void displayLast()
    {
        System.out.println("Last Element: " + myList.getLast());
    }
    
    public void displaySize()
    {
        System.out.println("Nodes: " + myList.size());    
    }
    
    /**
     *  Print the contents of myList
     */
    public void print()
    {
        myList.printList();
    }
   
    /**
     *  Demostrates the use of the SinglyLinkedList class.
     *  Creates and prints a list of 5 consecutive Integer ojects.
     *
     * @param  args  The command line arguments (not used)
     */
    public static void main(String[] args)
    {
        ListDemo sList = new ListDemo();

        sList.createList();
        sList.displayFirst();
        sList.displayLast();
        sList.print();
        sList.displaySize();
    }
}
