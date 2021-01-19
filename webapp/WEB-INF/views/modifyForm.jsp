<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		                            <!-- pbc에서 받은 값 -->
		<form action= "/phonebook3/phone/modify" method="get">
			이름(name): <input type="text" name="name" value="${mVo.name }"> <br>
			핸드폰(hp): <input type="text" name="hp" value="${mVo.hp }"> <br>
			회사(company): <input type="text" name="company" value="${mVo.company }"> <br> 
			
			<!-- 아이디 -->
		    <input type="hidden" name="id" value ="${mVo.phoneId }"><br>
			
			<button type="submit">수정</button>
		</form>
		
		
</body>
</html>