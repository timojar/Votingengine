package fi.softala.votingEngine.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.votingEngine.bean.Opiskelija;
import fi.softala.votingEngine.bean.Token;
import fi.softala.votingEngine.dao.innovaatio.InnovaatioDao;
import fi.softala.votingEngine.dao.opiskelija.OpiskelijaDao;
import fi.softala.votingEngine.dao.token.TokenDao;
import fi.softala.votingEngine.emailservice.SpostiLahetys;


@Controller
@RequestMapping(value = "/token")
@SessionAttributes({ "opiskelija", "tokenId" })
public class TokenController {
	
	
	
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

	@Autowired
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

	
	
	
	
	
	@RequestMapping(value = "etusivulle", method = RequestMethod.GET)
	public String index() {

		return "redirect:/";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "{tokenId}", method = RequestMethod.GET)
	public ModelAndView receiveConfirmOpiskelija(@PathVariable String tokenId, SessionStatus status){
		ModelAndView model=new ModelAndView("inn/confirm");
		boolean exist=false;
		Token token=tokendao.haeToken(tokenId);
		int ryhmaId=token.getRyhmaId();
		Opiskelija o=new Opiskelija();
		String email=token.getEmail();
		o.setRyhmaId(ryhmaId);
		o.setEmail(email);
		System.out.println(ryhmaId);
		 model.addObject("opiskelija", o);
		 model.addObject("tokenId", tokenId);
		
		 
		 exist=checkEmail(email);
		 
		 if(exist==true){
			 status.setComplete();
		tokendao.poistaToken(tokenId);	 
			 
			model.setViewName("inn/exist"); 
		 }
		 
		 
			
			return model;
	}
			
		
		
		@RequestMapping(value = "{tokenId}", method = RequestMethod.POST)
	public String ConfirmOpiskelija(@ModelAttribute(value = "opiskelija")@Valid Opiskelija opiskelija, BindingResult result, @ModelAttribute(value = "tokenId") String tokenId){
		
		if (result.hasErrors()) {
			return "inn/confirm";
		}
		else {
			
		
		
			int valtuusId=1;
			opiskelija.setValtuusId(valtuusId);
			
			opiskelijadao.talletaOpiskelija(opiskelija);
			
			tokendao.poistaToken(tokenId);
			
			return "inn/vahvistus";}
	}
	
	
		
		private boolean checkEmail(String email){
			
			boolean exist= false;
			Opiskelija o=new Opiskelija();
		try {o=opiskelijadao.haeOpiskelija(email);
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
		if(email.equals(o.getEmail())){
			
		exist=true;	
			
		}
		
		return exist;
			
			
		}
	

}
