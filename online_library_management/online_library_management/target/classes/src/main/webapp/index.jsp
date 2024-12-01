<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
    <!-- Include CSS -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- Include JavaScript -->
    <script src="static/js/validation.js" defer></script>
</head>
<body>
    <form id="loginForm" onsubmit="return validateLoginForm();">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email">
        <span id="emailError" class="error"></span>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <span id="passwordError" class="error"></span>

        <button type="submit">Login</button>
    </form>
</body>
</html>