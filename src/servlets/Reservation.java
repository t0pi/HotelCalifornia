package servlets;

import java.io.IOException;
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
		
		
		try {
			List<Chambre> ChambresParDate = new ChambreManager().selectionnerChambres();
			request.setAttribute("ChambresParDate", ChambresParDate);
			System.out.println(ChambresParDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/reservation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/reservation"))
		{
			System.out.println("hello");
		}
		
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
	}

}
