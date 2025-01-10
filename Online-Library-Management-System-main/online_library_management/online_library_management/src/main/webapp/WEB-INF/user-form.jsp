<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Form</title>
</head>
<script src="validation.js"></script>
<body>
<h2>User Registration Form</h2>
<form action="user?action=${action}" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${user.name}">
    <br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}">
    <br>
    <label for="membershipId">Membership ID:</label>
    <input type="text" id="membershipId" name="membershipId" value="${user.membershipId}">
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${user.passwordHash}">
    <br>
    <label for="country">Country:</label>
    <input type="text" id="country" name="country" value="${user.country}">
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
