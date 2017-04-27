<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
 <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Äänestyksen asettaminen</title>

<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="../resources/css/materialize.min.css" 
	media="screen,projection" />
	
<link type="text/css" rel="stylesheet" href="../resources/css/tyyli.css"> 
<link type="text/css" rel="stylesheet" href="../resources/css/form.css">







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
        
      </ul>
    </div>
  </nav>
	  <br>
<br>
<br><div id="sisalto">


<h1>Valitse äänestys päivän vuosi ja kuukausi</h1>






<form:form modelAttribute="kk" method="post" >

<label>Year</label>
<form:input path="vuosi"  value="${y }"/>

  <form:select path="nro" class="browser-default">
    
     
     <c:forEach items="${kuukaudet}" var="k">
   
 <form:option value="${k.nro }"> <c:out value="${k.nimi}"></c:out> </form:option> 

</c:forEach> 
    

    
    
  </form:select>


<br>
                   <br>

  <button class="btn waves-effect waves-light" type="submit" name="action">Choose
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