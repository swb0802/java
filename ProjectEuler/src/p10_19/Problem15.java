/* Lattice paths
 * Starting in the top left corner of a 2��2 grid, 
 * and only being able to move to the right and down, 
 * there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20��20 grid?
 * */

package p10_19;

public class Problem15 {

	public static long calc(int x, int y)
	{
		if(x == 1 || y == 1)
		{
			return 1;
		}
		else if(x == y)
		{
			return 2 * calc(x-1, y);
		}
		else 
		{
			return calc(x-1, y) + calc(x, y-1);
		}
	}
	
	public static void main(String args[])
	{
		System.out.println(calc(21,21));
	}
	
}
