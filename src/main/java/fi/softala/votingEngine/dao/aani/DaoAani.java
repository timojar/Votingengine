package fi.softala.votingEngine.dao.aani;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import fi.softala.votingEngine.bean.Aani;


public interface DaoAani {
	
@PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_USER, OWNER_USER')")	
public abstract void talletaAani(Aani aani);
public abstract void muutaoikeuksia(int opiskelijaId);
public abstract List<Aani> listaaTulokset();
	
	

}
