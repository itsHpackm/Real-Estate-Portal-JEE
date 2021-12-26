<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"> 
 <meta  name="viewport" conten="width=device-width",initial-scale="1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" > 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
<link rel="stylesheet" href="styles.css" >  

<link rel="stylesheet" href="css/all.min.css">
<style>

#inscription #input1 label {
position:absolute;
margin-top:1.5%;
margin-bottom:40px;
margin-right:6%;
right:60%;
pointer-events: none;
}
#inscription #input1 textarea{
margin-bottom: 20px;
padding: 4px 20px;
color: white;
font-size: 14px;
font-family: sans-serif;
outline: none;
border-bottom: 1px solid white;
background:transparent;
margin-top:10%;
border-color:white; 
border-radius:6px;
margin-left: 16%;
 } 

</style>
</head>
<body >

<!-- navbar  -->

<header>
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" style="height: 10%;">
  <div class="container">
  <span class="navbar-brand" > <img src="images/logo.png" alt="logo" style="width: 150px;height: 60px;"></span>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
    
     <li class="nav-item">
         <a  class="nav-link" href="accueil.jsp" style="color: white;" >Accueil</a>
      </li>

      <li class="nav-item">
        <a  class="nav-link" href="publier.jsp" style="color: white;" >Publier</a>
     </li>
  
    <li class="nav-item">
         <a  class="nav-link" href="ListeBienServlet" style="color: white;">Recherches</a>
      </li>
	<c:if test="${part==null }">
		 <li class="nav-item active">
          <a  class="nav-link" href="compte.jsp" style="color: white;">Crée Compte</a> 
     	 </li>
		
        <li class="">
          <a  class="nav-link" href="connecter.jsp" style="color:white;background:#1f8d94;border-radius:13px;" ><i class="fas fa-user" style="padding:5px"> Se Connecter</i></a> 
      </li>
      </c:if>
         <c:if test="${part !=null }">
		      <li class="dropdown" >
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white;background:#1f8d94;border-radius:13px;">
		         	<i class="fas fa-user" > <c:out value="${part.getNom()}"></c:out></i>
		        </a>
				       <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="">
					          <a class="dropdown-item" href="profil.jsp" style="font-size:15px;text-align:center;font-weight:bold">Profil</a>
					          <a class="dropdown-item" href="MesAnnonces" style="font-size:15px;text-align:center;font-weight:bold">Mes Annonces</a> 
					          <a class="dropdown-item" href="MessageServlet" style="font-size:15px;text-align:center;font-weight:bold">Mes Messages</a> 
					           <a class="dropdown-item" href="ConnexionServlet" style="font-size:15px;text-align:center;font-weight:bold">deconnexion</a> 
				       </div>
		      </li>
      </c:if>
        
    </ul>
  
  </div>
  </div>
  
  </nav>
  </header>
  
<!-- formumaire et text-->
<div id="bg"  style="padding-top: 10vh;margin-top:auto;padding-bottom:20px; margin-bottom: 0%;" >
   
    <div class=" inscription-text animated bounceInLeft">
     
    <div id=inscription style="background-color: #20969e49"> 
        <h2 style="text-transform:capitalize;color:rgb(241, 241, 241); margin-left: 18%;padding-bottom: 9px; ">contacter nous</h2>
        <form method="post" action="MessageServlet">
        <div id="input"><input type="text" name="numA" required=""><label>NºAnnonceur</label></div>
            <div id="input"><input type="text" name="nomE" required=""><label>Nom</label></div>
            <div id="input"><input type="text" name="prenomE" required=""><label>Prenom</label> </div>
            <div id="input"> <input type="text" name="emailE" required=""><label>Email</label></div>  
            <div id="input1"><textarea rows="3" cols="25" placeholder="veuillez saisir la description de votre annonce, ici!" name="message" required=""></textarea><label>Message</label> </div>
            <div id="button">
              <input type="submit" name="envoyer" value="Confirmer" >
            </div>
           <p style="margin-left:17%"><c:out value="${msg }"></c:out></p>
          </form>
    </div> 
 
   </div>
</div>
   
 
 
<!-- footer  -->

<footer class="section footer-classic context-dark bg-image" style="background: black; position: relative ; padding-top: 50px;  color: rgba(255, 255, 255, 0.8);font-size: 15px; margin-top:0;">
        <div class="container" >
          <div class="row row-30">
            <div class="col-md-4 col-xl-5">
              <div class="brand pr-xl-4 ">
                <h3 class="brand-title"><img src="images/logo.png" alt="logo" style="width: 150px;height: 60px;"></h3>
                <!-- Rights-->
                <p class="rights"><span>Copyright ©  </span><span class="copyright-year">2021</span><span> </span><span>. <BR></span><span> Site Des Annonces Immobilier aux Maroc <br>| All rights reserved |</span></p>
              </div>
            </div>
            <div class="col-md-4" >
              <h3>CONTACTS</h3>
              <dl class="contact-list" >
                <dt>Address:</dt>
                <dd>Hay El Madariss - Riad Essalame<br>
Béni Mellal BP: 23000</dd>
              </dl>
              <dl class="contact-list">
                <dt>Email:</dt> 
                 <dd><a href="mailto:#">assemlalihamza@gmail.com</a></dd>
              </dl>
           
            </div>
            <div class="col-md-4 col-xl-3" >
	            <div class="span8" >
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3371.728631236647!2d-6.381726359064249!3d32.31914352605944!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xda38649419c7fc1%3A0x6236b3e9a12bafd9!2sBeni-Mellal!5e0!3m2!1sen!2sma!4v1611075572654!5m2!1sen!2sma" width="330" height="150" frameborder="0" style="border:0; border-radius:15px" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
	       	   </div>
            </div>
          </div>
        </div>
</footer>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"  ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 
</body>
</html>
