<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.HashMap"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online User</title>
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
<body>
<div class="jumbotron">
  <h1 class="text-center">Welcome to Info6210 chat room!</h1>
  <p style="margin-left:18%">Hi,Here is the online users !!</p> 
  <button style="margin-left:18%; padding:5px; border: 1px solid gray; border-radius:5px" onclick="window.location.href='/WebTool/success.jsp' ">Back to Chat</button> 
  <button style="margin-left:5%; padding:5px; border: 1px solid gray; border-radius:5px" onclick="window.location.href='/WebTool/online.jsp' ">Refresh</button>
  <button style="margin-left:5%; padding:5px; border: 1px solid gray; border-radius:5px" onclick="window.location.href='/WebTool/visitAnalysis.jsp' ">Visiting Analysis</button>

  
</div>
   

<div class="row">
    <div class="col-sm-2" ></div>
    <div class="col-sm-8" >
    	
	  
	 	 <div id="myscroll" style="border: 2px solid gray; border-radius:6px; padding:18px; margin-top:20px; width:100%; height:470px; overflow-x:auto; overflow-y:scroll;">
		        
		       
					<%  //HttpSession hs= request.getSession();
						//Object list= hs.getAttribute("itemList");
						
						Object obj=application.getAttribute("online");
						
						out.println("<div class='row'>");
						out.print("<div class='col-sm-6' style='background-color: #ffcbbb; margin:3px 0; border-radius:6px'>");
						out.println("SessionID"+"</div>");
						
						out.print("<div class='col-sm-6' style='font-size:10px; background-color: #add888; margin:3px 0; border-radius:6px'>");
						out.println("UserName"+"</div>");
				
						
						out.println("</div>");
						
						if(obj!=null){
						HashMap<String, String> online= (HashMap<String, String>)obj;
						
						
							if(online.size()>0){
								for(String sessionId:online.keySet()){
									out.println("<div class='row'>");
									out.print("<div class='col-sm-6' style='background-color: #fffacd; margin:3px 0; border-radius:6px'>");
									out.println(sessionId+"</div>");
									
									out.print("<div class='col-sm-6' style='font-size:10px; background-color: #add8e6; margin:3px 0; border-radius:6px'>");
									out.println(online.get(sessionId)+"</div>");
							
									
									out.println("</div>");
									
								}
							}
					
						}
					%>
				
	      </div>
	   </div>
    <div class="col-sm-2" ></div>
  </div>
  
  
</body>
</html>