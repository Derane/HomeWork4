<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<div>
    <table>
        <thead>
        <td>Name</td>
        <td>Login</td>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.login}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>