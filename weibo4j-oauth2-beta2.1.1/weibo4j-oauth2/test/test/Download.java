package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.StringTool;
import weibo4j.Timeline;
import weibo4j.model.Paging;
import weibo4j.model.Tag;
import weibo4j.model.TagWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import fetcher.CommentFetcher;
import fetcher.GetOauth;
import fetcher.TagFetcher;

public class Download {

	public static void getCommentsByStatusMid(String access_token, String statusMid)
	{
		//String access_token = "2.00zzR3zB7uKfeB47c83a2905QlTuJE";
		//String statusMid = "ztcoxxfdw";
		JSONObject id = null;
		Timeline tm = new Timeline();
		long totalNum = 0;
		int countPerPage = 200;
		int pageNo = 1;
		Paging page = new Paging(pageNo, countPerPage);
		tm.client.setToken(access_token);
		try {
			id = tm.QueryId(statusMid, 1,1);
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CommentFetcher cf = new CommentFetcher();
		try {
			do
			{
				totalNum = cf.getComment(access_token, id.getString("id"), page);
				page.setPage(++pageNo);
				
			}while(pageNo * countPerPage < totalNum);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (WeiboException e1){
			e1.printStackTrace();
		}
		
	}
	
	public static void getCommentsByStatusId(String access_token, String statusId)
	{
		//String access_token = "2.00zzR3zB7uKfeB47c83a2905QlTuJE";
		Timeline tm = new Timeline();
		long totalNum = 0;
		int countPerPage = 200;
		int pageNo = 1;
		Paging page = new Paging(pageNo, countPerPage);
		tm.client.setToken(access_token);

		try {
			CommentFetcher cf = new CommentFetcher();
			do
			{
				totalNum = cf.getComment(access_token, statusId, page);
				page.setPage(++pageNo);
					
			}while(pageNo * countPerPage < totalNum);
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getStatusIdsByUserId(String access_token, String uid)
	{
		Timeline tm = null;
		Paging page = null;
		File file = null;
		FileWriter fw = null;
		int pageNo = 0;
		int countPerPage = 100;
		long totalNum = 0;
		try {
			file = new File("D:\\statusIds.txt");
			fw = new FileWriter(file, true);
			tm = new Timeline();
			tm.client.setToken(access_token);
			page = new Paging(1, countPerPage);
			
			do{
				page.setPage(++pageNo);
				JSONObject ids = tm.getUserTimelineIdsByUid(uid, page, 0, 0);
				JSONArray array = ids.getJSONArray("statuses");		
				totalNum = ids.getLong("total_number");
				int size = array.length();
				for(int i=0; i<size; i++)
				{
					fw.write(String.valueOf(array.getLong(i)));
					fw.write("\n");				
				}
			}while(page.getPage() * countPerPage < totalNum);
			
			//fw.write(list.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void getAllComments(String access_token) throws WeiboException
	{
		File statusIdsFile = null;
		BufferedReader br = null;
		String id = null;
		CommentFetcher cf = null;
		Paging page = null;
		int countPerPage = 200;
		int pageNo = 1;
		long totalNum = 0;

		try {
			statusIdsFile = new File("D:\\statusIds.txt");
			cf = new CommentFetcher();
			page = new Paging(pageNo, countPerPage);
			br = new BufferedReader(new FileReader(statusIdsFile));
			while((id = br.readLine()) != null)
			{
				while(true)
				{
					totalNum = cf.getComment(access_token, id, page);
					if(page.getPage() * page.getCount() >= totalNum)
					{
						break;
					}
					page.setPage(++pageNo);
				}
				pageNo = 1;
				page.setPage(pageNo);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllComments(String access_token, 
			String sinceId, int pageNo) 
	{
		File statusIdsFile = null;
		BufferedReader br = null;
		String id = null;
		CommentFetcher cf = null;
		Paging page = null;
		int countPerPage = 200;
		long totalNum = 0;

		try {
			statusIdsFile = new File("D:\\statusIds.txt");
			cf = new CommentFetcher();
			page = new Paging(pageNo, countPerPage);
			br = new BufferedReader(new FileReader(statusIdsFile));
			
			do
			{
				id = br.readLine();
				if(id.equals(sinceId))
				{
					break;
				}
			}while(id != null);
			
			while(id != null)
			{
				while(true)
				{
					try {
						totalNum = cf.getComment(access_token, id, page);
					} catch (WeiboException e) { //接口调用频率达到上限，则暂停1小时后继续
						e.printStackTrace();
						try {
							Thread.sleep(3700 * 1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						continue;
					}
					if(page.getPage() * page.getCount() >= totalNum)
					{
						break;
					}
					page.setPage(++pageNo);
				}
				pageNo = 1;
				page.setPage(pageNo);
				id = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String args[])
	{
		String accessToken = null;
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String sinceId = null;
		int pageNo = 0;
		
		try {
			try {
				accessToken = new GetOauth().getAccessToken().getAccessToken();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//accessToken = "2.00zzR3zB7uKfeB47c83a2905QlTuJE";
			if(false)
			{
				getAllComments(accessToken);
			}
			getAllComments(accessToken, "13769925738", 2 );
			
		} catch (WeiboException e) {//接口调用频率达到上限，则暂停1小时后，继续
			e.printStackTrace();
			try {
				Thread.sleep(3700 * 1000);
				file = new File("D:\\log.txt");
				br = new BufferedReader(new FileReader(file));
				sinceId = br.readLine();
				pageNo = Integer.parseInt(br.readLine());
				getAllComments(accessToken, sinceId, pageNo);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
