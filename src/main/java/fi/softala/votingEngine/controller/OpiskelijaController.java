package fi.softala.votingEngine.controller;



import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.SessionAttributes;

import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.dao.opiskelija.OpiskelijaDao;

@Controller

@RequestMapping("/opiskelijat")
@SessionAttributes("opiskelija")
public class OpiskelijaController {
	
@Inject	
private OpiskelijaDao dao;	
	






	
	public OpiskelijaDao getDao() {
	return dao;
}


public void setDao(OpiskelijaDao dao) {
	this.dao = dao;
}


	@RequestMapping(value="uusivierailija", method=RequestMethod.GET)
	public String getCreateForm1(Model model) {
		Opiskelija o = new Opiskelija();
		
		
		model.addAttribute("opiskelija", o);
		return "opp/createformVisitor";
	}
	
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm2(Model model) {
		Opiskelija o = new Opiskelija();
		
		
		model.addAttribute("opiskelija", o);
		return "opp/createform";
	}
	
	
	
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create1( @ModelAttribute(value="opiskelija") @Valid Opiskelija o, BindingResult result) {
		String polku="redirect:/innot/uusi";
		
		if (result.hasErrors()) {
			polku="opp/createform";
		} 
		
		else{
			
		
	
		}
		return polku;
	}
	
	
	
	
	@RequestMapping(value="uusivierailija", method=RequestMethod.POST)
	public String create2( @ModelAttribute(value="opiskelija") @Valid Opiskelija opiskelija, BindingResult result) {
		String polku="vahvistus/vierailija";
		
		if (result.hasErrors()) {
			polku="opp/createformVisitor";
		} 
		
		else{
			
			int ryhmaId=1;
			int valtuusId=1;
		opiskelija.setRyhmaId(ryhmaId);	
		opiskelija.setValtuusId(valtuusId);
			
		dao.talletaOpiskelija(opiskelija);
	
		}
		return polku;
	}
	
	
	@RequestMapping(value="etusivulle", method=RequestMethod.GET)
	 public String index() {
	    	
		   
		        return "redirect:/";
		}
	
	
	
	
	
	
	
	

}
