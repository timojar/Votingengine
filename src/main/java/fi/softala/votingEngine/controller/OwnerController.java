package fi.softala.votingEngine.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Kuukausi;
import fi.softala.votingEngine.bean.Pvm;
import fi.softala.votingEngine.bean.Votemode;
@SessionAttributes({ "kk", "inno" })
@Controller
@RequestMapping(value = "/management")
public class OwnerController {
	
	

	
	@RequestMapping(value = "voting")
	public ModelAndView chooseMonth() {

		ModelAndView model=new ModelAndView("manag/start");
		 Date date= new Date();
		
		Calendar kalenteri = Calendar.getInstance();
		kalenteri.setTime(date);
		
		List<Kuukausi> kuukaudet=haeKuukaudet();
		
		model.addObject("kuukaudet", kuukaudet);
		model.addObject("kk", new Kuukausi());
		

		return model ;
	}

	

	@RequestMapping(value = "voting", method = RequestMethod.POST)
	public ModelAndView direct(@ModelAttribute(value = "kk") Kuukausi k) {

		ModelAndView model=new ModelAndView("redirect:/management/pickdate");
		
		
		

		return model ;
	}
	
	
	@RequestMapping(value = "pickdate")
	public ModelAndView pickDate(@ModelAttribute(value = "kk") Kuukausi k) {

		ModelAndView model=new ModelAndView("manag/pvm");
		 Date date= new Date();
		
	
		System.out.println("Toimii");
		YearMonth yearMonth = YearMonth.of( k.getVuosi(), k.getNro() );
		
		LocalDate firstOfMonth = yearMonth.atDay( 1 );
		LocalDate last = yearMonth.atEndOfMonth();
		int vika=last.getDayOfMonth();
		System.out.println(firstOfMonth.getDayOfWeek());
		System.out.println(firstOfMonth.getDayOfMonth());
		int i=firstOfMonth.getDayOfMonth();
		
		List<Pvm>paivat=new ArrayList<Pvm>();
		
		Pvm paiva=new Pvm();
		int pv=firstOfMonth.getDayOfMonth();
		String nimi=""+firstOfMonth.getDayOfWeek();
		paiva.setPv(pv);
		paiva.setPaivamaara(firstOfMonth);
		paiva.setNimi(nimi);
		paivat.add(paiva);
		
		while(i<last.getDayOfMonth()){
			paiva=new Pvm();
			i++;
			LocalDate day = yearMonth.atDay( i );	
			
		
			
			
		 pv=day.getDayOfMonth();
		 nimi=""+day.getDayOfWeek();
			paiva.setPv(pv);
			paiva.setNimi(nimi);
			paiva.setPaivamaara(day);
			paivat.add(paiva);
			
		}
		
		
		
		model.addObject("pvm", new Pvm());
		model.addObject("paivat", paivat);
		
		return model ;
	}

	
	@RequestMapping(value = "pickdate" , method = RequestMethod.POST)
	public String insertDate(@ModelAttribute(value = "pvm") Pvm p){
		
		System.out.println(p.getNimi()+" "+p.getStartHH()+":"+p.getStartMM());
		
		return "";
	}
	
	
	
	private List<Kuukausi> haeKuukaudet(){
		
	List<Kuukausi>kuukaudet=new ArrayList();	
	
	
	for(int i=1; i<13; i++){
		YearMonth yearMonth = YearMonth.of( 2017, i);	
	Kuukausi k=new Kuukausi();
	int nro=i;
	String nimi=yearMonth.getMonth().toString();
	k.setNro(nro);
	k.setNimi(nimi);
	kuukaudet.add(k);
	
	}
	
	
	
	return kuukaudet;
		
		
	}
	
	
	

}
