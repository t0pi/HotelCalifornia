package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysql.bll.ChambreManager;
import mysql.bll.ClientManager;
import mysql.bll.ReservationManager;
import mysql.bo.Chambre;
import mysql.bo.Client;
import mysql.bo.Reservation;
import mysql.bo.LigneReservation;


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
	        
		 String arrivee = request.getParameter(CHAMP_ARRIVEE);
			String depart = request.getParameter(CHAMP_DEPART);
			String chambre = request.getParameter(CHAMP_CHAMBRE);
			
			
	        session.setAttribute("arrivee", arrivee);
	        session.setAttribute("depart", depart);
	        session.setAttribute("chambre", chambre);
	        
	        try {
	        	/* On récupère les info de la chambre avec l'id donné en session */
			if (chambre != null) {
				session.setAttribute("chambre", chambre);
				List<Chambre> ChambresParId = new ChambreManager().selectionnerChambresById(Integer.valueOf(chambre));
			
				request.setAttribute("chambres", ChambresParId);
			}
					        
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
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
		String chambre=(String)session.getAttribute("chambre");
		String tel = request.getParameter(CHAMP_TEL);		


		System.out.println("Votre réservation : "+ arrivee + " - " + depart + " - " + chambre);
		if(tel != null) {
			try {
				
				Client client = new ClientManager().selectionnerClient(tel);
				System.out.println(client);
				System.out.println(LocalDate.now());
				Reservation nouvelleReservation = new Reservation();
				nouvelleReservation.setClient(client);
				nouvelleReservation.setLe(LocalDate.now());
				nouvelleReservation.setPayeele(LocalDate.now());
				System.out.println(nouvelleReservation);
				LocalDate dateArrivee = LocalDate.parse(arrivee);
		        LocalDate dateDepart = LocalDate.parse(depart); 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
               
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
