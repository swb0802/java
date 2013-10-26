package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import weibo4j.model.Tag;
import weibo4j.model.TagWapper;

public class TagDAO {

	private Connection conn;
	private PreparedStatement pStmt;
	
	public TagDAO()
	{
		conn = DB.getConn();
	}
	
	public void save(TagWapper[] twArr)
	{
		List<Tag> tagList = null;
		String uid = null;
		TagWapper tw = null;
		String sql = null;
		Tag tag = null;
		
		try {
			sql = "insert into tag(tid, value, sid, weight) values(?, ?, ?, ?)";
			pStmt = DB.getpStmt(conn, sql);
			conn.setAutoCommit(false);
			for(int i = 0; i < twArr.length; i++)
			{
				tw = twArr[i];
				tagList = tw.getTags();
				uid = tw.getId();
				for(int j = 0; j < tagList.size(); j++)
				{
					tag = tagList.get(j);
					pStmt.setString(1, tag.getId());
					pStmt.setString(2, tag.getValue());
					pStmt.setString(3, uid);
					pStmt.setString(4, tag.getWeight());
					pStmt.addBatch();
				}
				pStmt.executeBatch();
				conn.commit();			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pStmt != null)
			{
				try {
					pStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		TagDAO tagDao = new TagDAO();
		List<Tag> tagList = new ArrayList<Tag>();
		String uid = null;
		TagWapper twArr[] = new TagWapper[1];
		
		tagList.add(new Tag("1","aaa","12312"));
		tagList.add(new Tag("2","你好","232134"));
		uid = "1111";
		TagWapper tw = new TagWapper(tagList, uid);
		twArr[0] = tw;
		tagDao.save(twArr);
		
		tagList.clear();
		tagList.add(new Tag("3","ccc","5466"));
		tagList.add(new Tag("4","ddd","45578"));
		uid = "2222";
		tw = new TagWapper(tagList, uid);
		twArr[0] = tw;
		tagDao.save(twArr);
	}
	
}
