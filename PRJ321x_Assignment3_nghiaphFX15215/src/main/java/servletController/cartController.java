package servletController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Product;

/**
 * Servlet implementation class cartController
 */
@WebServlet("/cart")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		DAO dao = new DAO();
		Product a =  dao.getProductByid(id);
		HttpSession session = request.getSession();
		if (session.getAttribute("user")==null) {
			response.sendRedirect("login.jsp");
		}else {
			if (session.getAttribute("listPP")==null) {
				List<Product> listP2 = new ArrayList<Product>();
				listP2.add(a);
				session.setAttribute("listPP", listP2);
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			}else {
				List<Product> listP1 = (List<Product>) session.getAttribute("listPP");
				boolean productIsExist = true;
				int x= Integer.parseInt(id);
				for (Product a1 : listP1) {
					if(a1.getId()==x) {
						session.setAttribute("mess", "This product have already in your cart!");
						response.sendRedirect("home");
						productIsExist = false;
					}
				}
				if (productIsExist) {
					listP1.add(a);
					session.removeAttribute("mess");
					session.setAttribute("listPP", listP1);
					request.getRequestDispatcher("cart.jsp").forward(request, response);
				}
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
