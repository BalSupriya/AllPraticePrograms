<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<h1 style="color: green; text-align: center">User Registration</h1>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
 
    $(document).ready(function(){
     
        $("#email").blur(function(){
        var email=$("#email").val();
          $("#dubEmail").text('');
          
          $.ajax({
          	 type: 'GET',
          	 url: '/validateEmail?email='+email,
          	 success: function(data){
          	    if(data=='DUPLICATE'){
          	            $("#dubEmail").text('Duplicate Email,pls enter unique email').css('color','red');
          	            $("#email").focus();
          	    }
          	 }
          
          });
        });
    $("#country").change(function(){
        var countryId=$("#country").val();
         $("#state").find('option').remove();
          $("<option>").val('').text("-Select-").appendTo("#state");
          
          $.ajax({
          	 type: 'GET',
          	 url: '/getState?countryId='+countryId,
          	 success: function(data){
          	    $.each(data,function(key,value){
          	     $("<option>").val(key).text(value).appendTo("#state");
          	    
          	    });
          	 },
          
          });
        });
        
         $("#state").change(function(){
        var stateId=$("#state").val();
         $("#city").find('option').remove();
          $("<option>").val('').text("-Select-").appendTo("#city");
          
          $.ajax({
          	 type: 'GET',
          	 url: '/getCity?stateId='+stateId,
          	 success: function(data){
          	    $.each(data,function(key,value){
          	     $("<option>").val(key).text(value).appendTo("#city");
          	    
          	    });
          	 },
          });
        });
        
        	
     $( function() {
    $( "#dob" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
    
    });
    </script>
</head>
<body>

	<form:form action="regUser" method="POST" modelAttribute="user">
		<center>
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
					<td><span id="dubEmail"></span></td>
				</tr>
				<tr>
					<td>Phone no:</td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td>DOB:</td>
					<td><form:input path="dob" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:input path="gender" /></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><form:select path="country">
							<form:option value='none' label="-Select-"></form:option>
							<form:options items="${countries}"></form:options>
						</form:select></td>
				</tr>

				<tr>
					<td>State:</td>
					<td><form:select path="state">
							<form:option value='' label="-Select-"></form:option>

						</form:select></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:select path="city">
							<form:option value='' label="-Select-"></form:option>

						</form:select></td>
				</tr>


				<tr>
					<td><input type="reset" value="Reset" /> &nbsp; <input
						type="submit" value="Submit" /></td>
				</tr>
			</table>
		</center>
	</form:form>




</body>
</html>