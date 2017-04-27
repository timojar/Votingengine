<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	
	


<sec:authorize access="hasRole('OWNER_USER')">
<c:set var="owner" value="1"/> 
</sec:authorize>
<sec:authorize access="hasRole('VOTED_USER')">
<c:set var="voted" value="1"/> 
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<c:set var="user" value="1"/> 
</sec:authorize>



	
	
	

	 <nav>
	 

	 
    <div class="nav-wrapper blue lighten-1">
      <a class="brand-logo center">Innovation</a>
      <ul class="left hide-on-med-and-down">
      <sec:authorize access="hasAnyRole('ROLE_ADMIN, ROLE_USER, OWNER_USER, VOTED_USER')">
      <c:set var="login" value="1"/> 
<li class="active"><a href="innot/ulos">
   Logout
            </a></li>
           
            
</sec:authorize>
<c:if test="${login!=1}">
 <li><a href="aanet/log"> <i class="material-icons">vpn_key</i></a></li>
        <li><a href="opiskelijat/uusivierailija"><spring:message code="innovaatio.index.nav.registration" /></a></li>
		

  </c:if>

 <c:if test="${voted!=1 && user!=1 && owner!=1}">  
  <li><a href="innot/myinnovation"><spring:message code="innovaatio.index.nav.myinnovation" /></a></li>
  </c:if>
 <c:if test="${voted!=1}">  
        <li><a href="innot/innovaatiot"><spring:message code="innovaatio.index.nav.vote"/></a></li>
        </c:if>
        
 <c:if test="${voted==1 || owner==1 }">         
       <li> <a href="aanet/tulokset"><spring:message code="innovaatio.index.nav.results"/></a></li>
 </c:if>      
 
 <c:if test="${owner==1 }">         
       <li> <a href="management/index">Set voting</a></li>
 </c:if>  
      
      </ul>
    </div>
  </nav>
	
<div id="kielet">
<div class="chip"><a href="?lang=fi">
    <img src="resources/css/flag-icon-css-master/flags/1x1/fi.svg" alt="Contact Person">
    Suomi</a>
  </div>
  <div class="chip"><a href="?lang=en">
    <img src="resources/css/flag-icon-css-master/flags/1x1/gb.svg" alt="Contact Person">
    English</a>
  </div>
 <div class="chip"><a href="?lang=se">
    <img src="resources/css/flag-icon-css-master/flags/1x1/se.svg" alt="Contact Person">
    Svenska</a>
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
              <img src="resources/kuvat/greatideas.jpg">
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
                
              </div>
              <div class="col l4 offset-l2 s12">
               
                <ul>
     
                 
                </ul>
                 <br>
                  <br>
                   <br>
                   <br>
                  <br>
                   <br>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            InnoDay 2016
              </div>
          </div>
        </footer>


</body>
</html>





