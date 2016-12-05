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
// NUID: 9236
// EMAIL: mikemonical@gmail.com

// Partners:None

// This is the ArrayList class that implemtns an ArrayList data structure, capable of handling types that implement
// Comparable<E>.

package dataStructures;
import java.util.Scanner;
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.SalaryEmployee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.employee.Employee;
import exceptions.InvalidSizeException;
import exceptions.InvalidCharacterException;
import java.util.InputMismatchException;
import exceptions.MaximumCapacityException;




@SuppressWarnings("unchecked")
public class ArrayList <E extends Comparable<E>>{
    private final int DEFCAP = 50;
    private int origCap;
    private int numElements;
    private Object[] list;

    public ArrayList( )
    {
        origCap = DEFCAP;
        list = new Object[origCap];
        numElements = 0;

    }

    //Method Name     :ArrayList
    //Parameters      :size, int
    //Return Value(s) :None
    //Partners        :None
    //Description     :The constructor that takes no size will set the origCap to DEFCAP and 
    //		      this will be the initial size. The constructor that accepts a size parameter 
    //  	      must throw an InvalidSizeException if the size passed is greater than the DEFCAP 
    //		      or less than 1.


    public ArrayList(int size)throws InvalidSizeException
    {
        numElements = 0;
        if( size > DEFCAP || size < 1)
            throw new InvalidSizeException();
        origCap = size;
        
        list = new Object[origCap];
        
    }

    //Method Name     :addItem
    //Parameters      :item E
    //Return Value(s) :None
    //Partners        :None
    //Description     :Attempts to add a new item to the ArrayList.  If the array is at capacity it attempts
    //                 to enlarge, then adds the item to the end.

    public void addItem(E item)throws MaximumCapacityException
    {
        if( numElements == DEFCAP)
        {
            throw new MaximumCapacityException();
        }
        if(numElements == list.length)
        {
            enlarge();
        }
        list[numElements] = item; 
        numElements++;
    }

    //Method Name     :getItem
    //Parameters      :index int;
    //Return Value(s) :E
    //Partners        :None
    //Description     :This method is to retrieve an item in the list given an index into the ArrayList. 
    //                 If that index does not exist within the ArrayList an IndexOutOfBoundsException is 
    //                 thrown with the message: "Index out of Range".


    public E getItem(int index)throws IndexOutOfBoundsException
    {
        if(index >= numElements || index < 0)
        {
            throw new IndexOutOfBoundsException("Index out of Range");
        }
        return (E) list[index];
    }

    //Method Name     :setItem
    //Parameters      :index int; item E
    //Return Value(s) :None
    //Partners        :None
    //Description     :Attempts to place the passed item into the given index. If that index does not exist
    //                 within the ArrayList an IndexOutOfBoundsException is thrown with the message: 
    //                "Index out of Range".

    public void setItem(int index, E item)throws IndexOutOfBoundsException
    {
        if(index >= numElements || index < 0)
        {
            throw new IndexOutOfBoundsException("Index out of Range");
        }
        list[numElements] = item;

    }

    //Method Name     :removeItem
    //Parameters      :index int;
    //Return Value(s) :E
    //Partners        :None
    //Description     :Attempts to remove the item at the given index from the ArrayList. 
    //                 If that index does not exist within the ArrayList an IndexOutOfBoundsException 
    //                 is thrown with the message: "Index out of Range".

    public E removeItem(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || numElements < 0)
        {
            throw new IndexOutOfBoundsException("Index out of Range");
        }
        E ret = (E)list[index];
        for(int i = index; i < numElements - 1; i++)
        {
            list[i] = list[i + 1];
        }
        numElements--;
        return ret;
    }

    //Method Name     :findItem
    //Parameters      :item E;
    //Return Value(s) :int
    //Partners        :None
    //Description     :Performs a linear search to fine the item passed. Returns the index of the item if found, 
    //                 returns -1 if not found.

    public int findItem(E item)
    {
        for(int i = 0; i < numElements; i++)
        {
            if(list[i] == item)
            {
                return i;
            }

        }
        return -1;

    }

    //Method Name     :isEmpty
    //Parameters      :None
    //Return Value(s) :boolean
    //Partners        :None
    //Description     :Returns a true if the ArrayList is empty, otherwise false.

    public boolean isEmpty()
    {
        return numElements == 0;
    }

    //Method Name     :lengthIs()
    //Parameters      :None
    //Return Value(s) :int
    //Partners        :None
    //Description     :Returns the current number of elements in the ArrayList.

    public int lengthIs()
    {

        return numElements;
    }

    //Method Name     :clear
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Clears contents of the ArrayList, sets size of array to the original capacity.

    public void clear()
    {
        if(list.length != origCap)
            list = new Object[origCap];

        numElements = 0;
    }

    //Method Name     :toString
    //Parameters      :None
    //Return Value(s) :String
    //Partners        :None
    //Description     :Returns a String containing all elements in the ArrayList, separated by a new line.

    @Override
    public String toString()
    {
        String name = "";
        for(int i = 0; i < numElements; i++)
        {
            name = name + list[i].toString() + "\n";
        }
        return name;
    }

    //Method Name     :sort
    //Parameters      :None
    //Return Value(s) :String
    //Partners        :None
    //Description     :Sorts the contents of the ArrayList using the Insertion Sort.

    public void sort()
    {
        E temp;

        for (int i = 1; i < numElements; i++) {
            for(int j = i ; j > 0 ; j--){
                temp = (E) list[j];

                //if ( list[j] == null)
		//{
		//
		//}
		if( temp.compareTo((E) list[j-1]) == -1)
                {
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }

            }
        }
        //10, 34, 2, 56, 7, 67, 88, 42
        //10, 34, 2, 56, 7, 67, 88, 42
        //10, 2, 34, 56
        //2, 10, 34, 56, 7
        // 2,10, 34, 7, 56
        // 2, 10, 7, 34, 56,

    }

    //Method Name     :enlarge
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Will attempt to enlarge the ArrayList by the value of origCap. 
    //                 If this would put it past its maximum size defined by DEFCAP it will enlarge 
    //                 to the size of DEFCAP. If it is already at size of DEFCAP it will throw a 
    //                 MaximumCapacityException.

    private void enlarge() throws MaximumCapacityException
    {
        int newsize = list.length + origCap;
        if(list.length == DEFCAP)
            throw new MaximumCapacityException();
        else if (newsize > DEFCAP)
            newsize = DEFCAP;
        Object[] tempArray = new Object[newsize];
        System.arraycopy(list, 0, tempArray, 0, numElements);
        list = tempArray;
    }
}

