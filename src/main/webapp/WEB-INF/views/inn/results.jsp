<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 

<title><spring:message code="innovaatio.results.title" /></title>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="../resources/css/materialize.min.css" 
	media="screen,projection" />
	
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
        
        <li class="active"><a href="ulos" >Logout</a></li>
      </ul>
    </div>
  </nav>
	
  <p></p>   

 

  
        

 
 
 <br>
  <br>
   <br>
   
   
   <div id="sisalto">
 
 <h1><spring:message code="innovaatio.results.heading" /></h1>
 
 
 
 
 
 
 
 
        
     
         
        
     
            
 <table>
 
 <thead>
          <tr>
              <th data-field="id"><spring:message code="innovaatio.results.name" /></th>
              <th data-field="name"><spring:message code="innovaatio.results.topic" /></th>
              <th data-field="price"><spring:message code="innovaatio.results.votes" /></th>
          </tr>
        </thead>
 
 
 <tbody>
 
 
 <c:forEach var="aani" items="${aanet }">
 
 <tr>
            <td id=""><c:out value="${aani.innoNimi }"></c:out></td>
            <td><c:out value="${aani.aihe }"></c:out></td>
            <td>  <c:out value="${aani.lkm }"></c:out>             </td>
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





