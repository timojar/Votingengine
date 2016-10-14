package fi.softala.votingEngine.dao.opiskelija;

import java.util.List;


import fi.softala.votingEngine.bean.Opiskelija;

public interface OpiskelijaDao {
	
	
	
	
	public abstract List<Opiskelija> haeKaikkiOpiskelijat();

	public  abstract void talletaOpiskelija(Opiskelija opiskelija);

	public abstract Opiskelija etsiOpiskelija(int id);
			
	
	

}
