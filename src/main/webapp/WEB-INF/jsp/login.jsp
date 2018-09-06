<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
   	<link rel="stylesheet" href="css/formstyle.css">
  
</head>
<body onload="document.f.username.focus();">
<div class="container">
    
    <div class="header clearfix">
     <h2>CSRF Login</h2>
<%--         <c:if test="${param.logout != null}">  --%>
<!--         //!= null?? -->
<!--         <p class="alert">You have been logged out</p> -->
<%--         </c:if> --%>
        	 <c:if test="${param.error != null}">
             <p class="alert alert-error">The username and/or the password is not correct. Please, please try again!</p>
        </c:if>
	</div>
	<div class="content">
        <c:url var="postUrl" value="/login"/>
        <form name="form" action="${login}" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <fieldset>
	            <label for="username">Username</label>
	            <input type="text" name="username" value="" placeholder="Username" />
	            <br>
	            <label for="password">Password</label>
	            <input type="password" name="password" placeholder="Password" />
            </fieldset>
            <input type="submit" id="login" value="Login" class="btn btn-primary" />
        </form>
    </div>
</div>
</body>
</html>