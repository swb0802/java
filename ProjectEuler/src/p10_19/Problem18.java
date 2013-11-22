/*
 * By starting at the top of the triangle below and 
 * moving to adjacent numbers on the row below, 
 * the maximum total from top to bottom is 23.
	3
	7 4
	2 4 6
	8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * Find the maximum total from top to bottom of the triangle below:

	75
	95 64
	17 47 82
	18 35 87 10
	20 04 82 47 65
	19 01 23 75 03 34
	88 02 77 73 07 63 67
	99 65 04 28 06 16 70 92
	41 41 26 56 83 40 80 70 33
	41 48 72 33 47 32 37 16 94 29
	53 71 44 65 25 43 91 52 97 51 14
	70 11 33 28 77 73 17 78 39 68 17 57
	91 71 52 38 17 14 91 43 58 50 27 29 48
	63 66 04 68 89 53 67 30 73 16 69 87 40 31
	04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * */

package p10_19;

import java.util.Scanner;

public class Problem18 {

	public static void main(String args[])
	{
		final int LINES = 15;
		int weight[][] = new int[LINES][LINES];
		int lpath[][] = new int [LINES][LINES];
		int maxTotal = Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < LINES; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				weight[i][j] = sc.nextInt();
				
				if(i == 0 && j==0)
				{
					lpath[0][0] = weight[0][0];
				}
				else if(j == 0)
				{
					lpath[i][j] = lpath[i-1][j] + weight[i][j];
				}
				else if(j == i)
				{
					lpath[i][j] = lpath[i-1][j-1] + weight[i][j];
				}
				else
				{
					lpath[i][j] = (lpath[i-1][j] > lpath[i-1][j-1] ?
					lpath[i-1][j] : lpath[i-1][j-1]) + weight[i][j];
				}
//				System.out.print(lpath[i][j] + "\t");
			}
//			System.out.println();
		}
		for(int j = 0; j < LINES; j++)
		{
			if(lpath[LINES-1][j] > maxTotal)
			{
				maxTotal = lpath[LINES-1][j];
			}
		}
		System.out.println(maxTotal);
		sc.close();
	}
	
}
