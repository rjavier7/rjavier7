
/**
 * Write a description of class dd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DListNode
{
    private Object value;
    private DListNode next;
    private DListNode previous;

    // Constructor:
    public DListNode(Object initValue,
    DListNode initNext,
    DListNode initPrevious)
    // post: constructs new element with list
    //       prefix referenced by previous and
    //       suffix referenced by next
    {
        value = initValue;
        next = initNext;
        if (next != null)
            next.previous = this;
        previous = initPrevious;
        if (previous != null)
            previous.next = this;
    }

    public DListNode(Object initValue)

    // post: constructs a single element
    {
        this(initValue, null, null);
    }

    public Object getValue()
    // post: returns value stored here
    {
        return value;
    }

    public DListNode getNext()
    // post: returns the element that follows this
    {
        return next;
    }

    public DListNode getPrevious()
    // post: returns element that precedes this
    {
        return previous;
    }

    public void setValue(Object theNewValue)
    // post: sets a new value for this object
    {
        value = theNewValue;
    }

    public void setNext(DListNode theNewNext)
    // post: sets value associated with this element
    {
        next = theNewNext;
    }

    public void setPrevious(DListNode theNewPrevious)
    // post: establishes a new reference to a previous value
    {
        previous = theNewPrevious;
    }

    public String toString()
    // post: returns string representation of element
    {
        return "[ " + getValue() + "]";
    }
}
