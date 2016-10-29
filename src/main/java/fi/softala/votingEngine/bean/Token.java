package fi.softala.votingEngine.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import fi.softala.votingEngine.beanValidation.EmailExist;

public class Token {
	
private int ryhmaId;	
private String tokenId;

@EmailExist @Email @Size(min=1)
private String email;





public int getRyhmaId() {
	return ryhmaId;
}

public void setRyhmaId(int ryhmaId) {
	this.ryhmaId = ryhmaId;
}

public String getTokenId() {
	return tokenId;
}

public void setTokenId(String tokenId) {
	this.tokenId = tokenId;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}




	

}
