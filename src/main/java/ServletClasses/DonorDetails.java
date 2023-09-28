package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;
import DBConnection.connectionSQL;
import DonorGetSt.DonorGtSt;
import DonorOperations.DonorPrp;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DonorDetails
 */
@WebServlet("/DonorDetails")
public class DonorDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
		out.print("<table width='100%' style='text-align:center'>");
		out.print("<tr><td>");
		out.print("<a href='ChangePassword.html'>Change Password</a>");
		out.print("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;");
		out.print("<a href='Login.html'>Logout</a>");
		out.print("</td></tr></table><hr />");
		
		HttpSession session = request.getSession();
		DonorGtSt emp = (DonorGtSt)session.getAttribute("emp"); 
		
		out.print("<table class='table table-hover table-striped' width='100%' border='1'><tr>");
		out.print("<th>Name</th><th>Father's Name</th><th>Job</th><th>Salary</th><th>Email</th></tr>");
		out.print("<tr>");
		out.print("<td>"+"kak"+"</td>");
		out.print("<td>" + emp.getCaste() +"kaks"+ "</td>");
		out.print("<td>" + emp.getFathersName() + "</td>");
		out.print("<td>" + emp.getSurname() + "</td>");
		out.print("<td>" + emp.getCaste() + "</td>");
		out.print("<td>" + emp.getBloodgrp() + "</td>");
		out.print("</tr></table>");
	}
		
		
	}


