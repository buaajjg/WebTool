package com.listener;





import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.webtool.bean.RequestRecord;
import com.webtool.dao.RequestDaoImpl;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    
    public RequestListener() {
        // TODO Auto-generated constructor stub
    }


    public void requestDestroyed(ServletRequestEvent event)  { 
         // TODO Auto-generated method stub
    	HttpServletRequest request= (HttpServletRequest)event.getServletRequest();
    	RequestDaoImpl requestDaoImpl= new RequestDaoImpl();
    	int lastMinuteRequest= requestDaoImpl.getLastMinuteRequest();
    	int lastHourRequest= requestDaoImpl.getLastHourRequest();
    	int lastDayRequest= requestDaoImpl.getLastDayRequest();
    	int lastWeekRequest= requestDaoImpl.getLastWeekRequest();
    	int lastMonthRequest= requestDaoImpl.getLastMonthRequest();
    	int lastYearRequest= requestDaoImpl.getLastYearRequest();
    	
    	request.setAttribute("lastMinuteRequest", lastMinuteRequest);
    	request.setAttribute("lastHourRequest", lastHourRequest);
    	request.setAttribute("lastDayRequest", lastDayRequest);
    	request.setAttribute("lastWeekRequest", lastWeekRequest);
    	request.setAttribute("lastMonthRequest", lastMonthRequest);
    	request.setAttribute("lastYearRequest", lastYearRequest);
    	
    	System.out.println("minute:"+lastMinuteRequest);
        	
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent event)  { 
    	HttpServletRequest request= (HttpServletRequest)event.getServletRequest();
    	System.out.println("request attribute removed"+ request.getRequestURI());
         // TODO Auto-generated method stub
    }

	
    public void requestInitialized(ServletRequestEvent event)  { 
         // TODO Auto-generated method stub
    	HttpServletRequest request= (HttpServletRequest)event.getServletRequest();
    	System.out.println("request initialized "+ request.getRequestURI());
    	RequestDaoImpl requestDaoImpl= new RequestDaoImpl();
    	Date now= new Date();
    	Timestamp requestTime= new Timestamp(now.getTime());
    	RequestRecord record= new RequestRecord(requestTime, request.getRequestURI());
    	requestDaoImpl.writeRequestRecord(record);
    	
    	
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent event)  { 
         // TODO Auto-generated method stub
    	HttpServletRequest request= (HttpServletRequest)event.getServletRequest();
    	System.out.println("request attribute added"+ request.getRequestURI());
    }


    public void attributeReplaced(ServletRequestAttributeEvent event)  { 
    	HttpServletRequest request= (HttpServletRequest)event.getServletRequest();
    	System.out.println("request attribute replaceed"+ request.getRequestURI());
    }



	
}
