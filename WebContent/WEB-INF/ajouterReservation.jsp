<% String pageTitle = "Confirmation de r&eacute;servation"; %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">Confirmation de votre réservation :</h5>	    
	    <form method="post" style="align-items: inherit;" action="${pageContext.request.contextPath}/nouvelle-reservation" id="reservation" name="reservation" class="form-inline">	    
			<c:forEach var="c"  items="${requestScope['chambres']}" > 				
				<div class="card resa" style="width: 12rem;">
				  <img src="${pageContext.request.contextPath}/img/room.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
					    <h5 class="card-title">${c.nom}</h5>
					    <ul>
							<li>${c.nbLits} lit(s)</li>
							<li>D&eacute;part <c:out value='${requestScope["arrivee"]}' /></li>
							<li>Arriv&eacute;e <c:out value='${requestScope["depart"]}' /></li>
						</ul>
				    </div>
				</div>
				<div class="card input" style="flex: max-content;">
				    <div class="card-body">
					    <h5 class="card-title">Vos identifiants</h5>
					    <p>Vous devez être inscrit pour réserver.</p>
					    <input style="width: 100%;" type="text" required  data-bv-notempty-message="Ce champs est requis" class="form-control" name="tel" id="tel" placeholder="Entrez votre numéro de téléphone">
					    
		  				<button style="display: block;" type="submit" class="btn btn-primary text-center">Confirmer</button>
					    <a style="text-decoration: underline; display: inherit; text-align: center; margin-top:50px;" href="${pageContext.request.contextPath}/inscription" >Par encore inscrit ? C'est par ici.</a>
				    </div>
				    </div>
			</c:forEach>
		</form>     
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />