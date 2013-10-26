package fetcher;

import java.io.IOException;
import java.util.List;

import weibo4j.Tags;
import weibo4j.examples.tags.GetTags;
import weibo4j.http.AccessToken;
import weibo4j.model.Tag;
import weibo4j.model.TagWapper;
import weibo4j.model.WeiboException;

public class TagFetcher {

	public List<Tag> getTags(String uid, String token)
	{
		try {
			Tags tags = new Tags();
			tags.setToken(token);
			List<Tag> tagList = tags.getTags("1822801735");
			return tagList;
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public TagWapper[] getTagsBatch(String uids, String token) throws WeiboException
	{
		
		Tags tags = new Tags();
		tags.setToken(token);
		TagWapper[] twArr = tags.getTagsBatch(uids);
		return twArr;

	}
	
	public static void main(String args[])
	{
//		try {
//			GetOauth go = new GetOauth();
//			AccessToken token = go.getAccessToken();
//			System.out.println(token.getAccessToken());
//			List<Tag> tag = getTags("1822801735", token.getAccessToken());
//			System.out.println(tag);
//		} catch (WeiboException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//TagWapper tw = getTagsBatch(FriendshipFetcher.getFriendsIds("1822801735", "2.00zzR3zB7uKfeB47c83a2905QlTuJE"),"2.00zzR3zB7uKfeB47c83a2905QlTuJE");
		//System.out.println(tw.getTags());
	}
	
}
