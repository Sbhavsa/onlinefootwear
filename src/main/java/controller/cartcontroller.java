package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.cartdao;
import model.cart;

/**
 * Servlet implementation class cartcontroller
 */
@WebServlet("/cartcontroller")
public class cartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		if (action.equalsIgnoreCase("addtocart")) {
			 cart c =  new cart();
			 c.setCusid(Integer.parseInt(request.getParameter("cusid")));
			 c.setPid(Integer.parseInt(request.getParameter("pid")));
			 System.out.println(c);
             cartdao.insertintocart(c);
             response.sendRedirect("cart.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		cart c = new cart();
		
		int qyt = Integer.parseInt(request.getParameter("quantity"));
		c.setQuantity(qyt);
		System.out.println(qyt);
		 
		double price = Double.parseDouble(request.getParameter("price"));
		double total = price*qyt;
		c.setPrice(total);
		cartdao.insertintocart(c);
		
		System.out.println(total);
		response.sendRedirect("cart.jsp");
		
	}

}
