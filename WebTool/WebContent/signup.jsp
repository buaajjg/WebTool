<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	function check(){
		var name= document.getElementById("name").value;
		var pass1=document.getElementById("pass1").value;
		var pass2=document.getElementById("pass2").value;
		
		if(name==null||name==""){
			document.getElementById("msg").innerHTML="Name cannot be void!";
			return false;
		}
		else if(pass1==null||pass1==""||pass2==null||pass2==""){
			
			document.getElementById("msg").innerHTML="Password cannot be void!";
			return false;
		}
		else if(pass1!=pass2){
			document.getElementById("msg").innerHTML="The Password should be same!";
			return false;
		}
		
		
		
	}
	

</script>
</head>
<body>


<div class="jumbotron">
  <h1 class="text-center">Welcome to Info6210 chat room!</h1>
  <p style="margin-left:18%">Sign up your account--</p>
</div>

<div class="row">
  		  <div class="col-sm-4"></div>
		  <div class="col-sm-4" style="padding:20px ;border: 2px solid gray; border-radius:10px">
				  <form name="form-signup" action="/WebTool/Log?action=signup" method="post" onsubmit="return check();"> 
		
						
							<table class="table">
								<tr>
									<td style="font-size:18px">Name:</td> <td><input type="text" id="name" name="name" class="form-control" /></td>
								</tr>
								
								<tr>
									<td style="font-size:18px">Password:</td> <td> <input type="password" id="pass1" name="password1" class="form-control" /></td>
								</tr>
								<tr>
									<td style="font-size:18px">ReEnterPassword:</td> <td> <input type="password" id="pass2"  name="password2" class="form-control"/></td>
								</tr>
								<tr>
									<td><input type="submit" class="btn btn-primary" value="Sign Up"/></td> 
								</tr>
								<tr>
									<td colspan="2" id="msg" style="color:red; font-size:18px"></td>
								</tr>
							</table>
				 </form>	
		  
			</div>
		  <div class="col-sm-4">
		  </div>
</div>

</body>
</html>