<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><spring:message code="innovaatio.index.title"/></title>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" 
	media="screen,projection" />
	
<link type="text/css" rel="stylesheet" href="resources/css/tyyli.css">
<link type="text/css" rel="stylesheet" href="resources/css/flag-icon-css-master/css/flag-icon.css"> 	 	

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


</head>



	
<body>


	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	
	
	 <nav>
    <div class="nav-wrapper blue lighten-1">
      <a class="brand-logo center">Innovation</a>
      <ul class="left hide-on-med-and-down">
        <li><a href="opiskelijat/uusivierailija"><spring:message code="innovaatio.index.nav.registration" /></a></li>
        <li><a href="opiskelijat/uusi"><spring:message code="innovaatio.index.nav.myinnovation" /></a></li>
        <li><a href="innot/innovaatiot"><spring:message code="innovaatio.index.nav.vote"/></a></li>
        <li><a href="aanet/tulokset"><spring:message code="innovaatio.index.nav.results"/></a></li>
      </ul>
    </div>
  </nav>
	
<div id="kielet">
<div class="chip"><a href="#">
    <img src="resources/css/flag-icon-css-master/flags/1x1/fi.svg" alt="Contact Person">
    Suomi</a>
  </div>
  <div class="chip">
    <img src="resources/css/flag-icon-css-master/flags/1x1/gb.svg" alt="Contact Person">
    English
  </div>
 <div class="chip">
    <img src="resources/css/flag-icon-css-master/flags/1x1/se.svg" alt="Contact Person">
    Svenska
  </div> 
 </div> 
        
 

  
        
 
 
 
 <br>
  <br>
   <br>
   
   
   <div id="sisalto">
 
 <h1><spring:message code="innovaatio.index.heading" /></h1>
 
 
 
 <br>
 
 
 
 
 <div class="row">
        <div class="col s12 m7">
          <div class="card">
            <div class="card-image">
              <img src="resources/kuvat/niagarafalls.jpg">
              <span class="card-title"><spring:message code="innovaatio.index.cardtitle"/></span>
            </div>
            <div class="card-content">
              <p><spring:message code="innovaatio.index.cardtext"/></p>
            </div>
            <div class="card-action">
              <a href="innot/innovaatiot"><spring:message code="innovaatio.index.wellcome"/>
              </a>
            </div>
          </div>
        </div>
      </div>
            
 
 
 

 
        
        
         
          
     
            

 
 

</div>


 <footer class="page-footer blue lighten-1">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>


</body>
</html>





