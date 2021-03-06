<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <sec:csrfMetaTags />
    <!--
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
    -->
    <title>Spring Security CSRF Sample</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="css/formstyle.css">
</head>
<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="/">Without token</a></li>
                <li role="presentation"><a href="/logout">Logout</a></li>
            </ul>
        </nav>
        <h2 >POST with CSRF-token</h2>
    </div>

    <c:url var="postUrl" value="/post"/>
    <c:url var="uploadUrl" value="/upload"/>
    <div class="row marketing">
	    <div class="col-lg-4">
            <h3>1. POST with CSRF-token</h3>
            <p>We add the token explicitly</p>
            <form action="/post" method="POST">
            	<input type="text" name="email" value="email"/>
            	<input type="text" name="address" value="adress"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
	    </div>
	</div>  
	<div class="row marketing">
        <div class=" col-lg-4">
            <h3>2. POST with token on URL</h3>
            <p>We put the CSRF token in the POST URL</p>
            <form action="/post?${_csrf.parameterName}=${_csrf.token}" method="POST">
                <input type="text" name="email" value="email"/>
            	<input type="text" name="address" value="adress"/>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
     </div>   
</div>
</body>
</html>