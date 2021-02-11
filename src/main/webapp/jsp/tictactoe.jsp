<%--
  Created by IntelliJ IDEA.
  User: Boyar_5zndhuq
  Date: 10.02.2021
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true"  %>
<html>
<head>
    <title>HTML код таблицы, примеры</title>
</head>
<body>

<form method="post">
    <table border="1">

        <tr>
            <td height="20" width="20">
                <button type="submit" name="submit" value="0,0">${foo.getTable()[0][0]}</button>
            </td>
            <td height="20" width="20">
                <button type="submit" name="submit" value="0,1">${foo.getTable()[0][1]}</button>
            </td>
            <td height="20" width="20">
                <button type="submit" name="submit" value="0,2">${foo.getTable()[0][2]}</button>
            </td>

        </tr>
        <tr>
            <td height="20" width="20">
                <button type="submit" name="submit" value="1,0">${foo.getTable()[1][0]}</button>
            </td>
            <td height="20" width="20">
                <button type="submit" name="submit" value="1,1">${foo.getTable()[1][1]}</button>
            </td>
            <td height="20" width="20">
                <button type="submit" name="submit" value="1,2">${foo.getTable()[1][2]}</button>
            </td>


        </tr>
        <tr>
            <td height="20" width="20">
                <button type="submit" name="submit" value="2,0">${foo.getTable()[2][0]}</button>
            </td>
            <td height="20" width="20">
                <button type="submit" name="submit" value="2,1">${foo.getTable()[2][1]}</button>
            </td>
            <td height="20" width="20">
                <button type="submit" name="submit" value="2,2">${foo.getTable()[2][2]}</button>
            </td>
        </tr>
    </table>
    <h2>${message}</h2>
</form>
</body>
</html>