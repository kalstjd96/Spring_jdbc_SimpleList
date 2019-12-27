<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

function fnCmdNew(){
	document.cardForm.bno.value = 0;
	document.cardForm.action = 'toForm.do';
	document.cardForm.submit();
}

function fnCmdEdit(sampleNo){
	document.cardForm.bno.value = sampleNo;
	document.cardForm.action = 'toForm.do';
	document.cardForm.submit();
}

function fnCmdDelete(sampleNo){
	document.cardForm.bno.value = sampleNo;
	document.cardForm.action = 'delete.do';
	document.cardForm.submit();
}

</script>
</head>
<body>
	메시지 : ${message}
	<br />
	<a href="#" onclick="fnCmdNew()"> [신규]</a>

	<form:form id="cardForm" name="cardForm" method="post">
		<input type="hidden" name="bno" />

		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>전화</th>
					<th>기록</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			<tbody>
				<c:forEach var="result" items="${list}" varStatus="status">
					<tr>
						<td>${result.bno }</td>
						<td>${result.bname }</td>
						<td>${result.phone }</td>
						<td>${result.description }</td>
						<td><a href="#" onclick="fnCmdEdit(${result.bno})">수정</a></td>
						<td><a href="#" onclick="fnCmdDelete(${result.bno})">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form:form>
</body>
</html>