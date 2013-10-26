package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import util.DB;

import model.Comment;


public class CommentDAO {
	
	private int currentCount = 0;
	private int pageNo = 0;
	private int countPerPage = 1000;
	private String[] comm = null;
	private int totalCount = 0;
	
	public CommentDAO(int c)
	{
		countPerPage = c;
		comm = new String[countPerPage];
		loadTotalNum();
	}
	
	public CommentDAO()
	{
		comm = new String[countPerPage];
		loadTotalNum();
	}
	
	public int getTotalCount()
	{
		return totalCount;
	}
	
	private void loadTotalNum()
	{
		Connection conn = null;
		Statement stmt = null;
		String sql = "select count(*) from comment";
		ResultSet rs = null;
		conn = DB.getConn();
		stmt = DB.getStmt(conn);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
				
	}
	
	public String nextComment() throws IOException, SQLException
	{
		if(pageNo == 0 && currentCount == 0)
		{
			loadComment();
		}
		if(currentCount >= countPerPage)
		{
			currentCount = 0;
			pageNo++;
			if(!loadComment())
			{
				return null;
			}
		}
		return comm[currentCount++];
	}
	
	public boolean loadComment() throws IOException, SQLException
	{
		if(pageNo * countPerPage >= totalCount)
		{
			return false;
		}
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		String sql = "select ctext from comment limit ?, ?";
		ResultSet rs = null;
		int i = 0;
		
		conn = DB.getConn();
		pStmt = DB.getpStmt(conn, sql);
		pStmt.setInt(1,(pageNo * countPerPage));
		pStmt.setInt(2, countPerPage);
		rs = pStmt.executeQuery();
		while(rs.next())
		{
			comm[i] = rs.getString(1);
			i++;
		}
		pageNo++;
		rs.close();
		pStmt.close();
		conn.close();
		return true;
	}
	
	public List<Comment> getCommentByStatusId(String statusId)
	{
		List<Comment> list = new LinkedList<Comment> ();
		Connection conn = null;
		PreparedStatement pStmt = null;
		String sql = "select cid, ctext from comment where sid = ?";
		ResultSet rs = null;
		Comment c = null;
		
		try {
			conn = DB.getConn();
			pStmt = DB.getpStmt(conn, sql);
			pStmt.setString(1, statusId);
			rs = pStmt.executeQuery();
			while(rs.next())
			{
				c = new Comment();
				c.setCid(rs.getString("cid"));
				c.setCtext(rs.getString("ctext"));
				c.setSid(statusId);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pStmt != null)
			{
				try {
					pStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public static void main(String args[])
	{

		 //CommentDAO cd = new CommentDAO();
	}
}
