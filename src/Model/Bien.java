package Model;
 
import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
 
public class Bien implements Serializable {

	    
	private int id_bien;
	private String type_bien;
	private String transaction;
	private Float surface;
	private int nbr_chambre;
	private int nbr_etage;
	private Float prix;	
	private String ville;
	private String region;
	private String adresse;
	private String etat;
	private String description;
	private int id_particulier;
	private String filename;
	private static final long serialVersionUID = 1L;

	public Bien() {
		super();
	}   
	
	
	
	public Bien(String type_bien, String transaction, Float surface, int nbr_chambre, int nbr_etage,
			Float prix, String ville, String region, String adresse, String etat, String description,
			int id_particulier) {
		super(); 
		this.type_bien = type_bien;
		this.transaction = transaction;
		this.surface = surface;
		this.nbr_chambre = nbr_chambre;
		this.nbr_etage = nbr_etage;
		this.prix = prix;
		this.ville = ville;
		this.region = region;
		this.adresse = adresse;
		this.etat = etat;
		this.description = description;
		this.id_particulier = id_particulier;
	}



	public int getId_bien() {
		return this.id_bien;
	}

	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}   
	public String getType_bien() {
		return this.type_bien;
	}

	public void setType_bien(String type_bien) {
		this.type_bien = type_bien;
	}   
	public Float getPrix() {
		return this.prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}   
	public Float getSurface() {
		return this.surface;
	}

	public void setSurface(Float surface) {
		this.surface = surface;
	}   
	public int getNbr_chambre() {
		return this.nbr_chambre;
	}

	public void setNbr_chambre(int nbr_chambre) {
		this.nbr_chambre = nbr_chambre;
	}   
	public int getNbr_etage() {
		return this.nbr_etage;
	}

	public void setNbr_etage(int nbr_etage) {
		this.nbr_etage = nbr_etage;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}   
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}   
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getId_particulier() {
		return id_particulier;
	}
	public void setId_particulier(int id_particulier) {
		this.id_particulier = id_particulier;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
 
	public String getFilename() {
		return filename;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}
   
}
