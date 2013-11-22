/*
 * The Fibonacci sequence is defined by the recurrence relation:
 * F(n) = F(n-1) + F(n-2), where F(1) = 1 and F(2) = 1.
 * The 12th term, F(12), is the first term to contain three digits.
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * */

package p20_29;

public class Problem25 {

	public static void main(String args[])
	{
		String num1 = "1";
		String num2 = "1";
		String sum = "";
		int i = 2;
		while(sum.length() < 1000)
		{
			sum = Problem20.plus(num1, num2);
			i++;
			num1 = num2;
			num2 = sum;
		}
		System.out.println(i);
		
	}
	
}
