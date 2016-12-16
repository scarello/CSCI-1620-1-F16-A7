package csci.pkg1620.pkg1.f16.a7;

// Name     : Michael Monical
// Class    : 1620-001
// Program #    : 7
// Due Date     : Dec. 16, 2016
//
// Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Michael Monical
// NUID: 9263
// EMAIL: mikemonical@gmail.com

// Partners:None

// This sets up a little manager interface the user can then use to add or remove employees. Calculting various 
// things.


import employeeType.employee.Employee;
//import employeeType.subTypes.*; Why would this not work?
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.subTypes.SalaryEmployee;
import exceptions.InvalidCharacterException;
import exceptions.InvalidSizeException;
import exceptions.MaximumCapacityException;
import exceptions.InvalidEmployeeNumberException;
import java.util.Scanner;
import dataStructures.ArrayList;
import dataStructures.LinkedList;
import dataStructures.Queue;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;


public class EmployeeManager {

    private ArrayList<Employee> employees;
    private final int employeeMax = 10;
    private LinkedList<Employee> hourlyList;
    private LinkedList<Employee> salaryList;
    private LinkedList<Employee> commissionList;
    private Queue<Employee> vacationRequests;


    //Method Name     :EmployeeManager
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Constructor, creates the Employee array, sets currentEmployees to 0.

    public EmployeeManager() {
        hourlyList = new LinkedList<>("Hourly List");
        salaryList = new LinkedList<>("Salary List");
        commissionList = new LinkedList<>("Commission List");
        vacationRequests = new Queue<>("Vacation Requests");

        try
        {

            employees = new ArrayList<>(3);

        }
        catch(InvalidSizeException E)
        {
            employees = new ArrayList<>();
        }
    }

    //Method Name     :addEmployee
    //Parameters      :type:int, fn:String, ln:String, m:char, g:char, en:int, ft:boolean, amount:double
    //Return Value(s) :String
    //Partners        :None
    //Description     :Takes an int representing the type of Employee to be added (1 Hourly, 2 Salary, 3 Commission) 
    //                 as well as the required data to create that Employee. If one of these values is not passed output 
    //                 the line, Invalid Employee Type, None Added, and exit the method. If an Employee with the given 
    //                 Employee Number already exists do not add the Employee and output the line, Duplicate Not Added, 
    //                 and exit the method. If the array is at maximum capacity do not add the new Employee, and output 
    //                 the line, "Cannot add more Employees".


    public String addEmployee(int type, String fn, String ln, char m, char g, int en, boolean ft, double amount)throws InvalidEmployeeNumberException{
        if (employees.lengthIs() == employeeMax)
        {
            return "Cannot add more Employees";

        }
        for(int i = 0;i < employees.lengthIs();i++){
            if(en == employees.getItem(i).getEmployeeNumber())
            {
                return "Duplicate Not Added";
                
            }

        } 
        switch (type) {
            case 1:
                HourlyEmployee he = new HourlyEmployee(fn, ln, m, g, en, ft, amount); 
                try{
                    employees.addItem(he);
                }
                catch(MaximumCapacityException E)
                {
                    System.out.println("At maximum capacity cannot add the employee");
                }
                hourlyList.insertAtBack(he);
                break;
            case 3:
                CommissionEmployee ce = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
                try{
                    employees.addItem(ce);
                }
                catch(MaximumCapacityException E)
                {
                    return "At maximum capacity cannot add the employee";
                }
                commissionList.insertAtBack(ce);
                break;
            case 2:
                SalaryEmployee se = new SalaryEmployee(fn, ln, m, g, en, ft, amount);

                try{
                    employees.addItem(se);
                }
                catch(MaximumCapacityException E)
                {
                    return "At maximum capacity cannot add the employee";
                }
                salaryList.insertAtBack(se);
                break;
            default:
                return "Invalid Employee Type, None Added";
                
        }
        return "Employee Added";
    }

    //Method Name     :removeEmployee
    //Parameters      :index:int
    //Return Value(s) :None
    //Partners        :None
    //Description     :Removes an Employee located at the given index from the Employee array.

    public void removeEmployee(int index)
    {
        if(!employees.isEmpty())
        {
            Employee temp = employees.removeItem(index);
            if(temp instanceof HourlyEmployee)
                hourlyList.findAndRemove(temp);
            else if( temp instanceof SalaryEmployee)
                salaryList.findAndRemove(temp);
            else
                commissionList.findAndRemove(temp);
        }
    }


    //Method Name     :listAll
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current Employees. Outputs there are none if there are none.


    public String listAll()
    {
        if (employees.isEmpty())
        {
            return "No Employees.";
        }    
        else
        {
            return employees.toString(); 
        }
    }

    //Method Name     :listHourly
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current HourlyEmployees. Outputs there are none if there are none.

    public String listHourly()
    {
        if (hourlyList.isEmpty())
        {    
            return "No Employees.";
        }
        else
        {
            return hourlyList.toString();
        }
    }


    //Method Name     :listSalary
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current SalaryEmployees. Outputs there are none if there are none.

    public String listSalary()
    {
        if (salaryList.isEmpty())
        {    
            return "No Employees.";
        }
        else
        {
            return salaryList.toString();
        }
    }   



    //Method Name     :listCommission
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Lists all the current CommissionEmployees. Outputs there are none if there are none.




    public String listCommission()
    {
        if (commissionList.isEmpty())
        {    
            return "No Employees.";
        }
        else
        {
          return commissionList.toString();
        }
    }

    //Method Name     :resetWeek
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Resets the week for all Employees.

    public void resetWeek(){
        for(int i = 0; i < employees.lengthIs(); i++){
            employees.getItem(i).resetWeek();
        }
    }

    //Method Name     :calculatePayout
    //Parameters      :None
    //Return Value(s) :sum:double
    //Partners        :None
    //Description     :Returns the total weekly payout for all Employees.

    public double calculatePayout(){
        double sum = 0.0;
        for(int i = 0; i < employees.lengthIs(); i++){
            sum += employees.getItem(i).calculateWeeklyPay(); 
        }
        return sum;
    }



    //Method Name     :getIndex
    //Parameters      :None
    //Return Value(s) :i:int
    //Partners        :None
    //Description     :Given an Employee Number, returns the index of that Employee in the array, if the Employee 
    //                 doesn't exist retuns -1.


    public int getIndex(int empNum){
        for(int i = 0; i < employees.lengthIs(); i++){
            if (employees.getItem(i).getEmployeeNumber() == empNum)
                return i;
        }
        return -1;
    }


    //Method Name     :annualRaises
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :Applies annual raise to all current Employees.


    public void annualRaises(){
        for(int i = 0; i < employees.lengthIs(); i++){
            employees.getItem(i).annualRaise();
        }
    }

    //Method Name     :holidayBonuses
    //Parameters      :None
    //Return Value(s) :bonus:double
    //Partners        :None
    //Description     :Outputs and returns the total holiday bonus of all Employees.

    public double holidayBonuses(){
        double bonus = 0.0;
        for(int i = 0; i < employees.lengthIs(); i++){
            bonus += employees.getItem(i).holidayBonus();
        }
        return bonus;
    }

    //Method Name     :increaseHours
    //Parameters      :index:int, amount:double
    //Return Value(s) :None
    //Partners        :None
    //Description     :Increase the hours worked of the Employee at the given index by the given double amount.

    public boolean increaseHours(int index, double amount){

        Employee employee = employees.getItem(index);
        if(employee instanceof HourlyEmployee)
        {
            HourlyEmployee Employee = (HourlyEmployee)employee;
            Employee.increaseHours(amount);
            return true;
        }
        else 
        {
            //System.out.println("\nThis is not an Hourly Employee!\n");
            return false;
        }
    }

    //Method Name     :increaseSales
    //Parameters      :index:int, amount:double
    //Return Value(s) :None
    //Partners        :None
    //Description     :Increase the sales of the Employee at the given index by the given double amount.

    public boolean increaseSales(int index, double amount){

        Employee employee = employees.getItem(index);
        if(employee instanceof CommissionEmployee)
        {
            CommissionEmployee Employee = (CommissionEmployee)employee;
            Employee.increaseSales(amount);
            return true;
        }
        else
        {
            //System.out.println("\nThis is not a Commission Employee!\n");
            return false;
        }
    }

    //Method Name     :findAllBySubstring
    //Parameters      :String: find
    //Return Value(s) :Array
    //Partners        :None
    //Description     :This method will return an array of all the Employees in the EmployeeManager that contain 
    //                the substring passed. Create a new Employee array with the size of the number of current 
    //                Employees. For every Employee call upon the RabinKarp method giving the search string as 
    //                the concatenation of that Employee's first and last name (no spaces). If the substring is 
    //                found in the Employee add that Employee to the new array. After all have been checked, 
    //                return the array.

    public ArrayList<Employee> findAllBySubstring(String find)
    {
        String name;
        ArrayList<Employee> ea = new ArrayList<>();


        for(int i = 0 ; i < employees.lengthIs();i++)
        {
            name = employees.getItem(i).getFirstName() + employees.getItem(i).getLastName();
            if (RabinKarp(name, find) != -1)
            {
                try
                {
                    ea.addItem(employees.getItem(i));
                }
                catch(MaximumCapacityException E)
                {    

                }
            }


        }
        return  ea;
    }

    //Method Name     :charNumericValue
    //Parameters      :char: c
    //Return Value(s) :int or throws InvalidCharacterException
    //Partners        :None
    //Description     :Given a character, returns the numeric value of the character, starting with A 0 up to Z 25. 
    //                This should treat upper and lower case the same; that is passing it will return 0, passing 
    //                it will also return 0. If a letter is not passed this method should create and throw an 
    //                InvalidCharacterException as provided.

    private int charNumericValue(char c) throws InvalidCharacterException
    {        
        //int val = Character.toUpper(c) - 65;
        switch( c )
        {
            case 'a': 
            case 'A':
                return 0;
            case 'b': 
            case 'B':
                return 1;
            case 'c': 
            case 'C':
                return 2;     
            case 'd': 
            case 'D':
                return 3;    
            case 'e': 
            case 'E':
                return 4;
            case 'f': 
            case 'F':
                return 5;
            case 'g': 
            case 'G':
                return 6;
            case 'h': 
            case 'H' :
                return 7;
            case 'i': 
            case 'I':
                return 8;
            case 'j': 
            case 'J':
                return 9;
            case 'k':
            case 'K':
                return 10;
            case 'l':
            case 'L':
                return 11;
            case 'm': 
            case 'M':
                return 12;
            case 'n': 
            case 'N':
                return 13;
            case 'o': 
            case 'O':
                return 14;
            case 'p': 
            case 'P':
                return 15;
            case 'q': 
            case 'Q':
                return 16;
            case 'r': 
            case 'R':
                return 17;
            case 's': 
            case 'S':
                return 18;
            case 't': 
            case 'T':
                return 19;
            case 'u': 
            case 'U':
                return 20;
            case 'v': 
            case 'V':
                return 21;
            case 'w': 
            case 'W':
                return 22;
            case 'x': 
            case 'X':
                return 23;
            case 'y': 
            case 'Y':
                return 24;
            case 'z': 
            case 'Z':
                return 25;
            default: 
                throw new InvalidCharacterException( c );
        }    
    }

    //Method Name     :stringHash
    //Parameters      :String:s
    //Return Value(s) :int:hash
    //Partners        :None
    //Description     :Given a string, return the hash value of the entire String. Use a base 26 number system to 
    //                create the hash as described in class. This will be needed only to find the hash of the 
    //                substring that is being searched for and the base case for finding all substring hashes 
    //                in the search string.


    private int stringHash (String s)
    {
        int hash = 0;
        int l = s.length();
        for(int i = 0; i < l; i++)
        {
            hash += charNumericValue(s.charAt(i))* (int) Math.pow(26,l-i-1);
        }
        return hash;
    }

    //Method Name     :RabinKarpHashes
    //Parameters      :String:s, intArray:hashes, int:pos, int:length
    //Return Value(s) :int
    //Partners        :None
    //Description     :Finds the hash values of all substrings of size length in the String s, starting at index 
    //                pos and down. These values are stored in the passed hashes array. This method must be recursive, 
    //                using the technique as described in the Rabin-Karp lecture.

    private int RabinKarpHashes(String s, int[] hashes, int pos, int length )
    {
        if(pos < 0)
        {
            return 0;
        }
        hashes[pos] = stringHash(s.substring(pos, pos + length));

        return RabinKarpHashes(s, hashes, pos - 1, length);

        //for(int i = 0; i < s.length() - length; i++)
        // {
        //     hashes[i] = stringHash(s.substring(pos - length, pos));
        //     pos--;
        // }

        //return 1;
    }

    //Method Name     :linearSearchRecursive
    //Parameters      :String:s, intArray:hashes, int: both pos and length
    //Return Value(s) :int
    //Partners        :none
    //Description     :This is a recursive linear search. Return the position of key in the data array, or -1 
    //                if it is not present. This method must be recursive.

    private int linearSearchRecursive(int[] data, int key, int pos)
    {
        if (pos <= 0 ) 
        {
            return -1;
        }
        if(key == data[pos-1])
        {
            return pos - 1;
        } 
        return linearSearchRecursive( data, key, pos - 1);
    }

    //Method Name     :RabinKarp
    //Parameters      :String:name, string:find
    //Return Value(s) :int
    //Partners        :none
    //Description     :Does the preprocessing of finding the hash for the substring, find using the stringHash method 
    //                and the hashes of substrings in the search string using RabinKarpHashes method. Calls upon 
    //                linearSearchRecursive to determine if the substring hash is in the collection of hashes and 
    //                returns the result.    

    private int RabinKarp(String name, String find)
    {
        if (find.length() > name.length() )
        {    
            return -1;
        }
        int findhash = stringHash(find);
        int[] nameHashes = new int[name.length() - find.length()+1];
        RabinKarpHashes(name, nameHashes, name.length() - find.length(), find.length());
        return linearSearchRecursive(nameHashes, findhash, nameHashes.length);
    }

    //Method Name     :Sort
    //Parameters      :None
    //Return Value(s) :none
    //Partners        :none
    //Description     :Simply calls upon the ArrayLists sort() method.

    public void sort()
    {
        if(!employees.isEmpty())
            employees.sort();
        if(!hourlyList.isEmpty())
            hourlyList.sort();
        if(!salaryList.isEmpty())
            salaryList.sort();
        if(!commissionList.isEmpty())
            commissionList.sort();
    }

    //Method Name     :addRequest
    //Parameters      :empNum:int
    //Return Value(s) :boolean
    //Partners        :None
    //Description     :If an Employee with the passed Employee number exists, add them to the vacation requests
    //		      queue and return true. Otherwise return false.

    public boolean addRequest(int empNum)
    {
        int i = getIndex(empNum);
        if( i != -1 )
        {
            vacationRequests.enqueue(employees.getItem(i));
            //System.out.println(vacationRequests.toString());
            return true;
        }
        else
            return false;

    }

    //Method Name     :viewNextRequest
    //Parameters      :None
    //Return Value(s) :Employee
    //Partners        :None
    //Description     :Returns the next Employee that would be granted a vacation request, but does not remove 
    //                 it from the Queue, if there are no requests in the Queue it returns null.

    public Employee viewNextRequest()
    {
        if(vacationRequests.isEmpty())
            return null;
        return vacationRequests.peek();
    }

    //Method Name     :grantNextRequest
    //Parameters      :None
    //Return Value(s) :Employee
    //Partners        :None
    //Description     :If requests are present, removes the next Employee from the Queue and returns it, 
    //		      if there are no requests returns null.

    public Employee grantNextRequest()
    {
        if(vacationRequests.isEmpty())
            return null;
        return vacationRequests.dequeue();        
    }

    //Method Name     :outputRequests
    //Parameters      :None
    //Return Value(s) :None
    //Partners        :None
    //Description     :If requests are present outputs all of the Employees in the Queue. 
    //                  If there are no requests outputs, No vacation requests.

    public String outputRequests()
    {
        if(vacationRequests.isEmpty())
            return "No vacation requests";
        else 
            return vacationRequests.toString();

    }
    //Method Name     :loadEmployees
    //Parameters      :employeeFile:String, requestFile:String
    //Return Value(s) :boolean true or false
    //Partners        :None
    //Description     :Given the name of a serialized file (employeeFile), this method attempts to read in Employees from a previous session. 
    //This method will return true if the load of Employees was successful and false if it was not successful (file doesn’t exist, 
    //ClassNotFoundException, or other IOException). Before reading in the Employees it will clear all of the lists to ensure it 
    //is loading into an empty set of Employees. This includes the ArrayList, the LinkedLists, and the Queue. 
    //If a MaximumCapacityException is encountered while adding Employees output “Maximum Capacity Reached”, and return true. 
    //The method will also open the text file (requestFile) to rebuild the vacation request Queue.

    public boolean loadEmployees(String employeeFile, String requestFile)
    {
        ObjectInputStream input;
        Scanner input2;
        employees.clear();
        salaryList.clear();
        hourlyList.clear();
        commissionList.clear();
        vacationRequests.clear();
        boolean error = false, flag = true;
        //Can one file open correctly and the other not? If so how do we handle that? 

        
        try
        {
            input = new ObjectInputStream(new FileInputStream(employeeFile));
        }
        catch(IOException IOE)
        {
            //System.err.println("Error Opening Employee File.");
            //System.out.println(IOE.toString());
            return false;
        }
        while(flag)
        {
            try{
                Employee record = (Employee)input.readObject();

                try{
                    employees.addItem(record);
                }catch(MaximumCapacityException MCE)
                {
                    System.out.print("Maximum Capacity Reached");
                    flag = false;
                }
                if (record instanceof HourlyEmployee)
                {
                    hourlyList.insertAtBack(record);
                }
                else if (record instanceof SalaryEmployee)
                {
                    salaryList.insertAtBack(record);
                }
                else
                    commissionList.insertAtBack(record);
            }
            catch(EOFException EOFE)
            {
                try{
                    input.close();
                }
                catch(IOException ex)
                {
                    System.err.println("Error closing file");
                }
                flag = false;
            }
            catch(ClassNotFoundException | IOException CNFE)
            {
                try{
                    input.close();
                }
                catch(IOException ex)
                {
                    System.err.println("Error closing file");
                }
                error = true;
                flag = false;
            }
            

            //What happens if we encounter an error in loading the employees do we still load requests or do we just return?
        }
        try
        {
            input2 = new Scanner(new File(requestFile));
        }
        catch(IOException IOE)
        {
            System.err.println("Error opening Request File");
            return false; 
        }
        
        while(input2.hasNextInt())
        {    
            addRequest(input2.nextInt());
        }
            input2.close();
        
        //System.out.println(error);    
        return !error;
    }
    //what could cause a return false? or return true?
    
    //Method Name     :saveEmployees
    //Parameters      :employeeFile:String, requestFile:String
    //Return Value(s) :boolean true or false
    //Partners        :None
    //Description     :This method will store all of the Employees as Serialized objects in the employeeFile and the 
    //          Employee numbers in the correct order of those in the vacation Queue as plain text, 
    //          placing a new line after every number.
                


    public boolean saveEmployees(String employeeFile, String requestFile)
    {
        ObjectOutputStream output;
        Formatter output2;
        boolean error = false, flag = true;
        try
        {
            output = new ObjectOutputStream(new FileOutputStream(employeeFile));
            output2 = new Formatter(requestFile);
        }
        catch(IOException IOE)
        {
            System.err.println("Error opening file.");
            return false;
        }
        for(int i = 0; i < employees.lengthIs(); i ++)
        {
            try{
                output.writeObject(employees.getItem(i));
            }
            catch(IOException IOE)
            {
                error = true;
                try{
                    output.close();
                }catch(IOException ex)
                {
                    System.err.println("Error closing file");
                }
                break;
            }
        }
        try{
            output.close();

        }catch(IOException ex)
        {
            System.err.println("Error closing file");
        }

        while(!vacationRequests.isEmpty()){
            Employee employeeTmp = vacationRequests.dequeue();
            int empNum = employeeTmp.getEmployeeNumber();
            output2.format("%d\n", empNum);
            //System.out.println(empNum);
        }
        output2.flush();
        output2.close();

        return !error;
    }
    
    //Method Name     :processUpdates
    //Parameters      :fileName:String
    //Return Value(s) :boolean true or false
    //Partners        :None
    //Description     :Given the name of a text file it will attempt to read in the values. Employee numbers being ints
    //                and doubles for the amount for the changes being made to the employee. If they are either negative or int he wrong order
    //               it will skip that set and try to find the next set of numbers.


    public boolean processUpdates( String fileName )
    {
        Scanner input;
        try
        {
            input = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException ex){
            System.err.println("File not found.");
            return false;
        }
        while(input.hasNext())
        {
            if(input.hasNextInt())
            {
                int empNum = input.nextInt();
                double amount = input.nextDouble();
                if( amount > 0 ){
                    int index = getIndex(empNum);
                    if( index != -1 )
                    {
                        if(employees.getItem(index) instanceof HourlyEmployee){
                            increaseHours(index, amount);
                        }
                        else if(employees.getItem(index) instanceof CommissionEmployee)
                        {
                            increaseSales(index, amount);
                        }
                    }
                }
            }
            else
            {
                input.next();
                input.next();
            }

        }  
        input.close();
        return true;
    }




}

