package p10_19;

public class Problem12_2 {

	private static final  int PRIMECOUNT = 1000; 
	private static int[] primeArr = new int[PRIMECOUNT];
	
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
	
	private static void calcPrimeArr()
	{
		int primeCount = 0;
		for(int i = 1; primeCount < PRIMECOUNT; i++)
		{
			if(isPrime(i))
			{
				primeArr[primeCount] = i;
				primeCount++;
			}
		}
	}
	
	public static int divisorCount(int num)
	{
		if(num == 0)
		{
			return 0;
		}
		int divCount = 1;
		int exp = 0;
		for(int i = 0; i < PRIMECOUNT; i++)
		{
			exp = 0;
			if(num == 1)
			{
				break;
			}
			while(num % primeArr[i] == 0)
			{
				num /= primeArr[i];
				exp++;
			}
			divCount *= (exp + 1);
		}
		if(num == 1)
		{
			return divCount;
		}
		else
		{
			return -1;
		}
	}
	
	public static void main(String args[])
	{
		calcPrimeArr();
		int divCount = 0;
		int Dn = 1, Dn1 = 0;
		int i;
		for(i = 2; divCount <= 500; i++)
		{
			if(i % 2 == 0)
			{
				Dn1 = divisorCount(i / 2);
			}
			else
			{
				Dn1 = divisorCount(i);
			}
			divCount = Dn * Dn1;
			Dn = Dn1;
		}
		System.out.println((i - 1) * (i - 2) / 2);
	}
}
