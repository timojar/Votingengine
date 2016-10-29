package fi.softala.votingEngine.dao.opiskelija;

import java.util.List;


import fi.softala.votingEngine.bean.Opiskelija;

public interface OpiskelijaDao {
	
	
	
	
	

	public  abstract void talletaOpiskelija(Opiskelija opiskelija);
	
	public abstract Opiskelija haeOpiskelija(String email);
	public abstract Opiskelija tarkistaOpiskelija(String opiskelijanumero);

	public abstract Opiskelija etsiOpiskelija(int id);
	
	public abstract List<Opiskelija> haeInnovaationOpiskelijat(int ryhmaId);
			
	
	

}
