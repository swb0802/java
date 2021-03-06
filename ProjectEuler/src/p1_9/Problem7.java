package p1_9;
/* 10001st prime
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 * */
public class Problem7 {

	public static void main(String args[])
	{
		int primeCount = 1;
		int i;
		for(i = 3; primeCount < 10001; i+=2)
		{
			if(Problem3.isPrime(i))
			{
				primeCount++;
			}
		}
		System.out.println(i - 2);
	}
	
}
