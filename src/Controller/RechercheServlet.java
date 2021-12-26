package Controller;

import java.io.IOException;

import java.io.PrintWriter;
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
 * Servlet implementation class RechercheServlet
 */
@WebServlet("/RechercheServlet")
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		float srf = -1,pr = -1;
	 	ServletContext ctx = request.getServletContext();
	 	String typebien=request.getParameter("typebien");
		String tra=request.getParameter("transaction");
		
		
		String ville=request.getParameter("vl");
		String region=request.getParameter("region");
		if(request.getParameter("surface")!="" && request.getParameter("prixmax")!="") {
			srf =  Float.parseFloat(request.getParameter("surface")); 
			pr =  Float.parseFloat(request.getParameter("prixmax"));
		}
		if(request.getParameter("surface")!="" ) {
			srf =  Float.parseFloat(request.getParameter("surface")); 
		}
		if(request.getParameter("prixmax")!="")
		{
			pr =  Float.parseFloat(request.getParameter("prixmax")); 
		}
		 
		 System.out.println(tra+"-"+typebien+"-"+srf+"-"+ville+"-"+pr);
		 MetierImpl metier = new MetierImpl();
		 List<Bien> bn = metier.afficheAnnonce(typebien,tra , srf, ville, pr, region);
	 	
		 if(bn.size()==0) {
			 msg="Désolé! Aucun résultat ne correspond à votre recherche";
			 request.setAttribute("msg", msg); 
			 ctx.setAttribute("biens", null);
			 ctx.setAttribute("listA", null);
				RequestDispatcher rs= request.getRequestDispatcher("chercher.jsp");
				rs.forward(request, response);
		 }
		 else {
			 ctx.setAttribute("biens", bn);
			 ctx.setAttribute("listA", null);
			 RequestDispatcher rs= request.getRequestDispatcher("chercher.jsp");
				rs.forward(request, response);
			
		 } 

	}

}
