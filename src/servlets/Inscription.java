package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.bll.ClientManager;
import mysql.bo.Client;

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

    public Inscription() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(VUE);
		rd.forward(request, response);
	}

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
        
        try {
        	Client nouveauClient = new ClientManager().ajouterClient(nom, prenom, adresse, telephone);
        	
        } catch (Exception e ) {
        	e.printStackTrace();
        }
        
        RequestDispatcher rd =
                request.getRequestDispatcher("/WEB-INF//inscriptionTerminee.jsp");
        rd.forward(request, response);
	}
	
	private void validationNom( String nom ) throws Exception{
		
	}
	
     private void validationPrenom( String prenom ) throws Exception{
		
	}
     
     private void validationAdresse ( String adresse ) throws Exception {
    	 
     }
   
     private void validationTelephone( String telephone ) throws Exception {
    	 
     }

}
