package mf.nexflix.model;

import java.util.HashMap;

public class Data
{
	public Data()
	{}
	public Data(int[] uids, int[] mids, HashMap<Integer, Integer> uidMap,
			HashMap<Integer, Integer> midMap, HashMap<Pair, Integer> ratingMap)
	{
		this.uids = uids;
		this.mids = mids;
		this.uidMap = uidMap;
		this.midMap = midMap;
		this.ratingMap = ratingMap;
	}
	public int[] uids;
	public int[] mids;
	public HashMap<Integer, Integer> uidMap;
	public HashMap<Integer, Integer> midMap;
	public HashMap<Pair, Integer> ratingMap;
	
}