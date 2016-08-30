// var application = (function(){})();  IIFE 패턴
var app = (function(){
	var init = function(context) {
		onCreate();
		session.init(context);
		member.init();
		user.init();
		account.init();
		kaup.init();
		grade.init();
		nav.init();
		admin.init();
	};
	var context = function(){return session.getAttribute();};
	var js = function(){return sessionStorage.getItem('js');};
	var css = function(){return sessionStorage.getItem('css');};
	var img = function(){return sessionStorage.getItem('img');};
	var setContentView = function(){
		$('#header_brand').attr('src' ,app.img()+'/highnoon.png').css('width','50px').css('height','50px');
		$('#footer').addClass('bottom').addClass('footer');
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content h2');
		$('#global_content_a_regist').text('SIGN UP').click(function(){controller.move('member','regist');});
		$('#global_content_a_login').text('LOG IN').click(function() {controller.move('member','login');});
		$('#global_content_a_admin').text('ADMIN MODE').click(function() {admin.check();});
	};
	var onCreate = function(){
		setContentView();
		$('#title').click(function(){controller.home();});
		$('#a_member').click(function(){controller.move('member','main');});
		$('#a_grade').click(function(){controller.move('grade','main');});
		$('#a_account').click(function(){controller.move('account','main');});
		$('#a_school').click(function(){controller.move('global','school_info');});
	};
	return {
		init : init,
		onCreate : onCreate,
		setContentView : setContentView,
		context : context,
		img : img,
		js : js,
		css : css
	}
})();
var user = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#account_content_img_home').attr('src' ,app.img()+'/home.jpg').css('width','30px');
		$('#account_content_a_home').attr('alt','home').click(function() {controller.home();});
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
	};
	var onCreate = function(){
		setContentView();
		$('#bt_bom').click(function(){controller.move('','bom');});
		$('#bt_dom').click(function(){controller.move('','dom');});
		$('#bt_kaup').click(function(){controller.move('','kaup');});
		$('#bt_account').click(function(){controller.move('','account');});
		$('#a_count').click(function() {controller.move('account','count');});
		$('#a_delete').click(function() {controller.move('account','delete');});
		$('#a_deposit').click(function() {controller.move('account','deposit');});
		$('#a_list').click(function() {controller.move('account','list');});
		$('#a_regist').click(function() {controller.move('account','regist');});
		$('#a_search').click(function() {controller.move('account','search');});
		$('#a_update').click(function() {controller.move('account','update');});
		$('#a_withdraw').click(function() {controller.move('account','withdraw');});
	};
	return {
		init : init
	};
})();
var account = (function(){
	var _account_no,_money;
	var setAccountNo = function(account_no) {this._account_no=account_no;};
	var getAccountNo = function(){return this._account_no;};
	var setMoney = function(money){this._money=money;};
	var getMoney = function(){return this._money;};
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
/*		$('#bt_spec_show').click(member.spec());
		$('#bt_make_account').click(this.spec());
		$('#bt_deposit').click(this.deposit());
		$('#bt_withdraw').click(this.withdraw()); */
	};
		return {
			setAccountNo : setAccountNo,
			getAccountNo : getAccountNo,
			setMoney : setMoney,
			getMoney : getMoney,
			init :init,
			spec : function() {
				setAccountNo(Math.floor(Math.random() * 899999) + 100000);
				setMoney(0);
				document.querySelector('#result_account').innerHTML=getAccountNo();
			},
			deposit : function(){
				var r_acc = document.querySelector('#result_account').innerText;
				console.log('계좌번호 : '+r_acc);
				switch (typeof r_acc) {
				case 'number' : console.log('this is number type'); break;
				case 'string' : console.log('this is string type'); break;
				case 'undefined' : console.log('this is undefined type'); break;
				default : console.log('type check fail !!');
				}
				if (getAccountNo() == null) {  //            null 체크 방식 1
					// r_acc === undefined                   null 체크 방식 2 
					alert('통장 개설을 먼저 하십시오');
				}else{
					var input_money = Number(document.querySelector('#money').value);
					var rest_money = getMoney();
					console.log('인풋 머니 타입 체크 : '+ (typeof input_money === 'number'));
					console.log('잔액 타입 체크 : '+ (typeof rest_money === 'number'));
					setMoney(input_money + rest_money);
					document.querySelector('#rest_money').innerHTML= getMoney();
				}
			},
			withdraw :function(){
				var input_money = Number(document.querySelector('#money').value);
				var rest_money = getMoney();
				setMoney(rest_money - input_money);
				document.querySelector('#rest_money').innerHTML= getMoney();
			}
		};
})();
var admin = (function(){
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass=pass;};
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#member2_img').attr('src' ,app.img()+'/member2.jpg');
		$('#grade_img').attr('src' ,app.img()+'/grade.jpg').css('height','180px');
		$('#account_img').attr('src' ,app.img()+'/account.jpg').css('height','180px');
		$('#admin_content h3').addClass('text_center');
	};
	var onCreate = function(){
		setContentView();
		$('#admin_nav #member_mgmt #list').click(function(){controller.move('member','list');});
		$('#admin_nav #member_mgmt #find').click(function(){controller.move('member','find');});
		$('#admin_nav #member_mgmt #count').click(function(){controller.move('member','count');});
		$('#admin_nav #account_mgmt #list').click(function(){controller.move('account','list');});
		$('#admin_nav #account_mgmt #open').click(function(){controller.move('account','open');});
		$('#admin_nav #account_mgmt #count').click(function(){controller.move('account','count');});
		$('#admin_nav #account_mgmt #delete').click(function(){controller.move('account','delete');});
		$('#admin_nav #account_mgmt #find').click(function(){controller.move('account','find');});
	};
	return {
		setPass : setPass,
		getPass : getPass,
		init : init,
		check : function() {
			setPass(1);
			var isAdmin = confirm('관리자입니까?');
			if (!isAdmin) {
				alert('관리자만 접근 가능합니다.');
			} else {
				var password = prompt('비밀번호를 입력하세요');
				if(password == getPass()){
					controller.move('admin','main');
				}else{
					alert('비밀번호가 다릅니다');
				} 
			}
		}
	};
})();
var member = (function() {
	var _age,_gender,_name,_ssn;
	var setAge = function(age){this._age=age;};
	var setGender = function(gender){this._gender=gender;};
	var setName = function(name){this._name=name;};
	var setSsn = function(ssn){this._ssn=ssn;};
	var getAge = function(ssn){return this._age;};
	var getGender = function(ssn){return this._gender;};
	var getName = function(ssn){return this._name;};
	var getSsn = function(ssn){return this._ssn;};
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#member_content_img_home').attr('src' ,app.img()+'/home.jpg').css('width','30px');
		$('#member_content_a_home').attr('alt','home').click(function() {controller.home();});
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
		$('#member_regist').addClass('box');
		$('#member_regist #bt_join').addClass('btn').addClass('btn-primary');
		$('#member_regist #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_regist_form > div > div').addClass('col-sm-10');
		$('#member_regist_form > div > div > input').addClass('form-control');
		$('#member_regist #rd_major > label:gt(2)').addClass('radio-inline');
		$('#member_regist #ck_subject').addClass('checkbox');
		$('#member_regist #ck_subject > label').addClass('checkbox-inline');
		$('#member_find_form').attr('action',sessionStorage.getItem('context')+'/member/search');
		$('#member_find_form input[type="submit"]').click(function(){
			$('#member_find_form').submit();
			});
	};
	var onCreate = function(){
		setContentView();
		$('#regist').click(function() {controller.move('member','regist');});
		$('#login').click(function() {controller.move('member','login');});
		$('#logout').click(function() {controller.move('member','logout');});
		$('#detail').click(function() {controller.move('member','detail');});
		$('#update').click(function() {controller.move('member','update');});
		$('#delete').click(function() {controller.move('member','delete');});
		$('#list').click(function() {controller.move('member','list');});
		$('#find_by').click(function() {controller.move('member','find_by');});
		$('#count').click(function() {controller.move('member','count');});
	};
	return {
		setSsn : setSsn,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		getName : getName,
		getAge : getAge,
		getSsn : getSsn,
		getGender : getGender,
		init : init,
		/*spec : function(){
			setSsn(document.querySelector('#ssn').value);
			setName(document.querySelector('#name').value);
			var now = new Date().getFullYear();
			var ssnArr = getSsn().split("-");
			var ageResult1 = ssnArr[0];
			var genderResult = Number(ssnArr[1]);
			var ageResult0 = 0;
			switch (genderResult) {
			case 1: case 5: 
				setGender("남"); 
				ageResult0 = now - 1900-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 3: case 7:
				setGender("남"); 
				ageResult0 = now - 2000-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 2: case 6:
				setGender("여");
				ageResult0 = now - 1900-(ageResult1/10000);
				setAge(ageResult0.toString().split(".")[0]);
				break;
			case 4: case 8:
				setGender("여");
				ageResult0 = now - 2000-(ageResult1/10000);
				setAge(geResult0.toString().split(".")[0]);
				break;

		}	
			document.querySelector('#result_name').innerHTML = getName();
			document.querySelector('#result_age').innerHTML = getAge();
			document.querySelector('#result_gender').innerHTML = getGender();
			
		}*/
	}
})();
var kaup = (function() {
	var init = function(){onCreate();};
	var setContentView = function(){};
	var onCreate = function(){
		setContentView();
		$('#bt_kaup_calc').click(this.calc);
	};
	var _name,_height,_weight,_result;
	var setName = function(name){this._name=name;};
	var setHeight = function(height){this._height=height;};
	var setWeight = function(weight){this._weight=weight;};
	var setResult = function(result){this._result=result;};
	var getName = function(){return this._name;};
	var getHeight = function(){return this._height;};
	var getWeight = function(){return this._weight;};
	var getResult = function(){return this._result;};
	return{
		setName : setName,
		setHeight : setHeight,
		setWeight : setWeight,
		setResult : setResult,
		getName : getName,
		getHeight : getHeight,
		getWeight : getWeight,
		getResult : getResult,
		calc : function(){
			setName(document.querySelector('#name').value);
			setHeight(document.querySelector('#height').value);
			setWeight(document.querySelector('#weight').value);
			var kaup = getWeight() / (getHeight()/100) / (getHeight()/100);
			if (kaup < 18.5) {
				setResult("저체중");
			} else if(kaup >= 18.5 && kaup <= 22.9){
				setResult("정상체중");
			} else if(kaup >= 23.0 && kaup <= 24.9){
				setResult("위험체중");
			} else if(kaup >= 25.0 && kaup <= 29.9){
				setResult("비만 1단계");
			} else if(kaup > 30 && kaup < 40){
				setResult("비만 2단계");
			} else if(kaup >= 40.0){
				setResult("비만 3단계");
			}
			document.querySelector('#result').innerHTML=getName() +'의 카우푸 결과 :'+ getResult();
		},
		init : init
	}
})();
var grade = (function() {
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#grade_content_img_home').attr('src' ,app.img()+'/home.jpg').css('width','30px');
		$('#grade_content_a_home').attr('alt','home').click(function() {controller.home();});
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
		/*$('#grade_content').addClass('box');
		$('#img_home').css('width','30px');
		$('#grade_content > article')
		   .css('width','300px')
		   .css('text-align','left')
		   .css('margin','0 auto');
		$('#title').css('font-size','40px');*/
	};
	var onCreate = function(){
		setContentView();
		$('#g_count').click(function() {controller.move('grade','count');});
		$('#g_delete').click(function() {controller.move('grade','delete');});
		$('#g_list').click(function() {controller.move('grade','list');});
		$('#g_regist').click(function() {controller.move('grade','regist');});
		$('#g_search').click(function() {controller.move('grade','search');});
		$('#g_update').click(function() {controller.move('grade','update');});
		$('#r_regist').click(function() {controller.move('','');});
		$('#r_update').click(function() {controller.move('','');});
		$('#r_delete').click(function() {controller.move('','');});
		$('#r_list').click(function() {controller.move('','');});
		$('#r_count').click(function() {controller.move('','');});
		$('#r_find').click(function() {controller.move('','');});
	};
	return{	init : init};
})();
var session = (function() {
	var init = function(context) {
		sessionStorage.setItem('context',context);
		sessionStorage.setItem('js',context+'/resources/js');
		sessionStorage.setItem('css',context+'/resources/css');
		sessionStorage.setItem('img',context+'/resources/img');
	};
	var getAttribute = function(){
		return sessionStorage.getItem('context');
	};
	var get
	return {
		init:init,
		getAttribute : getAttribute
	};
})();
var controller = (function() {
	var _page,_directory;
	var setPage = function(page){this._page=page;};
	var setDirectory = function(directory){this._directory=directory;};
	var getPage = function(){return this._page;};
	var getDirectory = function(){return this._directory};
	return {
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory,
		move : function(directory,page){
			setDirectory(directory);
			setPage(page);
			location.href = app.context()+'/'+getDirectory()+'/'+getPage();
		},
		home : function() {location.href = app.context()+'/';}
	};
})();
var util = (function() {
	return{
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	};
})();
var nav = (function() {
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#nav ul').addClass('list_style_none').addClass('over_hidden').addClass('bg_color_black').css('margin','0').css('padding','0');
		$('#nav li').addClass('float_left').addClass('display_inline').css('border-right','1px').css('solid','#bbb');
		$('#nav li:last-child').addClass('border_right');
		$('#nav li a ').addClass('display_block').addClass('color_white').addClass('text_align').addClass('text_decoration_none').css('padding','14px 16px');
		$('#nav li a:hover:not(.active)').addClass('bg_color_green');
		$('#nav .active').addClass('g_color_black');
	};
	var onCreate = function(){
		setContentView();
	};
	return{
		init:init
	};
})();
