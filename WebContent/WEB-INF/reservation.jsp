<% String pageTitle = "R&eacute;servation"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-50">
	  <div class="card-body">
	    <h5 class="card-title">Choisissez vos dates de réservation</h5>
	    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
	    
	    <form id="form" name="form" class="form-inline">
    <div class="form-group">
        <label for="startDate">Start Date</label>
        <input id="startDate" name="startDate" type="text" class="form-control" />
        &nbsp;
        <label for="endDate">End Date</label>
        <input id="endDate" name="endDate" type="text" class="form-control" />
    </div>
</form>
	    
		<span class="oi oi-arrow-circle-bottom"></span>          
	    <a href="#" class="btn btn-primary">Button</a>
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />