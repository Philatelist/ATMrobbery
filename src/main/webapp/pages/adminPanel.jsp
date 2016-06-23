
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>
<h1>${message}</h1>

<form>
    <br> <input type="submit" value="GET USERS"/>
    <br> <input type="submit" value="CHECK AVAILABILITY BANKNOTES in ATM"/>
    <br> <input type="submit" value="FILL ATM"/>
    <br> Fill USER:<input type="text" name="name" value="${x}"/> BALLANCE.<input type="submit" value="FILL BALLANCE"/>

    <input type="submit" value="EXIT"/>

</form>

</body>
</html>
