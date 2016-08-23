<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/global.css" />
<div class="box">
   <h1> ID 검색 </h1>
   <form action="${context}/member.do" method="get">
   		<input type="text" name="keyword" placeholder="검색할 ID" />
   		<input type="hidden" name="action" value="find_by_id" />
   		<input type="hidden" name="page" value="find_by_id" />
   		<input type="submit" value="ID검색" />
   		<input type="reset" value="취소"/>
   </form>
   <h1> 이름 검색 </h1>
   <form action="${context}/member.do" method="get">
   		<input type="text" name="keyword" placeholder="검색할 이름" />
   		<input type="hidden" name="action" value="find_by_name" />
   		<input type="hidden" name="page" value="list" />
   		<input type="submit" value="이름검색" />
   		<input type="reset" value="취소"/>
   </form>
    <iframe src="image.jsp" class="ifrm"></iframe>
    <a href="${context}/member/do"><img src="${img}/member.jpg" alt="member" style="width: 30px" /></a>
    <a href="${context}/global.do"><img src="${img}/home.jpg" alt="home" style="width: 30px" /></a>
    </div>
