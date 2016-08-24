var grade2 = (function(){
	return {
		init : function(){
			$('#grade_content').addClass('box');
			$('#img_home').css('width','30px');
			$('#grade_content > article')
			   .css('width','300px')
			   .css('text-align','left')
			   .css('margin','0 auto');
			$('#title').css('font-size','40px');
			$('#r_regist').click(function() {
				location.href = "${context}/grade/regist.do";
			});
			$('#r_update').click(function() {
				location.href ="${context}/grade/update.do";
			});
			$('#r_delete').click(function() {
				location.href = "${context}/grade/delete.do";
			});
			$('#r_list').click(function() {
				location.href = "${context}/grade/list.do";
			});
			$('#r_count').click(function() {
				location.href = "${context}/grade/count.do";
			});
			$('#r_find').click(function() {
				location.href = "${context}/grade/search.do";
			});
		}
	};
})();