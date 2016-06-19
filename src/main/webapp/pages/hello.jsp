
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ATM robbery</title>
</head>
<body>
<h1>${message}</h1>

<form>
    <br> LOGIN:<input type="text" name="login" value="${login}"/>

    <br> PASSWORD:<input type="text" name="password" value="${password}"/>

    <br>${result}
    <br/>
    <input type="submit" value="ENTER"/> OR
    <input type="submit" value="REGISTRATION"/>

</form>

</body>
</html>
