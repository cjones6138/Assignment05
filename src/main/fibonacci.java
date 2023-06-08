package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class fibonacci {

//	Throws required in place of Try-Catch block
	public static void main(String[] args) throws IOException {
		
		Random rand = new Random();
		File myFile = new File("fibonacci_chart.txt");
		FileWriter myWriter = new FileWriter(myFile, true);
		
//		Check if file exists
//			Create file if does not exist, notify creation of file
//			Notify if file exists
		if (myFile.createNewFile()) {
			System.out.println("File created: " + myFile.getName());
		} else {
			System.out.println("File already exists.");
		}
		
		PrintWriter out = new PrintWriter(myWriter);
		
		// TODO: Why are start times always longer for the first method?
		
		int num = 0, i = 0;
		
		long startTime = 0, endTime = 0;
			
//		Loop through Recursive and Iterative methods 20 times
//			initiating random numbers for each loop iteration
//			each sequence per method call once per loop iteration:
//				capture time before method, 
//				execute recursive/iterative method,
//				capture end time, 
//				print value at number place, 
//				print to file
		for (i = 0; i < 20; i++) {
			
//			Generate random number 1 - 20
			num = rand.nextInt(20) + 1;
			
//			Recursive Fibonacci sequence: 
//				Capture start time
//				Call recursive method with number
//				Capture end time
//				Call print time method
			startTime = System.nanoTime();
			fibRecursive(num);
			endTime = System.nanoTime();
			System.out.println(fibRecursive(num));
			printTime(out, "Recursive", num, startTime, endTime);
			
//			Iterative Fibonacci sequence: 
//				Capture start time
//				Call iterative method with number
//				Capture end time
//				Call print time method		
			startTime = System.nanoTime();
			fibIterative(num);
			endTime = System.nanoTime();
			System.out.println(fibIterative(num));
			printTime(out, "Iterative", num, startTime, endTime);

//			Add blank line between number iterations
			out.write("\n");
		}
		
//		Close FileWriter and PrintWriter
		myWriter.close();
		out.close();
	}
	
//	Perform Fibonacci sequence through recursion
	static int fibRecursive(int n) {
		
//		if: 0 or 1 returns self
//		else: calls fibRecursive for two numbers before to return sum
//			will call back down the fibonacci sequence to 1
//			and return up the sequence to increase sum
//			returning final sum to method call withing main method
		if ((n == 0) || (n == 1))
			return n;
		else
			return fibRecursive(n - 1) + fibRecursive(n - 2);
	}
	
//	Perform Fibonacci sequence through iteration
	static int fibIterative(int n) {
		
//		Create array to loop through for Fibonacci summation
		int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
		int i;
		
//		Initiate first two elements of the array
		f[0] = 0;
		f[1] = 1;
		
//		Loop through array:
//			i variable starts at 2;
//			because the first two indexes of the array have been initialized
//			if n is a 0 or 1, the loop will not initiate
		for (i = 2; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
//		Returning the value in the n place:
//			if n is 0 or 1, they were initialized as such
//			if 2 or greater, the loop will result in sum at n place of array
		return f[n];
	}	

//	Call PrintWriter and primitive data types
//	Throws required in place of Try-Catch block
	static void printTime(PrintWriter out, String str, int num, long start, long end) throws IOException {
		out.write(str + " - X : " + num + ", Y : " + (end - start) + "\n");
	}

}