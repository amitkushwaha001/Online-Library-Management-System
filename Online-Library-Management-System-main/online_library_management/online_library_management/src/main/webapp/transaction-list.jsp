<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Transactions</title>
</head>
<body>
<h2>Transactions</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Book ID</th>
        <th>Member ID</th>
        <th>Borrow Date</th>
        <th>Return Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="transaction" items="${transactions}">
        <tr>
            <td>${transaction.id}</td>
            <td>${transaction.bookID}</td>
            <td>${transaction.memberID}</td>
            <td>${transaction.borrowDate}</td>
            <td>${transaction.returnDate != null ? transaction.returnDate : "Not Returned"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
