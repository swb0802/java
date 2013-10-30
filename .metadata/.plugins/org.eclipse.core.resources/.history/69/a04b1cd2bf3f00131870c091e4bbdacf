/* Largest Palindrome product
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers 
 * is 9009 = 91 ¡Á 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * */

public class Problem4 {

	public static boolean isPalindrome(int num)
	{
		String str = String.valueOf(num);
		int size = str.length() / 2 - 1;
		boolean flag = true;
		for(int i = 0; i <= size; i++)
		{
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
			{
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String args[])
	{
		int biggest = 0;
		int product = 0;
		for(int i = 100; i <= 999; i++)
		{
			for(int j = 100; j<= 999; j++)
			{
				product = i * j;
				if(product > biggest && isPalindrome(product))
				{
					biggest = product;
				}
			}
		}
		System.out.println(biggest);
	}
	
}
