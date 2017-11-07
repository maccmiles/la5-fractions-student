package edu.wit.cs.comp1000;

public class LA5a {
	
	/**
	 * Error to output if either denominator is zero
	 */
	static final String E_DEN_ZERO = "Denominator cannot be zero.";
	
	/**
	 * Error to output if dividing by zero
	 */
	static final String E_DIV_ZERO = "Cannot divide by zero.";
	
	/**
	 * Error to output if the operation is invalid
	 */
	static final String E_OP_INVALID = "Invalid operation.";
	
	/**
	 * Returns the greatest common divisor (gcd) of two integers
	 * 
	 * @param num1 integer 1
	 * @param num2 integer 2
	 * @return gcd of integers 1 and 2
	 */
	public static int gcd(int num1, int num2) {
		int t;
		while (num2 != 0) {
			t = num2;
			num2 = num1 % num2;
			num1 = t;
		}
		
		return num1;
	}
	
	/**
	 * Returns the simplified form of a fraction
	 * 
	 * @param f fraction (numerator=[0], denominator=[1])
	 * @return simplified fraction (numerator=[0], denominator=[1])
	 */
	public static int[] simplifyFraction(int[] f) {
		final int gcd = gcd(f[0], f[1]);
		int[] result = {f[0]/gcd, f[1]/gcd};
		
		if ((result[0]<0 && result[1]<0) || (result[1]<0)) {
			result[0] = -result[0];
			result[1] = -result[1];
		}
		
		return result;
	}
	
	/**
	 * Adds two fractions
	 * 
	 * @param f1 first fraction (numerator=[0], denominator=[1])
	 * @param f2 second fraction (numerator=[0], denominator=[1])
	 * @return result of adding parameters (numerator=[0], denominator=[1])
	 */
	public static int[] addFractions(int[] f1, int[] f2) {
		int[] result = new int[2];
		result[0] = (f1[0] * f2[1]) + (f2[0] * f1[1]);
		result[1] = f1[1] * f2[1];
		
		return simplifyFraction(result);
	}
	
	/**
	 * Subtracts two fractions
	 * 
	 * @param f1 first fraction (numerator=[0], denominator=[1])
	 * @param f2 second fraction (numerator=[0], denominator=[1])
	 * @return result of subtracting parameter f2 from f1 (numerator=[0], denominator=[1])
	 */
	public static int[] subtractFractions(int[] f1, int[] f2) {
		return new int[2]; // TODO: replace with your code
	}
	
	/**
	 * Multiplies two fractions
	 * 
	 * @param f1 first fraction (numerator=[0], denominator=[1])
	 * @param f2 second fraction (numerator=[0], denominator=[1])
	 * @return result of multiplying parameters (numerator=[0], denominator=[1])
	 */
	public static int[] multiplyFractions(int[] f1, int[] f2) {
		return new int[2]; // TODO: replace with your code
	}
	
	/**
	 * Divides two fractions
	 * 
	 * @param f1 first fraction (numerator=[0], denominator=[1])
	 * @param f2 second fraction (numerator=[0], denominator=[1])
	 * @return result of dividing parameter f2 by f1 (numerator=[0], denominator=[1])
	 */
	public static int[] divideFractions(int[] f1, int[] f2) {
		return new int[2]; // TODO: replace with your code
	}

	public static void main(String[] args) {
		// TODO: write your code here
	}

}
