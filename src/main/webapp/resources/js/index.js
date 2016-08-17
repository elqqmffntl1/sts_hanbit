function go_home(context){
	location.href= context+"/home.do";
}
function start(context){
	document.getElementById('atag').onclick=go_home(context);
}
