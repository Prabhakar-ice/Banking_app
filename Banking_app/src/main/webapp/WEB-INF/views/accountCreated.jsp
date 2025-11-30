<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Account Created</title>

    <meta http-equiv="refresh" content="3;url=/dashboard" />

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background: white;
            padding: 25px 40px;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0 4px 10px rgba(0,0,0,0.15);
        }

        h2 {
            color: #2e7d32;
        }

        p {
            margin-top: 8px;
            font-size: 15px;
        }
    </style>
</head>
<body>

<div class="card">
    <h2>Account Created Successfully!</h2>
    <p>You will be redirected to Dashboard in 3 seconds...</p>
    <p>If not, <a href="/dashboard">click here</a>.</p>
</div>

</body>
</html>
