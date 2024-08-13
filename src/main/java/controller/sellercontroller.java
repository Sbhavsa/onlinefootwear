package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.sellerdao;
import model.seller;
import services.service;

/**
 * Servlet implementation class sellercontroller
 */
@WebServlet("/sellercontroller")
public class sellercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
        if (action.equalsIgnoreCase("register")) {
      	  seller s =new seller();
      	  s.setName(request.getParameter("name"));
      	  s.setContact(request.getParameter("contact"));
      	  s.setAddress(request.getParameter("address"));
      	  s.setEmail(request.getParameter("email"));
      	  s.setPassword(request.getParameter("password"));
      	  System.out.println(s);
      	  sellerdao.insertseller(s);
      	  request.getRequestDispatcher("seller-login.jsp").forward(request, response);
      	  
      	  
			
		}
        else if (action.equalsIgnoreCase("login")) {
        	 seller s =new seller();
        	 s.setEmail(request.getParameter("email"));
         	 s.setPassword(request.getParameter("password"));
         	 seller s1 = sellerdao.checklogin(s);
         	 if (s1==null) {
         		request.setAttribute("validate", "email or password is incorrect");
		 		request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("data", s1);
				request.getRequestDispatcher("seller-index.jsp").forward(request, response);
                      
			}
        	 
		}
        else if (action.equalsIgnoreCase("update")) {
        	seller s =new seller();
        	s.setId(Integer.parseInt(request.getParameter("id")));
        	s.setName(request.getParameter("name"));
        	s.setContact(request.getParameter("contact"));
        	s.setAddress(request.getParameter("address"));
        	s.setEmail(request.getParameter("email"));
            sellerdao.updateprofile(s);
            HttpSession session = request.getSession();
            session.setAttribute("data", s);
              request.getRequestDispatcher("seller-index.jsp").forward(request, response);	
		}
        else if(action.equalsIgnoreCase("changepassword")) {
        	seller s = new seller();
        	int id = Integer.parseInt(request.getParameter("id"));
        	String op = request.getParameter("op");
        	String np = request.getParameter("np");
        	String cnp = request.getParameter("cnp");
        	boolean flag = sellerdao.checkpassword(id, op);
        	System.out.println(flag);
        	
        	if(flag == true) {
        		if(np.equals(cnp)) {
        			sellerdao.changepassword(id, np);
                    response.sendRedirect("seller-index.jsp");
            		
            	}
        		else {
					request.setAttribute("msg1", "new password and confirm new password not matched");
					request.getRequestDispatcher("seller-changepassword.jsp").forward(request, response);
					
				}
            	
        	}
        	else {
        		request.setAttribute("msg", "old password incorrect");
        		request.getRequestDispatcher("seller-changepassword.jsp").forward(request, response);
        	}
        }
        else if (action.equalsIgnoreCase("get otp")) {
			String email = request.getParameter("email");
			boolean flag = sellerdao.checkemail(email);
			System.out.println(flag);
			if(flag == true) {
				service s = new service();
				Random r = new Random();
				int num = r.nextInt(9999);
				System.out.println(num);
				s.sendMail(email, num);
			    request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "email id not registered");
				request.getRequestDispatcher("seller-forgetpassword.jsp").forward(request, response);
			}
				
		}
        else if(action.equalsIgnoreCase("verify")) {
        	String email = request.getParameter("email");
        	int otp1 = Integer.parseInt(request.getParameter("otp1"));
        	int otp2 = Integer.parseInt(request.getParameter("otp2"));
        	System.out.println(email+otp1 +":"+otp2);
        	if (otp1==otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
			} else {
                request.setAttribute("email", email);
                request.setAttribute("otp", otp1);
                request.setAttribute("msg", "otp not mtched");
                request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response) ;
			}

        }
        else if (action.equalsIgnoreCase("new password")) {
        	String email = request.getParameter("email");
        	String np = request.getParameter("np");
        	String cnp = request.getParameter("cnp");
        	   if (np.equals(cnp)) {
				sellerdao.forgotpassword(email, np);
				response.sendRedirect("seller-login.jsp");
			}
        	   else {
        		   request.setAttribute("msg", "np and cnp not matched");
        		   request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
        	   }
			
		}
	}
	}