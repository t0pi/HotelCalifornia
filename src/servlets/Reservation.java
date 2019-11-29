package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.bll.ChambreManager;
import mysql.bo.Chambre;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/reservation.jsp";
	public static final String VUE_CALENDRIER = "/WEB-INF/calendrier.jsp";
    public static final String CHAMP_DATE = "daterange";
    public static List<Chambre> ChambresParDate;
     
    public Reservation() {
        super();
    }
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		RequestDispatcher rd = request.getRequestDispatcher(VUE);
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Récupération des champs du formulaire. */
        String dates = request.getParameter( CHAMP_DATE );
        String[] lesDates = dates.split(" - ");
                
       /* formatages des dates des input en format adapté à sql */
        
        /* pattern de formatage entrée et sortie */
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        /* formatage des chaines de caractère avec le pattern donné */
        String dateArrivee =  LocalDate.parse(lesDates[0], inputFormat).format(outputFormat);
        String dateDepart =  LocalDate.parse(lesDates[1], inputFormat).format(outputFormat);
        
        /* création d'une LocalDate avec les string formatées*/
        LocalDate arrivee = LocalDate.parse(dateArrivee);
        LocalDate depart = LocalDate.parse(dateDepart);      
        
        /* on récupère ces dates pour les envoyer dans le formulaire */
        request.setAttribute("arrivee", arrivee);
        request.setAttribute("depart", depart);
        try {
            validationDates( dates );
        } catch (Exception e) {
            System.out.println("erreur : dates invalides");
        }  
        
        try {
        	/* dialogue avec la bdd, affichage des chambres par date et de la liste de toutes les chambres pour le select */
			List<Chambre> ChambresParDate = new ChambreManager().selectionnerChambres(arrivee, depart);
			List<Chambre> listeChambres = new ChambreManager().selectionnerNomsChambres();
			
			/* On compte combien de jours il y a dans la tranche des dates sélectionnées pour calculer les prix des séjours */
			List<LocalDate> totalDates = new ArrayList<>();
	        while (!arrivee.isAfter(depart)) {
	            totalDates.add(arrivee);
	            arrivee = arrivee.plusDays(1);
	        }
	        
	       int size = totalDates.size();	       
	       float totalJours = size;	      
	       
	       /* on envoie les attributs sur la jsp */
			request.setAttribute("chambres", ChambresParDate);
			request.setAttribute("nomsChambres", listeChambres);
			request.setAttribute("totalJours", totalJours);
			request.setAttribute("nbJours", size);

		} catch (Exception e) {
			e.printStackTrace();
		}
        

        request.setAttribute("dateArrivee", lesDates[0]);
        request.setAttribute("dateDepart", lesDates[1]);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(VUE_CALENDRIER) ;
        
        // inclusion de cette ressource
       requestDispatcher.include(request, response) ;

}

private void validationDates( String dates ) throws Exception{}

}




