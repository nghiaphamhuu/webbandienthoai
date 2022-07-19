package servletController;

import java.io.IOException;
import java.util.Iterator;
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
 * Servlet implementation class addCart
 */
@WebServlet("/addCart")
public class addCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		request.setCharacterEncoding("utf-8");
		DAO dao = new DAO();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		String address = (String) session.getAttribute("address");
		dao.addCartToOrder(user, address);
		String order_id = dao.getLastOrderID();
		List<Product> list = (List<Product>) session.getAttribute("listPP");
		String quantity[] = request.getParameterValues("quantity");
		double total =0;
		for (int i = 0; i < quantity.length; i++) {
			dao.addCartToOrderDetail(order_id,list.get(i).getId(), quantity[i],list.get(i).getPrice());
			total+= Double.parseDouble(quantity[i])*Double.parseDouble(list.get(i).getPrice());
		}
		session.setAttribute("mess", "Order Suscesss!!. Your order is $" +total);
		session.removeAttribute("listPP");
		
		request.getRequestDispatcher("home").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
