package fi.softala.votingEngine.dao.innovaatio;

import java.util.List;

import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.bean.Ryhma;

public interface InnovaatioDao {


public abstract List<Innovaatio> haeKaikki(int ryhmaId);

public  abstract int talletaInnovaatio(Innovaatio innovaatio);

public abstract Innovaatio etsiInnovaatio(int ryhmaId);

public abstract Innovaatio tarkistaInnovaatio(String nimi);

public abstract Innovaatio haeInnovaatio(int innoId);

public abstract void muokkaInnovaatiota(Innovaatio i);






public abstract int talletaRyhma(Ryhma ryhma);
	
	
}
