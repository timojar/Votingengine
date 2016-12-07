<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
 <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="innovaatio.confirm.title"></spring:message></title>






<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="../resources/css/materialize.min.css" 
	media="screen,projection" />

<link type="text/css" rel="stylesheet" href="../resources/css/form.css"> 		
<link type="text/css" rel="stylesheet" href="../resources/css/tyyli.css"> 	

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
      <a href="#!" class="brand-logo center">Logo</a>
      <ul class="left hide-on-med-and-down">
        
       <li class="active"><a href="hallitse">
   Back
            </a></li>
            
        
      </ul>
    </div>
  </nav>
	




<h1><spring:message code="innovaatio.confirm.heading"></spring:message></h1>
 <div class="row">
<form:form modelAttribute="token" method="post" class="col s12">

<div class="row">
<div class="input-field col s12">
<form:label path="email"><spring:message code="opiskelija.create.email"></spring:message></form:label>
<br>

<form:input type="hidden" path="ryhmaId" value="${opiskelija.ryhmaId }"/>
<form:input  path="email" /><form:errors path="email" cssClass="Virheteksti"></form:errors>
</div>
</div>
  <br>
 <br>
  <br>
 <br>

<button class="btn waves-effect waves-light" type="submit" name="action"><spring:message code="opiskelija.create.button"></spring:message>
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