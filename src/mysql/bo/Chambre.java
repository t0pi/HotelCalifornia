package mysql.bo;

public class Chambre {
	
	private int idChambre;
	private String nom;
	private int nbLits;
	private float prix;
	
	public Chambre(int idChambre, String nom, int nbLits, float prix) {
		super();
		this.idChambre = idChambre;
		this.nom = nom;
		this.nbLits = nbLits;
		this.prix = prix;
	}

	public Chambre(String nom2, int id) {
		// TODO Auto-generated constructor stub
	}

	public int getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbLits() {
		return nbLits;
	}

	public void setNbLits(int nbLits) {
		this.nbLits = nbLits;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Chambre [idChambre=" + idChambre + ", nom=" + nom + ", nbLits=" + nbLits + ", prix=" + prix + "]";
	}
	
	
	
}
