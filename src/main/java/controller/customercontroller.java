package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.customerdao;
import dao.sellerdao;
import model.customer;
import model.seller;

/**
 * Servlet implementation class customercontroller
 */
@WebServlet("/customercontroller")
public class customercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
	      	  customer c =new customer();
	      	  c.setName(request.getParameter("name"));
	      	  c.setContact(request.getParameter("contact"));
	      	  c.setAddress(request.getParameter("address"));
	      	  c.setEmail(request.getParameter("email"));
	      	  c.setPassword(request.getParameter("password"));
	      	  System.out.println(c);
	      	  customerdao.insertcustomer(c);
	      	  request.getRequestDispatcher("customer-login.jsp").forward(request, response);	
			}
		else if (action.equalsIgnoreCase("login")) {
       	 customer c =new customer();
       	 c.setEmail(request.getParameter("email"));
        	 c.setPassword(request.getParameter("password"));
        	 customer c1 = customerdao.checklogin(c);
        	 if (c1==null) {
        		request.setAttribute("validate", "email or password is incorrect");
		 		request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("data", c1);
				request.getRequestDispatcher("customer-index-withlogin.jsp").forward(request, response);
                     
			}
       	 
		}
	}
	

}
