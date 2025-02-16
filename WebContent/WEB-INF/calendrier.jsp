<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						    <li style="color: #888;font-size: 16px;">${c.nbLits} lit(s)</li>
						    <li><strong>${c.prix}&euro;</strong> la nuit</li>
						    <li style="padding-top: 20px;">
							    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#chambre${c.idChambre}">
	  								R&eacute;server cette chambre
								</button>
						    </li>
					    </ul>
	          		</div>		    	
				</div>	
				<div class="modal fade" id="chambre${c.idChambre}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">${c.nom} <span style="color: #555;font-size: 15px;">${c.nbLits} lit(s)</span></h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <form method="post" action="${pageContext.request.contextPath}/nouvelle-reservation" id="nouvelle-reservation" name="nouvelle-reservation" class="form-inline">
					        <input type="hidden" value="<c:out value="${requestScope['arrivee']}" />" name="arrivee">
					        <input type="hidden" value="<c:out value='${requestScope["depart"]}' />" name="depart">
					        <input type="hidden" value="<c:out value='${c.idChambre}' />" name="chambre">
					        	<img src="${pageContext.request.contextPath}/img/room.jpg" />
							        <ul>							        
									    <c:set var="nbJrs" value='${requestScope["totalJours"]}' />							    
									    <c:set var="sum" value='${c.prix * nbJrs}' />
									    <li><strong style="font-size:25px;"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${sum}"/>&euro;</strong> pour <c:out value='${requestScope["nbJours"]}' /> nuits </li>	
							        <li style="color: #999;font-size: 14px;">Du <c:out value='${requestScope["dateArrivee"]}' /> au <c:out value='${requestScope["dateDepart"]}' /></li>						    							    
							    	</ul>
							    
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
					        <button type="submit" class="btn btn-primary">Confirmer</button>
					      </div>
					        </form>
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