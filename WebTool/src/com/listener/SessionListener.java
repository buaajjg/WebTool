package com.listener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import com.webtool.bean.VisitRecord;
import com.webtool.dao.RecordDaoImpl;
import com.webtool.dao.UserDaoImpl;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, HttpSessionIdListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent e)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionCreated:"+e.getSession());
      	
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent e)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionValueBound:"+e.getSession());
    }

	/**
     * @see HttpSessionIdListener#sessionIdChanged(HttpSessionEvent, String)
     */
    public void sessionIdChanged(HttpSessionEvent e, String oldId)  { 
         // TODO Auto-generated method stub
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent e)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionDestoyed:"+e.getSession());
    	
    
    	Date end=new Date();
    	HttpSession hs= e.getSession();
    	String username=(String) hs.getAttribute("username");
    	Date start=new Date(hs.getCreationTime());
    	Timestamp startTime= new Timestamp(hs.getCreationTime());
    	Timestamp endTime= new Timestamp(end.getTime());
    	System.out.println("session id---"+hs.getId()+"    session start--"+start+"    session end--"+end +"    username--"+username);
    	ServletContext application= hs.getServletContext();
    	String sessionId=hs.getId();
    	HashMap<String,String> online=(HashMap<String, String>)application.getAttribute("online");
    	if(online!=null){
    		online.remove(sessionId);
    	}
    	application.setAttribute("online", online);
    	
    	RecordDaoImpl recordDaoImpl= new RecordDaoImpl();
    	VisitRecord vr= new VisitRecord();
    	vr.setSessionId(sessionId);
    	vr.setStartTime(startTime);
    	vr.setEndTime(endTime);
    	UserDaoImpl userDaoImpl= new UserDaoImpl();
		int userId=userDaoImpl.getUserId(username);
		vr.setUserId(userId);
		recordDaoImpl.writeRecord(vr);
    	
    	
    }

	/**
     * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
     */
    public void sessionDidActivate(HttpSessionEvent e)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionDidActivate:"+e.getSession());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent e)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionAttributeAdded:"+e.getSession());
    	HttpSession hs=e.getSession();
    	String sessionId=hs.getId();
    	ServletContext application= hs.getServletContext();
    	if(e.getName().equals("username")){
    		String username= (String)hs.getAttribute("username");
    		
    		HashMap<String, String> online= (HashMap<String, String>) application.getAttribute("online");
    		if(online==null){
    			online= new HashMap<String, String>();
    		}
    		online.put(sessionId, username);
    		application.setAttribute("online", online);
    	}
   
		
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent e)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionAttributeRemoved:"+e.getSession());
    	if(e.getName().equals("username")){
    		System.out.println("-------remove username attribute--------");
    	}
    	
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent e)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionAttributeReplaced:"+e.getSession());
    
    	
    	
    }

	/**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
