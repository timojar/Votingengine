package fi.softala.votingEngine.beanValidation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioDao;

public class InnovatioNameExistValidator implements
ConstraintValidator<InnovatioNameExist, String> {
	
@Inject	
private InnovaatioDao dao;	
	



	
	
	
	
	public InnovaatioDao getDao() {
	return dao;
}

public void setDao(InnovaatioDao dao) {
	this.dao = dao;
}

	public void initialize(InnovatioNameExist innovationexist) {

	}

	public boolean isValid(String nimi, ConstraintValidatorContext context) {
		
		
		if (nimi == null || nimi.length() == 0) {
			return true;
		}
		
		
		Innovaatio i=new Innovaatio();
		
		try {i=dao.tarkistaInnovaatio(nimi);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		System.out.println(nimi+i.getNimi());
		if( nimi.equals(i.getNimi())){
			return false;	
		}
		
		
		
		return true;
		
		
		
		
	}		
	
	
	
	
	
	
	
	
	
	
	
	

}
