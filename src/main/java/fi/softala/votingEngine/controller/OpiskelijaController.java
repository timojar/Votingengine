package fi.softala.votingEngine.controller;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.SessionAttributes;

import fi.softala.votingEngine.bean.Opiskelija;

@Controller

@RequestMapping("/opiskelijat")
@SessionAttributes("opiskelija")
public class OpiskelijaController {
	
	
	
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Opiskelija o = new Opiskelija();
		
		
		model.addAttribute("opiskelija", o);
		return "opp/createform";
	}
	
	
	
	@RequestMapping(value="uusi", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="opiskelija") @Valid Opiskelija o, BindingResult result) {
		String polku="redirect:/innot/uusi";
		
		if (result.hasErrors()) {
			polku="opp/createform";
		} 
		
		else{
			
		
	
		}
		return polku;
	}
	
	
	
	
	
	
	
	
	
	
	

}
