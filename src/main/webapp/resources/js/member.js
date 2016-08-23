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
		}
	};
})();