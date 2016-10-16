package fi.softala.votingEngine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/")
@Controller
public class HTTPErrorHandler {

	
	
	
	 @RequestMapping(value="/403")
	    public String error403(){
	       // DO stuff here 
	        return "errors/403";
	    }	
	
	
	
	
	
}
