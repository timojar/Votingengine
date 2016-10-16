package fi.softala.votingEngine.beanValidation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fi.softala.votingEngine.bean.Opiskelija;

import fi.softala.votingEngine.dao.opiskelija.OpiskelijaDao;



public class EmailDublicateValidator implements
ConstraintValidator<EmailDublicate, String>{


	@Inject
	
	private OpiskelijaDao dao;

	
	
	
	
	public OpiskelijaDao getDao() {
		return dao;
	}

	public void setDao(OpiskelijaDao dao) {
		this.dao = dao;
	}

	public void initialize(EmailDublicate emailDublicate) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {

		Opiskelija o=new Opiskelija();
		
		
		
		
		String email=value;
		boolean ehto=true;
		try {
			o=dao.haeOpiskelija(email);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		if(value.equals(o.getEmail())){
			ehto=false;
			
		
		}
		System.out.println("Email: "+o.getEmail());
		
		return ehto;
	}	
	
		
	
	
	
	
	

}
