package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysql.bll.ChambreManager;
import mysql.bo.Chambre;

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
			
			System.out.println("Votre réservation : "+ arrivee + " - " + depart + " - " + chambre);
			
	        session.setAttribute("arrivee", arrivee);
	        session.setAttribute("depart", depart);
	        session.setAttribute("chambre", chambre);
	        
	        try {
	        	/* On récupère les info de la chambre avec l'id donné en session */
				List<Chambre> ChambresParId = new ChambreManager().selectionnerChambresById(Integer.valueOf(chambre));
				
				System.out.println("les chambres : " + ChambresParId);

				request.setAttribute("chambres", ChambresParId);
				
				
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

		String arrivee = request.getParameter(CHAMP_ARRIVEE);
		String depart = request.getParameter(CHAMP_DEPART);
		String chambre = request.getParameter(CHAMP_CHAMBRE);
		
		System.out.println("Votre réservation : "+ arrivee + " - " + depart + " - " + chambre);
		
        HttpSession session = request.getSession();
        session.setAttribute("arrivee", arrivee);
        session.setAttribute("depart", depart);
        session.setAttribute("chambre", chambre);
        
        try {
        	/* On récupère les info de la chambre avec l'id donné en session */
			List<Chambre> ChambresParId = new ChambreManager().selectionnerChambresById(Integer.valueOf(chambre));
			
			System.out.println("les chambres : " + ChambresParId);

			request.setAttribute("chambres", ChambresParId);

			request.setAttribute("arrivee", arrivee);
			request.setAttribute("depart", depart);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
