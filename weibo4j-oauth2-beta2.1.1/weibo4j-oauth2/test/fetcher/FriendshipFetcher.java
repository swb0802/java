package fetcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import DAO.UserDAO;

import weibo4j.Friendships;
import weibo4j.model.UserIdWapper;
import weibo4j.model.WeiboException;

public class FriendshipFetcher {

	public static void main(String args[])
	{
		//System.out.println(getFriendsIds("",""));
		FriendshipFetcher ff = new FriendshipFetcher();
		ArrayList<String> uidList = ff.getUids(1000000, "1822801735", "2.00zzR3zB7uKfeB47c83a2905QlTuJE");
		UserDAO userDao = new UserDAO();
		userDao.saveIds(uidList);
	}
	
	public static String getFriendsIds(String uid, String token)
	{
		try {
			Friendships fs = new Friendships();
			fs.setToken("2.00zzR3zB7uKfeB47c83a2905QlTuJE");
			String[] uids = fs.getFriendsIdsByUid("1822801735");
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < 20; i++)
			{
				sb.append(uids[i]);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 获得一定数目用户id集合
	 * @param count 要获得id的数目
	 * @param startId 从该用户id开始，广度优先搜索
	 * @param token 授权
	 * **/
	public ArrayList<String> getUids(int count, String startId, String token)
	{
		Set<String> uidSet = null;
		Queue<String> uidQueue = null;
		String[] uids = null;
		String uid = null;
		Friendships fs = null;
		UserIdWapper uiw = null;
		
		try {
			uidSet = new HashSet<String>(count);
			uidQueue = new LinkedList<String>();
			fs = new Friendships();
			uiw = new UserIdWapper();
			fs.setToken(token);
			uid = startId;
			while(uidSet.size() < count)
			{
				do
				{
					uiw = fs.getFriendsIdsWapperByUid(uid, 5000, (int) (uiw.getNextCursor()));
					uids = uiw.getUids();
					for(int i = 0; i < uids.length; i++)
					{
						if(uidSet.add(uids[i]))
						{
							uidQueue.add(uids[i]);
						}
					}
					
				}while(uiw.getNextCursor() != 0);
				if(uidQueue.isEmpty())
				{
					break;
				}
				else
				{
					uid = uidQueue.poll();
				}
			}
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<String>(uidSet);
		}
		return new ArrayList<String>(uidSet);
		
	}
	
}
