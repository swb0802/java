package p1_9;
/* Special Pathagorean triplet
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, 
 * for which,a^2 + b^2 = c^2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * */
public class Problem9 {

	public static boolean isTriplet(int a, int b, int c)
	{
		int aa = a * a;
		int bb = b * b;
		int cc = c * c;
		if(aa + bb == cc ||	aa + cc == bb ||
				bb + cc == aa)
		{
			return true;
		}
		return false;
			
	}
	
	public static void main(String args[])
	{
		int x1 = 0, x2 = 0, x3 = 0;
//		int sx1 = 0 , sx2 = 0, sx3 = 0;
		for(x1 = 1; x1 <= 998; x1++)
		{
			for(x2 = x1; x2 <= 998; x2++)
			{
				x3 = 1000 - x1 - x2;
				if(x3 < 0)
				{
					break;
				}
				if(isTriplet(x1, x2, x3))
				{
					System.out.println(x1 * x2 * x3);
					System.exit(0);
				}
			}
		}
	}
	
}
