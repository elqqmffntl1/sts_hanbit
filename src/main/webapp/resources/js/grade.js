var grade = (function() {
	return{
		init : function(){
		$('#g_count').click(function() {location.href=app.context()+"/grade/count"});
		$('#g_delete').click(function() {location.href=app.context()+"/grade/delete"});
		$('#g_list').click(function() {location.href=app.context()+"/grade/list"});
		$('#g_regist').click(function() {location.href=app.context()+"/grade/regist"});
		$('#g_search').click(function() {location.href=app.context()+"/grade/search"});
		$('#g_update').click(function() {location.href=app.context()+"/grade/update"});
		$('#grade_content_img_home').attr('src' ,app.img()+'/home.jpg').css('width','30px');
		$('#grade_content_a_home').attr('alt','home').click(function() {location.href=app.context()+"/"});
		$('#grade_content').css('font-size','20px').addClass('box');
		$('#grade_content > article').css('width','300px').addClass('center').addClass('text_left');
		$('#grade_content a').css('font-size','15px').addClass('cursor');
		$('#grade_content > h1').text('GRADE MGMT');
		$('#grade_content_ol > li > a').addClass('remove_underline');
		$('#grade_content_ol > li:first > a').text('REGIST');
		$('#grade_content_ol > li:nth(1) > a').text('UPDATE');
		$('#grade_content_ol > li:nth(2) > a').text('DELETE');
		$('#grade_content_ol > li:nth(3) > a').text('LIST');
		$('#grade_content_ol > li:nth(4) > a').text('COUNT');
		$('#grade_content_ol > li:nth(5) > a').text('SEARCH');
	}
};
})();