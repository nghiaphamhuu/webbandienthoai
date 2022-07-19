package servletController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Account;

/**
 * Servlet implementation class loginControler
 */
@WebServlet("/login")
public class loginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		request.setCharacterEncoding("utf-8");
		try {
			request.getSession(true).invalidate();
			String regexMail ="^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(5000);
			if(!password.matches(regex)||!user.matches(regexMail)) {
				session.setAttribute("error", "invalid syntax");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			DAO dao = new DAO();
			Account account = dao.listCheck(user, password);
			
			if(user != null && account!=null) {
				String address = account.getAddress();
				session.setAttribute("user", user);
				session.setAttribute("address", address);
				response.sendRedirect("home");
			} else {
				session.setAttribute("error", "wrong username or password");
				response.sendRedirect("login.jsp");
			}
		} catch ( NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}catch (Exception ex) {
			response.getWriter().println(ex);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
