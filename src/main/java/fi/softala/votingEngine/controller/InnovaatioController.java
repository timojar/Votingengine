package fi.softala.votingEngine.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.bean.Ryhma;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioDao;

@Controller
@RequestMapping(value = "/innot")
@SessionAttributes({"opiskelija","inno"})


public class InnovaatioController {

	@Inject
	private InnovaatioDao innovaatiodao;

	public InnovaatioDao getInnovaatiodao() {
		return innovaatiodao;
	}

	public void setInnovaatiodao(InnovaatioDao innovaatiodao) {
		this.innovaatiodao = innovaatiodao;
	}

	@RequestMapping(value = "innovaatiot", method = RequestMethod.GET)
	public ModelAndView getdata() {
		
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String email=auth.getName();
		Opiskelija o=innovaatiodao.haeOpiskelija(email);
		int ryhmaId=o.getRyhmaId();

		ModelAndView model = new ModelAndView("inn/listaus");
		List<Innovaatio> innovaatiot = innovaatiodao.haeKaikki(ryhmaId);
		model.addObject("opiskelija", o);
		model.addObject("innot", innovaatiot);
		model.addObject("inno", new Innovaatio());

		return model;

	}
	
	
	
	@RequestMapping(value = "innovaatiot", method = RequestMethod.POST)
	public String toVote(@ModelAttribute(value = "inno")  Innovaatio innovaatio
			){
		
		
		System.out.println(innovaatio.getId()+"id");
		
		
		
		return "redirect:/aanet/aanestys";
	}
	
	
	
	
	
	
	

	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Innovaatio i = new Innovaatio();

		model.addAttribute("innovaatio", i);
		return "inn/createform";
	}

	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String create(
			@ModelAttribute(value = "innovaatio") @Valid Innovaatio innovaatio,
			BindingResult result,
			@ModelAttribute(value = "opiskelija") Opiskelija o) {
		String polku = "";

		if (result.hasErrors()) {
			return "inn/createform";
		}

		else {
			Ryhma ryhma=new Ryhma();
			String nimi=innovaatio.getNimi();
			String tyyppi="innovaatio";
			ryhma.setTyyppi(tyyppi);
			ryhma.setNimi(nimi);
			
			
			int ryhmaId=innovaatiodao.talletaRyhma(ryhma);
			innovaatio.setRyhmaId(ryhmaId);
			
			int id = innovaatiodao.talletaInnovaatio(innovaatio);
			
			Logger log = LoggerFactory.getLogger(InnovaatioController.class);
			
			
			o.setRyhmaId(ryhmaId);
			innovaatio.setId(id);
			o.setInnovaatio(innovaatio);
			String email=o.getEmail();
			String tunniste=innovaatiodao.talletaOpiskelija(o);
			
			Authentication authentication =  new UsernamePasswordAuthenticationToken(email, tunniste);
			
			log.debug("Logging in with {}", authentication.getPrincipal());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return "redirect:/innot/innovaatio"+o.getId();
		}

		
	}

	@RequestMapping(value = "innovaatio"+"{id}", method = RequestMethod.GET)
	public ModelAndView getView(@PathVariable Integer id) {
		
		
		Opiskelija o=innovaatiodao.etsiOpiskelija(id);
		int ryhmaId=o.getRyhmaId();
		Innovaatio innovaatio=innovaatiodao.etsiInnovaatio(ryhmaId);
		
		o.setInnovaatio(innovaatio);
		
		ModelAndView model = new ModelAndView("inn/view");
		model.addObject("opiskelija1", o);
		
		
		return model;
	}
	
	
	
	
	
	
	
	 
	 
	

}
