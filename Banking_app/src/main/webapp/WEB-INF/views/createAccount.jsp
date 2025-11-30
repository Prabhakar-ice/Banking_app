<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Account</title>
</head>
<body>

    <h2>Create New Account</h2>
	
	<p style="color:red;">${error}</p>

    <form action="createBankAccount" method="post">

        <label>Account Type:</label>
        <select name="account_type" required>
            <option value="">-- Select --</option>
            <option value="SAVINGS">SAVINGS</option>
            <option value="CURRENT">CURRENT</option>
        </select>
        <br><br>
        
        <label>Branch Name:</label>
        <select name="branch_name" required>
            <option value="">-- Select --</option>
            <option value="T Nagar">T Nagar</option>
            <option value="Ashok Nagar">Ashok Nagar</option>
            <option value="Uthangarai">Uthangarai</option>
        </select>
        <br><br>

        <label>Initial Deposit:</label>
        <input type="number" name="initial_deposit" required />
        <br><br>

        <button type="submit">Create Account</button>

    </form>

</body>
</html>