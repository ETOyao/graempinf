(function($){
	var __validate = $.fn.validate;
	$.fn.graempinfValidate = function(opts) {
		var __rules = $.extend({
			userName:"required",
			userPassWord:"required",
     		name:"required",
     		groupName:"required",
			stuNum:"required",
			careerFairName:"required",
			sutName:"required",
			sutName:"required",
			examineeNum:"required",
			idCardNum:"required",
			email:"email",
			questionContent:"required",
			questionAnswer:"required",
			confirmPwd:{
				equalTo:"#userPassWord"
			},
			userEmail:"email"
		},opts?(opts.rules||{}):{});
		var __messages = $.extend({
    		userName:"用户名不能为空",
    		userPassWord:"用户密码不能为空",
			confirmPwd:"两次输入的密码不正确",
			userEmail:"邮件格式不正确",
			careerFairName:"招聘会名称不能为空！",
			name:"名称不能为空！",
			stuNum:"学号不能为空",
			sutName:"学生名称不能为空",
			examineeNum:"考试号不能为空",
			idCardNum:"身份证号不能为空",
			email:"邮箱格式不正确",
			questionContent:"反馈内容不能为空",
			questionAnswer:"答复内容不为空",
			groupName:"组名不能为空！"
		},opts?(opts.messages||{}):{});
		var __defaultOpts = $.extend(opts||{},{
			rules:__rules,
			messages:__messages,
			errorElement: opts?(opts.errorElement||"span"):"span",
			errorClass:opts?(opts.errorClass||"errorContainer"):"errorContainer"
		});
		$.extend($.fn.validate.prototype,__defaultOpts);
		__validate.call(this,__defaultOpts);
		return this;
	}
})(jQuery)