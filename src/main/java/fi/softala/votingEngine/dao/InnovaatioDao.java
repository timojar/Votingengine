package fi.softala.votingEngine.dao;

import java.util.List;

import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Opiskelija;

public interface InnovaatioDao {


public abstract List<Innovaatio> haeKaikki();

public  abstract int talletaInnovaatio(Innovaatio innovaatio);

public abstract Innovaatio etsiInnovaatio(int id);
public abstract Opiskelija etsiOpiskelija(int id);

public abstract void talletaOpiskelija(Opiskelija o);
	
	
}
