$(function(){
	$("#listTable").trColorChange();
	$("a.delete").confirmOperator();
	$("a.clearUsers").confirmOperator({msg:"清空用户操作不逆，确定操作吗？"});
});

function isExit(){
	 $.messager.confirm('操作确认', "确认要退出吗？", function(r){
		 if(r){
			 window.parent.exitSys(); 
		 }
	 });
}

