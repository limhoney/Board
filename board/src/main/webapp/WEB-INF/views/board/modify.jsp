<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示物修正</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">

<label>タイトル</label>
<input type="text" name="title" value="${view.title}"/><br />

<label>作成者</label>
<input type="text" name="writer" value="${view.writer}"/><br />

<label>内容</label>
<textarea cols="50" rows="5" name="content">${view.content}</textarea><br />

<button type="submit">完了</button>

</form>

</body>
</html>