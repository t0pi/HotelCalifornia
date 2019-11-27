<% String pageTitle = "R&eacute;servation"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title center">Choisissez vos dates de réservation</h5>	    
	    <form method="post" action="${pageContext.request.contextPath}/reservation" id="reservation" name="reservation" class="form-inline">	    
			<div class="input-group mb-3">
			  	<div class="input-group-prepend">
			   		<span class="input-group-text" id="basic-addon1">
			  		<span class="oi oi-calendar"></span></span>
			  	</div>
				<input class="form-control" type="text" name="daterange" placeholder="choisissez vos dates" />
				<button class="btn btn-primary" name="valider" type="submit">Valider</button>
			</div>
		</form>     
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />