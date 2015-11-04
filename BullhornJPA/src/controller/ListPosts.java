package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class ListTs
 */
@WebServlet("/ListPosts")
public class ListPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ArrayList<model.T> postList = TDB.selectAll();
        String message = "";
        java.sql.Timestamp sqlTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (model.T aPost : postList) {
	        sqlTime = aPost.getMsgdate();
	        
			message = message + "	<div class=\"row\"><br><div class=\"col-md-4\">"+aPost.getMsg()+"</div>" +
					"<div class=\"col-md-4\">"+sdf.format(sqlTime)+"</div>" + 
					"<div class=\"col-md-4\"><button type=\"submit\" class=\"btn btn-success\">"+aPost.getTuser().getLoginname()+"</button></div></div>";			
		}
        request.setAttribute("message", message);   
 		getServletContext().getRequestDispatcher("/ListPosts.jsp").forward(request, response);		


}
}