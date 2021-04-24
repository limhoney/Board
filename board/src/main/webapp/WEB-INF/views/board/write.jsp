<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示物作成</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">

<label>タイトル</label>
<input type="text" name="title" /><br />

<label>作成者</label>
<input type="text" name="writer" /><br />

<label>内容</label>
<textarea cols="50" rows="5" name="content"></textarea><br />

<button type="submit">作成</button>

</form>

</body>
</html>