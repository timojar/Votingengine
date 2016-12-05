<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page session="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="innovaatio.login.title" /></title>

<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css" 
	media="screen,projection" />
	
<link type="text/css" rel="stylesheet" href="resources/css/tyyli.css"> 	

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />





</head>
<body>

<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	
	
	 <nav>
    <div class="nav-wrapper blue lighten-1">
      <a class="brand-logo center">Innovation</a>
      <ul class="left hide-on-med-and-down">
      <li><a href="innot/etusivulle"><spring:message code="innovaatio.login.frontpage" /></a></li>
      </ul>
    </div>
  </nav>

<div id="sisalto">

<h1><spring:message code="innovaatio.login.heading" /></h1>



	<c:if test="${not empty loginerror}">
		<p class="Error"><spring:message code="innovaatio.login.loginerror" /></p>
	</c:if>

	<c:if test="${not empty loggedout}">
		<p class="Info"><spring:message code="innovaatio.login.logoutsuccessful" /></p>
	</c:if>
	
</div>








  <div class="row">
    <form class="col s12" action="j_spring_security_check" method="post">
      
      <div class="row">
      
     
      
        
        <div class="input-field col s12">
        <label for="text"><spring:message code="innovaatio.login.email" />
</label>
         <br>
        
          <input id="text"  class="validate" type='text' name='j_username'>
          
        </div>
      
      <div class="row">
        <div class="input-field col s12">
        
         <label for="text"><spring:message code="innovaatio.login.studentnumber" />
</label>
         <br>
          <input id="text" type="text" class="validate" name='j_password' >
         
        </div>
      </div>
      
      </div>
      
      
       <p><a href="opiskelijat/uusivierailija">You are not registered? Sign up here!</a></p>
      <br>
     
       <br>
        <br>
      <button class="btn waves-effect waves-light" type="submit" name="action"><spring:message code="innovaatio.login.button" />
    <i class="material-icons right">send</i>
  </button>
        
      
      
    </form>
  </div>
        




<br>
<br>

<br>
<br>
<br>
<br>
<br>
<br>
<br>







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