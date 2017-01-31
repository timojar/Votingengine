package fi.softala.votingEngine.bean;

import java.sql.Time;
import java.util.Date;

public class Aika {

private String aikavali;
private Date pvm;	
private Time alku, loppu;



public String getAikavali() {
	return aikavali;
}
public void setAikavali(String aikavali) {
	this.aikavali = aikavali;
}
public Date getPvm() {
	return pvm;
}
public void setPvm(Date pvm) {
	this.pvm = pvm;
}
public Time getAlku() {
	return alku;
}
public void setAlku(Time alku) {
	this.alku = alku;
}
public Time getLoppu() {
	return loppu;
}
public void setLoppu(Time loppu) {
	this.loppu = loppu;
}




}
