
public class Test {

	public static void seq(int num)
	{
		long number = num;
		while(number > 1)
		{
			if(number % 2 == 0)
			{
				number /= 2;
			}
			else
			{
				number = number * 3 + 1;
			}
			System.out.println(number);
		}
			
	}
	
	public static void main(String args[])
	{
		seq(837799);
		
	}
	
}
