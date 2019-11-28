<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String pageTitle = "R&eacute;servation"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card w-100">
		<div class="container">
		  <div class="row">
		    <div class="col-xs">
		      <select class="form-control form-control-sm">
				  <option>Choisissez une chambre</option>
				  <option>Choisissez une chambre</option>
				  <option>Choisissez une chambre</option>
				  <option>Choisissez une chambre</option>
				</select>
		    </div>
		    <div class="col-sm">
		      <h5 class="card-title center">Chambres disponibles</h5>	 
		    </div>
		    <div class="col-xs">
		      Du <c:out value='${requestScope["arrivee"]}' /> au <c:out value='${requestScope["depart"]}' />
		    </div>
		  </div>
		</div>
	  
	    <form method="post" action="${pageContext.request.contextPath}/reservation" id="reservation" name="reservation" class="form-inline">	    
			<div class="card-body">
	       <div class="d-flex flex-wrap">
	       <c:forEach var="c"  items="${requestScope['chambres']}" > 
	       
	          <div class="card card-body w-20">
				    <li>${c.nom}</li>
				    <li>${c.nbLits} lit(s)</li>
				    <li>${c.prix}&euro; la nuit</li>	
			</div>		  
				</c:forEach>
	                   
	                    
          </div>
       </div>
		</form>     
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />