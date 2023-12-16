<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style='color:green';align=center>Login Form</h2>

    <form action="login" method="post">
    
       <table>
          <tr>
            <td>Email:</td>
            <td><input type="text" name="email"></td>
          </tr>
          
           <tr>
            <td>Password:</td>
            <td><input type="password" name="pwd"></td>
          </tr>
          
          <tr>
          <td><input type="submit" value="Sign-In"></td>
          </tr>
          
       </table>
         <a href="/forgot" >Forgot Password</a>&nbsp;&nbsp;
    <a href="/user" >Sign Up</a>
    </form>

</body>
</html>