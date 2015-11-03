package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/ListTs")
public class ListTs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTs() {
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
		TDB tdb = new TDB();
		TuserDB tuserdb = new TuserDB();
        //get the user login name and verify if user registered (exist in TUSER table)
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	    String currentDate=sdf.format(date );
/*	    rating.setRateDate(currentDate);
	    dbService.addReview(rating);	
	    Reviewer theReviewer = dbService.getReviewerProfile(reviewername);
	    ArrayList<Rating> theReviews = dbService.getReviewsByReviewer(reviewerId);
        HttpSession session = request.getSession(true);
        session.setAttribute("reviewername", reviewername);
        session.setAttribute("revieweremail", theReviewer.getEmail());       
        session.setAttribute("zipcode", theReviewer.getZipcode());		
        String message = "";
		for (Rating aRating : theReviews) {
				message = message + "	<div class=\"row\"><br><div class=\"col-md-4\">"+dbService.getResturantName(aRating.getResturantId())+"</div>" +
																"<div class=\"col-md-4\">"+aRating.getRate()+"</div>" + 
																"<div class=\"col-md-4\">"+aRating.getRateDate()+"</div></div>";
*/		}
//		request.setAttribute("message", message);
 	    
//		getServletContext().getRequestDispatcher("/Actions.jsp").forward(request, response);		


}
