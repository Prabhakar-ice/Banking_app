<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Withdraw Money</title>
</head>
<body>

    <h2>Withdraw Amount</h2>

    <form action="/withdraw" method="post">
    <input type="hidden" name="_method" value="put" />

    <!-- Dropdown of accounts -->
    <label>Select Account:</label>
    <select name="account_selected" required>
        <option value="" disabled selected>-- Select Your Account --</option>

        <c:forEach var="acc" items="${accounts}">
            <option value="${acc.id}">
                ${acc.accountType} - ${acc.accountNumber}
            </option>
        </c:forEach>

    </select>
    <br><br>

    <label>Amount to Withdraw:</label>
    <input type="number" name="amount_to_withdraw" required />
    <br><br>

    <button type="submit">Withdraw</button>
</form>

</body>
</html>