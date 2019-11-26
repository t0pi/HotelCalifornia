package mysql.bo;

import java.util.Date;

public class LigneReservation {
	
	private Reservation reservation;
	private int ligneReservation;
	private Chambre chambre;
	private Date arrivee;
	private Date depart;
	
	
	public LigneReservation(Reservation reservation, int ligneReservation, Chambre chambre, Date arrivee, Date depart) {
		super();
		this.reservation = reservation;
		this.ligneReservation = ligneReservation;
		this.chambre = chambre;
		this.arrivee = arrivee;
		this.depart = depart;
	}

	
}
