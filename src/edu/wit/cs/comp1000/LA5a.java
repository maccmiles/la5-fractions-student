package edu.wit.cs.comp1000;
import java.util.Scanner;//import scanner
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
		int[] result = new int[2];
		result[0] = (f1[0] * f2[1]) - (f2[0] * f1[1]);
		result[1] = f1[1] * f2[1];
		
		return simplifyFraction(result);
	}
	
	/**
	 * Multiplies two fractions
	 * 
	 * @param f1 first fraction (numerator=[0], denominator=[1])
	 * @param f2 second fraction (numerator=[0], denominator=[1])
	 * @return result of multiplying parameters (numerator=[0], denominator=[1])
	 */
	public static int[] multiplyFractions(int[] f1, int[] f2) {
		int[] result = new int[2];
		result[0] = f1[0] * f2[0];
		result[1] = f1[1] * f2[1];
		
		return simplifyFraction(result);
	}
	
	/**
	 * Divides two fractions
	 * 
	 * @param f1 first fraction (numerator=[0], denominator=[1])
	 * @param f2 second fraction (numerator=[0], denominator=[1])
	 * @return result of dividing parameter f2 by f1 (numerator=[0], denominator=[1])
	 */
	public static int[] divideFractions(int[] f1, int[] f2) {
		int[] result = new int[2];
		result[0] = f1[0] * f2[1];
		result[1] = f1[1] * f2[0];
		
		return simplifyFraction(result);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//init scanner
		//VARS
		int[] f0 = new int[2];
		int[] f1 = new int[2];
		String sign = "";
		int[] ans = new int[2];
		/////
		//IN
		System.out.printf("Enter the numerator for the first fraction: ");
		f0[0] = input.nextInt();
		System.out.printf("Enter the denominator for the first fraction: ");
		f0[1] = input.nextInt();
		System.out.printf("Enter the numerator for the second fraction: ");
		f1[0] = input.nextInt();
		System.out.printf("Enter the denominator for the second fraction: ");
		f1[1] = input.nextInt();
		System.out.printf("Enter the operation (+, -, *, /): ");
		sign = input.next();
	     //////
	//Check zero
			if ((f0[1] == 0)||(f1[1] == 0)){System.out.printf("Denominator cannot be zero.%n");System.exit(0);}
		//////
		//Check Sign
		if (sign.equals("+")){//Add
			ans = addFractions(f0, f1);
		}else if (sign.equals("-")){//Sub
			ans = subtractFractions(f0, f1);
		}else if (sign.equals("*")){//Mul
			ans = multiplyFractions(f0, f1);
		}else if (sign.equals("/")){//Div
			if ((f0[1] == 0)||(f1[1] == 0)||(f1[0] == 0)){System.out.printf("Cannot divide by zero.%n");System.exit(0);}
			ans = divideFractions(f0, f1);
		}else {//Error in sign
			System.out.printf("Invalid operation.%n");
			System.exit(0);
		}
		if(ans[1] > 1) {//if denominator persists
		System.out.printf("%d/%d %s %d/%d = %d/%d%n", f0[0], f0[1], sign, f1[0], f1[1], ans[0], ans[1]);
		}else {
		System.out.printf("%d/%d %s %d/%d = %d%n", f0[0], f0[1], sign, f1[0], f1[1], ans[0]);
		}
		
	}

}
