package Controller;

import java.io.File;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Services.MetierImpl;
import Model.*; 

 
@WebServlet("/AnnonceServlet")
@MultipartConfig(
        fileSizeThreshold   =  1024 * 1024 * 2,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15// 15 MB 
)
public class AnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AnnonceServlet() {
        super();
           }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String msg;
		 MetierImpl metier = new MetierImpl(); 
		 ServletContext ctx = request.getServletContext();
		 Particulier par = (Particulier) ctx.getAttribute("part");
		 String tb = request.getParameter("typebien");
		 String tr = request.getParameter("transaction");
		 String et = request.getParameter("etat");
		 float sr =Float.parseFloat(request.getParameter("surface"));
		 int nc =Integer.parseInt(request.getParameter("nbr_ch"));
		 int ne = Integer.parseInt(request.getParameter("nbr_etage"));
		 float pr =  Float.parseFloat(request.getParameter("prix"));
		 String vl = request.getParameter("ville");
		 String rg = request.getParameter("region");
		 String adr = request.getParameter("adresse");
		 String dsr = request.getParameter("description");
		 Bien bien = new  Bien(tb, tr, sr, nc, ne,pr, vl, rg, adr, et, dsr,par.getId_particulier());  
		// System.out.println(bien.getType_bien()+"-"+bien.getTransaction()+"-"+bien.getSurface()+"-"+bien.getNbr_chambre()+"-"+bien.getNbr_etage()+"-"+bien.getPrix()+"-"+bien.getVille());
		 Part pt=request.getPart("image");
		 String filename = metier.extracetFileName(pt);
	//	 Random rand = new Random(); 
		// int nbr = rand.nextInt(1000);
		 //filename=nbr+filename;
		 String savepath="C:\\Users\\assem\\OneDrive\\Bureau\\DS&BD 2020-2021\\JEE & DOTNET\\eclipse-workspace\\SitePoratil\\WebContent\\photos"+ File.separator+filename;
		 File savedir =new File(savepath);
		 pt.write(savepath+File.separator);
		  Photos photo = new Photos(filename,savepath);
		 int nbrL=  metier.addBien(par.getId_particulier(), bien, photo);
			if (nbrL==0) {
				msg="Erreur! Votre Annonce n'est pas publiée";
			}
			else {
				msg="Votre Annonce est publiée";
				
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rs= request.getRequestDispatcher("publier.jsp");
			rs.forward(request, response);
			
	}

	 

}
