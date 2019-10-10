package Servlets;
/**
 * @file SimpleFormInsert.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Pet;
import Utils.UtilDB;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public Insert() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html");
      insert(request, response.getWriter());
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
   
   void insert(HttpServletRequest request, PrintWriter out) {
	   Pet pet = new Pet(
	    		  request.getParameter("name"),
	    		  request.getParameter("owner"),
	    		  request.getParameter("species"),
	    		  request.getParameter("isBaby") != null,
	   			  request.getParameter("description"));
	   
	   UtilDB.insert(pet);
	   
	   String title = "Insert";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<p>The following pet has been inserted:<br/><br/>" + pet.toString() + " </p>");
	      out.println("<p><a href=\"index.html\">Home</a></p>");
	      out.println("</body></html>");
   }
}
