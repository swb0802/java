import java.util.Arrays;


public class Main {

	private static String knight = "Then, when you have found the shrubbery, " +
			"you must cut down the mightiest tree int the forest... with... a herring!";
	
	public static void main(String args[])
	{
		int n = 0;
		int sum = 0;
		for(n = 1; n < 100; n++)
		{
			sum = 0;
			for(int i = 1; i <= n; i++)
			{
				if(2*i <= n)
				{
					for(int j=2*i; j<=n; j++)
					{
						sum++;
					}
				}
			}
			System.out.println("n=" + n + "sum=" + sum);
		}
	}
	
	public static void split(String regex)
	{
		System.out.println(Arrays.toString(knight.split(regex)));
	}
}
