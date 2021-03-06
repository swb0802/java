package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.StatusScore;

import util.DB;

public class StatusScoreDAO {

	public void save(List<StatusScore> sslist)
	{
		Connection conn = null;
		PreparedStatement pStmt = null;
		String sql = "insert into status_score(sid, score) values(?, ?)";
		StatusScore statusScore = null;
		Iterator<StatusScore> iter = null;
		
		try {
			conn = DB.getConn();
			conn.setAutoCommit(false);
			pStmt = DB.getpStmt(conn, sql);
			iter = sslist.iterator();
			while(iter.hasNext())
			{
				statusScore = iter.next();
				pStmt.setString(1, statusScore.getSid());
				pStmt.setFloat(2, statusScore.getScore());
				pStmt.addBatch();
			}
			pStmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//create table status_score
//(
//	sid varchar(32) primary key,
//	score float
//);
