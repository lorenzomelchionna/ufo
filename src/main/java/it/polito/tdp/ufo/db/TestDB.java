package it.polito.tdp.ufo.db;

import java.sql.SQLException;
import java.util.List;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		
		SightingDAO dao = new SightingDAO();
		
		List<String> formeUFO = dao.readShapes();
		
		for(String forma : formeUFO) {
			
			int count = dao.countByShape(forma);
			System.out.println("UFO di forma "+forma+" sono: "+count);
			
		}
		
	}

}
