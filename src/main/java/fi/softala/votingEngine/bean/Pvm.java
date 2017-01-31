package fi.softala.votingEngine.bean;

import java.time.LocalDate;
import java.util.Date;

import org.joda.time.DateTime;

public class Pvm {

	
private int id, pv, startHH, startMM, endHH, endMM;
private LocalDate paivamaara;
private Date  alkuKello, loppuKello;


private String nimi;





public Date getLoppuKello() {
	return loppuKello;
}
public void setLoppuKello(Date loppuKello) {
	this.loppuKello = loppuKello;
}
public Date getAlkuKello() {
	return alkuKello;
}
public void setAlkuKello(Date alkuKello) {
	this.alkuKello = alkuKello;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDate getPaivamaara() {
	return paivamaara;
}
public void setPaivamaara(LocalDate paivamaara) {
	this.paivamaara = paivamaara;
}
public String getNimi() {
	return nimi;
}
public void setNimi(String nimi) {
	this.nimi = nimi;
}
public int getPv() {
	return pv;
}
public void setPv(int pv) {
	this.pv = pv;
}
public int getStartHH() {
	return startHH;
}
public void setStartHH(int startHH) {
	this.startHH = startHH;
}
public int getStartMM() {
	return startMM;
}
public void setStartMM(int startMM) {
	this.startMM = startMM;
}
public int getEndHH() {
	return endHH;
}
public void setEndHH(int endHH) {
	this.endHH = endHH;
}
public int getEndMM() {
	return endMM;
}
public void setEndMM(int endMM) {
	this.endMM = endMM;
}

	
	
	

}
