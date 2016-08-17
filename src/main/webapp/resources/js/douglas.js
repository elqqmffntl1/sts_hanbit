var util = (function() {
	var _page,_directory;
	var setPage = function(page){this._page=page;};
	var setDirectory = function(directory){this._directory=directory;};
	return {
		move : function(directory,page){
			setDirectory(directory);
			setPage(page);
			location.href = sessionStorage.getItem('context')+'/'+getDirectory()+'.do?page='+getPage();
		},
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	};
})();
var move = function(context,page){
	location.href=context+'/douglas.do?page='+page;
}
var douglas = (function(){
	var context = sessionStorage.getItem('context');
		return {
			init : function(){
				document.querySelector('#bt_bom').addEventListener('click',function(){move(context,'bom');},false);
				document.querySelector('#bt_dom').addEventListener('click',function(){move(context,'dom');},false);
				document.querySelector('#bt_kaup').addEventListener('click',function(){move(context,'kaup');},false);
				document.querySelector('#bt_account').addEventListener('click',function(){move(context,'account');},false);
			}
		};
})();
var account = (function(){
	var _account_no,_money;
	var setAccountNo = function(account_no) {this._account_no=account_no;};
	var getAccountNo = function(){return this._account_no;};
	var setMoney = function(money){this._money=money;};
	var getMoney = function(){return this._money;};
		return {
			setAccountNo : setAccountNo,
			getAccountNo : getAccountNo,
			setMoney : setMoney,
			getMoney : getMoney,
			init :function() {
				document.querySelector('#bt_spec_show').addEventListener('click',member.spec,false);
				document.querySelector('#bt_make_account').addEventListener('click',this.spec,false);
				document.querySelector('#bt_deposit').addEventListener('click',this.deposit,false);
				document.querySelector('#bt_withdraw').addEventListener('click',this.withdraw,false);
			},
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
	return {
		setSsn : setSsn,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		getName : getName,
		getAge : getAge,
		getSsn : getSsn,
		getGender : getGender,
		spec : function(){
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
			
		}
	}
})();
var kaup = (function() {
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
		init : function() {
			document.querySelector('#bt_kaup_calc').addEventListener('click',this.calc,false);
		}
	}
})();
