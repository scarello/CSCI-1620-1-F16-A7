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

// This sets up and manipulates Hourly Employee information. 
// 


package employeeType.subTypes;
import exceptions.InvalidEmployeeNumberException;
import employeeType.employee.Employee;

public class HourlyEmployee extends Employee{

    private double wage;
    private double hoursWorked;
    
    //Method Name     :HourlyEmployee Constructor
    //Parameters      :String fn & ln, char m & g, int empNum, boolean ft, double w
    //Return Value(s) :None
    //Partners        :None
    //Description     :Takes in the values applying them to the field values
   
    public HourlyEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double w)throws InvalidEmployeeNumberException{
        super(fn, ln, m, g, empNum, ft);
        wage = w;
    }
    
    //Method Name     :increaseHours
    //Parameters      :double, hours
    //Return Value(s) :None
    //Partners        :None
    //Description     :allows you to add hours while preventing you from entering a non valid negative number

    public void increaseHours (double hours){    
        if (hours >= 0.0)
            hoursWorked = hoursWorked + hours;
        else
            System.out.print("You can't add negative hours");
    }
    
    //Method Name     :toString
    //Parameters      :toString, string
    //Return Values   :string, of the employee
    //Partners        :None
    //Description     :overides Object toString(). Returns as String of the Hourly Employee In  a certain format.
    
    @Override
    public String toString(){

        return super.toString() + "Wage: " + String.format("%.2f", wage) + "\n" + "Hours Worked: " + 
            String.format("%.2f", hoursWorked) + "\n";
    }
    
    //Method Name     :calculateWeeklyPay
    //Parameters      :None
    //Return Value(s) :double, wage
    //Partners        :None
    //Description     :Calculates the amount earned in the week using wage and hours worked. 
    //                 Also accounts for overtime hours paying Double the normal wage.

    public double calculateWeeklyPay(){
        if(hoursWorked <= 40)
            return wage * hoursWorked;
        else
            return (hoursWorked - 40)* (wage*2)+ 40 * wage;
    }
    
    //Method Name     :annualRaise
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :Patrick Cavanaugh pcavanaugh.uno@gmail.com answered my question on how to go about this. Class confirmed my suspisions.
    //Description     : calculates the wage after the annual raise. It does truncate any thousands and beyond numbers
    //                : example if it is 16.107 it will make it 16.10 instead of rounding to 16.11.

    public void annualRaise(){

        wage = (Math.floor((wage + (wage * .05))*100))/100; 

    }

    //Method Name     :holidayBonus
    //Parameters      :None
    //Return Value(s) :double, wage
    //Partners        :None
    //Description     :calculates the holiday bonus

    public double holidayBonus(){
        return wage * 40;
    }
    
    //Method Name     :resetWeek
    //Parameters      :none
    //Return Value(s) :none
    //Partners        :None
    //Description     :resets the weekly hours work to 0.0

    public void resetWeek(){
        hoursWorked = 0;
    }

}
