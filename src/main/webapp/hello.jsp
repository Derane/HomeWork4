<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<body>
Hello, ${name}<br>

<a href="${pageContext.request.contextPath}/users">Show other users</a>

<div>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <button type="submit">Logout</button>
    </form>
</div>

</body>
</html>