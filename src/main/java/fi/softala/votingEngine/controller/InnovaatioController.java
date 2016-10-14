package fi.softala.votingEngine.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

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
@SessionAttributes("opiskelija")

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

		ModelAndView model = new ModelAndView("inn/listaus");
		List<Innovaatio> innovaatiot = innovaatiodao.haeKaikki();
		model.addObject("innot", innovaatiot);

		return model;

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
			
			/* 
			 * talletaRyhma(innovaatio)-metodin parametrinä on innovaatio,
			 *  koska ryhman nimi tulee olemaan sama kuin innovaation nimi
			 */
			
			
			
			o.setRyhmaId(ryhmaId);
			innovaatio.setId(id);
			o.setInnovaatio(innovaatio);
			
			innovaatiodao.talletaOpiskelija(o);
			
			
			return "redirect:/innot/"+o.getId();
		}

		
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
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
