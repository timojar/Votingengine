<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="innovaatio.view.title" /></title>

<link type="text/css" rel="stylesheet" href="../resources/css/materialize.min.css" 
	media="screen,projection" />
	
<link type="text/css" rel="stylesheet" href="../resources/css/tyyli.css" 
	/>	


</head>
<body>


	 <nav>
    <div class="nav-wrapper blue lighten-1">
      <a href="#!" class="brand-logo center">Logo</a>
      <ul class="left hide-on-med-and-down">
       <li><a href="logout" > <spring:message code="innovaatio.listaus.link" /></a></li> 
      </ul>
    </div>
  </nav>
	
<div id="sisalto">






<br>
<br>

<br>

<br>

<h1><spring:message code="innovaatio.view.heading" /></h1>

<br>
<br>
<a class="waves-effect waves-light btn" href="muokkaa"><spring:message code="innovaatio.view.edit" /></a>

<a class="waves-effect waves-light btn" href="lisaaopiskelija"><spring:message code="innovaatio.view.add" /></a>
<br>

<br>
<br>

<h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.name" />:</span></h5>
    <h5 class="left--align"><c:out value="${opiskelija1.innovaatio.nimi}"></c:out></h5>
    <h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.topic" />:</span></h5>
    <h5 class="left--align"><c:out value="${opiskelija1.innovaatio.aihe}"></c:out></h5>
 
<br>
<br>



<br>
<br>
    
    
        






<br>
<br>

<br>
<h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.heading1" /></span></h5>
      <table class="striped">
        <thead>
          <tr>
              <th data-field="id"><spring:message code="innovaatio.view.studentnumber" /></th>
              <th data-field="name"><spring:message code="innovaatio.view.firstname" /></th>
              <th data-field="price"><spring:message code="innovaatio.view.lastname" /></th>
              <th data-field="price"><spring:message code="innovaatio.view.email" /></th>
          </tr>
        </thead>

        <tbody><c:forEach var="opp" items="${oppilaat}">
          <tr>
            <td><c:out value="${opp.opiskelijanumero }"></c:out></td>
            <td><c:out value="${opp.etunimi }"></c:out></td>
            <td><c:out value="${opp.sukunimi }"></c:out></td>
            <td><c:out value="${opp.email }"></c:out></td>
          </tr>
          </c:forEach>
          
        
        </tbody>
      </table>
            



<br>
<br>
<br>
<h3><spring:message code="innovaatio.view.heading2" /></h3>
  	<h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.studentnumber" />:</span></h5>
    <h5 class="left--align"><c:out value="${opiskelija1.opiskelijanumero }"></c:out></h5>
  	<h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.firstname" />:</span></h5>
    <h5 class="left--align"><c:out value="${opiskelija1.etunimi }"></c:out></h5>
  	<h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.lastname" />:</span></h5>
    <h5 class="left--align"><c:out value="${opiskelija1.sukunimi }"></c:out></h5>
    <h5 class="left--align"><span id="alaotsikko"><spring:message code="innovaatio.view.email" />:</span></h5>
    <h5 class="left--align"><c:out value="${opiskelija1.email }"></c:out></h5>
    
    <br>
 </div>

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