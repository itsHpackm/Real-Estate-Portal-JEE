package Model;

import java.io.Serializable;

public class Particulier implements Serializable {
 
	private int id_particulier; 
	private String nom; 
	private String prenom; 
	private String email; 
	private String password; 
	private String adresse; 
	private static final long serialVersionUID = 1L;

	public Particulier() { 
	}   
	
 public Particulier(String nom,String prenom,String email,String adresse,String password) {
		super();
 
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.adresse=adresse;
		this.password=password;	
	}  
	public  int getId_particulier() {
		return this.id_particulier;
	}

	public void setId_particulier(int id_particulier) {
		this.id_particulier = id_particulier;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
 
   
}

