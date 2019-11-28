<% String pageTitle = "Inscription"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- d�but de la div container principale -->

	<div class="card" style="width: 25rem; margin: auto;">
	  <div class="card-body">
	    <h5 class="card-title center">Inscription</h5>
	    <p class="card-subtitle">Tous les champs sont requis.</p>
	    
	    <form name="inscription" method="POST" action="${pageContext.request.contextPath}/inscription">
		  <div class="form-group">
		    <input required  data-bv-notempty-message="Votre nom est requis" type="text" class="form-control" name="nom" id="nom" placeholder="Votre nom">
		  </div>
		  <div class="form-group">
		    <input type="text" required  data-bv-notempty-message="Votre pr�nom est requis" class="form-control" name="prenom" id="prenom" placeholder="Votre pr�nom">
		  </div>
		  <div class="form-group">
		    <input type="text" required  data-bv-notempty-message="Votre adresse est requise" class="form-control" name="adresse" id="adresse" placeholder="Votre adresse">
		  </div>
		  <div class="form-group">
		    <input type="text" required  data-bv-notempty-message="Votre num�ro de t�l�phone est requis" class="form-control" name="tel" id="tel" placeholder="Votre num�ro de t�l�phone">
		  </div>
		  <button type="submit" class="btn btn-primary text-center">Envoyer</button>
		</form>
	  </div>
	</div>
</div>	

<jsp:include page="fragments/footer.jsp" flush="true" />