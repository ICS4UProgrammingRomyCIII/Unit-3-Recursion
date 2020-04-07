/*
 * Created by: Romy I. Chu III
 * Created on: 7-April-2020
 * Created for: ICS4U
 * Day #27 (Binary Search Recursively)
 * This program ... Same binary search algorithm, but recursive instead on iterative.
*/

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class Day27_BinarySearchRecursively {
	private JFrame frmDay27;												// Application Window.
	private ArrayList<Integer> sortedList = new ArrayList<Integer>();		// List to store sorted values.

	// This was Automatically Generated...
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Day27_BinarySearchRecursively window = new Day27_BinarySearchRecursively();
					window.frmDay27.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// This was Automatically Generated...
	public Day27_BinarySearchRecursively() { initialize(); }

	// This was Automatically Generated...
	private void initialize() {
		// These were auto-generated.
		frmDay27 = new JFrame();
		frmDay27.setTitle("Day #27 (Binary Search Recursively)");
		frmDay27.setBounds(100, 100, 807, 340);
		frmDay27.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDay27.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 11, 493, 277);
		frmDay27.getContentPane().add(textArea);
		
		JLabel lblEnterNum = new JLabel("Enter a number to find in the list : ");
		lblEnterNum.setBounds(513, 86, 207, 14);
		frmDay27.getContentPane().add(lblEnterNum);
		
		JTextField txtNumToFind = new JTextField();
		txtNumToFind.setBounds(513, 101, 207, 20);
		frmDay27.getContentPane().add(txtNumToFind);
		txtNumToFind.setColumns(10);
		
		JLabel lblFoundAt = new JLabel("Your Number was found at index : ");
		lblFoundAt.setBounds(513, 167, 268, 14);
		frmDay27.getContentPane().add(lblFoundAt);
		
		JButton btnGenerateArray = new JButton("Generate Array");
		btnGenerateArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> list = new ArrayList<Integer>();			// Create a temporary list(unsorted).
				Random rd = new Random(); 									// Create a Random object for random integers.
				sortedList.clear();											// Reset the list.
				textArea.setText("");										// Reset the text area.
				for (int i = 0; i < 250; i++) {								// This for-loop generates 250 unique random integers.
					int num = rd.nextInt(1000);								// Generate a random integer.
					while(list.contains(num)) { num = rd.nextInt(1000); }	// If that integer exists in the list... Generate a new one.
					list.add(num);											// Add the unique integer to the list.
				}
				list.sort(null);											// Sort the list.
				for(int n : list) { sortedList.add(n); }					// Add the sorted values to the sorted list.
				for (int num : sortedList) { textArea.setText(String.format(textArea.getText() + ", [%d]", num)); }	//Print all values to the text area.
		}});
		btnGenerateArray.setBounds(513, 11, 163, 31);
		frmDay27.getContentPane().add(btnGenerateArray);
		
		JButton btnFindNum = new JButton("Find Num");
		btnFindNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFoundAt.setText("Your Number was found at index : ");							 // Resets the output text.
				int[] intArray = new int[sortedList.size()];										 // Create an array with the same size as the sorted list.
				for(int i = 0; i <= sortedList.size() - 1; i++) { intArray[i] = sortedList.get(i); } // Add all sorted values to the array.
				try {
					int key = Integer.parseInt(txtNumToFind.getText());								 // Try to parse the user's input key as an integer.
					int index = recursiveBinarySearch(intArray, 0, sortedList.size(), key);			 // Call the binary search function.
					// If nothing was found... Tell the user.
					if(index == -1) { JOptionPane.showMessageDialog(null, "Your number was not found in the list!", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE); }
					else { lblFoundAt.setText(lblFoundAt.getText() + index); }						 // Otherwise... Tell the user the index that their number could be found at.
				} catch (Exception exc) {
					// If an exception occurs, tell the user.
					JOptionPane.showMessageDialog(null, "Please only enter INTEGERS!!", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		btnFindNum.setBounds(513, 125, 163, 31);
		frmDay27.getContentPane().add(btnFindNum);
	}
	
	// This function recursively finds a number in a sorted array.
	public static int recursiveBinarySearch(int[] sortedArray, int left, int right, int key) {
        if (left < right) {																						// If the left most value is less than the right most value...
            int mid = left + (right - left) / 2;  																// Get the mid point.
            if (key < sortedArray[mid]) { return recursiveBinarySearch(sortedArray, left, mid - 1, key); } 			// If the key value is less than the value at the mid point... call the function again with the midpoint - 1 as the new night most value.
            else if (key > sortedArray[mid]) { return recursiveBinarySearch(sortedArray, mid + 1, right , key); } // If the key value is greater than the value at the mid point... call the function again with the midpoint + 1 as the new left most value.
            else { return mid; } // Otherwise (key ==  midpoint value)... return the midpoint value.
        }
        return -1;  // If nothing was found, return -1.
    }
}