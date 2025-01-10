<html>
<head>
    <title>Send Notification</title>
</head>
<body>
<h2>Send Notification</h2>
<form action="notifications" method="post">
    <label for="recipient">Recipient Email:</label>
    <input type="email" id="recipient" name="recipient" required>
    <br>
    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject" required>
    <br>
    <label for="message">Message:</label>
    <textarea id="message" name="message" rows="5" required></textarea>
    <br>
    <button type="submit">Send Notification</button>
</form>

<c:if test="${param.success != null}">
    <p style="color:green;">Notification sent successfully!</p>
</c:if>
</body>
</html>
