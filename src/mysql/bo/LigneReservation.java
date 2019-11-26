package mysql.bo;

import java.util.Date;

public class LigneReservation {
	
	private int reservation;
	private int ligneReservation;
	private int chambre;
	private Date arrivee;
	private Date depart;
	
	
	public LigneReservation(int reservation, int ligneReservation, int chambre, Date arrivee, Date depart) {
		super();
		this.reservation = reservation;
		this.ligneReservation = ligneReservation;
		this.chambre = chambre;
		this.arrivee = arrivee;
		this.depart = depart;
	}


	public int getReservation() {
		return reservation;
	}


	public void setReservation(int reservation) {
		this.reservation = reservation;
	}


	public int getLigneReservation() {
		return ligneReservation;
	}


	public void setLigneReservation(int ligneReservation) {
		this.ligneReservation = ligneReservation;
	}


	public int getChambre() {
		return chambre;
	}


	public void setChambre(int chambre) {
		this.chambre = chambre;
	}


	public Date getArrivee() {
		return arrivee;
	}


	public void setArrivee(Date arrivee) {
		this.arrivee = arrivee;
	}


	public Date getDepart() {
		return depart;
	}


	public void setDepart(Date depart) {
		this.depart = depart;
	}


	@Override
	public String toString() {
		return "Reservation [reservation=" + reservation + ", ligneReservation=" + ligneReservation + ", chambre="
				+ chambre + ", arrivee=" + arrivee + ", depart=" + depart + "]";
	}
	
	
	

	
}
