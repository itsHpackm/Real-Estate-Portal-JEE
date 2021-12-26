<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</head>
<body>

<!-- navbar  -->

<header>
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" style="height: 10%;">
  <div class="container">
  <span class="navbar-brand" > <img src="images/logo0.png" alt="logo" style="width: 150px;height: 60px;"></span>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
    
     <li class="nav-item">
         <a  class="nav-link" href="accueil.jsp" style="color: black;" >Accueil</a>
      </li>

      <li class="nav-item">
        <a  class="nav-link" href="publier.jsp" style="color: black;" >Publier</a>
     </li>
   
    <li class="nav-item">
         <a  class="nav-link" href="ListeBienServlet" style="color: black;">Recherches</a>
      </li>
      <c:if test="${part==null }">
		 <li class="nav-item active">
          <a  class="nav-link" href="compte.jsp" style="color: black;">Crée Compte</a> 
     	 </li>
		
        <li class="">
          <a  class="nav-link" href="connecter.jsp" style="color: white;background:#1f8d94;border-radius:13px;" ><i class="fas fa-user" style="padding:5px"> Se Connecter</i></a> 
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
  


<!-- carosrel  -->


<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
<ol class="carousel-indicators">
  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
</ol>
<div class="carousel-inner">
  <div class="carousel-item active">
    <img src="images/immo.jpg" class="d-block w-100 responsive" alt="..." style="">
    <div class="carousel-caption d-none d-md-block animated pulse" style="animation-delay: 0.4s">
      <h5 class="animated bounceInLeft" style="animation-delay: 1s">Quand vous serez prêt pour un changement
</h5>
     <p class="animated bounceInRight" style="animation-delay: 2s ;text-transform:uppercase">nous serons prêts à vous aider.</p>
      <!--   <p class="animated bounceInRight" style="animation-delay: 2s"> Immo-Facile </p>-->  
      <p class="animated bounceInUp" style="animation-delay: 2s"><a href="#portail"  class="btn btn-info">Plus d'infos</a></p>
    </div>
  </div>
  <div class="carousel-item">
    <img src="images/immo0.jpg" class=" d-block w-100 responsive" alt="..." style="">
    <div class="carousel-caption d-none d-md-block animated pulse" style="animation-delay: 0.4s">
      <h5 class="animated bounceInLeft" style="animation-delay: 1s;text-transform:uppercase">Quand vous serez prêt pour un changement
</h5>
     <p class="animated bounceInRight" style="animation-delay: 2s;text-transform:uppercase">nous serons prêts à vous aider.</p>
        <!--   <p class="animated bounceInRight" style="animation-delay: 2s"> Immo-Facile </p>-->  
      <p class="animated bounceInUp" style="animation-delay: 2s;"><a href="#portail"  class="btn btn-info">Plus d'infos</a></p>
    </div>
  </div>
  <div class="carousel-item">
    <img src="images/immo2.jpg" class="d-block w-100 responsive" alt="..." style="">
    <div class="carousel-caption d-none d-md-block animated pulse" style="animation-delay:0.4s">
      <h5 class="animated bounceInLeft" style="animation-delay: 1s">Quand vous serez prêt pour un changement
</h5>
     <p class="animated bounceInRight" style="animation-delay: 2s;text-transform:uppercase">nous serons prêts à vous aider.</p>
   <!--   <p class="animated bounceInRight" style="animation-delay: 2s"> Immo-Facile </p>-->  
      <p class="animated bounceInUp" style="animation-delay: 2s"><a href="#portail"  class="btn btn-info">Plus d'infos</a></p>
    </div>
  </div>
</div>
<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
  <span class="sr-only">Previous</span>
</a>
<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
  <span class="carousel-control-next-icon" aria-hidden="true"></span>
  <span class="sr-only">Next</span>
</a>
</div>


<div id="portail" class="container text-center" style="margin-top:40px;margin-bottom:60px;">
      <div class="col-ml-8 mx-auto">  
			<img alt="images" src="images/lamp.png" style="width:140px;height:140px;" class="img-fluid">
			<h4 style="color:#1f8d94;padding-top:40px;"> Partail immobiler:Immo-Facile</h4>
        <p style="text-align: justify;">
			 Ce site est realisé dans le but d'un projet de module intitulé JEE (Java Entreprise Editon).
			 Le but de celui-ci est de réaliser un portail de petites annonces d'immobilier pour faciliter la tâche au gens qui veulent
			 louer ou acheter un bien qui peut être une maison, villa, appartement, bureau, immeuble, maison à construire, 
			 terrain ou local commercial.
			 Notre plateforme est dédiée aux gens qui veulent louer, acheter ou bien faire une annonce concernant un immobilier,
			  C’est encore une solution pour une disponibilité de 24/7, bien au-delà de l’ouverture d’un bureau. 
			  C’est également un service rendu à sa clientèle, que ce soit des acheteurs ou des vendeurs ou des loueurs.
			   Enfin, on retrouve, là, les avantages habituels de tout portail, 
			 comme fidéliser sa clientèle, l’informer, la relancer, la développer, etc
            </p>
         
        </div>
</div>
<div class="container-fluid" style="background-color:#f1f1f1;padding-top:40px;">
<div class="container">
<div class="row">

<div class="col-sm-8 text animated bounceInRight" style="text-align:justify;">
<h4 class="text-center" style="color:#1f8d94;padding-top:40px;">Faire une Recherche</h4>
<p style="padding-left:40px">Veuillez noter que les visiteurs qui souhaitent faire une recherche dans notre portail des annonces immobilières vous devez remplir le formulaire de recherche, la recherche 
peu être faite soit par type du bien, type de transaction, la surface du bien, la ville, le region ou le prix maximale. La recherche dans notre site est possible
  via le formulaire en ligne.<br> Veuillez remplir le formulaire suivant:</p>
<p style="text-align:center;"><a href="chercher.jsp" class="btn btn-info">Voir Plus</a></p>
</div>
<div class="col-sm-4 image animated bounceInLeft">
<img src="images/search.png" class="responsive mx-auto d-block" style="width:200px">
</div>
</div>
</div>
</div>

<div class="container" style="padding-top:20px;">
<div class="container-fluid registration">
<div class="row">
<div class="col-sm-4 image animated bounceInLeft">
<img src="images/OIP.jfif" class="responsive mx-auto d-block">
</div>
<div class="col-sm-8 text animated bounceInRight" style="text-align:justify;">
<h4 class="text-center" style="color:#1f8d94;padding-top:40px;">Créer Votre Compte</h4>
<p style="padding-left:40px">Veuillez noter que les utilisateurs  qui souhaitent publier une annonce dans notre portail des annonces immobilières vous devez vous inscrire en ligne au préalable. L'inscription à notre site est possible
  via le formulaire en ligne.<br> Veuillez remplir le formulaire suivant:</p>
<p style="text-align:center;"><a href="compte.jsp" class="btn btn-info">Voir Plus</a></p>
</div>
</div>
</div>
</div>
<!-- footer  -->

<footer class="section footer-classic context-dark bg-image" style="background: black; position: relative ; padding-top: 50px;  color: rgba(255, 255, 255, 0.8);font-size: 15px margin-top:0;">
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
            <div class="span8" style="">
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
 