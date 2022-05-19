
/**
 * Write a description of class d here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class SinglyLinkedList<E>
{
    private ListNode<E> first;  // first element
    private ListNode<E> last;
    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public SinglyLinkedList()
    {
        first = null;
        last = null;
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
        last = first;
        first = new ListNode<E>(value, first);
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
        System.out.println();
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
}