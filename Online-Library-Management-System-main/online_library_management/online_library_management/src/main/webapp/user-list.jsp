<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>Registered Users</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Membership ID</th>
        <th>Country</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.memberId}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.membershipId}</td>
            <td>${user.country}</td>
            <td>
                <a href="user?action=edit&id=${user.memberId}">Edit</a>
                <a href="user?action=delete&id=${user.memberId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
