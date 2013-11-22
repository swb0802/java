import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Test {

	
	
	public static void main(String args[])
	{
		BufferedWriter bw = null;
		try {
			File file = new File("D:\\test.txt");
			bw = new BufferedWriter(new FileWriter(file, true));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {			
			bw.write("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		int i, j;
//		i = 10235;
//		j = 23934;
//		
//		System.out.println(i*j + i+j * i*i + j*j + (i-j) * (i - j) + i * i + i + j* j * j);
//		HashMap<Pair, Integer> map = new HashMap<Pair, Integer>(100);
//		Pair[] pArr = new Pair[10];
//		
//		pArr[0] = new Pair(1,2,0);
//		pArr[1] = new Pair(1,2,0);
//		pArr[2] = new Pair(1,2,0);
//		pArr[3] = new Pair(2,3,0);
//		pArr[4] = new Pair(2,3,0);
//		pArr[5] = new Pair(2,3,0);
//		pArr[6] = new Pair(2,3,1);
//		pArr[7] = new Pair(2,3,1);
//		pArr[8] = new Pair(1,2,20);
//		pArr[9] = new Pair(1,2,20);
//		
//		for(int i = 0; i < 10; i++)
//		{
//			map.put(pArr[i], i);
//		}
//
//		System.out.println(map.size());
//		for(int i = 0; i <= 10; i++)
//		{
//			System.out.print(map.containsKey(new Pair(1,2,i)) + "\t");
//			System.out.println(map.get(new Pair(1,2,i)));
//		}
		
		
//		Pair p1 = new Pair(1,2), p2 = new Pair(1,2);
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
//		System.out.println(p1.toString());
//		System.out.println(p2.toString());
	}
}

class Pair
{
	public int i;
	public int j;
	public int code;
	public Pair(int i, int j, int code)
	{
		this.i = i;
		this.j = j;
		this.code = code;
	}
	
	
	public boolean equals(Object p)
	{
		if(p == null)
		{
			return false;
		}
		if((i == ((Pair)p).i) && (j == ((Pair)p).j))
		{
			return true;
		}
		return false;
	}
	
	
	public int hashCode()
	{
		//return (int) (i * Math.pow(10, 5) + j);
		//return (int) (Math.random() * 20);
		return code;
	}
	
	
	public String toString()
	{
		return "" + Math.random();
	}
}