<html>
<head>
    <title>Add Player</title>
</head>
<body>
<h1>Add Player</h1>
<form action="addPlayer" method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br>
    <label>Full Name:</label>
    <input type="text" name="fullName" required><br>
    <label>Age:</label>
    <input type="text" name="age" required><br>
    <label>Index:</label>
    <select name="indexId" required>
        <c:forEach var="index" items="${indexList}">
            <option value="${index.indexId}">${index.name}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Save</button>
</form>
</body>
</html>
