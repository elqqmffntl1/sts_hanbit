// var application = (function(){})();  IIFE 패턴
var app = (function(){
	var init = function(context) {
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
		move();
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content h2').text('서비스를 이용하시려면 회원가입을 하셔야 합니다');
		$('#global_content_a_regist')
		.text('SIGN UP')
		.click(function() {location.href=app.context()+'/member/regist';});
		$('#global_content_a_login')
		.text('LOG IN')
		.click(function() {location.href=app.context()+'/member/login';});
		$('#global_content_a_admin')
		.text('ADMIN MODE')
		.click(function() {admin.check();});
	};
	var context = function(){
		return sessionStorage.getItem('context');
	};
	var js = function(){
		return sessionStorage.getItem('js');
	};
	var css = function(){
		return sessionStorage.getItem('css');
	};
	var img = function(){
		return sessionStorage.getItem('img');
	};
	var to_douglas = function() {
		location.href=context()+"/douglas.do";
	};
	var move = function(){
		$('#title').click(function(){
			location.href=context()+"/";
		});
		$('#a_member').click(function(){
			location.href = context()+"/member/main";
		});
		$('#a_grade').click(function(){
			location.href = context()+"/grade/main";
		});
		$('#a_account').click(function(){
			location.href = context()+"/account/main";
		});
		$('#a_school').click(function(){
			location.href = context()+"/school_info";
		});
		
	}
	return {
		init : init,
		to_douglas : to_douglas,
		move : move,
		context : context,
		img : img,
		js : js,
		css : css
	}
})();
var admin = (function(){
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass=pass;};
	return {
		setPass : setPass,
		getPass : getPass,
		check : function() {
			setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {
				alert('관리자만 접근 가능합니다.');
			} else {
				var password = prompt('비밀번호를 입력하세요');
				if(password == getPass()){
					location.href = app.context()+'/global.do';
				}else{
					alert('비밀번호가 다릅니다');
				} 
			}
		}
	};
})();
