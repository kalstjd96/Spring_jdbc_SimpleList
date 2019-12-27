<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Card View</title>

<script type="text/javascript">
	function fnCmdSave(){
		document.cardView.action = '${commandUrl}';
		if (cardView.bname.value.length < 1){
			alert("이름을 입력하세요.");
			cardView.bname.focus();
			return false;
		}
		if (cardView.phone.value.length <1){
			alert("전화번호를 입력하세요.");
			cardView.bname.focus();
			return false;
		}
		if (cardView.description.value.length <1){
			alert("내용을를 입력하세요.");
			cardView.bname.focus();
			return false;
		}
		
		if(document.cardView.bno.value==""){
			document.cardView.bno.value=0;
		}
		
		document.cardView.submit();
	}
</script>

</head>
<body>
<a href="#" onclick="fnCmdSave()"> [Submit]</a>

<form:form modelAttribute="card" name="cardView" method="post">
	<input type="hidden" id ="bno" name="bno" value="${card.bno }"/>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<td><form:input path="bname" size="50" value="${card.bname }"/>
			<span class="fieldError"><form:errors path="bname"/></span>
			</td>
		</tr>
		<tr>
			<th>전화</th>
			<td><form:input path="phone" size="50" value="${card.phone }"/>
			<span class="fieldError"><form:errors path="phone"/></span>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><form:input path="description" size="50" value="${card.description }"/>
			<span class="fieldError"><form:errors path="description"/></span>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>