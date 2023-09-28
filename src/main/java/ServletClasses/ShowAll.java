package ServletClasses;

import DBConnection.connectionSQL;
import DonorGetSt.DonorGtSt;
import DonorOperations.DonorPrp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowAll
 */
@WebServlet("/ShowAll")
public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAll() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		out.print(
				"<style>.bttn hover{ width:100%;color:red;} .tbl{text-align:center;color:green;font-weight:bold;</style>");
		try {

			DonorPrp dnpr = new DonorPrp();
			ResultSet rs = dnpr.ShowAllDonors();
			out.print("<nav class=\"navbar navbar-light\" style=\"background-color: #e3f2fd;\">\r\n"
					+ "		<!-- Navbar content -->\r\n" + "	</nav>\r\n"
					+ "	<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
					+ "		<a class=\"navbar-brand\" href=\"#\">Maheshwawri Samaj</a>\r\n"
					+ "		<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n"
					+ "			data-target=\"#navbarText\" aria-controls=\"navbarText\"\r\n"
					+ "			aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
					+ "			<span class=\"navbar-toggler-icon\"></span>\r\n" + "		</button>\r\n"
					+ "		<div class=\"collapse navbar-collapse\" id=\"navbarText\">\r\n"
					+ "			<ul class=\"navbar-nav mr-auto\">\r\n"
					+ "				<li class=\"nav-item active\"><a class=\"nav-link\"\r\n"
					+ "					href=\"WelcomePage.html\"> Home <span class=\"sr-only\">(current)</span></a>\r\n"
					+ "				</li>\r\n"
					+ "				<li><i class=\"fa fa-whatsapp\" aria-hidden=\"true\"></i>\r\n"
					+ "					<button class=\"btn\">\r\n" + "						<a\r\n"
					+ "							href=\"https://api.whatsapp.com/send?phone=9173419273&text=Hello Welcome to Maheshwari Digital Blood Bank\">Whatsaap</a>\r\n"
					+ "					</button></li>\r\n" + "\r\n" + "			</ul>\r\n"
					+ "			<span class=\"navbar-text\"> Welcome to Maheshwari Samaj </span>\r\n"
					+ "		</div>\r\n" + "	</nav>\r\n" + "");
			out.print("<style> .table{text-align:center;font-weight:bold;} </style>");
			out.print(
					"<table class='table table-hover table-striped' width='80%' border='1';margin-left:'20%'; text-align:'center';	class='tbl'; ><tr> ");
			out.print(
					"<th>Name</th><th>Father's Name</th><th>Surname</th><th>Current City</th><th>Blood Group</th><th>Mobile Number</th><th>Admin</th><th>Authority</th></tr>");
			while (rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString("Name") + "</td>");
				out.print("<td>" + rs.getString("FathersName") + "</td>");
				out.print("<td>" + rs.getString("Surname") + "</td>");
				out.print("<td>" + rs.getString("Currentcity") + "</td>");
				out.print("<td>" + rs.getString("Bloodgrp") + "</td>");
				out.print("<td>" + rs.getString("Mobile") + "</td>");
				HttpSession session = request.getSession();
				session.setAttribute("dnpr", "emp");
				out.print("<td><button><a href='DeleteDonor?Mobile=" + rs.getString("Mobile")
						+ "'>Edit</a></button></td>");
				out.print("<td><button><a href='DeleteDonor?Mobile=" + rs.getString("Mobile")
						+ "'>Delete</a></button></td>");
			}

			out.print("</table>");
		} catch (Exception ex) {

		}
	}
}
