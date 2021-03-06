package p1_9;
import java.util.LinkedList;
import java.util.Queue;


public class Problem5 {

	public static void main(String args[])
	{
		final int NO = 20;
		int arr[] = new int[NO];
		int factors = 1;
		int index;
		int multiple = 1;
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 0; i < NO; i++)
		{
			arr[i] = i + 1;
		}
		for(int i = 2; i < NO; i++)
		{
			//log the index of numbers which have common factor of i
			for(int j = 0; j < NO; j++)
			{
				if(arr[j] % i == 0)
				{
					que.add(j);
				}
			}
			//At least 2 numbers have common factor of i
			if(que.size() >= 2)
			{
				//for each of the numbers, divided by i
				while(!que.isEmpty())
				{
					index = que.poll();
					arr[index] = arr[index] / i;
				}
				factors *= i;
				i--;
			}
			que.clear();
		}
		multiple = factors;
		for(int i = 0; i < NO; i++)
		{
			multiple *= arr[i];
		}
		System.out.println(multiple);
	}
	
}
