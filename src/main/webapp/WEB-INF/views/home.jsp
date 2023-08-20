<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">

	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.bo_num}</td>
                <td>${board.bo_title}</td>
                <td>${board.bo_us_id}</td>
                <!-- 필요한 컬럼들 출력 -->
            </tr>
        </c:forEach>
</body>
</html>
