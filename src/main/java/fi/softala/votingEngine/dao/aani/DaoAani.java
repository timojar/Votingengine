package fi.softala.votingEngine.dao.aani;

import java.util.List;

import fi.softala.votingEngine.bean.Aani;


public interface DaoAani {
	
	
abstract void talletaAani(Aani aani);
abstract void muutaoikeuksia(int opiskelijaId);
public abstract List<Aani> listaaTulokset();
	
	

}
