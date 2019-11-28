<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String pageTitle = "R&eacute;servation"; %>
<jsp:include page="fragments/head.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<jsp:include page="fragments/header.jsp" flush="true" />
<div class="container"><!-- début de la div container principale -->

	<div class="card calendrier" style="width: 50rem; margin: auto;">
		<div class="container">
		  <div class="row">
		    <div class="col-xs">
		    <form method="post" action="${pageContext.request.contextPath}/reservation" id="afficherDates" name="afficherDates" class="form-inline">
		      <select class="form-control form-control-sm">
				  <option name="null">Choisissez une chambre</option>
				  <c:forEach var="nc"  items="${requestScope['nomsChambres']}" > 
				  	<option value="${nc.idChambre}" name="${nc.idChambre}" >${nc.nom}</option>
				  </c:forEach> 
				</select>
				<button style="padding: 2px 5px;" class="btn btn-primary" name="valider" type="submit">Ok</button>
			</form>
		    </div>
		    <div class="col-sm">
		      <h5 class="card-title center">Chambres disponibles</h5>	 
		    </div>
		    <div class="col-xs">
		      Du <c:out value='${requestScope["dateArrivee"]}' /> au <c:out value='${requestScope["dateDepart"]}' />
		    </div>
		  </div>
		</div>
	    	    
			<div class="card-body">
	       <c:forEach var="c"  items="${requestScope['chambres']}" > 	  
	           
	          
				
					<div class="card card-body w-100">
	          		<div class="card-content">
	          			<img src="${pageContext.request.contextPath}/img/room.jpg" />	          			
		          		<ul>
						    <li>${c.nom}</li>
						    <li>${c.nbLits} lit(s)</li>
						    <li>${c.prix}&euro; la nuit</li>
						    <li style="padding-top: 20px;">
							    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#chambre${c.idChambre}">
	  								R&eacute;server
								</button>
						    </li>
					    </ul>
	          		</div>		    	
				</div>	
				<div class="modal fade" id="chambre${c.idChambre}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">${c.nom}</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <form method="post" action="${pageContext.request.contextPath}/reservation" id="reservation" name="reservation" class="form-inline">
					        	
					        
					        </form>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
					        <button type="button" class="btn btn-primary">Confirmer</button>
					      </div>
					    </div>
					  </div>
					</div>  
			</c:forEach>   
       </div>  
	  </div>
	</div>
</div>

<jsp:include page="fragments/footer.jsp" flush="true" />