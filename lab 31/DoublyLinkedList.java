
/**
 * Write a description of class r here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class DoublyLinkedList<E extends Comparable<E>>
{
    private DListNode first;  // first element/node
    private DListNode last;  // last element/node
    private DListNode temp;  // temp element/node
    private DListNode back;  // back  element
    private DListNode newnode;  // newnode  element
    private DListNode previous;  // previous  element
    private DListNode next;  // next  element


    /**
     *  Constructor for the DoublyLinkedList object
     *  Generates an empty list.
     */
    public DoublyLinkedList()
    {
        first = null;
        last=null;  
        previous=null;
        next=null;
    }

    /**
     *  Returns the first element in this list.
     *
     * @return  the first element in the linked list.
     */
    public Object getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        else
            return first.getValue();
    }

    /**
     *  Returns the LAST element in this list.
     *
     * @return  the last element in the linked list.
     */
    public Object getLast()
    {
        if (last == null)
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
     **/

    public void addFirst(E value)
    {

        first = new DListNode(value, null, null);
        last = first;
        next=first;
        previous=null;
    }

    public void addLast(E value) 

    {

        //if an empty list then
        // construct a new node and then set both 'first' and 'last' to    //reference the node
        if (first == null){

            first=new DListNode(value, first,null); 
            last=first;
            next=first;
            previous=null;
        }
        else
        /*   construct a new node and place at end of list by: (1) having the node that was previously at the
        end of the list now point to this one, and (2) having 'last' point to the new node*/
        {
            temp = last; // the current last node
            last = new DListNode(value,null,temp); //new last node with next of null and previous of old Last  
            temp.setNext(last); // the "next" of old last will be the new node
            // last.setPrevious(temp) - done already in new parameter temp - ;

        }
    }

    public void addTwo(E element)
    //adds first two nodes
    {

        //if an empty list then
        // construct the first new node and then set both 'first' and 'last' to    //reference the node
        System.out.println(" Inserting this value: " + element);
        if (first == null){
            first=new DListNode(element); // creates a node for first
            last=first; //only one node so set last to first also
            previous=first;
        }
        else
        /*   construct a new node and place at end(if bigger) or front(or smaller) of list by: */
        {
            temp = first;
            last = new DListNode(element,next,previous);   // create the second node
            E objTemp = (E) temp.getValue();
            if (element.compareTo(objTemp)>0) // if second is grater than first
            {
                first.setNext(last);  // larger -add after first and set reference to second
                last.setPrevious(first);
                //previous=first;
            }
            else
            {
                last.setNext(first); // smaller add before first and set reference to curent first
                first.setPrevious(last);
                first=last;  // last added is the new first
                last.setPrevious(null);
                last=first;
                //previous=last;
            }
        }

    } 
    // Method to insert (at the begining/middle/end of a sorted list.
    public void sortedInsert(E element)
    {

        temp=first;
        back=null;
        /* Special case for the head end */
        System.out.println(" Inserting this value: " + element);
        E objTemp = (E) temp.getValue();
        E objTempL = (E) getLast();

     
        if(element.compareTo(objTemp)<0) //new element smaller than the first
        {

            newnode = new DListNode(element);
            newnode.setNext(temp); //add to the beginnig of list
            newnode.setPrevious(null); //previous to first node is nothing hence null
            temp.setPrevious(newnode);  //
            first=newnode; // the new first is the newnode
            previous=null; 
        }
        else
        if(element.compareTo(objTempL)> 0){
            //add to end of list if bigger than last value in list

            temp=first;
            for(int i=1;i<=size();i++)
            {    
                back=temp; // will have the last node on exit
                temp=temp.getNext();
            }
            newnode = new DListNode(element);
            back.setNext(newnode); //new node is inserted next to back(max)
            newnode.setNext(temp); //temp is null here
            newnode.setPrevious(back); //new node is inserted after back so back is its previous node
            last=newnode; //add to the end of list
            previous=back; // previous to last is now in back

        }

        else {
            // new element belongs somwhere in the middle of the list

            newnode = new DListNode(element);
            temp=first; 
            back=null;
            objTemp = (E) temp.getValue();  //cast so types match

            while (temp.getNext()!=null && element.compareTo(objTemp)>0) //find the postion to insert
            {

                back=temp;

                temp=temp.getNext(); 
                objTemp = (E) temp.getValue();

            }
            newnode.setNext(temp); // newnode will now point to temp(front)
            newnode.setPrevious(back); //new node inserted between back and temp - hence previous is back
            back.setNext(newnode);   // back will now point to the new node
            temp.setPrevious(newnode); // new node is behind temp so set the previous of temp to newnode
            previous=back; //Set previous to back

        }   
    }

    public void insert(E element){
        /**
         *  Inserts the given element at the right place in the ordered(ascending)  list.
         **/    
        Comparable<E> elemC = (Comparable<E>) element;

        if (size()<2)
        // Adding the First two Nodes in sorted order//
        { 
            addTwo(element);
        }
        else    
        // insert elements at the right place in the list resulting a sorter list
            sortedInsert(element);
    }

   
    
    public E remove (E element) {
        //A remove method will remove unwanted data from the linked list.
        //It should return the removed data (or null if the data was not found). 
        //* initialize temp to head of list and back to null
        if (size()==0){ //empty list of size 0
            System.out.println("Empty list!! \n");
            temp=null;
            return null;
        }
        temp=first;
        back=null;

        E objTemp = (E) first.getValue(); //getFirst();
        E objTempL = (E) getLast();
        int count=1;
        if (element.compareTo(objTemp)== 0) // if the  item to be removed matches the first in list
        {
            temp = first;
            //first=null;
            first = temp.getNext();
            if (size()>1)
                first.setPrevious(null); 
            previous=null; //Set previous to null
            return objTemp;
        }
        else

        if (element.compareTo(objTempL)== 0)  // if item to be removed matches the last in list
        {

            temp=first;
            for(int i=1;i<=size()-1;i++)
            {    
                back=temp; // will have the last but one node on exit
                temp=temp.getNext(); //item to delete
            }

            back.setNext(null);
            last=back; //new last
            previous=back.getPrevious(); //new previous 

            return objTempL; //return item deleted

        }
        else{
            temp=first.getNext(); //start at two to search 
            back=first;
            objTemp = (E) temp.getValue();

            for(int i=2;i<=size();i++)
            {
                if (element.compareTo(objTemp)== 0) 
                {   //found item to delete

                    back.setNext(temp.getNext());
                    //temp.setNext(null); //item to be deleted so set links null
                    temp.setPrevious(null); //item to be deleted so set links null
                    temp=temp.getNext(); // node next to removed item
                    temp.setPrevious(back); //set its prev to back
                    previous=back;

                    return objTemp;
                }
                else
                {
                    back=temp;
                    temp=temp.getNext();  //found or null;
                    if(temp!=null)
                        objTemp = (E) temp.getValue();

                }
            }     

            System.out.println ("item not found !!" );
            return null;

        }

    }


  
    public void clear (){

        DListNode temp = first;// start from the first node
        DListNode delNode = first;// start from the first node
        while (temp != null)
        {

            temp = temp.getNext();// go to next node
            delNode=temp;
            if (delNode != null)
                delNode.setNext(null);  // set link to null to clear from list
        }
        first=null; //clear the first node finally
        last=null;  //clear the last node finally

    }

    /**
     *  Print the contents of the entire linked list
     */
    public void printListForward()
    {
        DListNode temp = first;// start from the first node

        if (size()==0){ //empty list of size 0
            System.out.println("Empty list!! \n");
            temp=null;
            return;
        }
        for(int i=1; i<=size()-1; i++)
        { //print each node value
            System.out.println (i + "     " + temp.getValue());
            if (temp != null)
                temp = temp.getNext();// go to next node
        }
        System.out.println (size() + "    "+ last.getValue() + " ");

    }

    public void printListBackwards (){
        temp=last; //first;
        if (size()==0){ //empty list of size 0
            System.out.println("Empty list!! \n");
            temp=null;
            return;
        }

        for(int I=1; I<=size()-1;I++)
        { //print each node value
            System.out.println (I+ "     "+ temp.getValue() + " ");
            if (temp.getPrevious()!=null)
                temp = temp.getPrevious();// go to next node
        }  
        System.out.println (size() + "    "+ first.getValue() + " ");

    }

    /**
     *  Print the size of the linked list
     */
    public int size()
    {
        int count=0; 
        DListNode temp = first;// start from the first node
        while (temp != null)
        {
            count++; // increment count of the nodes
            temp = temp.getNext();// go to next node
        }

        return count; // count has the size of the list
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

        DListNode temp = first;  // start from the first node
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
