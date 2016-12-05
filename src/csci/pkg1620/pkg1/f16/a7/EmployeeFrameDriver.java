/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci.pkg1620.pkg1.f16.a7;
import javax.swing.JFrame;


public class EmployeeFrameDriver {

	public static void main(String[] args)
	{
		EmployeeFrame employeeFrame = new EmployeeFrame();
		employeeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeeFrame.setSize(1200, 550);
		employeeFrame.setVisible(true);
	}

}