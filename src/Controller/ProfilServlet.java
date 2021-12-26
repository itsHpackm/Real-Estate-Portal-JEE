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

 
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		ServletContext cnt = request.getServletContext();
		Particulier part = (Particulier) cnt.getAttribute("part"); 
		PrintWriter out = response.getWriter();
		MetierImpl metier = new MetierImpl(); 
		int n =metier.supprimerCompte(part.getId_particulier());
		if (n==0) {
			msg="Erreur! Votre compte n'est pas crée";
			request.setAttribute("msg", msg);
			RequestDispatcher rs= request.getRequestDispatcher("profil.jsp");
			rs.forward(request, response);
		}
		else { 
			cnt.setAttribute("part", null);
			RequestDispatcher rs= request.getRequestDispatcher("accueil.jsp");
			rs.forward(request, response);
		}
		
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		ServletContext cnt = request.getServletContext();
		Particulier part = (Particulier) cnt.getAttribute("part"); 
		//PrintWriter out = response.getWriter();
		String pwd=request.getParameter("pwd");
		String pwd1=request.getParameter("pwd1"); 
		System.out.println(pwd+"--"+pwd1);
		if(pwd.equals(pwd1)) {
			MetierImpl metier = new MetierImpl();
			int n = metier.modifierPass(part.getId_particulier(), pwd);
			if (n==0) {
				msg="Erreur! Votre password n'est pas changé";
			}
			else {
				msg="Votre password est changé, reconnecté à nouveau!!!!";
				cnt.setAttribute("part", null);;
			}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rs= request.getRequestDispatcher("changerPassword.jsp");
		rs.forward(request, response);
		}
	}

}
