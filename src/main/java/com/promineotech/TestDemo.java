package com.promineotech;

import java.util.Random;

public class TestDemo {

	
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	

	 // My own method to test that multiplies two integers and returns the result.
     // @param a the first integer
     // @param b the second integer
     // @return the product of a and b
     

	public int multiply(int a, int b) {
		return a * b;
	}
	
	//Step 4 Mocking a Class
	// Returns the square of a random integer between 1 and 10.
    public int randomNumberSquared() {
        int result = getRandomInt();
        return result * result;
    }

    //Step 4
     // Generates a random integer between 1 and 10.
     // @return a random integer between 1 and 10
    
	 int getRandomInt() {
		 Random random = new Random();
	        return random.nextInt(10) + 1;
		
	}

}


