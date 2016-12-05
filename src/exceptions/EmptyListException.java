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

// Partners:duplicated the other exceptions from Patrick Cavanaugh

// This the empty list exception.
//


package exceptions;

public class EmptyListException extends RuntimeException
{
    public EmptyListException()
    {
        super();
    }

    public EmptyListException(String name)
    {
        super(name + " is Empty");
    }

}
