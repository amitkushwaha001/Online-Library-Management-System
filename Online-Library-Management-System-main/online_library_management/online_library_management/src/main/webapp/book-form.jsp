<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
<h2>${book != null ? "Edit Book" : "Add New Book"}</h2>
<form action="books?action=${book != null ? 'update' : 'insert'}" method="post">
    <input type="hidden" name="id" value="${book.id}">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${book.title}">
    <br>
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" value="${book.author}">
    <br>
    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" value="${book.isbn}">
    <br>
    <label for="genre">Genre:</label>
    <input type="text" id="genre" name="genre" value="${book.genre}">
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
