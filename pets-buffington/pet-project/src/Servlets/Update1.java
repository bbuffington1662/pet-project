package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Pet;
import Utils.UtilDB;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update1")
public class Update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update1() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    update(request, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	void update(HttpServletRequest request, PrintWriter out) {
	   Pet pet = new Pet(
			      Integer.parseInt(request.getParameter("update")),
			   	  request.getParameter("name"),
	    		  request.getParameter("owner"),
	    		  request.getParameter("species"),
	    		  request.getParameter("isBaby") != null,
	   			  request.getParameter("description"));

	   UtilDB.update(pet);
	   
	   String title = "Update";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<p>The pet now looks like:<br/>" + pet.toString() + " </p>");
	      out.println("<p><a href=\"index.html\">Home</a></p>");
	      out.println("</body></html>");
	}
}
