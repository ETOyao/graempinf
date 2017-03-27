$(function(){
	$("#listTable").trColorChange();
	$("a.delete").confirmOperator();
	$("a.clearUsers").confirmOperator({msg:"清空用户操作不逆，确定操作吗？"});
});


