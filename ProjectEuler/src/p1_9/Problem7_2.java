package p1_9;

public class Problem7_2 {

	//Comparing the alg in Problem3, this algorithm
	//will reduce the complexity slightly
	public static boolean isPrime(int num)
	{
		if(num <= 4)
		{
			if(num == 2 || num == 3)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		if(num % 2 == 0)
		{
			return false;
		}
		if(num % 3 == 0)
		{
			return false;
		}
		int sqrNum = (int) Math.sqrt(num);
		for(int i = 5; i <= sqrNum; i += 6)
		{
			if(num % i == 0 || num % (i + 2)==0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[])
	{
		int primeCount = 1;
		int i;
		for(i = 3; primeCount < 10001; i+=2)
		{
			if(isPrime(i))
			{
				primeCount++;
			}
		}
		System.out.println(i - 2);
	}
	
}
