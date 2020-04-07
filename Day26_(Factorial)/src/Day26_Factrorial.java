/*
 * Created by: Romy I. Chu III
 * Created on: 7-April-2020
 * Created for: ICS4U
 * Day #26 (Factorial)
 * This program ... Takes an integer and gets its factorial.
*/

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Day26_Factrorial {
	private JFrame frmDay26;		// Application window.
	private JTextField txtInput;	// Input text field.
	private JLabel lblFactorial;	// Output label.
	
	// This was Automatically Generated...
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Day26_Factrorial window = new Day26_Factrorial();
					window.frmDay26.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// This was Automatically Generated...
	public Day26_Factrorial() { initialize(); }
	
	// This was Automatically Generated...
	private void initialize() {
		// These were auto-generated.
		frmDay26 = new JFrame();
		frmDay26.setTitle("Day #26 (Factorial)");
		frmDay26.setBounds(100, 100, 338, 175);
		frmDay26.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDay26.getContentPane().setLayout(null);
		
		JLabel lblEnterNumber = new JLabel("Enter a number to get the factorial : ");
		lblEnterNumber.setBounds(10, 11, 224, 14);
		frmDay26.getContentPane().add(lblEnterNumber);
		
		lblFactorial = new JLabel("Factorial :");
		lblFactorial.setBounds(10, 110, 261, 14);
		frmDay26.getContentPane().add(lblFactorial);
		
		txtInput = new JTextField();
		txtInput.setBounds(10, 34, 208, 31);
		frmDay26.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnGetFactorial = new JButton("Get Factorial");
		btnGetFactorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFactorial.setText("Factorial : ");				// Resets the output label.
				try {												
					int n = Integer.parseInt(txtInput.getText());	// Try to parse the user input to a integer.
					int out = Factorial(n);							// Call the factorial function passing the user input as an argument.
					lblFactorial.setText("Factorial : " + out);		// Display the answer.
				} catch (Exception exc) {
					// If an exception occurs, it was because the user inputed a value that wasn't an integer... so tell them.
					JOptionPane.showMessageDialog(null, "Please only enter an Integer!!", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGetFactorial.setBounds(10, 76, 208, 23);
		frmDay26.getContentPane().add(btnGetFactorial);
	}
	
	// This function solves factorial recursively.
	public int Factorial(int inputNum) {		
		  if (inputNum <= 0) { return 1; }						// If the input number is 0 or less, return 1;
		  else { return(inputNum * Factorial(inputNum - 1)); }  // If it isn't 0. return the input number multiplied by the answer to the factorial of the input number - 1.
	}
}
