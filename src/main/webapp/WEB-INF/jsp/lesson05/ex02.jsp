<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리 (2)</title>
</head>
<body>
	<h1>1. 조건문(c:choose(제일바깥쪽 ul같은..?), c:when(if,else-if), c:otherwise(모두 아니라면))</h1>
	<c:set var="weight" value="85" />
	
	<c:choose>
		<c:when test="${weight < 60}">
			치맥먹자!<br>
		</c:when>
		<%-- (암묵적조건이 있음) 60이상 ~ 69이하 --%>
		<c:when test="${weight < 70}">
			샐러드먹자!<br>
		</c:when>
		<%-- 70키로 이상 --%>
		<c:otherwise>
			굶자<br>
		</c:otherwise>
	</c:choose>
	
	<h1>2. 반복문 (c:forEach)</h1>
	<c:forEach begin="0" end="5" step="1" var="i"> <%-- 0~5(포함)까지 6번 반복 --%>
		${i}<br>
	</c:forEach>
	
	<%-- 16~20: 5번 --%>
	<c:forEach begin="16" end="20" step="1" var="i" varStatus="status">
		var: ${i} current: ${status.current} <%-- 현재 뭐가들어있는지 보여줌 --%>
		first: ${status.first} <%-- 첫번째로 돌았는지 확인(true, false로 나옴) --%>
		last: ${status.last}
		index: ${status.index} <%-- 인덱스번호 --%>
		count: ${status.count} <%-- 반복문이 몇번째 도는건지 --%>
		<br>
	</c:forEach>
	
	${fruits}<br>
	<%-- 서버에서 가져온 List<String> 출력 , items와 var의 이름이 절대 같으면안됨!!--%>
	<c:forEach items="${fruits}" var="fruit" varStatus="status">
		${fruits} ::: index: ${status.index} ::: count: ${status.count}<br>
	</c:forEach>
	
	<%-- 서버에서 가져온 List<Map> 테이블 출력 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" value="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>