<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>会員加入</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#userPass").val()==""){
					alert("パスワードを入力してください。");
					$("#userPass").focus();
					return false;
				}
				if($("#userName").val()==""){
					alert("名前を入力してください。");
					$("#userName").focus();
					return false;
				}
				$.ajax({
					url : "/member/passChk",
					type : "POST",
					dateType : "json",
					data : $("#updateForm").serializeArray(),
					success: function(data){
						
						if(data==true){
							if(confirm("会員修正しますか？")){
								$("#updateForm").submit();
							}
							
						}else{
							alert("パスワードが正しくありません。");
							return;
							
						}
					}
				})
			});
		})
	</script>
	<body>
		<section id="container">
			<form id="updateForm" action="/member/memberUpdate" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="userId">ID</label>
					<input class="form-control" type="text" id="userId" name="userId" value="${member.userId}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userPass">パスワード</label>
					<input class="form-control" type="password" id="userPass" name="userPass" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">名前</label>
					<input class="form-control" type="text" id="userName" name="userName" value="${member.userName}"/>
				</div>
			</form>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="button" id="submit">会員情報修正</button>
					<button class="cencle btn btn-danger" type="button">キャンセル</button>
				</div>
		</section>
		
	</body>
	
</html>