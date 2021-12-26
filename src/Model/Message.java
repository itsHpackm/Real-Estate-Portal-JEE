package Model;

 
import java.io.Serializable;
import java.lang.String; 

 

public class Message implements Serializable {

	 
	private int id_message;
	private int id_particulier;
	private String nom_emeteur;
	private String prenom_emeteur;
	private String email_emeteur;
	private String message;
	
	private static final long serialVersionUID = 1L;

	public Message() {
		super();
	}   
	public Message(int idp,String n,String p,String em, String me) {
		id_particulier=idp;
		nom_emeteur=n;
		prenom_emeteur=p;
		email_emeteur=em;
		message=me;
	}
	public int getId_message() {
		return this.id_message;
	}

	public void setId_message(int id_message) {
		this.id_message = id_message;
	}   
	public String getNom_emeteur() {
		return this.nom_emeteur;
	}

	public void setNom_emeteur(String nom_emeteur) {
		this.nom_emeteur = nom_emeteur;
	}   
 
	public String getEmail_emeteur() {
		return this.email_emeteur;
	}

	public void setEmail_emeteur(String email_emeteur) {
		this.email_emeteur = email_emeteur;
	}   
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String Message) {
		this.message = Message;
	}   
	public int getId_particulier() {
		return this.id_particulier;
	}

	public void setId_particulier(int id_particulier) {
		this.id_particulier = id_particulier;
	}
	public String getPrenom_emeteur() {
		return prenom_emeteur;
	}
	public void setPrenom_emeteur(String prenom_emeteur) {
		this.prenom_emeteur = prenom_emeteur;
	}
   
}
