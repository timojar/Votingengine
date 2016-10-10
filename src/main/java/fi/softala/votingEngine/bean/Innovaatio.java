package fi.softala.votingEngine.bean;

import javax.validation.constraints.Size;

public class Innovaatio {
	
	
	
private int id;

private @Size(min= 1, max=50) String nimi;
private @Size(min= 1, max=70)String  aihe;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNimi() {
	return nimi;
}

public void setNimi(String nimi) {
	this.nimi = nimi;
}

public String getAihe() {
	return aihe;
}

public void setAihe(String aihe) {
	this.aihe = aihe;
}

}
