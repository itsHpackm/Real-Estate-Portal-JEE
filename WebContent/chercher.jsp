<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

<link rel="stylesheet" href="css/all.min.css">
</head>
<body style="background-color: rgba(233, 233, 233, 0.8);">
<c:if test="${msg==null}">
<c:set var="msg" value="" scope="request"/>
</c:if>
 
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
   <!--   <li class="nav-item dropdown" >
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white;">
          Publier
        </a>
       <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="">
          <a class="dropdown-item" href="maison.html" style="font-size:15px;text-align:center;font-weight:bold">Maison</a>
          <a class="dropdown-item" href="terrain.html" style="font-size:15px;text-align:center;font-weight:bold">Terrain</a> 
       </div>
      </li> -->
    <li class="nav-item">
         <a  class="nav-link" href="ListeBienServlet" style="color: #1f8d94;">Recherches</a>
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

<div id="bg"  style="padding-top: 10vh;margin-top:auto; " >
  <div class="row inscription-text animated bounceInLeft centre" >
    <div class="col-ml-8 mx-auto">
    <h2 style="padding-top:50px;text-transform: uppercase;color:#1f8d94;text-align: center;font-weight: bold;">faire votre recherche</h2>
    <p style="color:#e9f7f8;text-transform: centre;">
        Vous devez remplir tous les champs du formulaire de Recherche
      </p>
</div> 
  </div>
  <div class="container " style="margin-right:30px">
  <div class="row animated bounceInLeft " style="padding-top: 30px;padding-bottom: 80px;">
  <div class="col mx-auto" style="margin-right:40px"> 
    <form method="post" action="RechercheServlet">
      <select name="typebien" style="position: relative;height: 5vh; width:80px; border-radius: 5px;">
    	<option value="null">Tous</option>
        <option value="vente">Vente</option>
        <option value="location">Location</option> 
      </select>
      <select name="transaction" style="position: relative;height: 5vh;width:80px; border-radius: 5px;">
        <option value="null">Tous</option>
        <option value="maison">Maison</option>
        <option value="villa">Villa</option> 
        <option value="appartement">Appartement</option>
        <option value="bureau">Bureau</option> 
        <option value="terrain">Terrain</option>
        <option value="ferme">Ferme</option> 
      </select>
      <input type="text" name="surface" placeholder="Surface" style="height:5vh;">   
      <input type="text" name="vl"  placeholder="Ville"  style="height: 5vh;">    
      <input type="text" name="region" placeholder="Region" style="height: 5vh;"> 
      <input type="text" name="prixmax" placeholder="Prix Max" style="height: 5vh;"> 
      <input type="submit"  class="btn btn-info" value="Chercher" style="margin-bottom: 3px;">
    </form>
  </div> 
  
 </div>
</div>
</div>  

 
<div class="content clearfix " style="padding-bottom: 40px;">
  <div class="main-content">
    <c:if test="${msg!=null }">
    <h3 style="padding-top:50px;padding-bottom:30px;text-transform: capitalize;color:red;text-align: center;"><c:out value="${msg }"></c:out></h3>

  </c:if>
  <c:if test="${biens!=null }">
    <h3 style="padding-top:20px;padding-bottom:30px;text-transform: uppercase;color:#1f8d94;text-align: center;font-weight: bold;">résultats de recherche</h3>

	
	<c:forEach items="${biens}" var="ct">
   <div class="post">
    <img src="photos/<c:out value="${ct.getFilename()}"></c:out> " alt="Image d'Immobilier" class="post-image"> 
    
    <div class="post-preview">
      <h3 style="font-weight: bolder;text-transform:capitalize;color: #16686e;"><c:out value="${ct.getType_bien()}"></c:out> ( <c:out value="${ct.getTransaction()}"></c:out> ) </h3>
      <h4></h4> 
      <i class="fas fa-caret-up" style="margin:7px;">  Nº d'Annonceur :<c:out value="${ct.getId_particulier()}"></c:out> </i><br>
       <i class="fas fa-map-marker-alt" style="margin:7px;"> Adresse :<c:out value="${ct.getAdresse()}"></c:out> </i> <br>
       <i class="fas fa-home" style="margin:5px;"> Surface : <c:out value="${ct.getSurface()}"></c:out>  m²</i> <br>
      <i class="fas fa-money-bill" style="margin: 5px;"> Prix : <c:out value="${ct.getPrix()}"></c:out>  DH</i> <br>
      <i class="fas fa-door-open" style="margin:5px;"> Nombre de Chambres : <c:out value="${ct.getNbr_chambre()}"></c:out> </i> <br>
      <i class="fas fa-building" style="margin:5px;"> Nombres d'Etages : <c:out value="${ct.getNbr_etage()}"></c:out> </i> <br>
      <i class="fas fa-book-reader" style="margin: 5px;"> Description : </i> <p class="preview-text" style="margin: 5px;">
			<c:out value="${ct.getDescription()}"></c:out> 
      </p>
      <div><a href="contacter.jsp" class="btn btn-info" style="position: absolute;left:82%;top:auto">Contacter</a>
    </div>
  </div>
 </div>
 </c:forEach>
 </c:if>
 
 <c:if test="${listA!=null }">
    <h3 style="padding-top:20px;padding-bottom:30px;text-transform: uppercase;color:#1f8d94;text-align: center;font-weight: bold;">Toutes Les Annonces</h3>

	
	<c:forEach items="${listA}" var="ct">
   <div class="post">
    <img src="photos/<c:out value="${ct.getFilename()}"></c:out> " alt="Image d'Immobilier" class="post-image"> 
    
    <div class="post-preview">
      <h3 style="font-weight: bolder;text-transform:capitalize;color: #16686e;"><c:out value="${ct.getType_bien()}"></c:out> ( <c:out value="${ct.getTransaction()}"></c:out> ) </h3>
      <h4></h4> 
      <i class="fas fa-caret-up" style="margin:7px;">  Nº d'Annonceur :<c:out value="${ct.getId_particulier()}"></c:out> </i><br>
       <i class="fas fa-map-marker-alt" style="margin:7px;"> Adresse :<c:out value="${ct.getAdresse()}"></c:out> </i> <br>
       <i class="fas fa-home" style="margin:5px;"> Surface : <c:out value="${ct.getSurface()}"></c:out>  m²</i> <br>
      <i class="fas fa-money-bill" style="margin: 5px;"> Prix : <c:out value="${ct.getPrix()}"></c:out>  DH</i> <br>
      <i class="fas fa-door-open" style="margin:5px;"> Nombre de Chambres : <c:out value="${ct.getNbr_chambre()}"></c:out> </i> <br>
      <i class="fas fa-building" style="margin:5px;"> Nombres d'Etages : <c:out value="${ct.getNbr_etage()}"></c:out> </i> <br>
      <i class="fas fa-book-reader" style="margin: 5px;"> Description : </i> <p class="preview-text" style="margin: 5px;">
			<c:out value="${ct.getDescription()}"></c:out> 
      </p>
      <div><a href="contacter.jsp" class="btn btn-info" style="position: absolute;left:82%;top:auto">Contacter</a>
    </div>
  </div>
 </div>
 </c:forEach>
 </c:if>
    </div>

    
  </div>
   


<!-- footer  -->


<footer class="section footer-classic context-dark bg-image" style="background: black; position: relative; margin-top:10% ; padding-top: 50px;  color: rgba(255, 255, 255, 0.8);font-size: 15px; margin-top:0;">
        <div class="container" >
          <div class="row row-30">
            <div class="col-md-4 col-xl-5">
              <div class="brand pr-xl-4 ">
                <h3 class="brand-title"><img src="images/logo.png" alt="logo" style="width: 150px;height: 60px;"></h3>
             
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
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script>
$('.post-wrapper').slick({
  slidesToShow: 3,
  slidesToScroll: 1,
  autoplay: true,
  autoplaySpeed: 2000,
  nextArrow: $('.next'),
  prevArrow: $('.prev'),
  responsive: [
    {
      breakpoint: 1024,
      settings: {
        slidesToShow: 3,
        slidesToScroll: 3,
        infinite: true,
        dots: true
      }
    },
    {
      breakpoint: 600,
      settings: {
        slidesToShow: 1,
        slidesToScroll:1
      }
    },
    {
      breakpoint: 480,
      settings: {
        slidesToShow: 1,
        slidesToScroll: 1
      }
    } 
  ]
});
</script>
</body>
</html>
