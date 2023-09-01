<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
	width: 400px;
	board-collapse: collapse; /*cell 사이의 간격을 없애는 코드*/
}

th, td {
	border: 1px solid gray;
	padding: 5px;
}
</style>
<body>
	<table>
		<tr>
			<th>부서번호</th>
			<td>${DeptVO.deptno}</td>
		</tr>
		<tr>
			<th>부서이름</th>
			<td>${DeptVO.dname}</td>
		</tr>
		<tr>
			<th>부서위치</th>
			<td>${DeptVO.loc}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="button" onclick="location='deptModifyWrite.do?deptno=${DeptVO.deptno}'">수정</button>
				<button type="button" onclick="location='deptDelete.do?deptno=${DeptVO.deptno}'">삭제</button>
			</th>
		</tr>
	</table>

</body>
</html>