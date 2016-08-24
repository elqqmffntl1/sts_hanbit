var account = (function() {
	return{
		init : function(){
		$('#a_count').click(function() {location.href=app.context()+"/account/count"});
		$('#a_delete').click(function() {location.href=app.context()+"/account/delete"});
		$('#a_deposit').click(function() {location.href=app.context()+"/account/deposit"});
		$('#a_list').click(function() {location.href=app.context()+"/account/list"});
		$('#a_regist').click(function() {location.href=app.context()+"/account/regist"});
		$('#a_search').click(function() {location.href=app.context()+"/account/search"});
		$('#a_update').click(function() {location.href=app.context()+"/account/update"});
		$('#a_withdraw').click(function() {location.href=app.context()+"/account/withdraw"});
		$('#account_content_img_home').attr('src' ,app.img()+'/home.jpg').css('width','30px');
		$('#account_content_a_home').attr('alt','home').click(function() {location.href=app.context()+"/"});
		$('#account_content').css('font-size','20px').addClass('box');
		$('#account_content > article').css('width','300px').addClass('center').addClass('text_left');
		$('#account_content a').css('font-size','15px').addClass('cursor');
		$('#account_content > h1').text('ACCOUNT MGMT');
		$('#account_content_ol > li > a').addClass('remove_underline');
		$('#account_content_ol > li:first > a').text('REGIST');
		$('#account_content_ol > li:nth(1) > a').text('DEPOSIT');
		$('#account_content_ol > li:nth(2) > a').text('WITHDRAW');
		$('#account_content_ol > li:nth(3) > a').text('UPDATE');
		$('#account_content_ol > li:nth(4) > a').text('DELETE');
		$('#account_content_ol > li:nth(5) > a').text('LIST');
		$('#account_content_ol > li:nth(6) > a').text('SEARCH');
		$('#account_content_ol > li:nth(7) > a').text('COUNT');
	} 	
};
})();