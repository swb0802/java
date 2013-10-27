/* Largest prime factor
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * */
public class Problem3 {
	
	//judge if a number is prime
	public static boolean isPrime(long num)
	{
		if(num <= 1)
		{
			return false;
		}
		if(num == 2)
		{
			return true;
		}
		long sqr = (long) Math.sqrt(num);
		for(long i = 2; i <= sqr; i++)
		{
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[])
	{
		long num = 600851475143L;
		//num = (long) Math.sqrt(num);
		for(long i = num-1; i > 1; i--)
		{
			if(num % i == 0 && isPrime(i))
			{
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(num + "is prime");
	}
}
