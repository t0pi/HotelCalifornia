package mysql.bo;

import java.time.LocalDate;

public class LigneReservation {
	
	private Reservation reservation;
	private int ligneReservation;
	private Chambre chambre;
	private LocalDate arrivee;
	private LocalDate depart;
	
	public LigneReservation() {
		
	}
	
	
	public LigneReservation(Reservation reservation, int ligneReservation, Chambre chambre, LocalDate arrivee,
			LocalDate depart) {
		this(reservation, chambre, arrivee, depart);
		this.ligneReservation = ligneReservation;
	}
	
	public Reservation Reservation() {
		return reservation;
	}


	public LigneReservation(Reservation nouvelleReservation, Chambre nouvelleChambre, LocalDate dateArrivee,
			LocalDate dateDepart) {
		this();
		this.reservation = nouvelleReservation;
		this.chambre = nouvelleChambre;
		this.arrivee = dateArrivee;
		this.depart = dateDepart;
		
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public int getLigneReservation() {
		return ligneReservation;
	}


	public void setLigneReservation(int ligneReservation) {
		this.ligneReservation = ligneReservation;
	}


	public Chambre getChambre() {
		return chambre;
	}


	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}


	public LocalDate getArrivee() {
		return arrivee;
	}


	public void setArrivee(LocalDate arrivee) {
		this.arrivee = arrivee;
	}


	public LocalDate getDepart() {
		return depart;
	}


	public void setDepart(LocalDate depart) {
		this.depart = depart;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LigneReservation [reservation=");
		builder.append(reservation);
		builder.append(", ligneReservation=");
		builder.append(ligneReservation);
		builder.append(", chambre=");
		builder.append(chambre);
		builder.append(", arrivee=");
		builder.append(arrivee);
		builder.append(", depart=");
		builder.append(depart);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
