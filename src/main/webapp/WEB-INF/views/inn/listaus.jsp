<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><spring:message code="innovaatio.listaus.title" /></title>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="../resources/css/materialize.min.css" 
	media="screen,projection" />
	
<link type="text/css" rel="stylesheet" href="../resources/css/tyyli.css"> 	

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
 <meta http-equiv="Pragma" content="no-cache">
 <meta http-equiv="Cache-Control" content="no-cache">
 <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

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
       <li><a href="../j_spring_security_logout" > <spring:message code="innovaatio.listaus.link" /></a></li> 
      </ul>
    </div>
  </nav>
	



  
        

 
 
 <br>
  <br>
   <br>
   
   
   <div id="sisalto">
 
 <h1><spring:message code="innovaatio.listaus.heading" /></h1>
 
 
 
 
 
 
 
 
        
     
         
         
     
            
 <table>
 <tbody>
 
 
 <c:forEach var="innovaatio" items="${innot }">
 
 <tr>
            <td id=""><c:out value="${innovaatio.nimi }"></c:out></td>
            <td><c:out value="${innovaatio.aihe }"></c:out></td>
            <td>
            
   <form:form modelAttribute="inno" method="post" class="col s12">     
   
   <form:input path="id" value="${innovaatio.id}" type="hidden"/>
   
   
  <button class="btn waves-effect blue" type="submit" name="action"><spring:message code="innovaatio.listaus.button" />
    <i class="material-icons right">send</i>
  </button>
  </form:form>
        </td>
          </tr>
          
          
        
          

        
 
</c:forEach>


</tbody>
  </table>
 
 

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





