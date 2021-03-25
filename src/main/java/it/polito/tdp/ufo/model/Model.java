package it.polito.tdp.ufo.model;

import java.util.List;

import it.polito.tdp.ufo.db.SightingDAO;

public class Model {
	
	private List<String> formeUFO = null;
	
	public List<String> getFormeUFO() {
		
		if(this.formeUFO == null) {
			
			SightingDAO dao = new SightingDAO();
			formeUFO = dao.readShapes();
			
		}
		
		return formeUFO;
		
	}
	
	public int countByForma(String forma) {
		
		SightingDAO dao = new SightingDAO();
		return dao.countByShape(forma);
		
	}
	
}
