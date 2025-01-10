<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Member Form</title>
</head>
<body>
<h2>${member != null ? "Edit Member" : "Add New Member"}</h2>
<form action="members?action=${member != null ? 'update' : 'insert'}" method="post">
    <input type="hidden" name="id" value="${member.id}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${member.name}">
    <br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${member.email}">
    <br>
    <label for="membershipId">Membership ID:</label>
    <input type="text" id="membershipId" name="membershipId" value="${member.membershipId}">
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <br>
    <label for="country">Country:</label>
    <input type="text" id="country" name="country" value="${member.country}">
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
