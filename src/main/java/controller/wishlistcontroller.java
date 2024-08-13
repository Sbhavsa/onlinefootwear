package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.wishlistdao;
import model.wishlist;

/**
 * Servlet implementation class wishlistcontroller
 */
@WebServlet("/wishlistcontroller")
public class wishlistcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wishlistcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("addtowishlist")) {
			wishlist w = new wishlist();
			w.setCusid(Integer.parseInt(request.getParameter("cusid")));
			w.setPid(Integer.parseInt(request.getParameter("pid")));
			System.out.println(w);
			wishlistdao.insertintowishlist(w);
			response.sendRedirect("wishlist.jsp");
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
