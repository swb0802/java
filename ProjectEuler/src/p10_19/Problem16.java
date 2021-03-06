/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 * */

package p10_19;

public class Problem16 {

	public static String dob(String str)
	{
		//int length = str.length();
		int reg = 0;
		int prod = 0;
		StringBuffer sb = new StringBuffer();
		for(int i = str.length() - 1; i >= 0; i--)
		{
			prod = (str.charAt(i) - '0') * 2;
			prod += reg;
			sb.insert(0, "" + prod % 10);
			prod /= 10;
			reg = prod;
		}
		while(reg != 0)
		{
			sb.insert(0, "" + reg % 10);
			reg /= 10;
		}
		return sb.toString();
	}
	
	public static int calcSum(String str)
	{
		int sum = 0;
		for(int i = 0; i < str.length(); i++)
		{
			sum += str.charAt(i) - '0';
		}
		return sum;
	}
	
	public static void main(String args[])
	{
		String str = "2";
		for(int i = 1; i < 1000; i++)
		{
			str = dob(str);
		}
		System.out.println(calcSum(str));
		
	}
}
