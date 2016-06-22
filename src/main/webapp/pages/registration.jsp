
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ATM registration page</title>
</head>
<body>
<h1>${message}</h1>

<form>
    <br> NAME:<input type="text" name="name" value="${x}"/>

    <br> E-MAIL:<input type="text" name="email" value="${x}"/>

    <br> PASSWORD:<input type="text" name="password" value="${y}"/>

    <br> CONFIRM PASSWORD:<input type="text" name="confirm" value="${y}"/>

    <br> = ${sum}
    <br/>
    <input type="submit" value="REGISTER"/>

</form>

</body>
</html>
