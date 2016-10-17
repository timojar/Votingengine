package fi.softala.votingEngine.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



import fi.softala.votingEngine.beanValidation.EmailExist;
import fi.softala.votingEngine.beanValidation.Isokirjain;
import fi.softala.votingEngine.beanValidation.StudentNumberExist;

public class Opiskelija {
	
	
private int id	;
private int ryhmaId;
private Innovaatio innovaatio;

@StudentNumberExist @Pattern(regexp="a\\d{7}") private String opiskelijanumero;
@Isokirjain @Size(min=1, max=50) private String etunimi;
@Isokirjain @Size(min=1, max=150) private String sukunimi;


@EmailExist @Email @Size(min=1) private String email;




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}




public int getRyhmaId() {
	return ryhmaId;
}
public void setRyhmaId(int ryhmaId) {
	this.ryhmaId = ryhmaId;
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
