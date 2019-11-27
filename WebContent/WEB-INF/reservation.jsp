<% String pageTitle = "R&eacute;servation"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">Choisissez vos dates de réservation</h5>	    
	    <form id="form" name="form" class="form-inline">	    
			<span class="oi oi-calendar"></span>
			<input class="form-control" type="text" name="daterange" placeholder="choisissez vos dates" />
		    <a href="#" name="valider" class="btn btn-primary">Valider</a>
		</form>  

   
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />