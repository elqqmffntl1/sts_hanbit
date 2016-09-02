<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box" style='padding-top:0; width:90%'>
<ul class="list-group">
  <li class="list-group-item">총계좌수 : 120명</li>
</ul>
<div class="panel panel-Success">
  <div class="panel-heading">계좌 리스트</div>
<table id="account_list_table">
  <tr>
	<th>계좌번호</th>
	<th>이 름</th>
	<th>생년월일</th>
    <th>잔 액</th>
  </tr>
  <tr>
    <td>123-456-789</td>
    <td><a class="name">리 퍼</a></td>
    <td>1991.02.01</td>
    <td>￦100</td>
  </tr>
  <tr>
    <td>123-456-789</td>
    <td><a class="name">솔 져</a></td>
    <td>1991.02.01</td>
    <td>￦1000</td>
  </tr>
  <tr>
    <td>123-456-789</td>
    <td><a class="name">맥크리</a></td>
    <td>1998.02.01</td>
    <td>￦10000</td>
  </tr>
</table>
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
</div>
