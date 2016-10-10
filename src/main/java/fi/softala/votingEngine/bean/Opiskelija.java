package fi.softala.votingEngine.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Opiskelija {
	
	
private int id	;
private int innovaatioId;
private Innovaatio innovaatio;

@Pattern(regexp="a\\d{7}") private String opiskelijanumero;
@Size(min=1, max=50) private String etunimi;
@Size(min=1, max=150) private String sukunimi;
@Email @Size(min=1) private String email;




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}



public int getInnovaatioId() {
	return innovaatioId;
}
public void setInnovaatioId(int innovaatioId) {
	this.innovaatioId = innovaatioId;
}
public String getOpiskelijanumero() {
	return opiskelijanumero;
}
public void setOpiskelijanumero(String opiskelijanumero) {
	this.opiskelijanumero = opiskelijanumero;
}
public String getEtunimi() {
	return etunimi;
}
public void setEtunimi(String etunimi) {
	this.etunimi = etunimi;
}
public String getSukunimi() {
	return sukunimi;
}
public void setSukunimi(String sukunimi) {
	this.sukunimi = sukunimi;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Innovaatio getInnovaatio() {
	return innovaatio;
}
public void setInnovaatio(Innovaatio innovaatio) {
	this.innovaatio = innovaatio;
}






}
