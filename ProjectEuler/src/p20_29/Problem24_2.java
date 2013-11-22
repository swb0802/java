/*
 * A permutation is an ordered arrangement of objects. 
 * For example, 3124 is one possible permutation of the digits 
 * 1, 2, 3 and 4. If all of the permutations are listed numerically 
 * or alphabetically, we call it lexicographic order. 
 * The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation 
 * of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * */

package p20_29;

import java.util.LinkedList;

public class Problem24_2 {

	public static int fac(int num)
	{
		if(num == 1)
		{
			return 1;
		}
		else
		{
			return num * fac(num - 1);
		}
	}
	
	public static void main(String args[])
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		final int N = 10;
		for(int i = 0; i < N; i++)
		{
			list.add(i);
		}
		int num = 1000000;
		int div = fac(N) / N;
		int index = 0;
		StringBuffer sb = new StringBuffer();
		int i = N - 1;
		while(num != 1)
		{
			index = (num - 1) / div;
			sb.append(list.get(index));
			list.remove(index);
			num -= div * index;
			div /= i;
			i--;
		}
		while(list.size() != 0)
		{
			sb.append(list.get(0));
			list.remove(0);
		}
		System.out.println(sb);
		//2783915604
		//2783915460
	}
}
