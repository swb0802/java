/* Factorial digit sum
 * n! means n ¡Á (n - 1) ¡Á ... ¡Á 3 ¡Á 2 ¡Á 1
 * For example, 10! = 10 ¡Á 9 ¡Á ... ¡Á 3 ¡Á 2 ¡Á 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 * */

package p20_29;

public class Problem20 {

	public static String plus(String a, String b)
	{
		StringBuffer sb = new StringBuffer();
		int sum = 0;
		int reg = 0;
		int i = a.length() - 1, j = b.length() - 1;
		for(; i >= 0 && j >= 0; i--, j--)
		{		
			sum = Integer.parseInt(a.charAt(i) + "") + 
					Integer.parseInt(b.charAt(j) + "") + reg;
			sb.insert(0, (sum % 10) + "");
			reg = sum / 10;
		}
		while(i != -1)
		{
			sum = Integer.parseInt(a.charAt(i) + "") + reg;
			sb.insert(0, (sum % 10) + "");
			reg = sum / 10;
			i--;
		}
		while(j != -1)
		{
			sum = Integer.parseInt(b.charAt(j) + "") + reg;
			sb.insert(0, (sum % 10) + "");
			reg = sum / 10;
			j--;
		}
		while(reg != 0)
		{
			sb.insert(0, (reg % 10) + "");
			reg /= 10;
		}
		return sb.toString();
	}
	
	public static String multiply(String a, String b)
	{
		int alen = a.length();
		int num = 0;
		int shift = 0;
		String tmpRes;
		String result = "0";
		for(int i = alen - 1; i >= 0; i--)
		{
			num = Integer.parseInt(a.charAt(i) + "");
			tmpRes = "0";
			for(int j = 0; j < num; j++)
			{
				tmpRes = plus(tmpRes, b);
			}
			shift = alen - i - 1;
			while(shift != 0)
			{
				tmpRes += "0";
				shift--;
			}
			result = plus(result, tmpRes);
		}
		return result; 
	}
	
	public static void main(String args[])
	{
		String str = "1";
		for(int i = 2; i <= 100; i++)
		{
			str = multiply(str, "" + i);
		}
		System.out.println(str);
		int sum = 0;
		for(int i = 0; i < str.length(); i++)
		{
			sum += Integer.parseInt(str.charAt(i) + "");
		}
		System.out.println(sum);
	}
	
}
