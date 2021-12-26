package Services;
 
import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;
 

import Model.*; 
public class MetierImpl implements IMetierPortail{
	 private Statement st;
	   public ResultSet res;
	   int n,o,id; 
	   Particulier prt=null;
	   public MetierImpl() {}
	   
	   
	@Override
	public int addParticulier(Particulier pr) { 
		ConnexionDB.getconnection();
		try {
			st=ConnexionDB.cnx.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			try {
				  n=st.executeUpdate("INSERT INTO Particulier(`nom`, `prenom`, `email`, `mdp`, `adresse`) VALUES ('"+pr.getNom()+"','"+pr.getPrenom()+"','"+pr.getEmail()+"','"+pr.getPassword()+"','"+pr.getAdresse()+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					(ConnexionDB.cnx).close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return 0;
			}
			try {
				(ConnexionDB.cnx).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n;
			
			
					 
		 
	}

	@Override
	public int addBien(int idpart,Bien bn,Photos ph) {
		ConnexionDB.getconnection();
		try {
			st=ConnexionDB.cnx.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			try {
				n=st.executeUpdate("INSERT INTO `bien`(`type_bien`, `transaction`, `surface`, `nbr_chambre`, `nbr_etage`, `prix`, `ville`, `region`, `adresse`, `etat`, `id_particulier`, `description`) VALUES ('"+bn.getType_bien()+"','"+bn.getTransaction()+"','"+bn.getSurface()+"','"+bn.getNbr_chambre()+"','"+bn.getNbr_etage()+"','"+bn.getPrix()+"','"+bn.getVille()+"','"+bn.getRegion()+"','"+bn.getAdresse()+"','"+bn.getEtat()+"','"+idpart+"','"+bn.getDescription()+"')");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			try {
				res=st.executeQuery("select id_bien from Bien order by id_bien desc limit 1");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}

			try {
				while(res.next()) { 
					id=res.getInt("id_bien");
					
				}
			} catch (SQLException e) { 
				e.printStackTrace();
				return 0;
			}
			try {
				/*PreparedStatement pd=ConnexionDB.cnx.prepareStatement("INSERT INTO `photo`(`filename`, `path`, `id_bien') VALUES (?,?,?);");
				pd.setString(1, ph.getPhoto_name());
				pd.setString(2, ph.getPhoto_name());
				pd.setInt(3, ph.getId_bien());
				pd.executeUpdate();
				*/
				o=st.executeUpdate("INSERT INTO `photo`(`filename`, `path`, `id_bien`)  VALUES ('"+ph.getPhoto_name()+"','"+ph.getPhoto_path()+"','"+id+"')");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return 0;
			}
			try {
				(ConnexionDB.cnx).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			return 1;
		 
	}


	@Override
	public int addMessage(Message msg) { 
		
		ConnexionDB.getconnection();
		try {
			st=ConnexionDB.cnx.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			try {
				  n=st.executeUpdate("INSERT INTO Message(`nom_emetteur`, `prenom_emetteur`, `email_emetteur`, `message`, `id_particulier`) VALUES ('"+msg.getNom_emeteur()+"','"+msg.getPrenom_emeteur()+"','"+msg.getEmail_emeteur()+"','"+msg.getMessage()+"','"+msg.getId_particulier()+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					(ConnexionDB.cnx).close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return 0;
			}
			try {
				(ConnexionDB.cnx).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n;
			
	}


	@Override
	public Particulier seConnecter(String email, String pwd) { 
	 
		ConnexionDB.getconnection();
		try {
			st=ConnexionDB.cnx.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			try {
				  res=st.executeQuery("select * from  Particulier  where email='"+email+"' and mdp='"+pwd+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			 
				try {
					while(res.next()) {
						Particulier pr=new Particulier();
						pr.setId_particulier(res.getInt("id_particulier"));
						pr.setNom(res.getString("nom"));
						pr.setPrenom(res.getString("prenom"));
						pr.setEmail(res.getString("email"));
						pr.setPassword(res.getString("mdp"));
						pr.setAdresse(res.getString("adresse"));
						prt=pr;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				return prt;
				 
			 
			 	
	}


	@Override
	public List<Message> listMessage(int idpart) {
		List<Message> listMess = new ArrayList<Message>();
		try {
		ConnexionDB.getconnection();
		st=ConnexionDB.cnx.createStatement();
		 res=st.executeQuery("select * from  Message  where id_particulier='"+idpart+"'");
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		 try {
			while(res.next()) {
					Message mssg=new Message();
					mssg.setNom_emeteur(res.getString("nom_emetteur"));
					mssg.setPrenom_emeteur(res.getString("prenom_emetteur"));
					mssg.setEmail_emeteur(res.getString("email_emetteur")); 
					mssg.setMessage(res.getString("message")); 
					listMess.add(mssg);
			 
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return listMess;

}


	@Override
	public int supprimerCompte(int idpart) {
		try {
			ConnexionDB.getconnection();
			st=ConnexionDB.cnx.createStatement();
			 n=st.executeUpdate("Delete from  Particulier  where id_particulier='"+idpart+"'");
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
			  
		return n;
	}


	@Override
	public int modifierPass(int idpart, String pass) {
		 
		try {
			ConnexionDB.getconnection();
			st=ConnexionDB.cnx.createStatement();
			 n=st.executeUpdate("update Particulier set mdp='"+pass+"'  where id_particulier='"+idpart+"'");
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
			  
		return n;
	}


	@Override
	public String extracetFileName(Part pt) {
		String contentdisp =  pt.getHeader("content-disposition");
		String[] items = contentdisp.split(";");
		for (String d : items) {
			if(d.trim().startsWith("filename")) {
				return d.substring(d.indexOf("=")+2,d.length()-1);
			}
		}
		return "";
	}

	@Override
	public List<Bien> afficheAnnonce(String tran, String tb, float surf, String ville, float pm,String rg) {

		 List<Bien> list = new ArrayList<Bien>();
		try {
			ConnexionDB.getconnection();
			st=ConnexionDB.cnx.createStatement();
			String sql="SELECT id_particulier,bien.transaction,type_bien,adresse,surface,prix,nbr_chambre,nbr_etage,description,filename FROM photo,bien WHERE photo.id_bien=bien.id_bien";
			if(!tran.equals("null")) {
				sql=sql+" and bien.transaction='"+tran+"'";
			}
			if(!tb.equals("null")) {
				sql=sql+" and type_bien='"+tb+"'";
			}
			if(!rg.equals("")) {
				sql=sql+" and region='"+rg+"'";
			}
			if (surf!=-1) {
				sql=sql+" and surface<="+surf;
			}
			if (!ville.equals("")) {
				sql=sql+" and ville='"+ville+"'";
			}
			if (pm!=-1) {
				sql=sql+" and prix<="+pm;
			}
			sql=sql+";";
			res=st.executeQuery(sql);
				}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		try {
			while (res.next()) {
				Bien bn = new Bien();
				bn.setId_particulier(res.getInt("id_particulier"));
				bn.setTransaction(res.getString("transaction"));
				bn.setType_bien(res.getString("type_bien"));
				bn.setAdresse(res.getString("adresse"));
				bn.setSurface(res.getFloat("surface"));
				bn.setPrix(res.getFloat("prix"));
				bn.setNbr_chambre(res.getInt("nbr_chambre"));
				bn.setNbr_etage(res.getInt("nbr_etage"));
				bn.setDescription(res.getString("description"));
				bn.setFilename(res.getString("filename"));
				list.add(bn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public List<Bien> afficheMesAnnonce(int idpart) {
		 List<Bien> list = new ArrayList<Bien>();
			try {
				ConnexionDB.getconnection();
				st=ConnexionDB.cnx.createStatement();
				 res=st.executeQuery("SELECT bien.id_bien,id_particulier,transaction,type_bien,surface,prix,ville,region,nbr_chambre,nbr_etage,etat,description,filename FROM photo,bien WHERE photo.id_bien=bien.id_bien and id_particulier='"+idpart+"';");
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}
			try {
				while (res.next()) {
					Bien bn = new Bien();
					bn.setId_bien(res.getInt("id_bien"));
					bn.setId_particulier(res.getInt("id_particulier"));
					bn.setTransaction(res.getString("transaction"));
					bn.setType_bien(res.getString("type_bien")); 
					bn.setSurface(res.getFloat("surface"));
					bn.setPrix(res.getFloat("prix"));
					bn.setNbr_chambre(res.getInt("nbr_chambre"));
					bn.setNbr_etage(res.getInt("nbr_etage"));
					bn.setVille(res.getString("ville"));
					bn.setRegion(res.getString("region"));
					bn.setEtat(res.getString("etat"));
					bn.setDescription(res.getString("description"));
					bn.setFilename(res.getString("filename"));
					list.add(bn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		
	}


	
	@Override
	public int supprimerAnnonce(int id) { 
		try {
			ConnexionDB.getconnection();
			st=ConnexionDB.cnx.createStatement();
			 n=st.executeUpdate("Delete from  photo  where id_bien='"+id+"'");
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
		try {
			o=st.executeUpdate("Delete from  bien  where id_bien='"+id+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		return n+o;
	}


	@Override
	public int modifierAnnonce(int idbien,String tran, String tb, float surf, String ville, float pm, String reg, String et,
			String desc) {

		try {
			ConnexionDB.getconnection();
			st=ConnexionDB.cnx.createStatement();
			String sql="update bien set";
			if(!tran.equals("null")) {
				sql=sql+" transaction='"+tran+"'";
			}
			if(!tb.equals("null")) {
				if(!tran.equals("null")) {
					sql=sql+" ,";
				}
				sql=sql+" type_bien='"+tb+"'";
			}
			if(!reg.equals("")) {
				if(!tb.equals("null") || !tran.equals("null")) {
					sql=sql+" ,";
				}
				sql=sql+" region='"+reg+"'";
			}
			if (surf!=-1) {
				if(!reg.equals("") || !tb.equals("null") || !tran.equals("null")) {
					sql=sql+" ,";
				}
				sql=sql+" surface="+surf+"";
			}
			if (!ville.equals("")) {
				if (surf!=-1 || !reg.equals("") || !tb.equals("null") || !tran.equals("null")) {
					sql=sql+" ,";
				}
				sql=sql+" ville='"+ville+"'";
			}
			if (pm!=-1) {
				if (!ville.equals("") || surf!=-1 || !reg.equals("") || !tb.equals("null") || !tran.equals("null")) {
					sql=sql+" ,";
				}
				sql=sql+" prix="+pm+"";
			}
		 
			if(!et.equals("null")) {
				if(!reg.equals("") || pm!=-1 || !ville.equals("") || surf!=-1 || !reg.equals("") || !tb.equals("null") || !tran.equals("null")) {
						sql=sql+" ,";
					}
					sql=sql+" etat='"+et+"'";
				}
			if(!desc.equals("")) {
				if(!et.equals("null") ||  pm!=-1 ||!ville.equals("") || surf!=-1 || !reg.equals("")  || !tb.equals("null") || !tran.equals("null")) {
						sql=sql+" ,";
					}
					sql=sql+" description='"+desc+"'";
				}
			sql=sql+" where id_bien="+idbien;
			n=st.executeUpdate(sql);
				}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
		 
		return n;
	
	}


	@Override
	public List<Bien> afficheToutAnnonces() {
		 List<Bien> list = new ArrayList<Bien>();
			try {
				ConnexionDB.getconnection();
				st=ConnexionDB.cnx.createStatement();
				 res=st.executeQuery("SELECT bien.id_bien,id_particulier,transaction,type_bien,adresse,surface,prix,nbr_chambre,nbr_etage,etat,description,filename FROM photo,bien WHERE photo.id_bien=bien.id_bien");
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}
			try {
				while (res.next()) {
					Bien bn = new Bien();
					bn.setId_bien(res.getInt("id_bien"));
					bn.setId_particulier(res.getInt("id_particulier"));
					bn.setTransaction(res.getString("transaction"));
					bn.setType_bien(res.getString("type_bien"));
					bn.setAdresse(res.getString("adresse"));
					bn.setSurface(res.getFloat("surface"));
					bn.setPrix(res.getFloat("prix"));
					bn.setNbr_chambre(res.getInt("nbr_chambre"));
					bn.setNbr_etage(res.getInt("nbr_etage"));
					bn.setEtat(res.getString("etat"));
					bn.setDescription(res.getString("description"));
					bn.setFilename(res.getString("filename"));
					list.add(bn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		
	}


	
	
	 } 


