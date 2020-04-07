/*
 * Created by: Romy I. Chu III
 * Created on: 7-April-2020
 * Created for: ICS4U
 * Day #25 (Using Recursion)
 * This program ... Takes a string and reverses it (Writes it out backwards)
*/

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Day25_UsingRecursion {
	private JFrame frmDay25;			// The application window.
	private JTextField txtInput;		// The input text field.
	private JLabel lblReversedString;	// The output label.
	
	// This was Automatically Generated...
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Day25_UsingRecursion window = new Day25_UsingRecursion();
					window.frmDay25.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// This was Automatically Generated...
	public Day25_UsingRecursion() { initialize(); }
	
	// This was Automatically Generated...
	private void initialize() {
		// These were auto-generated.
		frmDay25 = new JFrame();
		frmDay25.setTitle("Day #25 (Using Recursion)");
		frmDay25.setBounds(100, 100, 450, 175);
		frmDay25.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDay25.getContentPane().setLayout(null);
		
		JLabel lblEnterString = new JLabel("Enter a String to be reversed :");
		lblEnterString.setBounds(10, 11, 224, 14);
		frmDay25.getContentPane().add(lblEnterString);
		
		lblReversedString = new JLabel("Reversed String : ");
		lblReversedString.setBounds(10, 110, 414, 14);
		frmDay25.getContentPane().add(lblReversedString);
		
		txtInput = new JTextField();
		txtInput.setBounds(10, 34, 414, 31);
		frmDay25.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		JButton btnReverseString = new JButton("Reverse String");
		btnReverseString.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblReversedString.setText("Reversed String : ");	// This resets the output label.
				ReverseString(txtInput.getText());					// Calls the reverse string function passing the input text as an argument.
				txtInput.setText("");								// Resets the input text field.
			}
		});
		btnReverseString.setBounds(10, 76, 140, 23);
		frmDay25.getContentPane().add(btnReverseString);
	}
	
	// This function reverses the input text.
	public void ReverseString(String inputString) {
		String inputSubString;		// This is a substring of the input text (will be all but the last character).
		Character lastChar;			// This is the last character from the input string.
		
		// If the string isn't blank...
		if(inputString.length() > 0) {
			inputSubString = inputString.substring(0, inputString.length() - 1); // Get the entire string except the last character.
			lastChar = inputString.charAt(inputString.length() - 1);			 // Get the last character from the input string.
			lblReversedString.setText(lblReversedString.getText() + lastChar);	 // Print the last character.
			ReverseString(inputSubString);										 // Call the reverse string function again, passing the substring instead.
		}
	}
}
