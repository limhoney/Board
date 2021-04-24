<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示物照会</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

 
<h2>${view.title}</h2>

<hr />
<div class="writer">
	<span>作成者 : </span>${view.writer}
</div>

<hr />

<div class="content">
	${view.content}
</div>

<hr />
 
<div>
<a href="/board/modify?bno=${view.bno}">掲示物修正</a>, <a href="/board/delete?bno=${view.bno}">掲示物削除</a>
</div>


<hr />

<ul>
	
	<c:forEach items="${reply}" var="reply">
	<li>
		<div>
			<p>${reply.writer} / <fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd" /></p>
			<p>${reply.content }</p>
		</div>
	</li>	
	</c:forEach>
</ul>

<div>

	<form method="post" action="/reply/write">
	
		<p>
			<label>コメント作成者</label> <input type="text" name="writer">
		</p>
		<p>
			<textarea rows="5" cols="50" name="content"></textarea>
		</p>
		<p>
			<input type="hidden" name="bno" value="${view.bno}">
			<button type="submit">コメント作成</button>
		</p>
	</form>
	
</div>


</body>
</html>