package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestionErreurs.BusinessException;
import mysql.bll.ChambreManager;
import mysql.bll.ClientManager;
import mysql.bll.ReservationManager;
import mysql.bo.Chambre;
import mysql.bo.Client;
import mysql.bo.Reservation;

/**
 * Servlet implementation class AjouterReservation
 */
@WebServlet("/AjouterReservation")
public class AjouterReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/ajouterReservation.jsp";
    public static final String CHAMP_ARRIVEE = "arrivee";
    public static final String CHAMP_DEPART = "depart";
    public static final String CHAMP_CHAMBRE = "chambre";
    public static final String CHAMP_TEL = "tel";
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();		 
		// on r�cup�re les valeurs que l'on a envoy� dans le POST de reservation.jsp
		 	String arrivee = request.getParameter(CHAMP_ARRIVEE);
			String depart = request.getParameter(CHAMP_DEPART);
			String idCchambre = request.getParameter(CHAMP_CHAMBRE);
			
			// on les stocke dans la session
	        session.setAttribute("arrivee", arrivee);
	        session.setAttribute("depart", depart);
	        session.setAttribute("chambre", idCchambre);
	        
	        try {
	        	/* On r�cup�re les info de la chambre avec l'id donn� en session */
				if (idCchambre != null) {
					session.setAttribute("chambre", idCchambre);
					Chambre chambre = new ChambreManager().selectionnerChambresById(Integer.valueOf(idCchambre));
				
					request.setAttribute("chambres", chambre);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
	        /* Et enfin on affiche la vue */
	        RequestDispatcher rd = request.getRequestDispatcher(VUE);
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();        

		String arrivee=(String)session.getAttribute("arrivee");
		String depart=(String)session.getAttribute("depart");
		String idChambre=(String)session.getAttribute("chambre");
		String tel = request.getParameter(CHAMP_TEL);	
		String submit = request.getParameter("submit");	

		if(tel != null) {
			try {
				
				Client client = new ClientManager().selectionnerClient(tel);
				Chambre chambre = new ChambreManager().selectionnerChambresById(Integer.valueOf(idChambre));
				Reservation nouvelleReservation = new ReservationManager().insert(client, chambre, arrivee, depart);
		        
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",((BusinessException) e).getListeCodesErreur());
			}
		}
		if(submit != null) {

			RequestDispatcher rd =
	                request.getRequestDispatcher("/WEB-INF/confirmation.jsp");
	        rd.forward(request, response);
		}
		else {
	          
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}

}
