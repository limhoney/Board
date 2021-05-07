<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
	li {list-style: none; display:inline; padding: 6px;}
</style>
<ul>
	<li><a href="/board/list">リスト</a></li>
	<li><a href="/board/writeView">作成</a></li>
	<li>
		<c:if test="${member != null}"><a href="/member/logout">ログアウト</a></c:if>
		<c:if test="${member == null}"><a href="/">ログイン</a></c:if>
	</li>
	<li>
		<c:if test="${member != null}">
			<p>${member.userId}様</p>
		</c:if>
	</li>
</ul>
