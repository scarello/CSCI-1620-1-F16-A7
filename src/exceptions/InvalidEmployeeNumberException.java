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

// Partners:Patrick Cavanaugh provided this.

// This is given to us to use for our exception. 
// 


package exceptions;



public class InvalidEmployeeNumberException extends Exception
{
    public InvalidEmployeeNumberException(int num)
    {
        super(num + " is not a valid EmployeeNumber\n");
    }

    InvalidEmployeeNumberException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

