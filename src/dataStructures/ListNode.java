// Name     : Michael Monical
// Class    : 1620-001
// Program #    : 6 
// Due Date     : Nov. 29, 2016 
//
// Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Michael Monical
// NUID: 9263 
// EMAIL: mikemonical@gmail.com

// Partners:None

// Manipulates the Nodes inside of the linked list.
// 


package dataStructures;

public class ListNode <E extends Comparable<E>>
{

    private E data;
    private ListNode<E> nextNode;

    //Method Name     :ListNode
    //Parameters      :d:E
    //Return Value(s) :None
    //Partners        :None
    //Description     :Constructor, creates a Node of setData

    public ListNode(E d)
    {

        setData(d);
        

    }

    //Method Name     :ListNode
    //Parameters      :d:E, node: ListNode<E>
    //Return Value(s) :None
    //Partners        :None
    //Description     :Constructor, creates the node and sets the next one.

    public ListNode(E d, ListNode<E> node)
    {

        this(d);
        setNext(node);

    }

    //Method Name     :setData
    //Parameters      :d:E
    //Return Value(s) :None
    //Partners        :None
    //Description     :sets data to the passed in value

    public void setData(E d)
    {

        data = d;

    }

    //Method Name     :getData
    //Parameters      :None
    //Return Value(s) :E
    //Partners        :None
    //Description     :returns the object of Data

    public E getData()
    {
        
        return data;

    }

    //Method Name     :setNext
    //Parameters      :next:ListNode<E>
    //Return Value(s) :None
    //Partners        :None
    //Description     :sets the next node to the passed in value

    public void setNext(ListNode<E> next)
    {
    
        nextNode = next;

    }

    //Method Name     :getNext
    //Parameters      :None
    //Return Value(s) :nextNode
    //Partners        :None
    //Description     :gets the next node and returns it

    public ListNode<E> getNext()
    {

        return nextNode;

    }



}
