package controller;

import java.io.IOException;
//import java.io.PrintWriter;
//mport java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		model.Tuser tuser = new model.Tuser();
		String userid = request.getParameter("loginname");    
		String motto = request.getParameter("motto");    
		tuser.setLoginname(userid);
		tuser.setMotto(motto);
		tuser.setJoindate(new Date());
		model.TuserDB.insert(tuser);
        HttpSession session = request.getSession(true);
        session.setAttribute("loginname", userid);
//		getServletContext().getRequestDispatcher("/UserProfile.jsp").forward(request, response);		
		getServletContext().getRequestDispatcher("/ListTs").forward(request, response);		
	}

}
