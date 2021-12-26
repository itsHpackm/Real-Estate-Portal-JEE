package Services;


import java.util.List;

import javax.servlet.http.Part; 
import Model.*; 

public interface IMetierPortail {
	
	public int addParticulier(Particulier pr);
	public int addBien(int idpart,Bien bn,Photos ph); 
	public int addMessage(Message msg);
	public Particulier seConnecter(String email,String pwd);
	public List<Message> listMessage(int idpart); 
	public int supprimerCompte(int idpart);
	public int modifierPass(int idpart,String pass);
	public String extracetFileName(Part pt);
	public List<Bien> afficheAnnonce(String tran,String tb,float surf,String ville,float pm,String region); 
	public List<Bien> afficheMesAnnonce(int idpart); 
	public int supprimerAnnonce(int id );
	public int modifierAnnonce(int id,String tran,String tb,float surf,String ville,float pm,String reg,String et,String desc);
	public List<Bien> afficheToutAnnonces(); 
	
}
