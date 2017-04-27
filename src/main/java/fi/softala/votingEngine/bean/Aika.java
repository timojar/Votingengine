package fi.softala.votingEngine.bean;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Aika {

private String aikavali;
private Date pvm;	
private Timestamp alku, loppu;



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
public Timestamp getAlku() {
	return alku;
}
public void setAlku(Timestamp alku) {
	this.alku = alku;
}
public Timestamp getLoppu() {
	return loppu;
}
public void setLoppu(Timestamp loppu) {
	this.loppu = loppu;
}




}
