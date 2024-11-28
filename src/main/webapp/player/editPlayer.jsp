<html>
<head>
    <title>Edit Player</title>
</head>
<body>
<h1>Edit Player</h1>
<form action="editPlayer" method="post">
    <input type="hidden" name="playerId" value="${player.playerId}">
    <label>Name:</label>
    <input type="text" name="name" value="${player.name}" required><br>
    <label>Full Name:</label>
    <input type="text" name="fullName" value="${player.fullName}" required><br>
    <label>Age:</label>
    <input type="text" name="age" value="${player.age}" required><br>
    <label>Index:</label>
    <select name="indexId" required>
        <c:forEach var="indexer" items="${indexerList}">
            <option value="${indexer.indexId}" ${indexer.indexId == player.indexId ? 'selected' : ''}>${indexer.name}</option>
        </c:forEach>
    </select><br><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
