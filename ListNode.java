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
// This class is meant to give you the ability to get and add nodes to the 
// LinkedList.

public class ListNode <E> {

    private E data;
    private ListNode<E> nextNode;

// Method Name      : ListNode
// Parameters       : d:E
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets nextNode to null.
    public ListNode (E d) {

        data = d;
        nextNode = null;
    }

// Method Name      : ListNode
// Parameters       : d:E, node: ListNode<E>
// Return value(s)  : None
// Partners         : N/A
// Description      : Second ListNode constructor.
    public ListNode (E d, ListNode<E> node) {

        data = d;
        nextNode = node;
    }

// Method Name      : setData
// Parameters       : d:E
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets the data in the node provided.
    public void setData (E d) {

        data = d;
    }

// Method Name      : getData
// Parameters       : None
// Return value(s)  : E
// Partners         : N/A
// Description      : Gets data from node called.
    public E getData () {

        return data;
    }

// Method Name      : setNext
// Parameters       : next:ListNode<E>
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets the node after the current node to nextNode.
    public void setNext (ListNode<E> next) {

        nextNode = next;
    }

// Method Name      : getNext
// Parameters       : None
// Return value(s)  : ListNode<E>
// Partners         : N/A
// Description      : Gets data from current node's nextNode.
    public ListNode<E> getNext () {

        return nextNode;
    }
}
