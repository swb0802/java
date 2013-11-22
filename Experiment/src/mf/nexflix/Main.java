package mf.nexflix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

	static class Pair{
		public Pair(int uid, int mid)
		{
			this.uid = uid;
			this.mid = mid;
		}
		int uid;
		int mid;		
	}
	
	public static HashMap<Pair, Integer> load()
	{
		
		HashMap<Pair, Integer> map = new HashMap<Pair, Integer>(20000000);
		String dir = "D:\\dataset\\nf_prize_dataset\\download\\training_set\\training_set";
		File directory = null;
		
		try {
			directory = new File(dir);
			File[] files = directory.listFiles();
			for(int i = 0; i < 2000; i++)
			{
				BufferedReader br = new BufferedReader(new FileReader(files[i]));
				System.out.println(files[i].getName());
				String str;
				String[] data;
				int uid, mid, rating;
				str = br.readLine();
				mid = Integer.parseInt(str.substring(0, str.length() - 1));
				while((str = br.readLine()) != null)
				{
					data = str.split(",");
					uid = Integer.parseInt(data[0]);
					rating = Integer.parseInt(data[1]);
					map.put(new Pair(uid, mid), rating);
				}
				br.close();
			}
			System.out.println(map.size());
			
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
		
		return map;
	
	}
		
	public static void main(String args[])
	{
		int[] uids = new int[500000];
		final int K = 100;
		float uiserFactor[][];
		float movieFactor[][];
		HashMap<Pair, Integer> map = load();
		
	}	
}
