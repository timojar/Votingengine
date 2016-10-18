package fi.softala.votingEngine.beanValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class IsokirjainValidator implements
ConstraintValidator<Isokirjain, String>{
	
	
	
	
	
	
	
	public void initialize(Isokirjain isokirjain) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0) {
			return true;
		}
		
		
		String compare=value.charAt(0)+"";
		String letter=value.charAt(0)+"";
		String match=letter.toUpperCase()+"";
		return compare.equals(match);
	}	
	
	
	
	

}
