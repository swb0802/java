package p1_9;

public class Problem3_2 {

	public static void main(String args[])
	{
		long num = 600851475143L;
		long sqr = (long) Math.sqrt(num);
		long prime = 0;
		while(num != 1)
		{
			for(long i = 2; i <= sqr; i++)
			{
				if(num % i == 0)
				{
					num = num / i;
					prime = i;
					break;
				}
			}
		}
		System.out.println(prime);
	}
	
}
