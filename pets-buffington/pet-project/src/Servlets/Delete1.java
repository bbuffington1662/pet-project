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
@WebServlet("/Delete1")
public class Delete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete1() {
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
		Pet pet = UtilDB.getPet(Integer.parseInt(request.getParameter("delete")));
		UtilDB.delete(pet);
		
		String title = "Delete";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<p>The following pet has been deleted:<br/>" + pet.toString() + " </p>");
	      out.println("<p><a href=\"index.html\">Home</a></p>");
	      out.println("</body></html>");
	}

}
