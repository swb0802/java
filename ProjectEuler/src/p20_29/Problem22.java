/* Names Scores
 * Using names.txt (right click and 'Save Link/Target As...'), 
 * a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. Then working out 
 * the alphabetical value for each name, multiply this value by 
 * its alphabetical position in the list to obtain a name score.
 * For example, when the list is sorted into alphabetical order, 
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th 
 * name in the list. So, COLIN would obtain a score of 
 * 938 ¡Á 53 = 49714.
 * What is the total of all the name scores in the file?
 * */

package p20_29;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

public class Problem22 {

	public static void main(String args[])
	{
		try {
			File file = new File("names.txt");
			FileInputStream fis = new FileInputStream(file);
			
			byte[] b = new byte[(int) file.length()];
			fis.read(b);
			String str = new String(b);
			String[] names = str.split("\",\"");
			int nameCount = names.length;
			int score = 0;
			int sumScore = 0;
			PriorityQueue<String> pQue = new PriorityQueue<String>();
			
			names[0] = names[0].substring(1);
			names[nameCount-1] = names[nameCount-1].substring(0,names[nameCount-1].length()-1);
			for(int i = 0; i < nameCount; i++)
			{
				pQue.add(names[i]);
			}
			int i = 1;
			while(!pQue.isEmpty())
			{
				str = pQue.poll();
				score = 0;
				for(int j = 0; j < str.length(); j++)
				{
					score += str.charAt(j) - 'A' + 1;
				}
				score *= (i);
				if(str.equals("COLIN"))
				{
					System.out.println(i);
					System.out.println(score);
				}
				sumScore += score;
				i++;
			}
//				str = names[i];
//				score = 0;
//				for(int j = 0; j < str.length(); j++)
//				{
//					score += str.charAt(j) - 'A' + 1;
//				}
//				score *= (i + 1);
//				if(str.equals("COLIN"))
//				{
//					System.out.println(i + 1);
//					System.out.println(score);
//				}
//				sumScore += score;
//			}
			System.out.println(sumScore);
//			System.out.println(names[0]);
//			System.out.println(names[names.length-1]);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
