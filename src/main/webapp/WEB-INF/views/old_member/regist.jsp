<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="member_regist">
	<form id="member_regist_form">
	<div>
  	  <label for="exampleInputEmail1">이름</label>
   	  <div><input type="text" id="username" placeholder="USER NAME"></div>
    </div>
    	<div>
  	  <label for="exampleInputEmail1">ID</label>
   	  <div><input type="text" id="id" placeholder="ID"></div>
    </div>
    	<div>
  	  <label for="exampleInputEmail1">비밀번호</label>
   	  <div><input type="password" id="password" placeholder="PASSWORD"></div>
    </div>
    	<div>
  	  <label for="exampleInputEmail1">SSN</label>
   	  <div><input type="text" id="ssn" placeholder="예)910201-1"></div>
   	  
    </div>
    	<div>
  	  <label for="exampleInputEmail1">EMAIL</label>
   	  <div><input type="email" id="eamil" placeholder="EMAIL"></div>
    </div>
    	<div>
  	  <label for="exampleInputEmail1">전화번호</label>
   	  <div><input type="text" id="phone" placeholder="PHONE"></div>
    </div>
    <div id="rd_major">
		<label for="exampleInputEmail1">전공</label><br>
		<label class="radio-inline"><input type="radio" name="major" id="inlineRadio1" value="computer" checked> 컴공학부</label>
		<label class="radio-inline"><input type="radio" name="major" id="inlineRadio2" value="mgmt"> 경영학부</label>
		<label class="radio-inline"> <input type="radio" name="major" id="inlineRadio3" value="math"> 수학부</label>
		<label class="radio-inline"><input type="radio" name="major" id="inlineRadio3" value="eng"> 영문학부</label>  
	</div>
	<div>
	<label for="exampleInputEmail1">수강과목</label><br>
    <div id="ck_subject">
      <div class="checkbox">
		<label class="checkbox-inline"> <input type="checkbox"  name="subject" value="java"> Java</label>
		<label class="checkbox-inline"> <input type="checkbox"  name="subject" value="sql"> SQL</label>
		<label class="checkbox-inline"> <input type="checkbox"  name="subject" value="cpp"> C++	</label>
		<label class="checkbox-inline"> <input type="checkbox"  name="subject" value="python"> 파이썬</label>
		<label class="checkbox-inline"> <input type="checkbox"  name="subject" value="delphi"> 델파이	</label>
		<label class="checkbox-inline"> <input type="checkbox"  name="subject" value="html"> HTML</label>
      </div>
    </div>
  </div>
		<input type="hidden" name="action" value="regist" />
		<input type="hidden" name="page" value="login" />
		<input id="bt_join" type="submit" value="회원가입" />
		<input id="bt_cancel" type="reset" value="취소" />
	</form>
</section>
