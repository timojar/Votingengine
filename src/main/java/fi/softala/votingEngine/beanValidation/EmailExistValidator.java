package fi.softala.votingEngine.beanValidation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.opiskelija.OpiskelijaDao;






public class EmailExistValidator implements
ConstraintValidator<EmailExist, String> {
	
@Inject	
private OpiskelijaDao dao;




	

	public OpiskelijaDao getDao() {
	return dao;
}

public void setDao(OpiskelijaDao dao) {
	this.dao = dao;
}

	public void initialize(EmailExist emailexist) {

	}

	public boolean isValid(String email, ConstraintValidatorContext context) {
		Opiskelija o=new Opiskelija();
		
		try {o=dao.haeOpiskelija(email);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println(email+o.getEmail());
		
		if(email.equals(o.getEmail())){
			return false;	
		}
		
		
		
		return true;
		
		
		
		
	}		
	
	


}
