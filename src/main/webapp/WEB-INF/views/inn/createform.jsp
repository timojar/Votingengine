<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="../resources/css/materialize.min.css" 
	media="screen,projection" />
	
<link type="text/css" rel="stylesheet" href="../resources/css/tyyli.css"> 
<link type="text/css" rel="stylesheet" href="../resources/css/form.css"> 		

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="innovaatio.create.title" /></title>
</head>
<body>



<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	
	
	 <nav>
    <div class="nav-wrapper blue lighten-1">
      <a href="#!" class="brand-logo center">Logo</a>
      <ul class="left hide-on-med-and-down">
        <li><a href="sass.html">Sass</a></li>
        <li><a href="badges.html">Components</a></li>
        <li class="active"><a href="collapsible.html">JavaScript</a></li>
      </ul>
    </div>
  </nav>
	



<h1>
		<spring:message code="innovaatio.create.heading" />
	</h1>
	
		<form:form modelAttribute="innovaatio" method="post" class="col s12">
	
		<div class="row">
		  
				
				<div class="input-field col s6">
					<form:label	path="nimi" for="first_name"><spring:message code="innovaatio.create.name" /></form:label>
					<br>	
					<form:input path="nimi" cssErrorClass="VirheellinenKentta" placeholder="Placeholder" id="first_name" type="text" class="validate"/> <form:errors path="nimi" cssClass="Virheteksti"/>	
					
				</div>
				<br>
				<br>
				<br>
				
		</div>		<div class="row">	
				<div class="input-field col s6">
				<form:label path="aihe" for="first_name"> <spring:message code="innovaatio.create.topic" /></form:label>
				<br/>
				<form:input path="aihe" id="last_name" type="text" class="validate" placeholder="Placeholder"/><form:errors path="aihe" cssClass="Virheteksti"/>
					
					
				 </div>	
				
					
				
			
			</div>
			
			<button class="btn waves-effect waves-light" type="submit" name="action"><spring:message code="innovaatio.create.button" />
    <i class="material-icons right">send</i>
  </button>
        
		</form:form>
		
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