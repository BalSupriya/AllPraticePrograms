<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
 
    $(document).ready(function(){
        $("#cnfrmPwd").blur(function(){
        var email=$("#email").val();
        var newPwd=$("#newPwd").val();
        var cnfrmPwd=$("#cnfrmPwd").val();
        
          $.ajax({
          	 type: 'GET',
          	 url: '/getUnlock?email='+email,
          	 success: function(){
          		 alert(newPwd+"  "+cnfrmPwd);
          	    if(newPwd == cnfrmPwd){
          	    	alert("hello");
          	            $("#updatePwd").text('');    
          	    }
          	    else{
          	      $("#updatePwd").text('New Passsword and Confirm password should match').css('color','red');
          	    }
          	 }
          
          });
        });
    });

</script>

</head>
<body>

<form action="getUnlock?email=${email}" method="POST">

<table>
     <tr>
         <td>Email:</td>
         <td><input type="hidden" name="email" id="email">${email}</td>
     </tr>
     <tr>
         <td>Tempory password:</td>
         <td><input type="password" name="tempPwd" id="tempPwd"></td>
     </tr>
     <tr>
         <td> New Password:</td>
         <td><input type="password" name="newPwd" id="newPwd"></td>
     </tr>
     <tr>
         <td>Confirm password</td>
         <td><input type="password" name="cnfrmPwd" id="cnfrmPwd"></td>
         <td><label id="updatePwd"></label></td>
     </tr>
</table>
    
     <input type="submit" value="submit">

</form>

</body>
</html>