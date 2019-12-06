package mysql.bll;

import java.time.LocalDate;

import gestionErreurs.BusinessException;
import mysql.bo.Chambre;
import mysql.bo.Client;
import mysql.bo.LigneReservation;
import mysql.bo.Reservation;
import mysql.dal.DaoFactory;
import mysql.dal.ReservationDao;

public class ReservationManager {

private ReservationDao reservationDao;
	
	public ReservationManager() {
		this.reservationDao =DaoFactory.getReservationDao();
	}
	
	public Reservation insert(Client client, Chambre chambre, String arrivee, String depart) throws Exception{		
		
		Reservation nouvelleReservation = new Reservation();
		nouvelleReservation.setClient(client);
		nouvelleReservation.setLe(LocalDate.now());
		nouvelleReservation.setPayeele(LocalDate.now());
		
		LocalDate dateArrivee = LocalDate.parse(arrivee);
        LocalDate dateDepart = LocalDate.parse(depart);
        LigneReservation lr = new LigneReservation(nouvelleReservation, chambre, dateArrivee, dateDepart);
        nouvelleReservation.ajouterLigneReservation(lr);
		
		return DaoFactory.getReservationDao().insert(nouvelleReservation);
	}
	
}
