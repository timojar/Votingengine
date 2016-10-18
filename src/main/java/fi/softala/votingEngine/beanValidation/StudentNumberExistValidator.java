package fi.softala.votingEngine.beanValidation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.opiskelija.OpiskelijaDao;

public class StudentNumberExistValidator 
implements
ConstraintValidator<StudentNumberExist, String>{
	
	
	
	
	
	
	
	@Inject	
	private OpiskelijaDao dao;




		

		public OpiskelijaDao getDao() {
		return dao;
	}

	public void setDao(OpiskelijaDao dao) {
		this.dao = dao;
	}

		public void initialize(StudentNumberExist exist) {

		}

		public boolean isValid(String opiskelijanumero, ConstraintValidatorContext context) {
			if (opiskelijanumero == null || opiskelijanumero.length() == 0) {
				return true;
			}
			
			
			Opiskelija o=new Opiskelija();
			
			try {o=dao.tarkistaOpiskelija(opiskelijanumero);
				
			} catch (Exception e) {
				e.getStackTrace();
			}
			System.out.println(o.getOpiskelijanumero());
			
			if(opiskelijanumero.equals(o.getOpiskelijanumero())){
				return false;	
			}
			
			
			
			return true;
			
			
			
			
		}		
		
			
	
	
	
	
	
	

}
