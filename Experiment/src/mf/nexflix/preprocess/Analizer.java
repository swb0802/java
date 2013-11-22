package mf.nexflix.preprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Analizer {

	//read through all ratings from training data set
	//generating movieId-ratingCount and userId(No.)-ratingCount files 
	public void analyze()
	{
		int[] userRC = new int[480189];
		int[] movieRC = new int[17770];
		int uidCount = 0;
		HashMap<Integer, Integer> uidMap = new HashMap<Integer, Integer>();
		
		String dir = "D:\\dataset\\nf_prize_dataset\\download\\training_set\\training_set";
		File directory = null;
		
		try {
			directory = new File(dir);
			File[] files = directory.listFiles();
			for(int i = 0; i < files.length; i++)
			{
				BufferedReader br = new BufferedReader(new FileReader(files[i]));
				System.out.println(files[i].getName());
				String str;
				String[] data;
				int uid, mid;
				str = br.readLine();
				mid = Integer.parseInt(str.substring(0, str.length() - 1));
				while((str = br.readLine()) != null)
				{
					data = str.split(",");
					uid = Integer.parseInt(data[0]);
//					rating = Integer.parseInt(data[1]);
					if(!uidMap.containsKey(uid))
					{
						uidMap.put(uid, uidCount++);
					}
					userRC[uidMap.get(uid)]++;
					movieRC[mid]++;
				}
				br.close();
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Start to write" + uidCount);
		try {
			File userFile = new File("D:\\dataset\\nf_prize_dataset\\user_RC");
			File movieFile = new File("D:\\dataset\\nf_prize_dataset\\movie_RC");
			BufferedWriter userBw = new BufferedWriter(new FileWriter(userFile));
			BufferedWriter movieBw = new BufferedWriter(new FileWriter(movieFile));
			for(int i = 0; i < userRC.length; i++)
			{
				userBw.write(i + "\t" + userRC[i] + "\n");
			}
			for(int i = 0; i < movieRC.length; i++)
			{
				movieBw.write(i + "\t" + movieRC[i] + "\n");
			}
			userBw.flush();
			movieBw.flush();
			userBw.close();
			movieBw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Analizer ana = new Analizer();
		ana.analyze();
	}
	
}
