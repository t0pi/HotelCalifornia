package mysql.bll;

import gestionErreurs.BusinessException;
import mysql.dal.DaoFactory;

import java.util.List;

import mysql.bo.Client;
import mysql.dal.ClientDao;

public class ClientManager {
	
	private ClientDao clientDao;
	
	public ClientManager() {
		this.clientDao =DaoFactory.getClientDao();
	}
	
	
	public Client ajouterClient(String nom, String prenom, String adresse, String telephone ) throws Exception{
		BusinessException businessException = new BusinessException();

		this.validerNom(nom, businessException);
		this.validerPrenom(prenom, businessException);
		this.validerAdresse(adresse, businessException);
		this.validerTelephone(telephone, businessException);

		Client client = new Client(nom, prenom, adresse, telephone);
		return DaoFactory.getClientDao().insert(client);
			
		}
	
    
    public Client selectionnerClient(String telephone) throws Exception {
		return this.clientDao.selectByTelephone(telephone);
	}

	private void validerNom(String nom, BusinessException businessException) {
		if(nom==null || nom.trim().length()>50)
		{
			businessException.ajouterErreur(CodesResultatBLL.NOM_ERREUR);
		}
	}

	private void validerPrenom(String prenom, BusinessException businessException) {
		if(prenom==null || prenom.trim().length()>50)
		{
			businessException.ajouterErreur(CodesResultatBLL.PRENOM_ERREUR);
		}
	}

	private void validerAdresse(String adresse, BusinessException businessException) {
		if(adresse==null || adresse.trim().length()>50)
		{
			businessException.ajouterErreur(CodesResultatBLL.ADRESSE_ERREUR);
		}
	}

	private void validerTelephone(String telephone, BusinessException businessException) {
		if(telephone==null || telephone.trim().length()>50)
		{
			businessException.ajouterErreur(CodesResultatBLL.TELEPHONE_ERREUR);
		}
	}
	
}
