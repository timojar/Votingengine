package fi.softala.votingEngine.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.votingEngine.bean.Aani;
import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.aani.DaoAani;

@Controller
@RequestMapping(value = "aanet")
@SessionAttributes({"opiskelija","inno"})
public class AaniController {
	
	
@Inject	
private DaoAani dao;	
	
	
	
	public DaoAani getDao() {
	return dao;
}



public void setDao(DaoAani dao) {
	this.dao = dao;
}








@RequestMapping(value = "etusivulle", method = RequestMethod.GET)
public ModelAndView toFrontpage(@ModelAttribute(value = "inno") Innovaatio innovaatio,
		@ModelAttribute(value = "opiskelija") Opiskelija o){
	
	
	ModelAndView model=new ModelAndView("redirect:/");
	
	
	
	return model;
	
}


@RequestMapping(value = "tulokset", method = RequestMethod.GET)
public ModelAndView listaa(){
	
	
	List<Aani>aanet=dao.listaaTulokset();
	ModelAndView model=new ModelAndView("inn/results");
	
	model.addObject("aanet", aanet);
	
	return model;
	
}




@RequestMapping(value = "peru", method = RequestMethod.GET)
public ModelAndView peruValvistus(){
	
	
	
	ModelAndView model=new ModelAndView("redirect:/innot/innovaatiot");
	

	
	return model;
	
}








@RequestMapping(value = "vahvista", method = RequestMethod.GET)
public ModelAndView getdata(@ModelAttribute(value = "inno") Innovaatio innovaatio,
		@ModelAttribute(value = "opiskelija") Opiskelija o){
	
	
	ModelAndView model=new ModelAndView();
	
	model.setViewName("vahvistus/kiitos");
	
	Aani aani=new Aani();
	int innoId=innovaatio.getId();
	int opiskelijaId=o.getId();

	aani.setInnoId(innoId);
	aani.setOpiskelijaId(opiskelijaId);
	dao.talletaAani(aani);
	dao.muutaoikeuksia(opiskelijaId);
	SecurityContextHolder.getContext().setAuthentication(null);
	
	return model;
	
}


@RequestMapping(value = "logout", method = RequestMethod.GET)
public ModelAndView ulosKirjaudu() {

	ModelAndView model = new ModelAndView("logout");

	SecurityContextHolder.getContext().setAuthentication(null);

	return model;
}


	@RequestMapping(value = "aanestys", method = RequestMethod.GET)
	public String create(
			@ModelAttribute(value = "inno") Innovaatio innovaatio,
					@ModelAttribute(value = "opiskelija") Opiskelija o) {	
	
		
		
		
		
	
	return "vahvistus/vahvistus";
	
	}

}
