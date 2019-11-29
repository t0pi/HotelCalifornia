<% String pageTitle = "R&eacute;servation termin&eacute;e"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- d�but de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">R�servation termin�e !</h5>
	    <p>Vous allez bient�t recevoir un e-mail de confirmation.</p>    
	    <a href="${pageContext.request.contextPath}/reservation">Retour � la page d'accueil.</a>
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />