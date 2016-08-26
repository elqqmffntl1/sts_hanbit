<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
		<h1>회원목록</h1> <br> 
		<table id="member_list">
			<tr>
				<th>ID</th>
				<th>이 름</th>
				<th>등록일</th>
				<th>생년월일</th>
				<th>이메일</th>
				<th>전화번호</th>
			</tr>
			<c:forEach var="member" items="${list}">
			<tr>
				<td>${member.id}</td>
				<td><a href="${context}/member.do?action=find_by_id&page=find_by_id&keyword=${member.id}">${member.name}</a></td>
				<td>${member.regDate}</td>
				<td>${member.birth}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
			</tr>
			</c:forEach>
		</table>
		<p>
		<a href="${context}/member.do"><img src="${img}/member.jpg" alt="member" style="width: 30px" /></a>
		</p>
		<a href="${context}/global.do"><img src="${img}/home.jpg" alt="home" style="width: 30px" /></a>
</div>