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

// This is my subclass Comission Employee. In here you will find the minpulation and setup for
// Comission Employees.


package employeeType.subTypes;
import exceptions.InvalidEmployeeNumberException;
import employeeType.employee.Employee;

public class CommissionEmployee extends Employee {
    private double sales;
    private double rate;
    
    //Method Name     :CommissionEmployee Constructor
    //Parameters      :String fn & ln, char m & g, int empNum, boolean ft, double r
    //Return Value(s) :None
    //Partners        :None
    //Description     :Takes in the values applying them to the field values the Super makes sure that you are taking the values from the super class
    
    public CommissionEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double r)throws InvalidEmployeeNumberException{
        super(fn, ln, m, g, empNum, ft);
        rate = r;
    }
    
    //Method Name     :increaseSales
    //Parameters      :double, sales
    //Return Value(s) :None
    //Partners        :None
    //Description     : if sales is greater than 0 it gets applied to sales otherwise tells you invalid

    public void increaseSales (double sales){    
        if (sales >= 0.0)
            this.sales = this.sales + sales;
        else
            System.out.print("You can't add negative sales");
    }
    
    //Method Name     :toString
    //Parameters      :toString, string
    //Return Value(s) :string, of the employee
    //Partners        :None
    //Description     :overides Object toString(). Returns as String of the Commission Employee In  a certain format.

    @Override
    public String toString(){

        return super.toString() + "Rate: " + String.format("%.2f", rate) + "\n" + "Sales: " + String.format("%.2f", sales) + "\n";
    }
    
    //Method Name     :calculateWeeklyPay
    //Parameters      :None
    //Return Value(s) :double, sales
    //Partners        :None
    //Description     :calculates the weekly pay returning it in sales

    public double calculateWeeklyPay(){
        return sales * (rate/100);
    }
    
    //Method Name     :annualRaise
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :adds the annual raise to commission rate and restores the new commission rate

    public void annualRaise(){
        rate = rate + .20; 

    }
    
    //Method Name      :holidayBonus
    //Parameters       :none
    //Return Value(s)  :double, 
    //Partners         :none
    //Description      : ensures holiday bonus is 0.0

    public double holidayBonus(){
        return 0.00; 
    }
    
    //Method Name     :resetWeek
    //Parameters      :none
    //Return Value(s) :none
    //Partners        :none
    //Description     :resets the weekly sales to 0

    public void resetWeek(){
        sales = 0.00;
    }
    
}
