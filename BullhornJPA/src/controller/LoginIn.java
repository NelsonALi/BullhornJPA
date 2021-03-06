package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tuser;
import model.TuserDB;

/**
 * Servlet implementation class LoginIn
 */
@WebServlet("/LoginIn")
public class LoginIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginIn() {
        super();
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
        HttpSession session = request.getSession(true);
        String userid = (String) session.getAttribute("loginname");
        if (userid == null) {
        	 userid = request.getParameter("loginname"); 
        	 Tuser tuser =  model.TuserDB.selectUser(userid);
     		if (tuser != null) {        	 
     			session.setAttribute("loginname", userid);
 	        	getServletContext().getRequestDispatcher("/ListTs").forward(request, response);	
     		} else {
     			// You are not a memeber yet, please register first
    	        getServletContext().getRequestDispatcher("/signup.html").forward(request, response);					     			
     		}
        } else {
        	//you have logged in already
        }
	}
}
