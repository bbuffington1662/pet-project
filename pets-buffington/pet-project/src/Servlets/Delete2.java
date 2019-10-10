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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete2")
public class Delete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		delete(request, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	void delete(HttpServletRequest request, PrintWriter out) {
		Pet pet = UtilDB.getPet(Integer.parseInt(request.getParameter("id")));
		
		String title = "Delete Confirmation";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<p>Are you sure you want to delete the following pet?<br/>" + pet.toString() + " </p>");
	      out.println("<form action=\"Delete1\" method=\"POST\">");
	      out.println("<button value=\"" + pet.getId() + "\"type=\"submit\" name=\"delete\">Yes</button>");
	      out.println("</form>");
	      out.println("<a href=\"index.html\"><button type=\"submit\">No</button></a>");
	      out.println("</body></html>");
	}

}
