import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class NO1002 {

	private static HashMap<Character, Character> code = new HashMap<Character, Character>();
	
	static {
		code.put('A', '2');code.put('B', '2');code.put('C', '2');
		code.put('D', '3');code.put('E', '3');code.put('F', '3');
		code.put('G', '4');code.put('H', '4');code.put('I', '4');
		code.put('J', '5');code.put('K', '5');code.put('L', '5');
		code.put('M', '6');code.put('N', '6');code.put('O', '6');
		code.put('P', '7');code.put('R', '7');code.put('S', '7');
		code.put('T', '8');code.put('U', '8');code.put('V', '8');
		code.put('W', '9');code.put('X', '9');code.put('Y', '9');
		//code.put('-', '-');
		
	}
	
	public static String transform(String str)
	{
		StringBuffer sb = new StringBuffer();
		int length = str.length();
		for(int i=0; i<length; i++)
		{
			if(str.charAt(i)=='-')
			{
				continue;
			}
			if(str.charAt(i) >= 48 && str.charAt(i) <= 57)
			{
				sb.append(str.charAt(i));
			}
			else
			{
				sb.append(code.get(str.charAt(i)));
			}
		}
		sb.insert(3,'-');
		return sb.toString();
	}
	
	public static void main(String args[])
	{
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		Scanner sc = new Scanner(System.in);
		int count = 0; //
		String str;
		count = sc.nextInt();
		sc.nextLine();
		while(count!=0)
		{
			str = sc.nextLine();
			str = transform(str);
			if(map.get(str)==null)
			{
				map.put(str, 1);
				queue.add(str);
			}
			else
			{
				map.put(str, map.get(str) + 1);
			}
			count--;
		}
		while(!queue.isEmpty())
		{
			str = queue.poll();
			if((count = map.get(str)) > 1)
			System.out.println(str + " " + count);
		}
		sc.close();

	}
	
}
