package Services;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnexionDB {
	public static Connection cnx=null;
	public ConnexionDB() {
	}
		
	                              
	public static void getconnection() {
	try{
		Class.forName("com.mysql.jdbc.Driver");
		cnx=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_portail","root","");
	}catch( Exception e3 ) {
		System.out.println(e3.getMessage());
		 
	}
	}
}
