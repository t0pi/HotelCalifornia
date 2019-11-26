package mysql.bo;

import java.util.Date;

public class Reservation {
	
	private int idReservation;
	private Client client;
	private Date le;
	private Date payeele;
	
	
	public Reservation(int idReservation, Client client, Date le, Date payeele) {
		super();
		this.idReservation = idReservation;
		this.client = client;
		this.le = le;
		this.payeele = payeele;
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


	public Date getLe() {
		return le;
	}


	public void setLe(Date le) {
		this.le = le;
	}


	public Date getPayeele() {
		return payeele;
	}


	public void setPayeele(Date payeele) {
		this.payeele = payeele;
	}


	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", client=" + client + ", le=" + le + ", payeele="
				+ payeele + "]";
	}
	

}
