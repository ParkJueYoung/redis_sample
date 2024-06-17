<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Redis Example</title>
</head>
<body>
    <h1>Redis Example</h1>

    <form action="/save" method="post">
        <h2>Save Data</h2>
        Key: <input type="text" name="key"><br>
        Value: <input type="text" name="value"><br>
        <input type="submit" value="Save">
    </form>

    <form action="/get" method="get">
        <h2>Get Data</h2>
        Key: <input type="text" name="key"><br>
        <input type="submit" value="Get">
    </form>

    <form action="/delete" method="post">
        <h2>Delete Data</h2>
        Key: <input type="text" name="key"><br>
        <input type="submit" value="Delete">
    </form>

    <h2>Results</h2>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
    <c:if test="${not empty key}">
        <p>Key: ${key}</p>
        <p>Value: ${value}</p>
    </c:if>

    <h2>All Keys</h2>
    <c:if test="${not empty keys}">
        <ul>
            <c:forEach var="k" items="${keys}">
                <li>${k}</li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
