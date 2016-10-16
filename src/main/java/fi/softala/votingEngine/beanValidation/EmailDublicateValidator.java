package fi.softala.votingEngine.beanValidation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioDao;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioSpringImpl;



public class EmailDublicateValidator implements
ConstraintValidator<EmailDublicate, String>{


	
	
	

	
	
	
	
	public void initialize(EmailDublicate emailDublicate) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {

		Opiskelija o=new Opiskelija();
		
		InnovaatioDao innovaatiodao=new InnovaatioSpringImpl();
		
		
		String email=value;
		boolean ehto=true;
		try {
			o=innovaatiodao.haeOpiskelija(email);
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
