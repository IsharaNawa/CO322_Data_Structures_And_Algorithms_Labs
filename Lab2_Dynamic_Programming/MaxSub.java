//Reg No:E17219
//Ishara Nawarathna

import java.util.Random;

class MaxSub { 

    static int MAX_NUM = 200; 
    static int start, end; 

    static int [] generate(int howmany) { 
	int [] data = new int[howmany]; 
	Random randomGenerator = new Random();
	for(int i=0; i<howmany; i++) 
	    data[i] = randomGenerator.nextInt(MAX_NUM) - (MAX_NUM/2); 
	return data; 
    }

    static void show(int []data, int s, int e) { 
	for(int i=s; i<e; i++) 
	    System.out.print(data[i] + " "); 
	System.out.println(); 
    }	


//finding max sub array with dynamic programming
    static int findMaxSub(int [] data) { 
        int [] temp = new int[data.length+1];		//delaring an array to store values temporarily
        temp[0] = 0;								//assinging the first index of the array as 0

        for (int j = 1; j <temp.length ; j++) {
            temp[j] = Math.max(temp[j-1]+data[j-1],data[j-1]);		//adding elements to temp
        }
        int maxVal = temp[0];						//gets the maximum
        for (int j = 1; j <temp.length ; j++) {		//finding the largest maxVal from the temp
            if(maxVal<temp[j])
                maxVal = temp[j];
        }

        return maxVal;
    }

static int findMaxSubDynamicWrap(int[] data) {
		// A wrapper for findMaxSubDynamic()
		return findMaxSubDynamic(data, 0, data.length - 1);
	}

	static int findMaxSubDynamic(int[] data, int start, int end) {
		// The Recursive approach
		int mid, max1, max2;

		// The base case
		if (start == end) {
			if (data[start] >= 0)			// Checks whether the integer is positive or zero
				return data[start];			// If so, this is a positive sum
			else
				return 0;					//  Else, there is no effect on the sum
		}

		// The recursive case
		mid = (start + end) / 2;
		max1 = Math.max(findMaxSubDynamic(data, start, mid), findMaxSubDynamic(data, mid + 1, end));
		max2 = Math.max(max1, getSubArraySum(data, start, mid, end));
		return max2;
	}

	static int getSubArraySum(int[] data, int start, int mid, int end) {
		// Returns the Summation of the values of the sub array
		int i, sum, left_portion, right_portion, max1, max2;

		// Analyses the Left portion of the dataset
		left_portion = Integer.MIN_VALUE;
		sum = 0;
		for (i = mid; i >= start; i--) {
			sum += data[i];
			if (sum > left_portion)
			{left_portion = sum;}
		}

		// Analyses the Right portion of the dataset
		right_portion = Integer.MIN_VALUE;
		sum = 0;
		for (i = mid + 1; i <= end; i++) {
			sum += data[i];
			if (sum > right_portion)
			{right_portion = sum;}
		}

		max1 = Math.max(left_portion, right_portion);
		max2 = Math.max(left_portion + right_portion, max1);
		return max2;
	}
	
    public static void main(String [] args) { 
	// try it with a known array first
	// then use a random array and see it works 
	
	int [] data = {1, 12, -129, 192, 2, 10, -19, 25, -200, 91, 10};
	findMaxSub(data);

	System.out.println("Max sum = " + findMaxSub(data)); 
	System.out.println("Max sum = " + findMaxSubDynamicWrap(data));

	data = generate(100); 
	System.out.println("Max sum = " + findMaxSub(data)); 
	
	

	
    }
}