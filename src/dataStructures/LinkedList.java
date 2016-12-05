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

// This creates a data structure or object of a linked list for each type of employee.
// 


package dataStructures;
import exceptions.EmptyListException;


public class LinkedList<E extends Comparable<E>>
{

    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private int numElements;
    private String name;

    
    //Method Name     :LinkedList
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Empty Constructor, setting values to 0;

    public LinkedList()
    {
        firstNode = lastNode = null;
        numElements = 0;

    }

    //Method Name     :LinkedList
    //Parameters      :name:String
    //Return Value(s) :None
    //Partners        :None
    //Description     :Constructor, setting values to 0 and creating a string.

    public LinkedList(String name)
    {

        firstNode = lastNode = null;
        numElements = 0;
        this.name = name;

    }

    //Method Name     :insertAtFront
    //Parameters      : item: E
    //Return Value(s) :None
    //Partners        :None
    //Description     :Inserts the passed item to the front of the list

    public void insertAtFront(E item)
    {

        ListNode<E> newNode = new ListNode<E>(item);

        if(numElements == 0)
        {
            firstNode = lastNode = newNode;
            numElements++;
        }
        else
        {
            newNode.setNext(firstNode);
            firstNode = newNode;
            numElements++;
        }

    }

    //Method Name     :insertAtBack
    //Parameters      :item:E
    //Return Value(s) :None
    //Partners        :None
    //Description     :Inserts the passed item in the back of the list

    public void insertAtBack(E item)
    {

        ListNode<E> newNode = new ListNode<E>(item);

        if(numElements == 0)
        {

            firstNode = lastNode = newNode;
            numElements++;

        }
        else
        {

            lastNode.setNext(newNode);
            lastNode = newNode;
            numElements++;

        }

    }

    //Method Name     :removeFromFront
    //Parameters      :None
    //Return Value(s) :E
    //Partners        :None
    //Description     :Removes the first item in the list, and returns it. If the list is empty throws a 
    //		      new EmptyListException with the message: (Name of list) is Empty

    public E removeFromFront()throws EmptyListException
    {

        if(numElements == 0)
            throw new EmptyListException(name);
        E ret = firstNode.getData();
        if(firstNode == lastNode)
        {
            firstNode = lastNode = null;
        }
        else
        {
            firstNode = firstNode.getNext();
        }

        numElements--;
        return ret;

    }

    //Method Name     :removeFromBack
    //Parameters      :None
    //Return Value(s) :ret
    //Partners        :None
    //Description     :Removes the last item in the list, and returns it. If the list is empty throws a 
    //                 new EmptyListException with the message:(Name of list) is Empty

    public E removeFromBack() throws EmptyListException
    {

        if(numElements == 0)
            throw new EmptyListException(name);
        E ret = lastNode.getData();
        
        if(firstNode == lastNode)
        {
            firstNode = lastNode = null;
        }
        else
        {
            ListNode<E> curr = firstNode;
            while(curr.getNext() != lastNode )
                curr = curr.getNext();

            curr.setNext(null);
            lastNode = curr;
        }

        numElements--;
        return ret;


    }

    //Method Name     :removeItem
    //Parameters      :Index:Int
    //Return Value(s) :E
    //Partners        :None
    //Description     :Removes the element from the list at the given index. If that index does not exist within 
    //                 the LinkedList an IndexOutOfBoundsException is thrown with the message: (Name of List) 
    //                 Index out of Range. Returns the item removed.

    public E removeItem(int index) throws IndexOutOfBoundsException
    {
        ListNode<E> curr = firstNode;
        if((index > (lengthIs()-1)) || (index < 0))
        {
           throw new IndexOutOfBoundsException(name + " Index Out of Range");  
        }
        else if ( index == 0 )
        {
            return removeFromFront();
        }
        else if (index == lengthIs() - 1)
        {
            return removeFromBack();
            
        }
        else
        {
            for(int i = 0; i < index - 1; i++)
            {
                curr = curr.getNext();
            }
            E ret = curr.getNext().getData();    
            curr.setNext(curr.getNext().getNext());
            numElements--;
            return ret;
        }
    }      

    //Method Name     :getItem
    //Parameters      :Index:Int
    //Return Value(s) :cur.getData()
    //Partners        :None
    //Description     :Returns the element at the given index. If that index does not exist within the LinkedList 
    //		      an IndexOutOfBoundsException is thrown with the message: (Name of List) Index out of Range.

    public E getItem(int index) throws IndexOutOfBoundsException
    {
        ListNode<E> curr = firstNode;
        if((index > (lengthIs()-1)) || (index < 0))
        {
           throw new IndexOutOfBoundsException(name + "Index Out of Range");  
        }
        for(int i = 0; i < index; i++)
            curr = curr.getNext();

        return curr.getData();
         

    }

    //Method Name     :setItem
    //Parameters      :Index:Int, Item:E
    //Return Value(s) :None
    //Partners        :None
    //Description     :Attempts to place the passed item into the given index. If that index does not exist within the 
    //		       LinkedList an IndexOutOfBoundsException is thrown with the message: (Name of List) 
    //		       Index out of Range.

    public void setItem(int index, E item) throws IndexOutOfBoundsException
    {
        ListNode<E> curr = firstNode;
        if((index > (lengthIs()-1)) || (index < 0))
        {
           throw new IndexOutOfBoundsException(name + "Index Out of Range");  
        }
        for(int i = 0; i < index; i++)
            curr = curr.getNext();

       curr.setData(item);
         
        
    }

    //Method Name     :findAndRemove
    //Parameters      :item E
    //Return Value(s) :found
    //Partners        :None
    //Description     :Attempts to find the passed item, if found removes it and returns true, if not returns false

    public boolean findAndRemove(E item)
    {
        boolean found = false;
        ListNode<E> curr = firstNode;
        if(isEmpty())
        {
            return found;
        }
        for(int i = 0; !found && curr.getNext() != null; i++)
        {
            if(item == curr.getData())
            {    
                found = true;
                removeItem(i);
            }
            else
                curr = curr.getNext();
        
        }
        
        return found;
    }
    
    //Method Name     :findItem
    //Parameters      :item E
    //Return Value(s) :int
    //Partners        :None
    //Description     :Attempts to find the passed item, if found returns the location, if not returns -1.

    public int findItem(E item)
    {
        int spot = -1;
        ListNode<E> curr = firstNode;

        for(int i = 0; (i < lengthIs())&& (spot == -1); i++)
        {
            if(curr.getData() == item)
            {
                spot = i;
            }
            else
            {
                curr = curr.getNext();
            }
        }
        
        return spot;
    }
    
    //Method Name     :lengthIs
    //Parameters      :None
    //Return Value(s) :int
    //Partners        :None
    //Description     :Returns the number of elements in the list.

    public int lengthIs()
    {
        return numElements;
    }
    
    //Method Name     :clear
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Removes all elements from the list

    public void clear()
    {
        firstNode = lastNode = null;
        numElements = 0;
    }
    
    //Method Name     :toString
    //Parameters      :None
    //Return Value(s) :ret
    //Partners        :None
    //Description     :Returns a String containing all elements in the LinkedList separated by two new lines.

    public String toString()
    {
        ListNode<E> curr = firstNode;
        String ret = "";
        
        while(curr != null)
        {
            ret = ret + curr.getData().toString() + "\n\n";
            curr = curr.getNext();
        }
        return ret;
    }

    //Method Name     :sort
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Sorts the contents of the LinkedList using the Selection Sort. 
    //                 If the list is empty throws a new EmptyListException with the 
    //  	       message: (Name of list) is Empty

    public void sort() throws EmptyListException
    {
        if( lengthIs() == 0)
            throw new EmptyListException(name);
        for(ListNode<E> curr1 = firstNode; curr1 != null; curr1 = curr1.getNext())
        {
           // System.out.println("I'm here 1");
            ListNode<E> small = curr1;
            for(ListNode<E> curr2 = curr1.getNext(); curr2 !=  null; curr2 = curr2.getNext())
            {
             //   System.out.println("Im ehre 2");
                if((small.getData().compareTo(curr2.getData())) == 1)
                {
                    small = curr2;
                }
            }
            ListNode<E> temp = new ListNode<E>(curr1.getData());
            curr1.setData(small.getData());
            small.setData(temp.getData());

        }
        
    
    }
    
    //Method Name     :isEmpty
    //Parameters      :None
    //Return Value(s) :boolean if numElements is 0 or not.
    //Partners        :None
    //Description     :Returns true if empty, false if not
    
    public boolean isEmpty()
    {
        return numElements == 0;
    }






}
