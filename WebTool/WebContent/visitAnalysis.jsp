<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.webtool.dao.RecordDaoImpl,com.webtool.bean.RecordItem, java.util.List, com.webtool.dao.RequestDaoImpl"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visit Analysis</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.12/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.13.0/ui-bootstrap-tpls.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
    
    <%
    	if(session.getAttribute("username")==null){
    		out.println("alert('Session expired, relogin');window.location.href='index.html';");
    	}
    
    %>
    
    </script>
</head>
<body >
	<div class="jumbotron">
  <h1 class="text-center">Welcome to Info6210 chat room!</h1>
  <p style="margin-left:18%">Web Site Visiting Analysis  !!</p> 
  <button style="margin-left:18%; padding:5px; border: 1px solid gray; border-radius:5px" onclick="window.location.href='/WebTool/success.jsp' ">Back to Chat</button> 
  <button style="margin-left:5%; padding:5px; border: 1px solid gray; border-radius:5px" onclick="window.location.href='/WebTool/online.jsp' ">Check Online User</button>
  <button style="margin-left:5%; padding:5px; border: 1px solid gray; border-radius:5px" onclick="window.location.href='/WebTool/visitAnalysis.jsp' ">Refresh</button>
 
  
</div>
  
  <%  						
				    RequestDaoImpl requestDaoImpl= new RequestDaoImpl();
					
					out.println("<div class='row' style='margin:0' > ");
					out.print("<div class='col-sm-1' style='background-color: #ffcbbb; margin:3px 0'>");
					out.println("Last Minute Request"+"</div>");
					out.print("<div class='col-sm-1' style='margin:3px 0;padding-top:5px; font-size:20px'>");
					out.println( requestDaoImpl.getLastMinuteRequest()+"</div>");
					
					
					out.print("<div class='col-sm-1' style='background-color: #faabbb; margin:3px 0'>");
					out.println("Last Hour Request"+"</div>");
					out.print("<div class='col-sm-1' style='padding-top:5px; font-size:20px; margin:3px 0'>");
					out.println( requestDaoImpl.getLastHourRequest()+"</div>");
					
					out.print("<div class='col-sm-1' style='background-color: #aacbbb; margin:3px 0'>");
					out.println("Last Day Request"+"</div>");
					out.print("<div class='col-sm-1' style='padding-top:5px; font-size:20px; margin:3px 0'>");
					out.println( requestDaoImpl.getLastDayRequest()+"</div>");
					
					out.print("<div class='col-sm-1' style='background-color: #ffcb22; margin:3px 0'>");
					out.println("Last Week Request"+"</div>");
					out.print("<div class='col-sm-1' style='padding-top:5px; font-size:20px; margin:3px 0'>");
					out.println( requestDaoImpl.getLastWeekRequest()+"</div>");
					
					out.print("<div class='col-sm-1' style='background-color: #04cb3b; margin:3px 0'>");
					out.println("Last Month Request"+"</div>");
					out.print("<div class='col-sm-1' style='padding-top:5px; font-size:20px; margin:3px 0'>");
					out.println( requestDaoImpl.getLastMonthRequest()+"</div>");
					
					out.print("<div class='col-sm-1' style='background-color: #04cffb; margin:3px 0'>");
					out.println("Last Year Request"+"</div>");
					out.print("<div class='col-sm-1' style='padding-top:5px; font-size:20px; margin:3px 0'>");
					out.println( requestDaoImpl.getLastYearRequest()+"</div>");
					
										
					out.println("</div>");
				  
  
  
  
  						RecordDaoImpl recordDaoImpl= new RecordDaoImpl();
						
						out.println("<div class='row' style='margin:0 5%' > ");
						out.print("<div class='col-sm-2' style='background-color: #ffcbbb; margin:3px 0'>");
						out.println("Last One Hour Visit:"+"</div>");
						out.print("<div class='col-sm-1' style='background-color: #ffcbbb; margin:3px 0'>");
						out.println( recordDaoImpl.lastOneHourVisit()+"</div>");
						
						out.print("<div class='col-sm-2' style='background-color: #aacbbb; margin:3px 0'>");
						out.println("Last One Day Visit:"+"</div>");
						out.print("<div class='col-sm-1' style='background-color: #aacbbb; margin:3px 0'>");
						out.println( recordDaoImpl.lastOneDayVisit()+"</div>");
						
						out.print("<div class='col-sm-2' style='background-color: #ffcb22; margin:3px 0'>");
						out.println("Last OneWeek Visit:"+"</div>");
						out.print("<div class='col-sm-1' style='background-color: #ffcb22; margin:3px 0'>");
						out.println( recordDaoImpl.lastOneWeekVisit()+"</div>");
						
						out.print("<div class='col-sm-2' style='background-color: #04cb3b; margin:3px 0'>");
						out.println("Last one month visit:"+"</div>");
						out.print("<div class='col-sm-1' style='background-color: #04cb3b; margin:3px 0'>");
						out.println( recordDaoImpl.lastOneMonthVisit()+"</div>");
						
											
						out.println("</div>");
						
						
	%> 

<div class="row">
    <div class="col-sm-2" ></div>
    <div class="col-sm-8" >
    			<% 
    			out.println("<div class='row' style='margin-top:10px; width:104%;'> ");
		     		
					out.print("<div class='col-sm-1' style='background-color: #ffcbbb; margin:0'>");
					out.println("ID"+"</div>");
					
					out.print("<div class='col-sm-4' style='background-color: #ffcbbb; margin:0'>");
					out.println( "Session ID"+"</div>");
					
					out.print("<div class='col-sm-3' style='background-color: #aacbbb; margin:0'>");
					out.println("Start Time"+"</div>");
					
					out.print("<div class='col-sm-3' style='background-color: #aacbbb; margin:0'>");
					out.println( "End Time"+"</div>");
					
					out.print("<div class='col-sm-1' style='background-color: #ffcb22; margin:0'>");
					out.println("User"+"</div>");
					
																
					out.println("</div>");
	  		%>
	 	 <div id="myscroll" style="border: 2px solid gray; border-radius:6px; padding:5px;  width:104%; height:470px; overflow-x:auto; overflow-y:scroll;">
		        
		    <%	     	    
		       	List<RecordItem> list= recordDaoImpl.getRecord();
		     	for(int i=0;i<list.size();i++){
		     		out.println("<div class='row'> ");
		     		
					out.print("<div class='col-sm-1' style='background-color: #ffcbbb; margin:3px 0'>");
					out.println((i+1)+"</div>");
					
					out.print("<div class='col-sm-4' style='background-color: #ffcbbb; margin:3px 0'>");
					out.println( list.get(i).getSessionId()+"</div>");
					
					out.print("<div class='col-sm-3' style='background-color: #aacbbb; margin:3px 0'>");
					out.println(list.get(i).getStartTime()+"</div>");
					
					out.print("<div class='col-sm-3' style='background-color: #aacbbb; margin:3px 0'>");
					out.println( list.get(i).getEndTime()+"</div>");
					
					out.print("<div class='col-sm-1' style='background-color: #ffcb22; margin:3px 0'>");
					out.println(list.get(i).getUserName()+"</div>");
					
																
					out.println("</div>");
		     		
		     	}
			     
		     %>
					
				
	      </div>
	   </div>
    <div class="col-sm-2" ></div>
  </div>
  
</body>
</html>