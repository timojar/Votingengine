package fi.softala.votingEngine.beanValidation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Constraint(validatedBy = StudentNumberExistValidator.class)
@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentNumberExist {
	
	
	
	String message() default "{fi.softala.jee.demo.d15.StudentNumberExist.message}";
	 
	 Class<?>[] groups() default {};
	 
	 Class<? extends Payload>[] payload() default {};	
				
	
	

}
