<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
       
      </ul>
    </div>
  </nav>
	
<div id="sisalto">


<h1>Tiedot</h1>


</div>

<br>
<br>
<br>
<br>
 <table class="centered">
        <thead>
          <tr>
              <th data-field="id">Studennumber</th>
              <th data-field="name">Firstname</th>
              <th data-field="price">Lastname</th>
              <th data-field="price">Email</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td><c:out value="${opiskelija1.opiskelijanumero }"></c:out></td>
            <td><c:out value="${opiskelija1.etunimi }"></c:out></td>
            <td><c:out value="${opiskelija1.sukunimi }"></c:out></td>
            <td><c:out value="${opiskelija1.email }"></c:out></td>
          </tr>
  

        </tbody>
      </table>

<br>
<br>
<br>
<br>


<table >
        <thead>
          <tr>
              <th data-field="id">Name of the Innovation</th>
              
             
          </tr>
        </thead>

        <tbody>
          <tr>
            <td><c:out value="${opiskelija1.innovaatio.nimi}"></c:out></td>
            <td><c:out value="${opiskelija1.innovaatio.aihe}"></c:out></td>
            
          </tr>
  

        </tbody>
      </table>




<br>
<br>
<br>
<br>

 <p><a href="logout" > Kirjaudu ulos</a></p>


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