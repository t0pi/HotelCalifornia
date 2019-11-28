package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/inscription.jsp";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_ADRESSE = "adresse";
    public static final String CHAMP_TELEPHONE = "tel";
    public static final String CHAMP_ARRIVEE = "arrivee";
    public static final String CHAMP_DEPART = "depart";
    public static final String CHAMP_CHAMBRE = "idChambre";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher(VUE);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Récupération des champs du formulaire. */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter(CHAMP_PRENOM); 
        String adresse = request.getParameter(CHAMP_ADRESSE);
        String telephone = request.getParameter(CHAMP_TELEPHONE);
        
        try {
        	validationNom(nom); 
        	validationPrenom(prenom); 
        	validationAdresse(adresse); 
        	validationTelephone(telephone);
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        String arrivee = request.getParameter(CHAMP_ARRIVEE);
		String depart = request.getParameter(CHAMP_DEPART);
		String chambre = request.getParameter(CHAMP_CHAMBRE);
		
		System.out.println("Votre réservation : "+ arrivee + " - " + depart + " - " + chambre);
		
        HttpSession session = request.getSession();
        session.setAttribute("arrivee", arrivee);
        session.setAttribute("depart", depart);
        session.setAttribute("chambre", chambre);
          
	}
	
	
	private void validationNom( String CHAMP_NOM ) throws Exception{
		
	}
	
     private void validationPrenom( String CHAMP_PRENOM ) throws Exception{
		
	}
     
     private void validationAdresse ( String CHAMP_ADRESSE ) throws Exception {
    	 
     }
     
     private void validationTelephone( String CHAMP_TELEPHONE ) throws Exception {
    	 
     }

}
