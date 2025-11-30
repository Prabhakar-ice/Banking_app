<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw Money</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 40px;
    }
    form {
        padding: 20px;
        border: 1px solid #ccc;
        width: 350px;
        background: #f9f9f9;
        border-radius: 8px;
    }
    label, select, input {
        display: block;
        margin-bottom: 12px;
    }
    button {
        padding: 10px 18px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
    }
    button:hover {
        background: #0056b3;
        cursor: pointer;
    }
</style>

</head>
<body>

<h2>Withdraw Amount</h2>

<form action="/withdraw" method="post">
    <!-- Enable PUT method -->
    <input type="hidden" name="_method" value="put" />

    <!-- Dropdown -->
    <label>Select Account:</label>
    <select name="account_selected" required>
        <option value="" disabled selected>-- Select Your Account --</option>

        <c:forEach var="acc" items="${accounts}">
            <option value="${acc.account_no}"> <!-- this refers to Account objects getAccount_no() method -->
                ${acc.acc_type} - ${acc.account_no} 
            </option>
        </c:forEach>

    </select>

    <label>Amount to Withdraw:</label>
    <input type="number" name="amount_to_withdraw" required />

    <button type="submit">Withdraw</button>
</form>

</body>
</html>
