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

// This is my manipulation of Salary Employee information. 
// 


package employeeType.subTypes;
import exceptions.InvalidEmployeeNumberException;

import employeeType.employee.Employee;

public class SalaryEmployee extends Employee {
    private double salary;

    //Method Name     :SalaryEmployee Constructor
    //Parameters      :String fn & ln, char m & g, int empNum, boolean ft, double s
    //Return Value(s) :None
    //Partners        :None
    //Description     :Takes in the values applying them to the field values

    public SalaryEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double s)throws InvalidEmployeeNumberException{
        super(fn, ln, m, g, empNum, ft);
        salary = s;
    }

    //Method Name     :toString
    //Parameters      :toString, string
    //Return Values   :string, of the employee
    //Partners        :None
    //Description     :overides Object toString(). Returns as String of the SalarayEmployee In  a certain format.
    
    @Override
    public String toString(){

        return super.toString() + "Salary: " + String.format("%.2f", salary) + "\n";
    }
    
    //Method Name     :calculateWeeklyPay
    //Parameters      :None  
    //Return Values   :double, salary
    //Partners        :None
    //Description     :takes the salary and divides by 52 weeks to give weekly pay.
   
    public double calculateWeeklyPay(){
        return salary/52;
    }

    //Method Name     :annualRaise
    //Parameters      :None
    //Return Value(s) :double, salary
    //Partners        :None
    //Description     :Takes and calculates the annual raise plus the salary

    public void annualRaise(){
        
        salary = salary + (salary * .06); 
        salary = Math.round(salary*100.)/100.0;

    }

    //Method Name     :holidayBonus
    //Parameters      :None
    //Return Value(s) :double salary
    //Partners        :NOne
    //Description     :figures the value of the holiday bonus

    public double holidayBonus(){
        return salary * .03;
    }
    
    //Method Name     :resetWeek
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Does nothing at this time
    
    public void resetWeek(){
        
    }
}
