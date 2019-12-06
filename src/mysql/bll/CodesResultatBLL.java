package mysql.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */

public abstract class CodesResultatBLL {
    /**
     * Echec : le nom ne respecte pas les règles définies
     */
    public static final int NOM_ERREUR=20000;
    /**
     * Echec : le prénom ne respecte pas les règles définies
     */
    public static final int PRENOM_ERREUR = 20001;
    /**
     * Echec : l'adresse ne respecte pas les règles définies
     */
    public static final int ADRESSE_ERREUR = 20002;
    /**
     * Echec : le n° telephone ne respecte pas les règles définies
     */
    public static final int TELEPHONE_ERREUR = 20003;
}
