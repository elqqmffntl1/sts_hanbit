<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="box">
		<h1>상세보기 페이지</h1>
			<table id="member_detail">
			<tr>
				<td rowspan="5" style="width: 30%">
				<img src="${img}/member/${user.img}" alt="mak.com" width="150" height="200">
				</td>
				<td style="width: 20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width: 40%">${user.id}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이 름</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">성 별</td>
				<td>${user.gender}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">전공과목</td>
				<td>${user.major}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">수강과목</td>
				<td colspan="2">${user.subjects}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2">${user.ssn.substring(0, 6)}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2">${user.reg}</td>
			</tr>
			
		</table>
		<p>
		<a href="${context}/member.do"><img src="${img}/member.jpg" alt="member" style="width: 30px" /></a>
		</p>
		<a href="${context}/global.do"><img src="${img}/home.jpg" alt="home" style="width: 30px" /></a>
	</div>
