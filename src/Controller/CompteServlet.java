package Controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.*;
import Model.*;

@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		PrintWriter out = response.getWriter();
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String adr=request.getParameter("adresse");
		String pwd=request.getParameter("pwd"); 
	 	Particulier pr=new Particulier(nom,prenom,email,adr,pwd);
		MetierImpl metier = new MetierImpl();
		int n =metier.addParticulier(pr);
		if (n==0) {
			msg="Erreur! Votre compte n'est pas crée";
		}
		else {
			msg="Votre compte est crée";
			
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rs= request.getRequestDispatcher("compte.jsp");
		rs.forward(request, response);
		
	}

}
