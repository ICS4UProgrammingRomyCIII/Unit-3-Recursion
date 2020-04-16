/*
 * Created by: Romy I. Chu III
 * Created on: 16-April-2020
 * Created for: ICS4U
 * Day #29 (Magic Squares)
 * This program ... Creates a magic square (where the sum of the numbers in each row column, or diagonal is equal to N * [(N * N + 1) / 2] where N is the side length of the square.
*/

import java.util.*;
public class Day29_MagicSquares {
	static Random rn = new Random(); 							// Used to generate random integer arrays.
	static Scanner sc = new Scanner(System.in);					// Used to get user input.
	static List<int[][]> listOfSqurs = new ArrayList<int[][]>();// Used to store the Magic Squares.
	static int N = 0;											// Used to determine the size of the magic square.

	public static void main(String[] args) {
		int numSquares = 0; // To determine how many squares the user wants generated.
		while(N <= 0) { // While magic square size is invalid...
			try {
				System.out.println("How large do you want the magic square? (Odd integers only!)");					// Ask the user for the MS size.
				N = Integer.parseInt(sc.nextLine());																// Try to parse it as an int.
				if (N % 2 == 0) {  System.out.println("That Number is EVEN!!! ODD integers ONLY!!"); N = 0; }		// Check if the number is even or odd.
			} catch(Exception exc) { System.out.println("You have entered an invalid number!! Only Itegers!!"); }	// If the user inputed an invalid number, tell them.
		}
		while(numSquares <= 0) { // While the number of squares to generate is invalid...
			try {
				System.out.println("How many squares do you want to generate?(Note putting a high number, like 200, may result in duplicates)"); // Ask the users for the number of square to generate.
				numSquares = Integer.parseInt(sc.nextLine());																					 // Try to parse the line as an int.
			} catch(Exception exc) { System.out.println("You have entered an invalid number!! Only Itegers!!"); }								 // If the user inputed an invalid number, tell them.
		}
		
		// This for loop will generate 'numSquares' amount of magic squares.
		for(int t = 0; t < numSquares; t++) {
			int[][] temp = Generate_Random_Array(); 							// Create a random array.
			while(!isMagicSquare(temp)) { temp = Generate_Random_Array(); }		// While the array ISN'T a magic square... Generate a new array.
			if(listOfSqurs.contains(temp) == false){ listOfSqurs.add(temp); }	// If that array hasn't already been created... add it to the list of magic squares.
		}
		
		// For every 2D array in the list of squares...
		System.out.println(); System.out.println(); // Added so the text doesn't look super compressed and messy.
		// Tell the user the specs of the magic square.
		String out = String.format("The sum of each row, column, and diagonal for a %d x %d Magic Square is : %d", N, N, N * ((N * N + 1) / 2));
		System.out.println(out);
		
		for(int[][] arr : listOfSqurs) {
			for(int i = 0; i < arr.length; i++) {		// For every row in the array...
				for(int j = 0; j < arr.length; j++) {		// For every column in the row...
					System.out.print(arr[i][j] + " ");			// Print the value of the square...
				}
				System.out.println();		// After each row start on a new line.
			}
			System.out.println();			// When the whole square is complete, add another line break.
		}
	}
	
	// This function will return a filled 2D array.
	static int[][] Generate_Random_Array() {
		int values[][] = new int[N][N];					// Create a 2D array of N N.
	    for (int i = 0; i < values.length; i++) {		// For every row...
	        for (int j = 0; j < values.length; j++) {	// For every column in the row...
	        	int temp = rn.nextInt(N * N + 1);		// Generate a random number.
	        	while(inArray(temp, values)) {			// While that random number is already in the array...
	        		temp = rn.nextInt(N * N + 1);			// Generate a new random number.
	        	}
	        	values[i][j] = temp;					// Once a unique number has been found, Set that number to the current position in the array.
	        }
	    }
	    return values;	// Return the array.
	}
	// This checks if a given value is already contained in a given 2D array.
	static boolean inArray(int find, int[][] array){
		// For every position in the 2D array... Check if the given value is contained in any position.
	    for(int i = 0; i < N; i++){
	        for(int j = 0; j < N; j++){
	            if(array[i][j] == find) return true; // If the value is in that position, return true.
	        }
	    }
	    return false; // If the value cannot be found in the array, return false.
	}
	
	// This function checks if the array is a magic square.
	static boolean isMagicSquare(int arr[][]) { 
		int reqVal = N * ((N * N + 1) / 2); // Get the required value for the sum of the square.
        int dSum = 0, dSum2 = 0;  			// Create variables for the sum of the 2 diagonals.
        
        for (int i = 0; i < N; i++) { dSum += arr[i][i]; } 			// Get the dSum of the \ diagonal. Top Left to Bottom right.
        for (int i = 0; i < N; i++) { dSum2 += arr[i][N - 1 - i]; } // Get the dSum of the / diagonal. Bottom Left to Top Right.
        if(dSum != reqVal || dSum2 != reqVal) { return false; } 	// If either diagonal doesn't equal the required value, then return false.

        // For every row...
        for (int i = 0; i < N; i++) { 
        	int rowSum = 0;										 // Reset the row sum.
            for (int j = 0; j < N; j++) { rowSum += arr[i][j]; } // Get the sum of a row...
            if (rowSum != dSum) { return false; }				 // Check if the row is equal to the required value.
        } 
        // For sums of Columns 
        for (int i = 0; i < N; i++) { 
            int colSum = 0; 									 // Reset the column sum.
            for (int j = 0; j < N; j++) { colSum += arr[j][i]; } // Get the sum of a column...
            if (dSum != colSum) { return false; }				 // Check if the column is equal to the required value.
        } 
        
        return true; // If all values equal the required value... return true.
    } 
}
