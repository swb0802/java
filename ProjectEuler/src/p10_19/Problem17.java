/*
 * If the numbers 1 to 5 are written out in words: 
 * one, two, three, four, five, then there are 
 * 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand inclusive)
 *  were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 
 * 342 (three hundred and forty-two) contains 23 letters and 
 * 115 (one hundred and fifteen) contains 20 letters. 
 * The use of "and" when writing out numbers is in compliance 
 * with British usage.
 * */

/*
 * one two three four five six seven eight nine ten
 * eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty
 * thirty forty fifty sixty seventy eighty ninety hundred thousand
 * */

package p10_19;

public class Problem17 {
	
	private static int[] tens = {3, 6, 6, 5, 5, 5, 7, 6, 6};
	private static int[] beforeTwenty = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3,
			6, 6, 8, 8, 7, 7, 9, 8, 8, 6};
	
	public static void main(String args[])
	{
		int r = 0;
		int num = 0;
		int count = 0;
		boolean flag = false;
		for(int i = 1; i < 1000; i++)
		{
			num = i;
			flag = false;
			// dealing with the hundreds place
			r = num / 100;
			if(r != 0)
			{
				count += (7 + beforeTwenty[r - 1]);
				flag = true;
			}
			
			// dealing with the tens and the unit place
			num = num % 100;
			//r = num / 10;
			if(num != 0)
			{
				if(num <= 20)
				{
					count += beforeTwenty[num - 1];
				}
				else if(num % 10 == 0)
				{
					count += tens[num / 10 - 1];
				}
				else
				{
					count += tens[num / 10 - 1] + beforeTwenty[num % 10 - 1];
				}
				
				if(flag)
				{
					count += 3; // "and"
				}
			}
		}
		count += 11;
		System.out.println(count);
	}
	
}
