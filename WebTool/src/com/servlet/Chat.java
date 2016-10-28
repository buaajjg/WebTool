package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.webtool.bean.Message;
import com.webtool.bean.MsgItem;
import com.webtool.dao.MsgDaoImpl;
import com.webtool.dao.UserDaoImpl;

/**
 * Servlet implementation class Chat
 */
@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs= request.getSession(false);
		
		String userName= request.getParameter("name");
		//String action= request.getParameter("action");
		String message= request.getParameter("input");
	
			if(message.equals("invalidate")){
				hs=null;
			}
			if(hs==null){
				
				//JOptionPane.showMessageDialog(null, "session expired, Please relogin!");
				response.getWriter().print("<script language='javascript'>alert('Session expired, relogin');window.location.href='index.html';</script>");
				return;
			}
		
			
					
			MsgDaoImpl msgDaoImpl= new MsgDaoImpl();
			
			if(message!=""&&message!=null){
				
				Message msg= new Message();
				UserDaoImpl userDaoImpl= new UserDaoImpl();
				int userId=userDaoImpl.getUserId(userName);
				msg.setMsg(message);
				msg.setUserId(userId);
				msgDaoImpl.post(msg);
			}
			
			
			List<MsgItem> list= msgDaoImpl.getRecord();
			
			
			System.out.println(hs.getId());
			hs.setAttribute("itemList", list);
			
			request.getRequestDispatcher("/success.jsp?name="+userName).forward(request, response);
		}
		
				
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
