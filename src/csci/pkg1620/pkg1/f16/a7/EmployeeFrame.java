/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci.pkg1620.pkg1.f16.a7;

/**
 *
 * @author mikem
 */
import dataStructures.ArrayList;
import employeeType.employee.Employee;
import exceptions.InvalidCharacterException;
import exceptions.InvalidEmployeeNumberException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmployeeFrame extends JFrame
{
	private EmployeeManager em;
	
	//Components for Adding Employee
	private JComboBox<String> employeeTypeCombo;
	private JTextField firstField;
	private JTextField lastField;
	private JComboBox<Character> middleCombo;
	private JComboBox<Character> genderCombo;
	private JTextField employeeNumberField;
	private JRadioButton fullTimeRadio;
	private JRadioButton partTimeRadio;
	private JTextField amountField;
	private JButton addEmployeeButton;
	
	//Components for Remove Employee
	private JTextField employeeNumberRemoveField;
	private JButton removeButton;
	
	//Components for Updating Employee
	private JTextField employeeNumberUpdateField;
	private JTextField amountUpdateField;
	private JButton updateHourlyButton;
	private JButton updateCommissionButton;
	private JButton updateFromFileButton;
	
	//Components for Financial Options
	private JButton payoutButton;
	private JButton bonusButton;
	private JButton raisesButton;
	private JButton resetWeekButton;
	
	//Components for Vacation Request
	private JButton viewRequestButton;
	private JButton addRequestButton;
	private JButton grantRequestButton;
	
	//Management Panel
	private JButton sortPrintButton;
	private JButton printHourlyButton;
	private JButton printSalaryButton;
	private JButton printCommissionButton;
	private JButton findButton;
	private JButton exitButton;
	
	private JTextArea console;
	
	public EmployeeFrame()
	{
		super("Employee Manager");
		setLayout(new FlowLayout());
		
		//Create EmployeeManager
                em = new EmployeeManager();
		//Create ButtonHandler
		ButtonHandler handler = new ButtonHandler();
		//ADD EMPLOYEE PANEL
		JPanel addPanel = new JPanel();
                JLabel addLabel = new JLabel("Add Employee: ");
                addPanel.add(addLabel);
                addPanel.setLayout(new FlowLayout());
                addPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                String[] typeArray = { "Hourly", "Salary", "Commission" };
                employeeTypeCombo = new JComboBox(typeArray);
                addPanel.add(employeeTypeCombo);
                
                employeeNumberField = new JTextField("", 5);
                employeeNumberField.setText("Emp #");
                employeeNumberField.setForeground(Color.BLACK);
                addPanel.add(employeeNumberField);
                
                firstField = new JTextField("",15);
                firstField.setText("First");
                firstField.setForeground(Color.BLACK);
                addPanel.add(firstField);
                
                middleCombo = new JComboBox<>(createMiddleOptions());
                addPanel.add(middleCombo);
                
                lastField = new JTextField("",15);
                lastField.setText("Last");
                lastField.setForeground(Color.BLACK);
                addPanel.add(lastField);
                
                Character[] genderArray = { 'M', 'F' };
                genderCombo = new JComboBox<>(genderArray);
                addPanel.add(genderCombo);
                
                fullTimeRadio = new JRadioButton("Full");
                fullTimeRadio.setSelected(true);
                addPanel.add(fullTimeRadio);
                
                partTimeRadio = new JRadioButton("Part");
                addPanel.add(partTimeRadio);
                ButtonGroup group = new ButtonGroup(); 
                group.add(partTimeRadio); 
                group.add(fullTimeRadio);
                
                fullTimeRadio.isSelected();
                
                amountField = new JTextField("",10);
                amountField.setText("Wage/Salary/Rate");
                amountField.setForeground(Color.BLACK);
                addPanel.add(amountField);
                
                addEmployeeButton = new JButton("Add Employee");
                addPanel.add(addEmployeeButton);
                addEmployeeButton.addActionListener(handler);
                
                
                add(addPanel);
		//REMOVE EMPLOYEE PANEL
                JPanel removePanel = new JPanel();
                JLabel removeLabel = new JLabel("Remove Employee: ");
                removePanel.add(removeLabel);
                removePanel.setLayout(new FlowLayout());
                removePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                employeeNumberRemoveField = new JTextField("", 5);
                employeeNumberRemoveField.setText("Emp #");
                employeeNumberRemoveField.setForeground(Color.BLACK);
                removePanel.add(employeeNumberRemoveField);
                
                removeButton = new JButton("Remove Employee");
                removePanel.add(removeButton);
                
                removeButton.addActionListener(handler);
                
                add(removePanel);
                
		//UPDATE PANEL
		
                JPanel updatePanel = new JPanel();
                JLabel updateLabel = new JLabel("Update Employee: ");
                updatePanel.add(updateLabel);
                updatePanel.setLayout(new FlowLayout());
                updatePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                
                employeeNumberUpdateField = new JTextField("", 5);
                String employeeNumberUpdateFieldHintText = "Emp #";
                employeeNumberUpdateField.setText(employeeNumberUpdateFieldHintText);
                employeeNumberUpdateField.setForeground(Color.BLACK);
                updatePanel.add(employeeNumberUpdateField);
                
                amountUpdateField = new JTextField("", 10);
                amountUpdateField.setText("Hours/Sales");
                amountUpdateField.setForeground(Color.BLACK);
                updatePanel.add(amountUpdateField);
                
                updateHourlyButton = new JButton("Update Hourly Employee");
                updatePanel.add(updateHourlyButton);
                
                updateHourlyButton.addActionListener(handler);
                
                updateCommissionButton = new JButton("Update Commission Employee");
                updatePanel.add(updateCommissionButton);
                
                updateCommissionButton.addActionListener(handler);
                
                updateFromFileButton = new JButton("Update From File");
                updatePanel.add(updateFromFileButton);
                
                updateFromFileButton.addActionListener(handler);
                
                add(updatePanel);
                
                
                
		//FINANCIAL PANEL
                
                JPanel financialPanel = new JPanel();
                JLabel financialLabel = new JLabel("Financial Options: ");
                financialPanel.add(financialLabel);
                financialPanel.setLayout(new FlowLayout());
                financialPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                payoutButton = new JButton("Weekly Payout");
                financialPanel.add(payoutButton);
                
                payoutButton.addActionListener(handler);
                
                bonusButton = new JButton("Bonuses");
                financialPanel.add(bonusButton);
                
                bonusButton.addActionListener(handler);
                
                raisesButton = new JButton("Annual Raises");
                financialPanel.add(raisesButton);
                
                raisesButton.addActionListener(handler);
                
                resetWeekButton = new JButton("Reset Week");
                financialPanel.add(resetWeekButton);
                
                resetWeekButton.addActionListener(handler);
                
                add(financialPanel);

		//VACATION PANEL
                
                JPanel vacationPanel = new JPanel();
                JLabel vacationLabel = new JLabel("Vacation Queue: ");
                vacationPanel.add(vacationLabel);
                vacationPanel.setLayout(new FlowLayout());
                vacationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                viewRequestButton = new JButton("View Requests");
                vacationPanel.add(viewRequestButton);
                
                viewRequestButton.addActionListener(handler);
                
                addRequestButton = new JButton("Add Request");
                vacationPanel.add(addRequestButton);
                
                addRequestButton.addActionListener(handler);
                
                grantRequestButton = new JButton("Grant Request");
                vacationPanel.add(grantRequestButton);
                
                grantRequestButton.addActionListener(handler);
                
                add(vacationPanel);
		//CONSOLE PANEL
		JPanel consolePanel = new JPanel();
		consolePanel.setLayout(new FlowLayout());
		console = new JTextArea(20, 100);
		console.setEditable(false);
		JScrollPane consoleScrollPane = new JScrollPane(console);
		consolePanel.add(consoleScrollPane);
		add(consolePanel);
		
		//Management PANEL
                
                JPanel managePanel = new JPanel();
                JLabel manageLabel = new JLabel("Management: ");
                managePanel.add(manageLabel);
                managePanel.setLayout(new FlowLayout());
                managePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                sortPrintButton = new JButton("Sort and Print");
                managePanel.add(sortPrintButton);
                
                sortPrintButton.addActionListener(handler);
                
                printHourlyButton = new JButton("Print Hourly");
                managePanel.add(printHourlyButton);
                
                printHourlyButton.addActionListener(handler);
                
                printSalaryButton = new JButton("Print Salary");
                managePanel.add(printSalaryButton);
                
                printSalaryButton.addActionListener(handler);
                
                printCommissionButton = new JButton("Print Commission");
                managePanel.add(printCommissionButton);
                
                printCommissionButton.addActionListener(handler);
                
                findButton = new JButton("Find Employee");
                managePanel.add(findButton);
                
                findButton.addActionListener(handler);
                
                exitButton = new JButton("Save/Exit");
                managePanel.add(exitButton);
                
                exitButton.addActionListener(handler);
                add(managePanel);
                
		if(em.loadEmployees("employees.ser", "requests.dat"))
			console.append("Employees Loaded\n");
		else
			console.append("Employees Not Loaded\n");
	}
	
	private Character[] createMiddleOptions()
	{
		Character[] ret = new Character[26];
		for(int i = 0; i < 26; i++)
			ret[i] = (char)(i+65);
		
		return ret;
	}
	
	//inner class for ActionListener
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event)
		{
			//EVENT HANDLER CODE HERE
                    switch(event.getActionCommand()){
                        case "Add Employee":
                            String fn, ln;
                            int empNum, amount, employeeType;
                            char mi, g;
                            boolean ft = true;
                            
                            fn = firstField.getText();
                            ln = lastField.getText();
                            mi = (char) middleCombo.getSelectedItem();
                            g  = (char) genderCombo.getSelectedItem();
                            if(partTimeRadio.isSelected())
                                ft = false;
                            
                            employeeType = employeeTypeCombo.getSelectedIndex();
                            try{
                            empNum = Integer.parseInt(employeeNumberField.getText());
                            }catch(NumberFormatException E){
                                console.setText("Invalid Employee Number");
                                employeeNumberField.setText("Emp #");
                                firstField.setText("First");
                                lastField.setText("Last");
                                amountField.setText("Wage/Salary/Rate");
                                break;
                            }
                            try{
                            amount = Integer.parseInt(amountField.getText());
                            }catch(NumberFormatException E){
                                console.setText("Invalid Amount");
                                employeeNumberField.setText("Emp #");
                                firstField.setText("First");
                                lastField.setText("Last");
                                amountField.setText("Wage/Salary/Rate");
                                break;
                            }
     
                            try{
                                
                                console.setText(em.addEmployee(employeeType + 1, fn, ln, g, g, empNum, ft, amount));
                            }catch(InvalidEmployeeNumberException E){
                                console.setText("Invalid Employee Number Please Re-enter A New One");
                            
                            }
                            employeeNumberField.setText("Emp #");
                            firstField.setText("First");
                            lastField.setText("Last");
                            amountField.setText("Wage/Salary/Rate");
                            
                            break;
                            
                        case "Remove Employee":
                            int en;
                             try{
                            en = Integer.parseInt(employeeNumberRemoveField.getText());
                            }catch(NumberFormatException E){
                                console.setText("No Such Employee");
                                employeeNumberRemoveField.setText("Emp #");
                                
                                break;
                            }
                            int index = em.getIndex(en);
                            if(index == -1){
                                console.setText("No Such Employee");
                                employeeNumberRemoveField.setText("Emp #");
                            }
                            else{
                                em.removeEmployee(index);
                                console.setText("Employee " + en  + " Removed");
                            }
                            
                            break;
                        case "Update Hourly Employee":
                            try{
                            en = Integer.parseInt(employeeNumberUpdateField.getText());
                            }catch(NumberFormatException E){
                                console.setText("Invalid Employee Number");
                                employeeNumberUpdateField.setText("Emp #");
                                amountUpdateField.setText("Hours/Sales");
                                break;
                            }
                            
                             try{
                            amount = Integer.parseInt(amountUpdateField.getText());
                            
                            }catch(NumberFormatException E){
                                console.setText("Invalid Amount");
                                employeeNumberUpdateField.setText("Emp #");
                                amountUpdateField.setText("Hours/Sales");
                                break;
                            }
                             
                            index = em.getIndex(en);
                            if(index == -1){
                                console.setText("No Such Employee");
                                employeeNumberUpdateField.setText("Emp #");
                            }
                            else{
                                
                                if(em.increaseHours(index, amount))
                                    console.setText(en + " increased by " + amount + " hours");
                                else
                                    console.setText("Employee Not Hourly");
                                
                            }
                            
                            
                            
                            break;
                        case "Update Commission Employee":
                            try{
                            en = Integer.parseInt(employeeNumberUpdateField.getText());
                            }catch(NumberFormatException E){
                                console.setText("Invalid Employee Number");
                                employeeNumberUpdateField.setText("Emp #");
                                amountUpdateField.setText("Hours/Sales");
                                break;
                            }
                            
                             try{
                            amount = Integer.parseInt(amountUpdateField.getText());
                            
                            }catch(NumberFormatException E){
                                console.setText("Invalid Amount");
                                employeeNumberUpdateField.setText("Emp #");
                                amountUpdateField.setText("Hours/Sales");
                                break;
                            }
                             
                            index = em.getIndex(en);
                            if(index == -1){
                                console.setText("No Such Employee");
                                employeeNumberUpdateField.setText("Emp #");
                            }
                            else{
                                
                                if(em.increaseSales(index, amount))
                                    console.setText(en + " increased by " + amount + " sales");
                                else
                                    console.setText("Employee Not Commission");
                                
                            }
                            break;
                        case "Update From File":
                            JFileChooser fileChooser = new JFileChooser(new File("."));
				int fileRet = fileChooser.showOpenDialog(null);
	
				if(fileRet == JFileChooser.APPROVE_OPTION)
				{
					if(em.processUpdates(fileChooser.getSelectedFile().getAbsolutePath()))
					{
						console.setText("Updates Processed Successfully");
					}
					else
					{
						console.setText("Updates Not Processed");
					}
				}

                            break;
                        case "Weekly Payout":
                            console.setText("Total weekly pay out is " + String.format("%.2f", em.calculatePayout()) );
                            break;
                        case "Bonuses":
                            console.setText("Total holiday bonus is " + String.format("%.2f", em.holidayBonuses()));
                            break;
                        case "Annual Raises":
                            em.annualRaises();
                            console.setText("Annual Raises Applied");
                            break;
                        case "Reset Week":
                            em.resetWeek();
                            console.setText("Weekly values reset");
                            break;
                        case "View Requests":
                            console.setText(em.outputRequests());
                            if(!(em.viewNextRequest() == null))
                                console.append(em.viewNextRequest().toString() + "will receive next request");
                            
                            break;
                        case "Add Request":
                            String S = (String)JOptionPane.showInputDialog("Enter Employee Number");
                            int e;
                            try{
                                e = Integer.parseInt(S);
                                
                            }catch(NumberFormatException E){
                                console.setText("Invalid Employee Number");
                                break;
                            }
                            
                            if(em.addRequest(e))
                                console.setText("Employee " + e + " added to vacation queue");
                            else
                                console.setText("No Such Employee");
                            break;
                        case "Grant Request":
                           
                            if(!(em.viewNextRequest() == null))
                                console.setText(em.grantNextRequest().toString() + "granted vacation request");
                            
                            break;
                        case "Sort and Print":
                            em.sort();
                            console.setText(em.listAll());
                            
                            break;
                        case "Print Hourly":
                            console.setText(em.listHourly());
                            break;
                        case "Print Salary":
                            console.setText(em.listSalary());
                            break;
                        case "Print Commission":
                            console.setText(em.listCommission());
                            break;
                        case "Find Employee":
                            S = (String)JOptionPane.showInputDialog("Enter Search String");
                            if(S == null)
                                break;
                            
                            try{
                                 ArrayList<Employee> ea = em.findAllBySubstring(S);
                                 console.setText(ea.toString());
                            }catch(InvalidCharacterException E){
                                 console.setText("Invalid character found in search");
                                 break;
                            }
                              
                            break;
                        case "Save/Exit":
                            em.saveEmployees("employees.ser", "requests.dat");
                            System.exit(0);
                            break;
                            
                            
                    }
		}
        }
}