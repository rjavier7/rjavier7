
/**
 * Write a description of class f here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class SinglyLinkedList<E extends Comparable<E>>
{
    private ListNode<E> first;  // first element
    private ListNode<E> last;
    //private ListNode<E> tempFirst;
    //private ListNode<E> tempLast;
    //private ListNode<E> newNode;

    //private ListNode<E> foundnode;
    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public SinglyLinkedList()
    {
        first = null;
        //last = null;
    }

    /**
     *  Returns the first element in this list.
     *
     * @return  the first element in the linked list.
     */
    public E getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        else
            return first.getValue();
    }

    /**
     *  Returns the last element in this list.
     *
     * @return  the last element in the linked list.
     */
    public E getLast()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        else
            return last.getValue(); 
    }

    /**
     *  Inserts the given element at the beginning of this list.
     *
     * @param  value  the element to be inserted at the beginning of this list.
     */
    public void addFirst(E value)
    {
        // note the order that things happen:
        // head is parameter, then assigned

        first = new ListNode<E>(value, first);
        last = first;
    }

    public void addLast(E value)
    {
        if (first == null)
        {
            ListNode temp = new ListNode<E>(value, first); //new temp node pointing to first      
            first = temp;                                  //first reference set pointing to first                                                                  
            last = temp;                                   //last reference set pointing to last
        }
        else
        {
            ListNode temp = last;                        //temporary node set to current last node
            last = new ListNode<E>(value, null);         //new node created with null pointer
            temp.setNext(last);                          //current last node (temp) set to new last node
        }
    }

    public int size()
    {
        int numberOfNodes = 0;

        ListNode<E> temp = first;// start from the first node
        while (temp != null)
        {
            numberOfNodes++;
            temp = temp.getNext();// go to next node
        }

        return numberOfNodes;
    }

    /**
     *  Print the contents of the entire linked list
     */
    public void printList()
    {
        ListNode<E> temp = first;// start from the first node
        while (temp != null)
        {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();// go to next node
        }
    }

    /**
     *  Returns a string representation of this list. The string
     *  representation consists of the list's elements in order,
     *  enclosed in square brackets ("[]"). Adjacent elements are
     *  separated by the characters ", " (comma and space).
     *
     * @return    string representation of this list
     */
    public String toString()
    {
        String s = "[";

        ListNode<E> temp = first;  // start from the first node
        while (temp != null)
        {
            s += temp.getValue(); // append the data
            temp = temp.getNext();      // go to next node
            if (temp != null)
                s += ", ";
        }
        s += "]";
        return s;
    }

    public void insertFirstTwo(E element)
    {
        ListNode<E> temp;
        ListNode<E> newNode;
        if (first == null)
        {
            first = new ListNode<E> (element);
            last = first;
        }
        else
        {
            temp = first;

            if(element.compareTo(temp.getValue()) < 0)
            {
                newNode = new ListNode<E>(element);
                newNode.setNext(temp);
                first = newNode;
            }
            else
            {
                newNode = new ListNode<E>(element);
                temp.setNext(newNode);
                last = newNode;
            }    
        }
    }

    public void insert(E element)
    {
        Comparable<E> elemC = (Comparable<E>) element;

        ListNode<E> temp = first;
        ListNode<E> back = null;
        ListNode<E> newNode;

        if (size() < 2)
            insertFirstTwo(element);

        else if (element.compareTo(temp.getValue()) < 0)              //inserts element in the first position of the linked list
        {
            newNode = new ListNode<E>(element);
            newNode.setNext(temp);
            first = newNode;
        }
        else if (element.compareTo(getLast()) > 0)                    //inserts element in the last position of the linked list
        {
            newNode = new ListNode<E>(element);
            last.setNext(newNode);
            last = newNode;
        }
        else                                                          //inserts element between nodes in the linked list
        {
            while (temp.getNext() != null && element.compareTo(temp.getValue()) > 0)        //traverse through the link list, comparing element with each Item object (Id value)
            {
                back = temp;
                temp = temp.getNext();
            }

            newNode = new ListNode<E>(element);                                     
            back.setNext(newNode);
            newNode.setNext(temp);
        }
    }

    public E find (E element)
    {
        int count = 1;
        ListNode<E> temp = first;

        while (temp.getNext() != null && element.compareTo(temp.getValue()) != 0)       //traverse through the link list, comparing element with each Item object (Id value)
        {
            count++;
            //System.out.println("count = " + count);
            temp = temp.getNext();
        }

        if (count == size())        //traversed the entire length of the linked list
            return null;
        else                        //found the node containing the searched Id
            return temp.getValue();    
    }

    public E remove (E element)
    {
        int count = 1;
        ListNode<E> temp = first;
        ListNode<E> back = null;
        ListNode<E> front = null;

        while (temp.getNext() != null && element.compareTo(temp.getValue()) != 0)       //traverse through the link list, comparing element with each Item object (Id value)
        {
            count++;
            back = temp;
            //System.out.println("count = " + count);
            temp = temp.getNext();
            front = temp.getNext();
        }

        if (count == 1)                     //removes the node at the first position
        {
            first = temp.getNext();
            back = temp;
            back.setNext(null);

            return back.getValue();         // returns value of deleted node
        }
        else if (count == size())           //removes the node at the last position
        {
            //System.out.println("inside else if count = " + count); 
            //System.out.println("temp.getValue() = " + temp.getValue()); 
            last = back;
            last.setNext(null);

            return temp.getValue();
        }
        else                             //removes a node in between two nodes
        {
            temp.setNext(null);
            back.setNext(null);
            back.setNext(front);

            return temp.getValue();
        }
    }

    public void clear()
    {
        ListNode<E> temp = first;
        ListNode<E> back = null;

        while (temp != null)       //traverse through the link list (removed temp.getNext() for temp to reach final node in linked list)
        {
            back = temp;
            temp = temp.getNext();
            first = temp;
            back.setNext(null);
        }
    }
    
    public void printBackwards()
    {
        printBackwards(first);
    }
    
    private void printBackwards (ListNode<E> temp)
    {
        if (temp.getNext() != null)
            printBackwards(temp.getNext());             //recursion continues until last node
        
        System.out.println(temp.getValue());            //recursion unwinds and prints all nodes
    }
}
