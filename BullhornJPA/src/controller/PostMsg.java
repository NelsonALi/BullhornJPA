package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TuserDB;

/**
 * Servlet implementation class PostT
 */
@WebServlet("/PostMsg")
public class PostMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostMsg() {
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
		model.T tPost = new model.T();
		String theMsg = request.getParameter("tmsg");    
        HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("loginname");
        tuser = TuserDB.selectUser(userName);
        tPost.setId(tuser.getId());
        tPost.setMsg(theMsg); 
        tPost.setMsgdate(new java.sql.Timestamp(new Date().getTime()));
		model.TDB.insert(tPost);

//		getServletContext().getRequestDispatcher("/UserProfile.jsp").forward(request, response);		
		getServletContext().getRequestDispatcher("/ListTs").forward(request, response);	
	}

}
