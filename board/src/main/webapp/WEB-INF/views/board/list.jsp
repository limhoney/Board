<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示物リスト</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<table>
	<thead>
		<tr>
			<th>番号</th>
			<th>タイトル</th>
			<th>作成日</th>
			<th>作成者</th>
			<th>クリック数</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.bno}</td>
				<td>
					<a href="/board/view?bno=${list.bno}">${list.title}</a>
				</td>
				<td>
					<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" />				
				</td>
				<td>${list.writer}</td>
				<td>${list.viewCnt}</td>
			</tr>
		</c:forEach>
	
	</tbody>

</table>

</body>
</html>