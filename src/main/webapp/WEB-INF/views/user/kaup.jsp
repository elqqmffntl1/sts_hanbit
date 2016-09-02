<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="container">
<section class ="formbox">
		<p>카우푸 지수 구하기</p>
		<p>이름</p><input type="text" name="name" id="name" />
		<p>키</p> <input type="text" name="height" id="height" />
		<p>몸무게</p><input type="text" name="weight" id="weight" />
		<input type="button" value="결과보기" id="bt_kaup_calc" />
</section>
<section id="databox">
	<p>결과 : </p> <span id="result"></span>
</section>
</div>
