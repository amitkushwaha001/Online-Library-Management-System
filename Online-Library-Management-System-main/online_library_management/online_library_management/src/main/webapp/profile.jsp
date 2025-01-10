<html>
<head>
    <title>Profile</title>
</head>
<body>
<h2>Update Profile</h2>
<form action="profile" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${user.name}">
    <br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}">
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <br>
    <label for="country">Country:</label>
    <input type="text" id="country" name="country" value="${user.country}">
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
