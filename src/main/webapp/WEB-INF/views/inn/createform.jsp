<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="innovaatio.create.title" /></title>
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
	<script type="text/javascript" src="../resources/js/materialize.min.js"></script>
	
	
	 <nav>
    <div class="nav-wrapper blue lighten-1">
      <a href="#!" class="brand-logo center">Logo</a>
      <ul class="left hide-on-med-and-down">
      
      </ul>
    </div>
  </nav>
	
<br>
<br>
<br>
<h1>Innovation data</h1>
<br>
<br>
<br>



<div class="row">
      <form:form modelAttribute="innovaatio" method="post" class="col s12">
        <div class="row">
          <div class="input-field col s6">
            <form:input path="nimi"  id="input_text" type="text" maxlength="50" length="50"/>

            <label for="input_text">Name of the Innovation</label><form:errors path="nimi" cssClass="Virheteksti"/>	
          </div>
        </div>
        <div class="row">
          <div class="input-field col s8">
          
            <form:input path="aihe"  id="input_text" type="text" maxlength="70" length="70"/>
            <label for="textarea1">Describe your topic</label><form:errors path="aihe" cssClass="Virheteksti"/>
          </div>
        </div>
        
        
        <button class="btn waves-effect waves-light" type="submit" name="action"><spring:message code="innovaatio.create.button" />
    <i class="material-icons right">send</i>
  </button>
        
        
      </form:form>
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