<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>
<link rel="stylesheet" href="${css}/global.css" />
<jsp:include page="../global/header.jsp"/>
<jsp:include page="../global/navi.jsp"/>
<div class="box">
     <h1>인원수 페이지</h1> <br />
      <span style="font-size: 50px;color: red">현재 인원은 ${count} 명 입니다</span>
      <a href="${context}/member.do"><img src="${img}/member.jpg" alt="member" style="width: 30px" /></a>
      <a href="${context}/global.do"><img src="${img}/home.jpg" alt="home" style="width: 30px" /></a>
      </div>
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>