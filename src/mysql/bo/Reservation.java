package mysql.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;





public class Reservation {
	
	private int idReservation;
	private Client client;
	private LocalDate le;
	private LocalDate payeele;
	private List<LigneReservation> ligneReservation;

	public Reservation() {
		ligneReservation = new ArrayList<LigneReservation>();
	}
	
	public Reservation(Client client, LocalDate le, LocalDate payeele, LigneReservation ligneReservation) {
		this();
		this.client = client;
		this.le = le;
		this.payeele = payeele;
		ajouterLigneReservation(ligneReservation);
	}
	
	
	public void ajouterLigneReservation(LigneReservation lr) {
		ligneReservation.add(lr);
	}


	public int getIdReservation() {
		return idReservation;
	}



	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public LocalDate getLe() {
		return le;
	}



	public void setLe(LocalDate le) {
		this.le = le;
	}

	public LocalDate getPayeele() {
		return payeele;
	}

	public void setPayeele(LocalDate payeele) {
		this.payeele = payeele;
	}


	public List<LigneReservation> getLigneReservation() {
		return ligneReservation;
	}


	public void setLigneReservation(List<LigneReservation> ligneReservation) {
		this.ligneReservation = ligneReservation;
	}


	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", client=" + client + ", le=" + le + ", payeele="
				+ payeele + "]";
	}
	

}
