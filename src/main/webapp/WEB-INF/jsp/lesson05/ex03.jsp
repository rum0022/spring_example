<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt 라이브러리</title>
</head>
<body>
	<h1>1. 숫자출력</h1>
	<c:set var="number" value="12345678" />
	<fmt:formatNumber value="${number}" />
	
	<h3>Type</h3>
	<%-- number --%>
	숫자: <fmt:formatNumber value="${number}" type="number" /><br>
	숫자 3자리마다 콤마 제거: <fmt:formatNumber value="${number}" type="number" groupingUsed="false" /><br>
	
	<%-- percent --%>
	100%: <fmt:formatNumber type="percent" value="1"/><br>
	40%: <fmt:formatNumber type="percent" value="0.4"/><br>
	
	<%-- currency --%>
	통화(원): <fmt:formatNumber type="currency" value="${number}" /><br>
	통화(달러): <fmt:formatNumber type="currency" value="${number}" currencySymbol="$" /><br>
	
	<h3>pattern</h3>
	3.14: <fmt:formatNumber value="3.14" /><br>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000"/><br>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####"/><br>
	3.141592653(#.####): <fmt:formatNumber value="3.141592653" pattern="#.####"/><br>
	
	<hr>
	
	<h1>date 객체를 string형태로 출력(fmt:formatdate)</h1>
	Date객체를 그냥 뿌렸을때 : ${now}<br>
	<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /><br> <%-- simpledateformat과 서식같음 --%>
	<fmt:formatDate value="${now}" pattern="yyyy/MM/dd  HH:mm:ss" var="pattern2"/><br> <%-- 변수이름을 패턴2로 저장하겠다 --%>
	pattern2: ${pattern2}
	
	<h1>string을 date객체로 변환(fmt:parsedate)</h1>
	<fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd  HH:mm:ss"/>
</body>
</html>