var member = (function(){
	return {
		init : function() {
			$('#regist').click(function() {location.href=app.context()+"/member/regist"});
			$('#login').click(function() {location.href=app.context()+"/member/login"});
			$('#logout').click(function() {location.href=app.context()+"/member/logout"});
			$('#detail').click(function() {location.href=app.context()+"/member/detail"});
			$('#update').click(function() {location.href=app.context()+"/member/update"});
			$('#delete').click(function() {location.href=app.context()+"/member/delete"});
			$('#list').click(function() {location.href=app.context()+"/member/list"});
			$('#find_by').click(function() {location.href=app.context()+"/member/find_by"});
			$('#count').click(function() {location.href=app.context()+"/member/count"});
			$('#member_content_img_home').attr('src' ,app.img()+'/home.jpg').css('width','30px');
			$('#member_content_a_home').attr('alt','home').click(function() {location.href=app.context()+"/"});
			$('#member_content').css('font-size','20px').addClass('box');
			$('#member_content > article').css('width','300px').addClass('center').addClass('text_left');
			$('#member_content a').css('font-size','15px').addClass('cursor');
			$('#member_content > h1').text('MEMBER MGMT');
			$('#member_content_ol > li > a').addClass('remove_underline');
			$('#member_content_ol > li:first > a').text('SIGN UP');
			$('#member_content_ol > li:nth(1) > a').text('LOGIN');
			$('#member_content_ol > li:nth(2) > a').text('LOGOUT');
			$('#member_content_ol > li:nth(3) > a').text('DETAIL');
			$('#member_content_ol > li:nth(4) > a').text('UPDATE');
			$('#member_content_ol > li:nth(5) > a').text('DELETE');
			$('#member_content_ol > li:nth(6) > a').text('LIST');
			$('#member_content_ol > li:nth(7) > a').text('FIND_BY');
			$('#member_content_ol > li:nth(8) > a').text('COUNT');
		}
	};
})();