// Name         : Josh Heyer
// Class        : CSCI 1620-301
// Program #    : 5
// Due Date     : 7/5/2016
//
// Honor Pledge : On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// Name         : Josh Heyer
// NUID         : 59530380
// Email        : jheyer@unomaha.edu
// Partners     : None
//
// Class creates the LinkedList and processes operations done to it.

public class LinkedList <E> {

    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private int numElements;
    private String name;

// Method Name      : LinkedList
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets name to "list", firstNode and lastNode to null,
// and numElements to 0.
    public LinkedList () {

        name = "list";
        firstNode = null;
        lastNode = null;
        numElements = 0;
    }

// Method Name      : LinkedList
// Parameters       : listName:String
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets name to String passed, firstNode and lastNode to
// null, and numElements to 0.
    public LinkedList (String listName) {

        name = listName;
        firstNode = null;
        lastNode = null;
        numElements = 0;
    }

// Method Name      : insertAtFront
// Parameters       : item:E
// Return value(s)  : None
// Partners         : N/A
// Description      : Inserts passed item to the front of the list.
    public void insertAtFront (E item) {

        if (numElements == 0) {
            ListNode temp = new ListNode(item);
            firstNode = temp;
            lastNode = temp;
            numElements++;
        }
        else {
            ListNode temp = new ListNode(item, firstNode);
            temp.setNext(firstNode);
            firstNode = temp;
            numElements++;
        }
    }

// Method Name      : insertAtBack
// Parameters       : item:E
// Return value(s)  : None
// Partners         : N/A
// Description      : Inserts passed item to the back of the list.
    public void insertAtBack (E item) {

        if (numElements == 0) {
            ListNode temp = new ListNode(item);
            firstNode = temp;
            lastNode = temp;
            numElements++;
        }
        else {
            ListNode temp = new ListNode(item, firstNode);
            lastNode.setNext(temp);
            lastNode = temp;
            numElements++;
        }
    }

// Method Name      : removeFromFront
// Parameters       : None
// Return value(s)  : E
// Partners         : N/A
// Description      : Removes item from front of list and returns it.
    public E removeFromFront () throws EmptyListException {

        ListNode<E> temp;
        if (numElements == 0) {
            EmptyListException a = new EmptyListException();
            throw a;
        }
        else if (numElements == 1) {
            temp = firstNode;
            firstNode = null;
            lastNode = null;
            numElements--;
            return temp.getData();
        }
        else {
            temp = firstNode;
            firstNode = firstNode.getNext();
            numElements--;
            return temp.getData();
        }
    }

// Method Name      : removeFromBack
// Parameters       : None
// Return value(s)  : E
// Partners         : N/A
// Description      : Removes item from back of list and returns it.
    public E removeFromBack () throws EmptyListException {

        ListNode<E> temp;
        ListNode<E> path;
        if (numElements == 0) {
            EmptyListException b = new EmptyListException();
            throw b;
        }
        else if (numElements == 1) {
            temp = firstNode;
            firstNode = null;
            lastNode = null;
            numElements--;
            return temp.getData();
        }
        else {
            path = firstNode;
            for (int x = 0; x < numElements - 1; x++) {
                path = path.getNext();
            }
            temp = lastNode;
            lastNode = path;
            numElements--;
            return temp.getData();
        }
    }

// Method Name      : remove
// Parameters       : index:int
// Return value(s)  : None
// Partners         : N/A
// Description      : Removes element from the list at given index.
    public void remove (int index) throws EmptyListException, IndexOutOfBoundsException {

        ListNode<E> temp;
        ListNode<E> temp1;
        if (numElements == 0) {
            EmptyListException d = new EmptyListException();
            throw d;
        }
        else if (index < 0 || index > numElements - 1) {
            IndexOutOfBoundsException b = new IndexOutOfBoundsException();
            throw b;
        }
        else {
            temp = firstNode;
            if (index == 0) {
                removeFromFront();
            }
            else {
                for (int x = 0; x < index - 1; x++) {
                    temp = temp.getNext();
                }
                temp1 = temp.getNext();
                temp.setNext(temp1.getNext());
                numElements--;
            }
        }
    }

// Method Name      : get
// Parameters       : index:int
// Return value(s)  : E
// Partners         : N/A
// Description      : Returns element at the given index.
    public E get (int index) throws EmptyListException, IndexOutOfBoundsException {

        ListNode<E> temp;
        if (numElements == 0) {
            EmptyListException c = new EmptyListException();
            throw c;
        }
        else if (index < 0 || index > numElements - 1) {
            IndexOutOfBoundsException a = new IndexOutOfBoundsException();
            throw a;
        }
        else {
            temp = firstNode;
            for (int x = 0; x < index; x++) {
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }

// Method Name      : findAndRemove
// Parameters       : item:E
// Return value(s)  : Boolean
// Partners         : N/A
// Description      : Attempts to find passed item. If found, removes it
// and returns true.
    public Boolean findAndRemove (E item) throws EmptyListException {

        ListNode<E> temp = firstNode;
        if (numElements == 0) {
            EmptyListException e = new EmptyListException();
            throw e;
        }
        else if (findItem(item) == -1) {
            return false;
        }
        else {
            for (int x = 0; x < findItem(item) - 1; x++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            numElements--;
            return true;
        }
    }

// Method Name      : findItem
// Parameters       : item:E
// Return value(s)  : int
// Partners         : N/A
// Description      : Attampts to find passed item. If found, returns location.
    public int findItem (E item) {

        int pos = -1;
        ListNode<E> temp = firstNode;
        for (int x = 0; x < numElements; x++) {
            E temp1 = temp.getData();
            if (temp.getData().equals(item)) {
                pos = x;
                break;
            }
            else {
                temp = temp.getNext();
            }
        }
        return pos;
    }

// Method Name      : lengthIs
// Parameters       : None
// Return value(s)  : int
// Partners         : N/A
// Description      : Returns number of elements in list.
    public int lengthIs () {

        return numElements;
    }

// Method Name      : clear
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Removes all elements from the list.
    public void clear () {

        numElements = 0;
        firstNode = null;
        lastNode = null;
    }

// Method Name      : print
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Prints "Empty LISTNAME" if empty. Otherwise, prints
// name in format: The list LISTNAME is: 
// Then all elements of list separated by a space and then a new line.
    public void print () {

        ListNode<E> temp = firstNode;
        E y;
        if (numElements == 0) {
            System.out.print ("Empty Integer List");
        }
        else {
            System.out.printf ("The list %s is: ", name);
        }
        for (int x = 0; x < numElements; x++) {
            System.out.printf ("%d ", get(x));
        }
        System.out.println ("");
    }

// Method Name      : isEmpty
// Parameters       : None
// Return value(s)  : Boolean
// Partners         : N/A
// Description      : Returns true is list is empty.
    public Boolean isEmpty () {

        if (numElements == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
