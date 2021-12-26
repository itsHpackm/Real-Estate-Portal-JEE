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

 
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ConnexionServlet() {
        super();
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx=request.getServletContext();
		 
		ctx.setAttribute("part", null);
		//RequestDispatcher rs= request.getRequestDispatcher("publier.jsp");
		//rs.forward(request, response);
		RequestDispatcher rs= request.getRequestDispatcher("accueil.jsp");
		rs.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String msg ;
		ServletContext ctx=request.getServletContext();
		PrintWriter out = response.getWriter();
		String email=request.getParameter("uname"); 
		String pwd=request.getParameter("pwd");  
	 
		MetierImpl metier = new MetierImpl();
		Particulier part =metier.seConnecter(email, pwd);
		if (part==null) {
			msg="Erreur! Votre compte n'est pas crée";
			request.setAttribute("msg", msg);
			RequestDispatcher rs= request.getRequestDispatcher("connecter.jsp");
			rs.forward(request, response);
		}
		else {
			 
			ctx.setAttribute("part", part); 
			RequestDispatcher rs= request.getRequestDispatcher("accueil.jsp");
			rs.forward(request, response);
		}
	
		
	}

}
