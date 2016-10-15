package fi.softala.votingEngine.dao.aani;

import fi.softala.votingEngine.bean.Aani;

public interface DaoAani {
	
	
abstract void talletaAani(Aani aani);
abstract void muutaoikeuksia(int opiskelijaId);
	
	

}
