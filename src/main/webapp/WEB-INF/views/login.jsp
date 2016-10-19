<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ page session="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
	<script type="text/javascript" src="js/materialize.min.js"></script>
	
	
	 <nav>
    <div class="nav-wrapper blue lighten-1">
      <a href="#!" class="brand-logo center">Innovaatio</a>
      <ul class="left hide-on-med-and-down">
      <li><a href="innot/etusivulle">Front page</a></li>
      </ul>
    </div>
  </nav>

<div id="sisalto">

<h1>Login</h1>



	<c:if test="${not empty loginerror}">
		<p class="Error">Login failed. Username or password is entered incorrectly.</p>
	</c:if>

	<c:if test="${not empty loggedout}">
		<p class="Info">Logout successful</p>
	</c:if>
	
</div>








  <div class="row">
    <form class="col s12" action="j_spring_security_check" method="post">
      
      <div class="row">
      
     
      
        
        <div class="input-field col s12">
        <label for="text">Email</label>
         <br>
        
          <input id="text"  class="validate" type='text' name='j_username'>
          
        </div>
      
      <div class="row">
        <div class="input-field col s12">
        
         <label for="text">Studentnumber</label>
         <br>
          <input id="text" type="text" class="validate" name='j_password' >
         
        </div>
      </div>
      
      </div>
      
      
      
      <br>
       <br>
        <br>
      <button class="btn waves-effect waves-light" type="submit" name="action">Submit
    <i class="material-icons right">send</i>
  </button>
        
      
      
    </form>
  </div>
        











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