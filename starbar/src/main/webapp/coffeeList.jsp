<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>size</th>
			<th>price</th>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.list || fn:length(list) == 0}">
				<tr>
					<td>등록된 커피 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.list}" var="coffee">
					<tr>
						<td>${coffee.id}</td>
						<td>${coffee.name}</td>
						<td>${coffee.size}</td>
						<td>${coffee.price}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
	</table>
	<a href="index.jsp"><button type="button">뒤로가기</button></a>
</body>
</html>