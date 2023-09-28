package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBConnection.connectionSQL;
import DonorGetSt.DonorGtSt;
import DonorOperations.DonorPrp;

/**
 * Servlet implementation class DeleteDonor
 */
@WebServlet("/DeleteDonor")
public class DeleteDonor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteDonor() {
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
		String eno = request.getParameter("Mobile");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// out.print(eno);

		DonorPrp eo = new DonorPrp();

		String res = eo.DeleteDonor(eno);

		if (res.equals("Success"))
			response.sendRedirect("ShowAll");

	}

}
