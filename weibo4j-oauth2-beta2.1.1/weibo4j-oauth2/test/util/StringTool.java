package util;

import java.util.List;

public class StringTool {

	public static String Merge(String[] arr)
	{
		StringBuffer strBuf = null;
		
		strBuf = new StringBuffer();
		for(int i = 0; i < arr.length; i++)
		{
			strBuf.append(arr[i]);
			strBuf.append(",");
		}
		strBuf.deleteCharAt(strBuf.length() - 1);
		return strBuf.toString();
		
	}
	
	public static String Merge(List<String> arr)
	{
		StringBuffer strBuf = null;
		
		strBuf = new StringBuffer();
		for(int i = 0; i < arr.size(); i++)
		{
			strBuf.append(arr.get(i));
			strBuf.append(",");
		}
		strBuf.deleteCharAt(strBuf.length() - 1);
		return strBuf.toString();
		
	}
	
}
