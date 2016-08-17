var admin = (function(){
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass=pass;};
	return {
		setPass : setPass,
		getPass : getPass,
		init : function() {
			document.querySelector('#a_admin').addEventListener('click',this.check,false);
		},
		check : function() {
			setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {
				alert('관리자만 접근 가능합니다.');
			} else {
				var password = prompt('비밀번호를 입력하세요');
				if(password == getPass()){
					location.href = sessionStorage.getItem('context')+'/global.do';
				}else{
					alert('비밀번호가 다릅니다');
				} 
			}
		}
	};
})();
