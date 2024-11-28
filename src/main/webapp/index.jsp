<%--<%@ page language="java" contentType="text/html; charset=UTF-8" %>--%>
<%--&lt;%&ndash;<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>&ndash;%&gt;--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Player Management</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Player Management</h1>--%>
<%--<a href="addPlayer.jsp">Add New Player</a>--%>
<%--<table border="1">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>ID</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Full Name</th>--%>
<%--        <th>Age</th>--%>
<%--        <th>Index</th>--%>
<%--        <th>Actions</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="player" items="${playerList}">--%>
<%--        <tr>--%>
<%--            <td>${player.playerId}</td>--%>
<%--            <td>${player.name}</td>--%>
<%--            <td>${player.fullName}</td>--%>
<%--            <td>${player.age}</td>--%>
<%--            <td>${player.indexName}</td>--%>
<%--            <td>--%>
<%--                <a href="editPlayer.jsp?playerId=${player.playerId}">Edit</a>--%>
<%--                <a href="deletePlayer?playerId=${player.playerId}">Delete</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Player Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: orange;
            text-align: center;
        }
        form {
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            text-align: center;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        input, select, button {
            padding: 10px;
            margin: 5px 0;
        }
    </style>
</head>
<body>

</body>
</html>
