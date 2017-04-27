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
       <li><a href="ulos" > <spring:message code="innovaatio.listaus.link" /></a></li> 
      </ul>
    </div>
  </nav>
	
<div id="sisalto">






<br>
<br>

<br>

<br>

<h1>Äänestyksen asettaminen</h1>

<br>
<br>
<a class="waves-effect waves-light btn" href="voting">Aseta äänestys</a>




<br>
<br>
    
    
        






<br>
<br>

<br>

      <table class="striped">
        <thead>
          <tr>
              <th data-field="id">Äänestys päivä</th>
              <th data-field="name">Äänestys aika</th>
            
          </tr>
        </thead>

        <tbody>
          <tr>
            <td><c:out value="${aika.pvm }"></c:out></td>
            <td><c:out value="${aika.aikavali }"></c:out></td>
           
          </tr>
          
          
        
        </tbody>
      </table>
            



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