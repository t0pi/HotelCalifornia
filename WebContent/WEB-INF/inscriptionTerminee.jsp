<% String pageTitle = "Inscription termin&eacute;e"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">Inscription terminée !</h5>
	    <p>Vous pouvez désormais effectuer des réservations</p>    
	    <a href="${pageContext.request.contextPath}/reservation">Effectuer une réservation</a>
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />