package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webtool.bean.User;
import com.webtool.dao.UserDaoImpl;

/**
 * Servlet implementation class Log
 */
@WebServlet("/Log")
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		System.out.println(action);
		
		if(action.equals("login")){
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			String record=request.getParameter("record");
						
			if(username==null||password==null||username==""||password==""){
				request.getRequestDispatcher("/error.jsp").forward(request, response);
				return;
			}
		
				
			UserDaoImpl userDaoImpl= new UserDaoImpl();
			User u= new User(username, password);
			boolean flag=userDaoImpl.logIn(u);
			if(flag){

				 if(record=="yes")  
				  {  
				      Cookie nameCookie = new Cookie("username", username);  
				      Cookie passCookie = new Cookie("password", password);  
				     
				      nameCookie.setMaxAge(30*60*24);
				      passCookie.setMaxAge(30*60*24);  
				     
				      response.addCookie(nameCookie);  
				      response.addCookie(passCookie);  
			   } 
				//request.getRequestDispatcher("/test.html?name="+name).include(request, response);
				response.sendRedirect("/WebTool/success.jsp?name="+username); 
			}
			else{
				request.getRequestDispatcher("/failure.jsp").forward(request, response);
			}
			
		}
		
		if(action.equals("signup")){
			String name=request.getParameter("name");
			String password1=request.getParameter("password1");
			String password2=request.getParameter("password2");
			if(!password1.equals(password2)){
				request.getRequestDispatcher("/error.jsp").forward(request, response);
				return;
			}
			else{
				UserDaoImpl userDaoImpl= new UserDaoImpl();
				User u= new User(name, password1);
				boolean flag=userDaoImpl.signUp(u);
				if(flag){
					request.getRequestDispatcher("/signupSuccess.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("/signupFail.jsp").forward(request, response);
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
