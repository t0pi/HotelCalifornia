<% String pageTitle = "Confirmation de r&eacute;servation"; %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container">
<!-- JE SAIS QU'IL FAUT PAS METTRE DE STYLES EN DUR DANS LE HTML MAIS JAVAIS PAS LE TEMPS ET SANS LESS C'EST COMPLIQUÉ DESOLE -->
	<div class="card"  style="width: 42rem; margin: auto;">
	  <div class="card-body">
	    <h5 class="card-title center">Confirmation de votre réservation</h5>	    
	    <form method="post" style="align-items: inherit;" action="${pageContext.request.contextPath}/nouvelle-reservation" id="reservation" name="reservation" class="form-inline">	    
			
				<div class="card input" style="flex: max-content;">
				    <div class="card-body">
					    <h5 class="card-title">Vos identifiants</h5>
					    <p>Vous devez être inscrit pour réserver.</p>
					    <input style="width: 100%;" type="text" required  data-bv-notempty-message="Ce champs est requis" class="form-control" name="tel" id="tel" placeholder="Entrez votre numéro de téléphone">
					    
		  				<button name="submit" style="display: block;" type="submit" class="btn btn-primary text-center">Confirmer</button>
					    <a style="text-decoration: underline; display: inherit; text-align: center; margin-top:140px;" href="${pageContext.request.contextPath}/inscription" >Par encore inscrit ? C'est par ici.</a>
				    </div>
				    </div>
			
		</form>     
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />