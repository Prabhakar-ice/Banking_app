<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="3;url=/dashboard" />
<title>Withdrawal Successful</title>

<style>
	 body {
        font-family: Arial, sans-serif;
        text-align: center;
        padding-top: 50px;
        background-color: #f2f2f2;
    }
    .box {
        display: inline-block;
        padding: 20px 30px;
        background: white;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    .success {
        color: green;
        font-size: 22px;
        font-weight: bold;
    }
    a {
        margin-top: 15px;
        display: inline-block;
        text-decoration: none;
        color: #007bff;
        font-size: 16px;
    }
</style>



</head>
<body>

	<div class="box">
	
		<p class="success"> Withdrawal Successful! </p>
		
		<p> Redirecting to Dashboard in 3 seconds...</p>
		
		<p> If not, <a href = "/dashboard"> Clich here</a>.</p>
	</div>
</body>
</html>