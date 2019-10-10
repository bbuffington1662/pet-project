package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Pet;
import Utils.UtilDB;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		retrieveDisplayData(response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	void retrieveDisplayData(PrintWriter out) {
	      String title = "Pets";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<p><a href=\"index.html\">Home</a></p>");
	      out.println("<ul>");
	      List<Pet> pets = UtilDB.listPets();
	      for (Pet pet : pets) {
	         out.println("<li>" + pet.toString()
	         		+ "<br/>"
	         		+ "<form action=\"Delete2\" method=\"POST\">"
	         		+ "<button type=\"submit\" name=\"id\" value=\"" + pet.getId() + "\">Delete</button>"
	         		+ "</form>"
	         		+ "<form action=\"Update2\" method=\"POST\">"
	         		+ "<button type=\"submit\" name=\"id\" value=\"" + pet.getId() + "\">Update</button>"
	         		+ "</form></li>"
	         		+ "<br/>");
	      }
	      out.println("</ul>");
	      out.println("</body></html>");
	   }
}
