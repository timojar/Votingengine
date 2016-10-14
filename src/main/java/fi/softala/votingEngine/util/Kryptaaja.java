package fi.softala.votingEngine.util;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class Kryptaaja {

	
	
public String opiskelijanumeroKryptattuna(String opiskelijanumero){
	
	StandardPasswordEncoder spe = new StandardPasswordEncoder();
	
	String kryptaus=spe.encode(opiskelijanumero);
	
	
	
	return kryptaus;
}
	
	
	
}
