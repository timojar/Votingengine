package fi.softala.votingEngine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping (value="/logfin")
public class LoginController {
	
	
	
	@RequestMapping(value="/loginpage", method = RequestMethod.GET)
	public String login(Model model) {
 
		return "security/login";
 
	}	

}
