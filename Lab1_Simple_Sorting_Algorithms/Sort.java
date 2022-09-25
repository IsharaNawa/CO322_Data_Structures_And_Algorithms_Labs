/**
 * Simple sorting algorithms and their performance 
 * Reg: E/17/219
 *
 */

import java.util.*; 
import java.util.Scanner;

public class Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the soring worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/
    static void buble_sort(int [] data)  {
	// Implement 
    	
    	boolean quit=false;
    	for(int i=0;i<data.length && !quit;i++) {
    		quit = true;
    		for(int j = data.length-1;j>i;j--) {
    			if(data[j]<data[j-1]) {
    				swap(data,j,j-1);
    				quit = false;
    			}
    		}
    	}	
    }

    static void selection_sort(int [] data) {
	// Implement 
    	for(int i=0;i<data.length;i++) {
    		int minIndex=i;
    		for(int j=data.length-1;j>i;j--) {
    			if(data[minIndex]>data[j]) {
    				minIndex = j;
    			}
    		}
    		swap(data,i,minIndex);
    	}
    }

    static void insertion_sort(int [] array) {
	// Implement
    	int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key; 
        }
    }
    
    static void timer(int inputSize,String case_,String alg) {
    	
    	int myArray[] = null;
    	
    	if(case_=="best") {
    		myArray = create_best_data(inputSize);
    	}
    	else if(case_=="average") {
    		myArray = create_rand_data(inputSize);
    	}
    	else if(case_=="worst") {
    		myArray = create_worst_data(inputSize);
    	}
    	
    	long start = 0,finish = 0;
    	
    	if(alg=="bubble") {
    		start = System.nanoTime();
    		buble_sort(myArray);
    		finish = System.nanoTime();
    	}
    	else if(alg=="selection") {
    		start = System.nanoTime();
    		selection_sort(myArray);
    		finish = System.nanoTime();
    	}
    	else if(alg=="insertion"){
    		start = System.nanoTime();
    		insertion_sort(myArray);
    		finish = System.nanoTime();
    	}
    	
    	System.out.print("Time Taken to "+alg+" sorting for the "+case_+" case when input size is "+inputSize+":" );
    	System.out.println((finish-start)/1000);
    }
    

    

    public static void main(String [] args) {
	// create arrays of different size populate with data
	// measure the time taken by different algorithms to
	// sort the array.
	// Think about effects of caches, other apps running etc.
    	
    	while(true) {	
	    	Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
	    	System.out.print("Enter the input size(enter 0 to terminate): "); 
	    	int n= sc.nextInt();
	    	
	    	if(n==0) {
	    		break;
	    	}
	    	
	    	timer(n,"worst","bubble");
	    	timer(2*n,"worst","bubble");
	    	timer(3*n,"worst","bubble");	    	
	    	timer(4*n,"worst","bubble");	    	
	    	timer(5*n,"worst","bubble");	    	
	    	timer(6*n,"worst","bubble");
	    
	    	timer(n,"best","bubble");
	    	timer(2*n,"best","bubble");
	    	timer(3*n,"best","bubble");
	    	timer(4*n,"best","bubble");
	    	timer(5*n,"best","bubble");
	    	timer(6*n,"best","bubble");
	    	
	    	timer(n,"worst","selection");
	    	timer(2*n,"worst","selection");
	    	timer(3*n,"worst","selection");
	    	timer(4*n,"worst","selection");
	    	timer(5*n,"worst","selection");	
	    	timer(6*n,"worst","selection");
	    	
	    	timer(n,"best","selection");
	    	timer(2*n,"best","selection");
	    	timer(3*n,"best","selection");
	    	timer(4*n,"best","selection");
	    	timer(5*n,"best","selection");
	    	timer(6*n,"best","selection");
	    	
	    	timer(n,"worst","insertion");
	    	timer(2*n,"worst","insertion");
	    	timer(3*n,"worst","insertion");
	    	timer(4*n,"worst","insertion");
	    	timer(5*n,"worst","insertion");
	    	timer(6*n,"worst","insertion");
	    	
	    	timer(n,"best","insertion");
	    	timer(2*n,"best","insertion");
	    	timer(3*n,"best","insertion");
	    	timer(4*n,"best","insertion");
	    	timer(5*n,"best","insertion");
	    	timer(6*n,"best","insertion");
	    	
	    	
    	}
    }
}

