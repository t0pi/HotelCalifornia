package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Calendrier;
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

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		RequestDispatcher rd = request.getRequestDispatcher(VUE);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Récupération des champs du formulaire. */
        String dates = request.getParameter( CHAMP_DATE );
        String[] lesDates = dates.split(" - ");
                
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dateArrivee =  LocalDate.parse(lesDates[0], inputFormat).format(outputFormat);
        String dateDepart =  LocalDate.parse(lesDates[1], inputFormat).format(outputFormat);

        LocalDate arrivee = LocalDate.parse(dateArrivee);
        LocalDate depart = LocalDate.parse(dateDepart);
        try {
            validationEmail( dates );
        } catch (Exception e) {
            System.out.println("erreur : dates invalides");
        }  
        
        try {
			List<Chambre> ChambresParDate = new ChambreManager().selectionnerChambres(arrivee, depart);
			
			/*List<LocalDate> totalDates = new ArrayList<>();
	        while (!arrivee.isAfter(depart)) {
	            totalDates.add(arrivee);
	            arrivee = arrivee.plusDays(1);
	        }
	        
	        System.out.printf("total dates: ");
	        for (LocalDate temp : totalDates) {
				System.out.println(temp);
			}
	        
	        Map<String, List<String>> hm = new HashMap<String, List<String>>();
	        List<String> values = new ArrayList<String>();
	        values.add("Value 1");
	        values.add("Value 2");
	        hm.put("Key1", values);

	        List<Calendrier> monCalendrier = new ArrayList<Calendrier>();*/
	        
	        // to get the arraylist
	        
			request.setAttribute("chambres", ChambresParDate);
			System.out.println(ChambresParDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        request.setAttribute("arrivee", arrivee);
        request.setAttribute("depart", depart);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(VUE_CALENDRIER) ;
        
        // inclusion de cette ressource
       requestDispatcher.include(request, response) ;

}

private void validationEmail( String dates ) throws Exception{}

}




