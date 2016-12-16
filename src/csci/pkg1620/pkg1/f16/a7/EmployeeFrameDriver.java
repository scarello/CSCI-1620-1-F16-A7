/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

// This is provied by Patrick Cavanaugh
// 
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