<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="../resources/css/materialize.min.css" 
	media="screen,projection" />
	
<link type="text/css" rel="stylesheet" href="../resources/css/tyyli.css"> 	

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />



<title><spring:message code="innovaatio.vahvistus.title" /></title>
</head>
<body>


<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	
	
	 <nav>
    <div class="nav-wrapper blue lighten-1">
      <a  class="brand-logo center">Logo</a>
      <ul class="left hide-on-med-and-down">
        
      </ul>
    </div>
  </nav>
	

<div id="sisalto">

<h1><spring:message code="innovaatio.vahvistus.heading" /></h1>
<br>
<br>
<br>
<h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.name" />:</span></h5>
    <h5 class="left--align"><c:out value="${innovaatio.nimi}"></c:out></h5>
    <h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.topic" />:</span></h5>
    <h5 class="left--align"><c:out value="${innovaatio.aihe}"></c:out></h5>
 
<br>
<h5><spring:message code="innovaatio.vahvistus.text" /></h5>
<br>
<br>

<h5></h5>

<br>
<br>

<a href="peru" class="waves-effect red btn-large"><spring:message code="innovaatio.vahvistus.buttonno" /></a>
<a href="vahvista" class="waves-effect waves-light btn-large"><spring:message code="innovaatio.vahvistus.buttonyes" /></a>




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