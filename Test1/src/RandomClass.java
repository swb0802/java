import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Pair
{
	public Pair(String[] str)
	{
		no = str[0];
		name = str[1];
	}
	
	String no;
	String name;
	public String toString()
	{
		return no + "\t" + name;
	}
}

public class RandomClass {

	public static List<Pair> load(String fileName)
	{
		List<Pair> nameList = null;
		Pair p = null;
		BufferedReader br = null;
		String line = null;
		
		
		try {
			nameList = new ArrayList<Pair> ();
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			while((line = br.readLine())!=null)
			{
				p = new Pair(line.split("\t"));
				nameList.add(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nameList;
	}
	
	public static List<Pair> rand(String fileName)
	{
		List<Pair> nameList = load(fileName);
		Collections.shuffle(nameList);
		return nameList;
	}
	
	public static void main(String args[])
	{
		List<Pair> nameList = RandomClass.rand("D:\\name02.txt");
		//System.out.println(nameList);
		BufferedWriter bw1 = null;
		BufferedWriter bw2 = null;
		int lineCount = nameList.size();
		try {
			bw1 = new BufferedWriter(new FileWriter("D:\\name02_01.txt"));
			bw2 = new BufferedWriter(new FileWriter("D:\\name02_02.txt"));
			for(int i = 0; i < lineCount/2; i++)
			{
				bw1.write(nameList.get(i).toString());
				bw1.newLine();
			}
			for(int i = lineCount/2; i < lineCount; i++)
			{
				bw2.write(nameList.get(i).toString());
				bw2.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw1.flush();
				bw2.flush();
				bw1.close();
				bw2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
