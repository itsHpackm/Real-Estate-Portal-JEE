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
 
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ct = request.getServletContext();
		Particulier part = (Particulier) ct.getAttribute("part"); 
		PrintWriter out = response.getWriter();
		MetierImpl metier = new MetierImpl();
		List<Message> lm=metier.listMessage(part.getId_particulier());
 
		ct.setAttribute("list", lm);
		if(ct.getAttribute("list")==null) { 
			out.println("une erreur s'est produit");
		}
		else {
			RequestDispatcher rs= request.getRequestDispatcher("MessageRecu.jsp");
			rs.forward(request, response);
		}
		}
	

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		PrintWriter out = response.getWriter();
		int numA=Integer.parseInt(request.getParameter("numA"));
		String nom=request.getParameter("nomE");
		String prenom=request.getParameter("prenomE");
		String email=request.getParameter("emailE");
		String message=request.getParameter("message"); 
	 	Message msge=new Message(numA,nom,prenom,email,message);
	 
		MetierImpl metier = new MetierImpl();
		int n =metier.addMessage(msge);
		if (n==0) {
			msg="Erreur! Votre message n'est pas envoyé";
		}
		else {
			msg="Votre Message est envoyé";
			
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rs= request.getRequestDispatcher("contacter.jsp");
		rs.forward(request, response);
	
	}		

	
}
