<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Banking App - Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 100px;
        }

        h1 {
            margin-bottom: 30px;
        }

        .btn {
            padding: 12px 25px;
            font-size: 18px;
            margin: 10px;
            cursor: pointer;
            color: white;
            border: none;
            border-radius: 5px;
        }

        .login { background-color: #007bff; }
        .register { background-color: #28a745; }

        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

    <h1>Welcome to Banking Application</h1>

    <a href="login"><button class="btn login">Login</button></a>
    <a href="register"><button class="btn register">Register</button></a>

</body>
</html>