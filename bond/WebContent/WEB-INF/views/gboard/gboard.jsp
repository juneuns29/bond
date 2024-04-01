<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bond 방명록</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/resources/css/user.css">
<script type="text/javascript" src="/resources/js/jquery-3.7.1.min.js"></script>
<style type="text/css">
	p {
		margin: 0px!important;
	}
	hr {
		margin: 3px!important;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('#home').click(function(){
			$(location).attr('href', '/main.bnd');
		});
		
		$('#login').click(function(){
			$(location).attr('href', '/member/login.bnd');
		});
		
		$('#logout').click(function(){
			$(location).attr('href', '/member/logoutProc.bnd');
		});
		
		$('#join').click(function(){
			$(location).attr('href', '/member/join.bnd');
		});
		
		$('#wbtn').click(function(){
			alert('때가되면 합니다...!');
		});
	});
</script>
</head>
<body>
	<div class="w3-content mxw600">
		<h1 class="w3-col w3-blue w3-center w3-padding">Bond 방명록</h1>
		<div class="w3-col">
			<div class="w3-green w3-btn" id="home">home</div>
<c:if test="${empty SID}"><!-- 로그인 안한 경우 -->
			<div class="w3-pink w3-btn w3-right" id="join">회원가입</div>
			<div class="w3-blue w3-btn w3-right" id="login">로그인</div>
</c:if>

<c:if test="${not empty SID}"> <!-- 로그인 한 경우 -->
			<div class="w3-red w3-btn" id="logout">로그아웃</div>
	<c:if test="${empty CNT or CNT eq 0}">
			<div class="w3-orange w3-btn w3-right" id="wbtn">글작성</div>
	</c:if>
</c:if>

		</div>
		<div class="w3-col w3-margin-top">
<c:forEach var="DATA" items="${LIST}">
			<div class="w3-col w3-padding w3-card-4 w3-margin-bottom">
				<div class="w3-col" 
					style="width: 110px; height: 100px; padding-right: 10px; border-right: 1px solid lightgray;">
					<img src="/resources/image/avatar/${DATA.sname}" class="imgBox w3-left w3-border">
				</div>
				<div class="w3-rest" style="padding-left: 10px;">
					<div class="w3-col w3-border-bottom" style="padding-bottom: 3px;">
						<p class="w3-half w3-left-align pdl10"><strong>작성자 : ${DATA.id}</strong></p>
						<p class="w3-half w3-right-align">${DATA.sdate}</p>
					</div>
					<!-- <hr class="w3-col"> -->
					<div class="w3-col w3-padding">
						<pre><small>${DATA.body}</small></pre>
					</div>
				</div>
			</div>
</c:forEach>
		</div>
	</div>
	
	<div id="id01" class="w3-col w3-modal1">
		<div class="w3-modal-content mxw600">
			<header class="w3-container w3-blue"> 
				<span onclick="document.getElementById('id01').style.display='none'" 
				class="w3-btn w3-display-topright">&times;</span>
				<h2>Modal Header</h2>
			</header>
			<div class="w3-container">
				<p>Some text..</p>
				<p>Some text..</p>
			</div>
			<footer class="w3-container">
				<p>Modal Footer</p>
			</footer>
		</div>
	</div>
	
</body>
</html>