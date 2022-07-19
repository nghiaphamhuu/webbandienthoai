<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
<div class="container">
<div id="welcomeLine" class="row">
	<div class="span6">Welcome!<strong> ${sessionScope.user}</strong></div>
	<div class="span6">
	<div class="pull-right">
		<a href="cartSum"><span class="btn btn-large btn-success"><i class="icon-shopping-cart icon-white"></i> Go to cart </span> </a> 
	</div>
	</div>
</div>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
    <a class="brand" href="index.html"><img src="themes/images/logo.png" alt="Bootsshop"/></a>
		<form class="form-inline navbar-search" method="post" action="search" >
		<input id="srchFld" class="srchTxt" type="text" name="searchTxt" />
		  
		  <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
    </form>
    <ul id="topMenu" class="nav pull-right">
	 <li class=""><a href="special_offer.html">Specials Offer</a></li>
	 <li class=""><a href="normal.html">Delivery</a></li>
	 <li class=""><a href="contact.html">Contact</a></li>
	 <li class="">
	 <c:if test="${sessionScope.user==null}">
	 	<a href="login.jsp" style="padding-right:0"><span class="btn btn-large btn-success">Login</span></a>
	 </c:if>
	 <c:if test="${sessionScope.user!=null}">
	 	<a href="logout" style="padding-right:0"><span class="btn btn-large btn-success">Logout</span></a>
	 </c:if>
	</li>
    </ul>
  </div>
</div>
</div>
</div>
</body>
</html>