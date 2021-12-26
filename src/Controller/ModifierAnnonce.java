package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.*;
import Model.*;

/**
 * Servlet implementation class ModifierAnnonce
 */
@WebServlet("/ModifierAnnonce")
public class ModifierAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		float srf = -1,pr = -1;
	 	ServletContext ctx = request.getServletContext();
	 	int idbien=Integer.parseInt(request.getParameter("id_bien"));
		String tra=request.getParameter("transaction");
		String typebien=request.getParameter("typebien");
		String ville=request.getParameter("vl");
		String region=request.getParameter("rg");
		String et=request.getParameter("etat");
		String desc=request.getParameter("desc");
		if(request.getParameter("surface")!="" && request.getParameter("prix")!="") {
			srf =  Float.parseFloat(request.getParameter("surface")); 
			pr =  Float.parseFloat(request.getParameter("prix"));
		}
		if(request.getParameter("surface")!="" ) {
			srf =  Float.parseFloat(request.getParameter("surface")); 
		}
		if(request.getParameter("prix")!="")
		{
			pr =  Float.parseFloat(request.getParameter("prix")); 
		}
		 
		 System.out.println(idbien+"*"+tra+"*"+typebien+"*"+srf+"*"+ville+"*"+pr+"*"+region+"*"+et+"*"+desc);
		 MetierImpl metier = new MetierImpl();
		 int n=metier.modifierAnnonce(idbien, tra, typebien, srf, ville, pr, region, et, desc);
		 if(n==0) {
			 msg="Désolé! Aucun mise à jour n'a pas été realiser";
			
		 }
		 else {
			 msg="Votre mise à jour est bien faite,vous pouvez actualiser pour voir";
		 } 
		 request.setAttribute("mssg", msg);  
			RequestDispatcher rs= request.getRequestDispatcher("mesAnnonces.jsp");
			rs.forward(request, response);

	}

}
