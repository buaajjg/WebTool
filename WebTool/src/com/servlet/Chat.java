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
		String userName= request.getParameter("name");
		String action= request.getParameter("action");
		String message= request.getParameter("input");
		
		if(action.equals("post")){
			
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
			
			HttpSession hs= request.getSession();
			hs.setAttribute("itemList", list);
			
			request.getRequestDispatcher("/success.jsp?action=post&name="+userName).forward(request, response);
		}
		
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
