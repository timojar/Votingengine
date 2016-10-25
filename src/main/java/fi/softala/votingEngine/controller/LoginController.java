package fi.softala.votingEngine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.votingEngine.emailservice.SpostiLahetys;


@Controller
@RequestMapping (value="/")
public class LoginController {
 
	@Autowired
	private SpostiLahetys lahetys;
	
	@RequestMapping(value="/loginpage", method = RequestMethod.GET)
	public String login(Model model) {
		lahetys.sendMail("timo.jarmala@myy.haaga-helia.fi", "subject", "body");
		return "login";
 
	}
 
	@RequestMapping(value="/loginfail", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("loginerror", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		model.addAttribute("loggedout", "true");
		return "login";
 
	}
	
}