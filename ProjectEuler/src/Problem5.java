import java.util.LinkedList;
import java.util.Queue;


public class Problem5 {

	public static void main(String args[])
	{
		int arr[] = new int[20];
		int factors = 1;
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 0; i < 20; i++)
		{
			arr[i] = i;
		}
		for(int i = 2; i < 20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				if(arr[j] % i == 0)
				{
					que.add(j);
				}
			}
			if(que.size() >= 2)
			{
				while(!que.isEmpty())
				{
					arr[]
				}
			}
		}
	}
	
}