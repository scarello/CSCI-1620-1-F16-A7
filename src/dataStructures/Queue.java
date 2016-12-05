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

// We make calls in queue with has-a instead of an is-a relationship.
// 

package dataStructures;




public class Queue<E extends Comparable<E>>
{
    private LinkedList<E> list;

    //Method Name     :LinkedList
    //Parameters      :none
    //Return Value(s) :none
    //Partners        :None
    //Description     :constructor creates the linked list object

    public Queue()
    {
        list = new LinkedList<E>();
    }

    //Method Name     :Queue
    //Parameters      :name:string
    //Return Value(s) :none
    //Partners        :None
    //Description     :constructor creates the linked list object

    public Queue(String name)
    {
        list = new LinkedList<E>(name);

    }
    
    //Method Name     :enqueue
    //Parameters      :item:E
    //Return Value(s) :none
    //Partners        :None
    //Description     :this method adds the item to the back

    public void enqueue(E item)
    {
        list.insertAtBack(item);
    
    
    }
    
    //Method Name     :dequeue
    //Parameters      :none
    //Return Value(s) :E
    //Partners        :None
    //Description     :this method removes the from the front of the list.

    public E dequeue()
    {
        return list.removeFromFront();

    }
    
    //Method Name     :peek
    //Parameters      :none
    //Return Value(s) :getItem
    //Partners        :None
    //Description     :this method gets the first item in the array.

    public E peek()
    {
        return list.getItem(0);
    }

    //Method Name     :isEmpty
    //Parameters      :none
    //Return Value(s) :true/false
    //Partners        :None
    //Description     :checks if the list is empty

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    //Method Name     :toString
    //Parameters      :none
    //Return Value(s) :String
    //Partners        :None
    //Description     :this method gets the employeeNumber
    
    public String toString()
    {
        return list.toString();
    }
    
    //Method Name     :clear
    //Parameters      :none
    //Return Value(s) :none
    //Partners        :None
    //Description     :this method gets the clears the list

    public void clear()
    {
        list.clear();    
    }


}
