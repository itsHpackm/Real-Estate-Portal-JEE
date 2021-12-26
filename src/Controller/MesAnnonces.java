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
 * Servlet implementation class MesAnnonces
 */
@WebServlet("/MesAnnonces")
public class MesAnnonces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		ServletContext ct = request.getServletContext();
		Particulier part = (Particulier) ct.getAttribute("part"); 
		PrintWriter out = response.getWriter();
		MetierImpl metier = new MetierImpl();
		List<Bien> lm=metier.afficheMesAnnonce(part.getId_particulier());
 
		ct.setAttribute("listb", lm);
		if(ct.getAttribute("listb")==null) { 
			out.println("une erreur s'est produit");
		}
		else {
			RequestDispatcher rs= request.getRequestDispatcher("mesAnnonces.jsp");
			rs.forward(request, response);
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg1;
		int id =Integer.parseInt(request.getParameter("idbien"));
		 MetierImpl metier = new MetierImpl();
		 int n =metier.supprimerAnnonce(id);
		 if (n==0) {
			 msg1="erreur! Votre annonce n'a pas été supprimé ou il n'existe pas";
		 }
		 else {
			 msg1="Votre annonce a été supprimé, actualiser la page pour voir";
			 
		 }
		 request.setAttribute("msg",msg1);
		 RequestDispatcher rs= request.getRequestDispatcher("mesAnnonces.jsp");
			rs.forward(request, response);
	}

}
