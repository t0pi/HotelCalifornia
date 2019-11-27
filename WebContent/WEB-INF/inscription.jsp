<% String pageTitle = "Inscription"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">Inscription</h5>
	    
	    <form name="inscription" method="POST" action="${pageContext.request.contextPath}/inscription">
		  <div class="form-group">
		    <input type="text" class="form-control" name="nom" id="nom" placeholder="Votre nom">
		  </div>
		  <div class="form-group">
		    <input type="text" class="form-control" name="prenom" id="prenom" placeholder="Votre prénom">
		  </div>
		  <div class="form-group">
		    <input type="text" class="form-control" name="adresse" id="adresse" placeholder="Votre adresse">
		  </div>
		  <div class="form-group">
		    <input type="text" class="form-control" name="tel" id="tel" placeholder="Votre numéro de téléphone">
		  </div>
		  <button type="submit" class="btn btn-primary text-center	">Envoyer</button>
		</form>
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />