package ServletClasses;

import java.io.IOException;
import DBConnection.connectionSQL;
import DonorGetSt.DonorGtSt;
import DonorOperations.DonorPrp;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		out.print("<Style>");
		out.print("body{\r\n" + "	background-image: url('img4.jpg');\r\n" + "	background-repeat: no-repeat;\r\n"
				+ "	background-size: cover;\r\n" + "	font-size: 14px;\r\n" + "	padding-top: 4px;\r\n" + "	\r\n"
				+ "}");
		out.print("</Style>");
		response.setContentType("text/html");
		out.print("<link rel='set' href='css/bootstrap.css'></link>");
		out.print("<link rel=\'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css\'></link>");
		// out.print//("<link
		// rel=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css\"><link>\r\n"
		// + "");
		String Name = request.getParameter("User_Name");
		String Fname = request.getParameter("User_Fname");
		String Sname = request.getParameter("User_Sname");
		String Caste = request.getParameter("User_Caste");
		String Email = request.getParameter("User_Email");
		String Password = request.getParameter("User_Password");
		String Ccity = request.getParameter("User_Ccity");
		String Ncity = request.getParameter("User_Ncity");
		String Number = request.getParameter("User_Number");
		String Dob = request.getParameter("User_dob");
		String Bgroup = request.getParameter("User_Bgroup");
		String Gnder = request.getParameter("gender");
		String Ltbd = request.getParameter("user_lbd");
		try {
			DonorGtSt dgt = new DonorGtSt();
			dgt.setName(Name);
			dgt.setFathersName(Fname);
			dgt.setSurname(Sname);
			dgt.setCaste(Caste);
			dgt.setEmail(Email);
			dgt.setPassword(Password);
			dgt.setCurrentcity(Ccity);
			dgt.setNativecity(Ncity);
			dgt.setMobile(Number);
			dgt.setDob(Dob);
			dgt.setBloodgrp(Bgroup);
			dgt.setGender(Gnder);
			dgt.setLtbd(Ltbd);

			DonorPrp dp = new DonorPrp();
			String rs = dp.AddNewDnr(dgt);

			out.print(
					"<div class='card' style='border:1px solid;text-align:center;background-color:green;color:white;margin:auto;width:300px;margin-top:100px;width:50%; height:120px;'>");
			if (rs.equals("success")) {
				out.print("<h2 class='bg-danger text-light text-center'>Registered Successfully</h2>");
				// response.sendRedirect("Home.html");

			} else {
				out.print("<h2>Not Registered</h2>");
				out.print("</div>");
			}
			out.print("<style> .btn{ width:20%; height: 30%; font-weight:bold;} .btn hover{background-color:gray;} </style>");
			out.print("<a href='LoginPage.html'><button class='btn btn-outline-success'>Login</Button></a>");
			out.print("&nbsp&nbsp&nbsp&nbsp");
			out.print(" <a href='LoginPage.html'><button class='btn btn-outline-success'>Home</Button></a>");

		} catch (Exception e) {
			out.print("<h1>" + e.getMessage() + "<h1>");
		}
	}
}
