package fi.softala.votingEngine.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpPlus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.bean.Ryhma;
import fi.softala.votingEngine.bean.Token;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioDao;
import fi.softala.votingEngine.dao.opiskelija.OpiskelijaDao;
import fi.softala.votingEngine.dao.token.TokenDao;
import fi.softala.votingEngine.emailservice.SpostiLahetys;
import fi.softala.votingEngine.util.Kryptaaja;

import java.util.UUID;
@Controller
@RequestMapping(value = "/innot")
@SessionAttributes({ "opiskelija", "inno" })
public class InnovaatioController {

	@Autowired
	private OpiskelijaDao opiskelijadao;
	@Autowired
	private TokenDao tokendao;
	
	@Autowired
	private SpostiLahetys lahetys;
	
	
	public TokenDao getTokendao() {
		return tokendao;
	}

	public void setTokendao(TokenDao tokendao) {
		this.tokendao = tokendao;
	}

	@Inject
	private InnovaatioDao innovaatiodao;

	public OpiskelijaDao getOpiskelijadao() {
		return opiskelijadao;
	}

	public void setOpiskelijadao(OpiskelijaDao opiskelijadao) {
		this.opiskelijadao = opiskelijadao;
	}

	public InnovaatioDao getInnovaatiodao() {
		return innovaatiodao;
	}

	public void setInnovaatiodao(InnovaatioDao innovaatiodao) {
		this.innovaatiodao = innovaatiodao;
	}

	@RequestMapping(value = "innovaatiot", method = RequestMethod.GET)
	public ModelAndView getdata() {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String email = auth.getName();
		Opiskelija o = opiskelijadao.haeOpiskelija(email);
		int ryhmaId = o.getRyhmaId();

		ModelAndView model = new ModelAndView("inn/listaus");
		List<Innovaatio> innovaatiot = innovaatiodao.haeKaikki(ryhmaId);
		model.addObject("opiskelija", o);
		model.addObject("innot", innovaatiot);
		model.addObject("inno", new Innovaatio());

		return model;

	}

	@RequestMapping(value = "innovaatiot", method = RequestMethod.POST)
	public String toVote(@ModelAttribute(value = "inno") Innovaatio innovaatio) {

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
			@ModelAttribute(value = "opiskelija") Opiskelija opiskelija) {
		String polku = "";

		if (result.hasErrors()) {
			return "inn/createform";
		}

		else {
			Ryhma ryhma = new Ryhma();
			String nimi = innovaatio.getNimi();
			String tyyppi = "innovaatio";
			ryhma.setTyyppi(tyyppi);
			ryhma.setNimi(nimi);
			
			int ryhmaId = innovaatiodao.talletaRyhma(ryhma);
			innovaatio.setRyhmaId(ryhmaId);

			int id = innovaatiodao.talletaInnovaatio(innovaatio);
			
			int valtuusId=2;
			opiskelija.setValtuusId(valtuusId);
			opiskelija.setRyhmaId(ryhmaId);
			innovaatio.setId(id);
			opiskelija.setInnovaatio(innovaatio);
			opiskelijadao.talletaOpiskelija(opiskelija);
			ModelAndView model = new ModelAndView();
			model.addObject("opiskelija", opiskelija);

			return "redirect:/innot/tarkista";
		}

	}

	@RequestMapping(value = "hallitse", method = RequestMethod.GET)
	public ModelAndView hallitseInnovaatiota() {

		Opiskelija o = dummyOpiskelija();

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String email = auth.getName();
		o = opiskelijadao.haeOpiskelija(email);

		int ryhmaId = o.getRyhmaId();
		Innovaatio innovaatio = innovaatiodao.etsiInnovaatio(ryhmaId);

		o.setInnovaatio(innovaatio);
		
		ModelAndView model = new ModelAndView("inn/view");
		model.addObject("inno", innovaatio);
		model.addObject("opiskelija1", o);
		model.addObject("oppilaat", opiskelijadao.haeInnovaationOpiskelijat(ryhmaId));

		return model;
	}

	@RequestMapping(value = "tarkista", method = RequestMethod.GET)
	public ModelAndView esiKatsele(
			@ModelAttribute(value = "opiskelija") Opiskelija o) {
		int ryhmaId=o.getRyhmaId();
		ModelAndView model = new ModelAndView("inn/view");

		model.addObject("inno", innovaatiodao.etsiInnovaatio(ryhmaId));
		model.addObject("opiskelija1", o);
		model.addObject("oppilaat", opiskelijadao.haeInnovaationOpiskelijat(ryhmaId));

		return model;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView ulosKirjaudu(SessionStatus status) {
		status.setComplete();
		ModelAndView model = new ModelAndView("logout");

		SecurityContextHolder.getContext().setAuthentication(null);

		return model;
	}

	@RequestMapping(value = "etusivulle", method = RequestMethod.GET)
	public String index() {

		return "redirect:/";
	}

	@RequestMapping(value = "lisaaopiskelija", method = RequestMethod.GET)
	public ModelAndView viewLisaaOpiskelija() {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String email = auth.getName();
		Opiskelija o = opiskelijadao.haeOpiskelija(email);
		
		ModelAndView model = new ModelAndView("inn/addOppilas");
		model.addObject("opiskelija", o);
		model.addObject("token", new Token());

		return model;
	}

	@RequestMapping(value = "lisaaopiskelija", method = RequestMethod.POST)
	public ModelAndView LisaaOpiskelija(
			@ModelAttribute(value = "token") @Valid Token v, BindingResult result, @ModelAttribute(value = "opiskelija") Opiskelija o
			, @ModelAttribute(value = "inno") Innovaatio i) {

		
		
		ModelAndView model = new ModelAndView("inn/emailSucceed");
		
		if (result.hasErrors()) {
			model.setViewName("inn/addOppilas");
		}
		
		else{
			
		Kryptaaja krypt=new Kryptaaja();	
			
		System.out.println(v.getEmail() + v.getRyhmaId());
		String random=UUID.randomUUID().toString();
		String tokenId=krypt.merkkijonoKryptattuna(random);
		v.setTokenId(tokenId);
		tokendao.lisaaToken(v);
		String url="http://localhost:8080/softala_votingengine/token/"+tokenId;
		String body=emailBody(url,o, i);
		lahetys.sendMail(v.getEmail(), "Invite to InnoDay",body );
		}
		return model;
	}

	


	
	@RequestMapping(value="myinnovation")
	public String myInnovation(){
		
		
		return "inn/innovation";
	}
	
	
	private Opiskelija dummyOpiskelija() {

		final String email = "oletus@oletus";
		final String etunimi = "oletusnimi";
		final String sukunimi = "oletusnimi";
		final String opiskelijanumero = "00000";
		final String nimi = "00000";
		final String aihe = "00000";

		Opiskelija o = new Opiskelija();
		Innovaatio i = dummyInnovaatio();
		o.setEmail(email);
		o.setEtunimi(etunimi);
		o.setSukunimi(sukunimi);
		o.setOpiskelijanumero(opiskelijanumero);

		return o;

	}

	private Innovaatio dummyInnovaatio() {

		Innovaatio i = new Innovaatio();
		final String nimi = "00000";
		final String aihe = "00000";
		i.setAihe(aihe);
		i.setNimi(nimi);

		return i;
	}
	
	
	
private String emailBody(String url, Opiskelija o, Innovaatio i){
	String linebreak = System.getProperty("line.separator");
	
String text=
"Hey! " +  linebreak+linebreak+ 
o.getEtunimi()+" "+o.getSukunimi()+" has invited you to join  "+i.getNimi()+"-innovation group"+linebreak+
"Click link below to join:"
+linebreak+linebreak+url+linebreak
+linebreak+
"Best regards"+linebreak+
"Innovation Conference ";	
	
	return text;
}
	

}
