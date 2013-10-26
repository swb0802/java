package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import DAO.TagDAO;
import DAO.UserDAO;

import util.StringTool;
import weibo4j.model.Tag;
import weibo4j.model.TagWapper;
import weibo4j.model.WeiboException;
import fetcher.TagFetcher;

public class DownloadTag {

	public static void getTagsByUid(ArrayList<String> idList, String token, int since)
	{
		List<String> tmpList = null;
		int size = 0;
		//int step = 0;
		TagFetcher tf = null;
		TagWapper[] twArr = null;
		List<Tag> tagList = null;
		File file = null;
		FileWriter fw = null;
		TagDAO tagDao = null;
		int i = 0;
		
		try {
			size = idList.size();
			//step = size / 20;
			tf = new TagFetcher();
			file = new File("D:\\tags");
			fw = new FileWriter(file);
			tagDao = new TagDAO();
			for(i = since; i < size - 20; i += 20)
			{
				tmpList = idList.subList(i, i + 20);
				twArr = tf.getTagsBatch(StringTool.Merge(tmpList), token);
				tagDao.save(twArr);
				for(int k = 0; k < twArr.length; k++)
				{
					tagList = twArr[k].getTags();
					for(int j = 0; j < tagList.size(); j++)
					{
						fw.write(tagList.get(j).getValue());
						fw.write("\t");
					}
				}
				
			}
			if(size >= 20)
			{
				tmpList = idList.subList(size - 20, size);
				twArr = tf.getTagsBatch(StringTool.Merge(tmpList), token);
				tagDao.save(twArr);
				for(int k = 0; k < twArr.length; k++)
				{
					tagList = twArr[k].getTags();
					for(int j = 0; j < tagList.size(); j++)
					{
						fw.write(tagList.get(j).getValue());
						fw.write("\t");
					}
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(WeiboException e){
			try {
				e.printStackTrace();
				System.out.println("Since:" + i);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String newToken = br.readLine();
				getTagsByUid(idList, newToken, i);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally{
			try {
				fw.flush();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String args[])
	{
		UserDAO userDao = new UserDAO();
		getTagsByUid(userDao.getIds(), "2.00zzR3zB7uKfeB47c83a2905QlTuJE", 0);
//		TagFetcher tf = new TagFetcher();
//		TagWapper tw = tf.getTagsBatch("1197161814,1004524612", "2.00zzR3zB7uKfeB47c83a2905QlTuJE");
//		System.out.println(tw);
	}
}
