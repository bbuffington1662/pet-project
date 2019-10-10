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
@WebServlet("/Update2")
public class Update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update2() {
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
		Pet pet = UtilDB.getPet(Integer.parseInt(request.getParameter("id")));

	   String title = "Update";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n");
	      out.println("<form action=\"Update1\" method=\"POST\">" + 
	      		"Name: <input type=\"text\" name=\"name\" value=\"" + pet.getName() + "\"> <br />" + 
	      		"Owner: <input type=\"text\" name=\"owner\" value=\"" + pet.getOwner() + "\"> <br />" + 
	      		"Species: <input type=\"text\" name=\"species\" value=\"" + pet.getSpecies() + "\"> <br />" + 
	      		"Is a Baby: <input type=\"checkbox\" name=\"isBaby\"" + (pet.getIsBaby() ? "checked" : "") + "> <br />" +
	      		"Description: <input type=\"text\" name=\"description\" value=\"" + pet.getDescription() + "\"> <br />" + 
	      		"<button type=\"submit\" value=\"" + pet.getId() + "\"name=\"update\"/>Update</button>" + 
	      		"</form>");
	      out.println("</body></html>");
	}
}
