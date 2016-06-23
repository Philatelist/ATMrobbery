
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ATM</title>
</head>
<body>
<h1>${message}</h1>

<form>
    <br> How much money do You need? <input type="text" name="name" value="${x}"/> UAH

    <%--<br> E-MAIL:<input type="text" name="email" value="${x}"/>--%>

    <%--<br> PASSWORD:<input type="text" name="password" value="${y}"/>--%>

    <%--<br> CONFIRM PASSWORD:<input type="text" name="confirm" value="${y}"/>--%>


    <input type="submit" value="GET MONEY"/>

    <input type="submit" value="EXIT"/>

</form>

</body>
</html>
