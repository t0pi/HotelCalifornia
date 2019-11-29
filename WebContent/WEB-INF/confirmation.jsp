<% String pageTitle = "R&eacute;servation termin&eacute;e"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">Réservation terminée !</h5>
	    <p>Vous allez bientôt recevoir un e-mail de confirmation.</p>    
	    <a href="${pageContext.request.contextPath}/reservation">Retour à la page d'accueil.</a>
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />