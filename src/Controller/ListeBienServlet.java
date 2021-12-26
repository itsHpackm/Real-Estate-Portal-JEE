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
 * Servlet implementation class ListeBienServlet
 */
@WebServlet("/ListeBienServlet")
public class ListeBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeBienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();
		PrintWriter out= response.getWriter();
		MetierImpl metier = new MetierImpl();
		List<Bien> list=metier.afficheToutAnnonces();
		ctx.setAttribute("listA", list); 
		if(ctx.getAttribute("listA")==null) { 
			out.println("une erreur s'est produit");
		}
		else {
			ctx.setAttribute("biens", null);
			RequestDispatcher rs= request.getRequestDispatcher("chercher.jsp");
			rs.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
