package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	
	public List<String> readShapes() {
		
		try{
			
			Connection conn = DBConnect.getConnection();
		
			String sql = "SELECT DISTINCT shape "
					+ "FROM sighting "
					+ "WHERE shape<>'' "
					+ "ORDER BY shape ASC";
		
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery(sql);
		
			List<String> FormeUFO = new ArrayList<>();
		
			while(res.next()) {
			
				String forma = res.getString("shape");
				FormeUFO.add(forma);
			
			}
		
			st.close();
			conn.close();
			
			return FormeUFO;
		
		} catch(SQLException e) {
			throw new RuntimeException("Database error in readShapes", e);
		}
		
	}
	
	public int countByShape(String shape) {
		
		try {
			
			Connection conn = DBConnect.getConnection();
			
			String sql2 = "SELECT COUNT(*) AS cnt FROM sighting WHERE shape = ? ";
			String shapeScelta = "circle";
			
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setString(1, shapeScelta);
			
			ResultSet res2 = st2.executeQuery();
			res2.first();
			int count = res2.getInt("cnt");
			
			st2.close();
			conn.close();
			
			return count;
			
		}catch(SQLException e) {
			throw new RuntimeException("Database error in countByShape", e);
		}
		
	}

}
