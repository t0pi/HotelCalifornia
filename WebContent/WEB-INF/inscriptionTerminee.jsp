<% String pageTitle = "Inscription termin&eacute;e"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- d�but de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">Inscription termin�e !</h5>
	    <p>Vous pouvez d�sormais effectuer des r�servations</p>    
	    <a href="${pageContext.request.contextPath}/reservation">Effectuer une r�servation</a>
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />