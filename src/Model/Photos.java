package Model;

 
 
import java.io.Serializable;
import java.lang.String; 

 
public class Photos implements Serializable {

	    
	private int id_photo;
	private String photo_name;
	private String photo_path;
	private int id_bien;
	private static final long serialVersionUID = 1L;

	public Photos() {
		super();
	}   
	
	public Photos(String photo_name, String photo_path) {
		super();
		this.photo_name = photo_name;
		this.photo_path = photo_path;
	}

	public int getId_photo() {
		return this.id_photo;
	}

	public void setId_photo(int id_photo) {
		this.id_photo = id_photo;
	}   
	public String getPhoto_name() {
		return this.photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}   
	public String getPhoto_path() {
		return this.photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public int getId_bien() {
		return id_bien;
	}
	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}
   
}
