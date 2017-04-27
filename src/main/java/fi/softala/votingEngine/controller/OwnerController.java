package fi.softala.votingEngine.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.votingEngine.bean.Aika;
import fi.softala.votingEngine.bean.Innovaatio;
import fi.softala.votingEngine.bean.Kuukausi;
import fi.softala.votingEngine.bean.Pvm;
import fi.softala.votingEngine.bean.Votemode;
import fi.softala.votingEngine.dao.Aika.DaoAika;
@SessionAttributes({ "kk", "inno" })
@Controller
@RequestMapping(value = "/management")
public class OwnerController {
	
@Inject
private DaoAika daoAika;




	
	public DaoAika getDaoAika() {
	return daoAika;
}



public void setDaoAika(DaoAika daoAika) {
	this.daoAika = daoAika;
}



	@RequestMapping(value = "voting")
	public ModelAndView chooseMonth() {

		ModelAndView model=new ModelAndView("manag/start");
		 Date date= new Date();
		
		Calendar kalenteri = Calendar.getInstance();
		kalenteri.setTime(date);
		YearMonth yearMonth = YearMonth.now();
		int vuosi=yearMonth.getYear();
		
		List<Kuukausi> kuukaudet=haeKuukaudet();
		
		System.out.println("lkm "+kuukaudet.size());
		
		model.addObject("y", vuosi);
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
		
		
	Pvm p=	new Pvm() ;
	int startHH=16;
	int startMM=10;
	int endHH=18;
	int endMM=30;
	p.setStartHH(startHH);
	p.setStartMM(startMM);
	p.setEndHH(endHH);
	p.setEndMM(endMM);	
		model.addObject("pvm", p);
		model.addObject("paivat", paivat);
		
		return model ;
	}

	
	@RequestMapping(value = "pickdate" , method = RequestMethod.POST)
	public String insertDate(@ModelAttribute(value = "pvm") Pvm p, @ModelAttribute(value = "kk") Kuukausi k){
		Date aika=null;
		Date alkuKello=null;
		Date loppuKello=null;
		String pvmString=p.getPv()+"."+k.getNro()+"."+k.getVuosi()+"-"+p.getStartHH()+":"+p.getEndMM();
		String alkuKelloString=p.getPv()+"."+k.getNro()+"."+k.getVuosi()+"-"+p.getStartHH()+":"+p.getStartMM();
		String loppuKelloString=p.getPv()+"."+k.getNro()+"."+k.getVuosi()+"-"+p.getEndHH()+":"+p.getEndMM();		
				SimpleDateFormat formpvm=new SimpleDateFormat("dd.MM.yyy-HH:mm");
				SimpleDateFormat formAlkukello=new SimpleDateFormat("dd.MM.yyy-HH:mm");
				SimpleDateFormat formLoppuKello=new SimpleDateFormat("dd.MM.yyy-HH:mm");
				try {
					alkuKello=formAlkukello.parse(alkuKelloString);
					loppuKello=formLoppuKello.parse(loppuKelloString);
				} catch (Exception e) {
					// TODO: handle exception
				}
				p.setLoppuKello(loppuKello);	
				p.setAlkuKello(alkuKello);
				
		daoAika.asetaAika(p);
		System.out.println(alkuKello);
		System.out.println(loppuKello);
		
		return "redirect:/management/index";
		

	}
	@RequestMapping(value = "ulos", method = RequestMethod.GET)
	public String indexAndLogout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/";
	}

	
	

	@RequestMapping(value = "index")
	public ModelAndView index() {

		ModelAndView model=new ModelAndView("manag/index");
		Aika a=haeAika();
		model.addObject("aika", a);
		return model ;
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
	
	
	
	
private Aika haeAika(){
	Aika a=null;
	try {
		 a=daoAika.haeAika();
		
	    Date pvm = a.getPvm();
	    Date time1=a.getAlku();
	    
	    String alkustr=time1.getHours()+":"+time1.getMinutes();
	    
	   
	    
	    
	    Date time2=a.getLoppu();
	    String loppustr=time2.getHours()+":"+time2.getMinutes();
	   
	    String aikavali=alkustr+"-"+loppustr;
	    
	  a.setAikavali(aikavali);
	    a.setPvm(pvm);
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
		
	
	return a;
	
}
	
	
	

}
