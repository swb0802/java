/* Non-abundant sums
 * A perfect number is a number for which the sum of its proper divisors 
 * is exactly equal to the number. For example, the sum of the proper divisors
 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n 
 * and it is called abundant if this sum exceeds n.
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number 
 * that can be written as the sum of two abundant numbers is 24. By mathematical analysis, 
 * it can be shown that all integers greater than 28123 can be written as the sum of two 
 * abundant numbers. However, this upper limit cannot be reduced any further by analysis 
 * even though it is known that the greatest number that cannot be expressed as the sum of 
 * two abundant numbers is less than this limit.
 * Find the sum of all the positive integers which cannot be written as the sum of 
 * two abundant numbers.
 * */
package p20_29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem23 {

	//find all abundant numbers no greater than 28123 
	public static List<Integer> abundantNum()
	{
		int sum = 0;
		int sqr = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 12; i <= 28123; i++)
		{
			sum = 1;
			sqr = (int) Math.sqrt(i);
			for(int j = 2; j <= sqr; j++)
			{
				if(i % j == 0)
				{
					sum += ( i / j + j);
				}
			}
			if(sqr * sqr == i)
			{
				sum -= sqr;
			}
			if(sum > i)
			{
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String args[])
	{
		int sum = 0;
		boolean flag = false;
		List<Integer> list = abundantNum();
		Set<Integer> set = new HashSet<Integer>();
		
//		System.out.println(list);
		for(int i = 0; i < list.size(); i++)
		{
			set.add(list.get(i));
		}
		
		for(int i = 1; i <= 28123; i++)
		{
			int j = 0;
			flag = false;
			while(j < list.size() && list.get(j) < i)
			{
				if(set.contains(i - list.get(j)))
				{
					flag = true;
					break;
				}				
				j++;
			}
			if(!flag)
			{
//				System.out.print(i + " ");
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
	
}
