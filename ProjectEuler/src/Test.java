import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Stack;


public class Test {

	public static String convert(int deci, int scale)
	{
		Stack<Character> sta = new Stack<Character>();
		while(deci != 0)
		{
			sta.push((char)((deci % scale) + 48) );
			deci /= scale;
		}
		StringBuffer sb = new StringBuffer();
		while(!sta.isEmpty())
		{
			sb.append(sta.pop());
		}
		return sb.toString();
	}
	
	public static int Convert(String str, int scale)
	{
		int exp = 1;
		int num = 0;
		for(int i = str.length()-1; i >= 0; i--)
		{
			num += ((int) str.charAt(i) - 48) * exp;
			exp *= scale;
		}
		return num;
	}
	
	public static void main(String args[])
	{
//		for(int i = 1; i < 1000; i++)
//		{
//			System.out.print(i + "\t\t");
//			for(int j = 2; j <= 9; j++)
//			{
//				System.out.print(convert(i,j) + "\t\t");
//			}
//			System.out.println();
//		}
		String str = "0";
		int nums[] = new int[10];
		for(int i = 0; i <= 9; i++)
		{
//			str = (i - 1) + str;
			System.out.println(nums[i]);
		}
	}
	
}
