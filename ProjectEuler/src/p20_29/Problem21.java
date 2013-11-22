/* Amicable numbers
 * Let d(n) be defined as the sum of proper divisors of n 
 * (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ¡Ù b, then a and b 
 * are an amicable pair and each of a and b are called 
 * amicable numbers.
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 
 * 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; 
 * so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under 10000.
 * */

package p20_29;

import java.util.HashMap;
import java.util.Iterator;

public class Problem21 {
	
	public static int sumOfPD(int num)
	{
		int sum = 1;
		int len = (int) Math.sqrt(num);
		for(int i = 2; i <= len; i++)
		{
			if(num % i == 0)
			{
				sum += num / i + i;
			}
		}
		if(num % len == 0)
		{
			sum -= len;
		}
		return sum;
	}
	
	public static void main(String args[])
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int key = 0;
		int value = 0;
		for(int i = 1; i <= 10000; i++)
		{
			map.put(i, sumOfPD(i));
		}
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext())
		{
			key = iter.next();
			value = map.get(key);
			if(map.get(value) != null && map.get(value) == key && key != value)
			{
				System.out.println(key + "\t" + value);
				sum += key;
			}
		}
		System.out.println(sum);
	}

}
