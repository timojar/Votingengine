package fi.softala.votingEngine.beanValidation;

import javax.inject.Inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioDao;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioSpringImpl;

public class Testaus {

	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		InnovaatioDao dao = (InnovaatioDao)context.getBean("daoLuokka");
		
		
		InnovaatioDao innovaatiodao=new InnovaatioSpringImpl();
		
		int id =2;
		
		Opiskelija o=innovaatiodao.etsiOpiskelija(id);
		
		
		System.out.println(o.getEtunimi());
		
		
		context.close();
		
	}

}
