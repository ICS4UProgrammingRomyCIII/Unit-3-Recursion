/*
 * Created by: Romy I. Chu III
 * Created on: 7-April-2020
 * Created for: ICS4U
 * Day #25 (Towers of Hanoi)
 * This program ... Solves the Towers of Hanoi game for you (given the number of disks).
*/

import java.util.Scanner;
public class Day28_TowersOfHanoi {
	static Scanner sc = new Scanner(System.in); // Used to scan for user input.
	public static void main(String[] args) {
		while(true) {
			try {
				System.out.println("How many pegs are in the tower?");	// Asks the user to input the number of disks.
				int n = Integer.parseInt(sc.nextLine());				// Scan the next line for the user input and try to parse it as an int.
				// A, B, and C are just the names of the pins (This will treat A as the source, B as the target, and C as the extra pin).
				towerOfHanoi(n,'A', 'B', 'C');							// Call the tower of hanoi function with the number of disks as an argument.
				// Catches an exception when it happens
			} catch (Exception exc) { System.out.println("Please input ONLY integers!!"); }
		}
	}
	
	// This function recursively solves the Towers of Hanoi problem.
    static void towerOfHanoi(int n, char sourceRod, char targetRod, char extraRod)  { 
        if(n == 1) { System.out.println("Move disk 1 : " +  sourceRod + " >>>> " + targetRod); } 	// When it reaches disk 1, move it to the target rod
        else { 																					 	// Otherwise...
            towerOfHanoi(n - 1, sourceRod, extraRod, targetRod); 									// Move the disk from the source rod to the extra rod.
            System.out.println(String.format("Move disk %d : %c >>>> %c", n, sourceRod, targetRod));// Print the move.
            towerOfHanoi(n - 1, extraRod, targetRod, sourceRod); 									// Move the disk back to the target rod from the extra rod.
        }
    } 
}
