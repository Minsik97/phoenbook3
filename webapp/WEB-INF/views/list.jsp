<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 리스트</h1>

	<p>입력한 전화번호 내역</p>


	<c:forEach items="${requestScope.pList }" var="phoneVo">
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<td>${phoneVo.name }</td>
				
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td>${phoneVo.hp }</td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td>${phoneVo.company }</td>
			</tr>
			<tr>
				<td><a  href = "/phonebook3/phone/modifyForm?id=${phoneVo.phoneId}">[수정]</a></td>
				<td><a  href = "/phonebook3/phone/delete?id=${phoneVo.phoneId }">[삭제]</a></td>
			</tr>

		</table>

		<br>
	</c:forEach>

	<a href="/phonebook3/phone/writeForm">추가번호 등록하기</a>

</body>
</html>