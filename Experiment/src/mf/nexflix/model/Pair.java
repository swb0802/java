package mf.nexflix.model;

public class Pair
{
	public Pair(){}
	public Pair(int uid, int mid)
	{
		this.uid = uid;
		this.mid = mid;
	}
	@Override
	public boolean equals(Object p)
	{
		if(p == null)
		{
			return false;
		}
		if(uid == ((Pair)p).uid && mid == ((Pair)p).mid)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return uid * uid + mid * mid;
	}
	
	public int uid;
	public int mid;
}