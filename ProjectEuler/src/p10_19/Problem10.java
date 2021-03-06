/* Summation of primes
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * */

package p10_19;

public class Problem10 {

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
		long sum = 0;
		for(int i = 2; i < 2000000; i++)
		{
			if(isPrime(i))
			{
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
//1179908154