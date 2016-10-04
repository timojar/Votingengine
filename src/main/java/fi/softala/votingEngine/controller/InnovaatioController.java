package fi.softala.votingEngine.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.dao.InnovaatioDao;

@Controller
@RequestMapping(value="/innot")
public class InnovaatioController {
	
@Inject	
private InnovaatioDao dao;	 
	
	
	public InnovaatioDao getDao() {
	return dao;
}


public void setDao(InnovaatioDao dao) {
	this.dao = dao;
}


	@RequestMapping(value = "innovaatiot", method = RequestMethod.GET)
	public ModelAndView getdata() {

	

		
		ModelAndView model = new ModelAndView("inn/listaus");
		List<Innovaatio> innovaatiot=dao.haeKaikki();
		model.addObject("innot",innovaatiot);

		return model;

	}	
	
	

}
