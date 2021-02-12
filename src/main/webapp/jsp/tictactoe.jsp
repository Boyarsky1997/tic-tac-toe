<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tic Tac Toe</title>
    <style>
        footer {
            position: absolute;
            bottom: 3%;
            width: 97%;
            height: 5.0rem;
        }
    </style>
</head>
<body>
<form method="post">
    <table border="1" align="center">
        <c:forEach var="i" begin="0" end="2">
            <tr>
                <c:forEach var="j" begin="0" end="2">
                    <td height="100" width="100">
                        <button
                                <c:if test="${game.getTable()[i][j] != 46 || isGameOver }">
                                    disabled
                                </c:if>
                                type="submit"
                                style="height: 100%;
                                        width: 100%;
                                        background: url('<%=request.getContextPath()%>/img/${game.getTable()[i][j]}.png');
                                        background-size: cover;"
                                name="submit"
                                value="${i},${j}"></button>
                    </td>
                </c:forEach>
            </tr>

        </c:forEach>

    </table>
    <h2 align="center">${message}</h2>
    <form>
        <h2 align="center">
            ${messages}
        </h2>
        <p align="center"><a style="height: 100px; width: 100px; text-decoration: none;" href="/game/">New Game</a></p>
    </form>
    <footer align="right">
        <p>Author: Roman Boyarsky</p>
        <p><a href="mailto:boyarsky1997@gmail.com">boyarsky1997@gmail.com</a></p>
    </footer>
</form>
</body>
</html>
