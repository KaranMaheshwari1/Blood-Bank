package ServletClasses;

import java.io.IOException;
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

import DonorGetSt.DonorGtSt;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		String email = request.getParameter("username");
		String pwd = request.getParameter("pswrd");
			
		if(email.equals("Admin")  && pwd.equals("Admin"))
			response.sendRedirect("ShowAll");
		else
		{
			DonorPrp  eo = new DonorPrp();
			DonorGtSt emp = eo.LoginCheck(email, pwd);
			if(emp!=null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("dnpr", emp);
				response.sendRedirect("ShowDonor");
			}
			else
				response.sendRedirect("Error.html");
		}	
	}
		
	}


