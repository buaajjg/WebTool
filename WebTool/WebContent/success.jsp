<%@ page language="java" contentType="text/html; charset=gbk" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INFO6250</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.12/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.13.0/ui-bootstrap-tpls.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
    function autopost(){
    	
    	document.getElementById("myform").submit();
    	alert("submit");
    	
    }
     
    $(document).ready(function(){
    	  
       $('#myscroll').scrollTop($('#myscroll')[0].scrollHeight);
       
    });
    
    	//window.setInterval(autopost(),3000);
    
    //window.load= setTimeOut(autopost(),3000);
    //window.load=scrollTop();
    
    </script>

</head>
<body>
<div class="jumbotron">
  <h1 class="text-center">Welcome to Info6210 chat room!</h1>
  <p style="margin-left:18%">Hi,<%=request.getParameter("name") %> !!</p>
</div>
   

<div class="row">
    <div class="col-sm-2" ></div>
    <div class="col-sm-8" >
    	
	    <form id="myform" action=<%="/WebTool/Chat?action=post&name="+request.getParameter("name") %>  method="post">
		    <fieldset class="row">
		    	
		    	<div class="col-sm-1" style="font:Serif; font-size:20px"><%=request.getParameter("name") %>:</div> 
		    	<div class="col-sm-10">
		    		<input placeholder="Type your message and click send" class="form-control" type="text" name="input" autofocus="autofocus">
		    	</div>	
		    	<div class="col-sm-1">
		    		<input  class="btn btn-primary" type="submit" value="sent"/>
		    	</div>
			    
		 	</fieldset>
	 	</form>
	 
	 	 <div id="myscroll" style="border: 2px solid gray; border-radius:6px; padding:18px; margin-top:20px; width:100%; height:470px; overflow-x:auto; overflow-y:scroll;">
		        <c:if test="${ itemList!=null }" > 
					<c:forEach var="i" items="${ itemList }">
						<div class="row">
							  <div class="col-sm-1" style="background-color: #fffacd; margin:3px 0; border-radius:6px"> <c:out value="${i.userName}" />  </div>
							  <div class="col-sm-2" style="font-size:10px; background-color: #add8e6; margin:3px 0; border-radius:6px"><c:out value="${i.time }" />      </div>
							  <div class="col-sm-9" > <c:out value="${i.message }" /> </div>
							
						</div>		
					</c:forEach>
										
				</c:if> 
	      </div>
	   </div>
    <div class="col-sm-2" ></div>
  </div>
  
  
	     


</body>
</html>