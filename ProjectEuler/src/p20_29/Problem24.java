package p20_29;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem24 {

	public static int fac(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		else
		{
			return fac(n - 1) * n;
		}
	}
	
	public static void main(String args[])
	{
		System.out.println(fac(10));
		final int N = 10;
		LinkedList<Character> list = new LinkedList<Character>();
		for(int i = 0; i < N; i++)
		{
			list.add((char)(i + '0'));
		}
		System.out.println(list);
		int num = fac(N);
		int sum = 0;
		String str = "";
		for(int i = 0; i < N - 1; i++)
		{
			num /= (N - i);
			int j = 0;
			while(sum <= 1000000)
			{
				j++;
				sum += num;
			}

			sum -= num;
			str += list.get(j-1);
			list.remove(j-1);
		}
		str += list.get(0);
		System.out.println(str);
		//2783915604
	}
	
}
