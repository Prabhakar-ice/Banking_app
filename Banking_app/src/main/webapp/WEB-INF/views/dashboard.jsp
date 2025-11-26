<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
    <title>Dashboard</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        /* Top navigation bar */
        .navbar {
            background-color: #222;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h2 {
            margin: 0;
        }

        /* Buttons on the right */
        .nav-buttons a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            padding: 8px 14px;
            background-color: #444;
            border-radius: 4px;
        }

        .nav-buttons a:hover {
            background-color: #666;
        }

        /* Content section */
        .content {
            padding: 20px;
        }
    </style>

</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <h2>Dashboard</h2>

        <div class="nav-buttons">
            <a href="/about">About</a>
            <a href="/logout">Logout</a>
        </div>
    </div>

    <!-- Main Dashboard Content -->
    <div class="content">
        <h3>Welcome to your Dashboard!</h3>
        <p>This is a simple dashboard page after login.</p>
    </div>

</body>
</html>