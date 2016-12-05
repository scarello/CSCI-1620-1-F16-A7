// Name     : Michael Monical
// Class    : 1620-001
// Program #    :  6
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

// This sets up my superclass or parent class for my Employee information. In here you will find setters, getters.
// along with many default values used in this assignment.



package employeeType.employee;
import exceptions.InvalidEmployeeNumberException;
import java.util.Scanner;
import java.io.Serializable;

public abstract class Employee implements Comparable<Employee>, Serializable{
    private String firstName, lastName;
    private char middleInitial, gender;
    private boolean Fulltime;
    private int employeeNum;

    //Method Name     :Employee Constructor
    //Parameters      :String fn & ln, char m & g, int empNum, boolean ft 
    //Return Value(s) :none
    //Partners        :None
    //Description     :Sets the passed values into the field values.

    public Employee(String fn, String ln, char m, char g, int empNum, boolean ft)throws InvalidEmployeeNumberException {
        setEmployeeNumber(empNum);
        setFirstName(fn);
        setLastName(ln);
        setMiddleInitial(m);
        setGender(g);
	Fulltime = ft;


    }

    //Method Name     :getEmployeeNumber
    //Parameters      :none
    //Return Value(s) :employeeNumber, int
    //Partners        :None
    //Description     :this method gets the employeeNumber

    public int getEmployeeNumber()
    {
        return employeeNum;
    }

    //Method Name     :setEmployeeNumber
    //Parameters      :employeeNumber, int
    //Return Value(s) :none
    //Partners        :None
    //Description     :Checks if employee Number is valid

    public void setEmployeeNumber(int empNum)throws InvalidEmployeeNumberException
    {

        boolean flag = false;
        while (!flag)
        {
            if(10000 <= empNum && empNum <= 99999)
            {
                employeeNum = empNum;
                flag = true;
            }
            else 
            {
                throw new InvalidEmployeeNumberException(empNum);
            }
        }
    }

    //Method Name     :getFirstName
    //Parameters      :None
    //Return Value(s) :firstName, string
    //Partners        :None
    //Description     :Gets the first name from string.

    public String getFirstName(){
        return firstName;
    }

    //Method Name     :getLastName
    //Parameters      :None
    //Return Value(s) :lastName, string
    //Partners        :None
    //Description     :Gets the last name from string.

    public String getLastName(){
        return lastName;
    }

    //Method Name     :getMiddleInitial
    //Parameters      :None
    //Return Value(s) :middleInitial, char
    //Partners        :None
    //Description     :Gets the middle initial from char.

    public char getMiddleInitial(){
        return middleInitial;
    }

    //Method Name     :getGender
    //Parameters      :None
    //Return Value(s) :gender, char
    //Partners        :None
    //Description     :Gets the gender from char.

    public char getGender() {
        return gender;
    }


    //public boolean getFulltime(){
    //    return Fulltime;
    //}

    //Method Name     :setFirstName
    //Parameters      :fn, string
    //Return Value(s) :none
    //Partners        :None
    //Description     :takes in the string fn and sets firstName

    public void setFirstName(String fn){
        firstName = fn;
    }

    //Method Name     :setLastName
    //Parameters      :ln, string
    //Return Value(s) :none
    //Partners        :None
    //Description     :takes in the string ln and sets lastName

    public void setLastName(String ln){
        lastName = ln;
    }

    //Method Name     :setMiddleInitial
    //Parameters      :m, char
    //Return Value(s) :none
    //Partners        :None
    //Description     :takes in the char m and sets middleInitial

    public void setMiddleInitial(char m){
        middleInitial = m; 
    }

    //Method Name     :setGender
    //Parameters      :g, char
    //Return Value(s) :none
    //Partners        :None
    //Description     :takes in the char g and checks if it is 'M' for male or 'F' for female and sets gender.

    public void setGender(char g) {
        if(g == 'M' || g == 'F' )
            gender = g;
        else
            gender = 'F';

    }

    //public void setFulltime(boolean ft){
    //    Fulltime = ft;
    //}

    //Method Name     :equals
    //Parameters      :e2, Employee
    //Return Value(s) :boolean, true or false
    //Partners        :None
    //Description     :Returns true if the employeeNum of the two instances are equal, false otherwise.

    public boolean equals(Employee e2){
        return (employeeNum == e2.getEmployeeNumber());
    }

    //Method Name     :toString
    //Parameters      :toString, string
    //Return Values   :string, of the employee
    //Partners        :None
    //Description     :overides Object toString(). Returns as String of the Employee In certain format.

    @Override
    public String toString(){
        String toString;
        toString = employeeNum + "\n" + lastName + ',' + firstName + " " 
            + middleInitial + '.' + "\n" + "Gender: " + gender + "\n" + "Status: ";
        if (Fulltime)
            toString = toString + "Full Time" + "\n";
        else
            toString = toString + "Part Time" + "\n";
        return toString;
    }


    //Method Name      :calculateWeeklyPay
    //Parameters       :None
    //Return Value(s)  :double
    //Partners         :none
    //Description      :Abstract method will later calculate weekly pay of an employee.


    public abstract double calculateWeeklyPay();

    //Method Name      :annualRaise
    //Parameters       :None
    //Return Value(s)  :None
    //Partners         :None
    //Description      :Abstract method will later calculate annual raise of an employee.

    public abstract void annualRaise();

    //Method Name      :holidayBonus
    //Parameters       :None
    //Return Value(s)  :Double
    //Partners         :None
    //Description      :Abstract method will later calculate the annual bonus of an employee.

    public abstract double holidayBonus();

    //Method Name      :resetWeek
    //Parameters       :None
    //Return Value(s)  :None
    //Partners         :None
    //Description      :Abstract method will later reset the weekly values of an employee.

    public abstract void resetWeek();

    //Method Name     :compareTo
    //Parameters      :e Employee
    //Return Value(s) :int
    //Partners        :None
    //Description     :By implementing the Comparable interface, Employee becomes what is known as a 
    //     Comparable type. All Comparable types have the compareTo() method which determines the logical 
    //	   ordering of instances of the class. This will be based on an Employee's Employee Number. If 
    //	   the calling Employee's number is greater than the passed Employee's number return 1, if it is 
    //	   less than return -1, if they are equal return 0. The use of this will be necessary for the ArrayList's sort.

    @Override
    public int compareTo(Employee e)
    {
        if(getEmployeeNumber() > e.getEmployeeNumber())
            return 1;
        else if(getEmployeeNumber() < e.getEmployeeNumber())
            return -1;
        else
            return 0;
    }

}


