package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DB;

public class UserDAO {

	public void saveIds(ArrayList<String> uids)
	{
		Connection conn = null;
		PreparedStatement pStmt = null;
		String sql = "insert into sina_user(uid) values(?)";
		
		try {
			conn = DB.getConn();
			conn.setAutoCommit(false);
			pStmt = DB.getpStmt(conn, sql);
			
			for(int i = 0; i < uids.size(); i += 50)
			{
				for(int j = i * 50; j < uids.size(); j++)
				{
					pStmt.setString(1, uids.get(j));
					pStmt.addBatch();
				}
				pStmt.executeBatch();
				conn.commit();				
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			try {
				if(pStmt != null)
				{
					pStmt.close();
				}
				if(conn != null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<String> getIds()
	{
		ArrayList<String> list = null;
		String sql = "select uid from sina_user";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String uid = null;
		
		try {
			list = new ArrayList<String>();
			conn = DB.getConn();
			stmt = DB.getStmt(conn);
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				uid = rs.getString("uid");
				list.add(uid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String args[])
	{
		UserDAO userDao = new UserDAO();
		//userDao.test();
	}
}

//create table user
//(
//	uid varchar(32) primary key, 	#用户id
//	screen_name varchar(32),		#昵称
//	provience varchar(32),			#省份
//	city varchar(32),				#城市
//	url TEXT,						#用户博客地址
//	gender varchar(2),				#性别
//	follower_count int,				#粉丝数
//	friends_count int,				#关注数
//	status_count int,				#微博数
//	favourites_count int,			#收藏数
//	created_at DATETIME,			#账户创建时间
//	bi_followers_count int			#互粉数
//);