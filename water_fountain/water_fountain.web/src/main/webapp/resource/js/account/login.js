$("#loginForm").submit(function()
   {
	  accountLogin();
   }
);

function accountLogin() {
	var accountNo = $("#accountNo").val();
	var password = $("#password").val();
	
	$.ajax({
		url : $("#loginForm").action,//'${rc.contextPath}/accountController/getAccount',
		type:'post',
		contentType:"application/x-www-form-urlencoded; charset=utf-8", 
		data : {
			"accountNo" : accountNo,
			"password" : password
		},
		dataType : 'json',
		traditional : true,
		beforeSend : function() {
			spinner = commonLoad("loginForm");
		},
		success : function(data) {
			if (data.isSuccess) {
				alert("登录成功!");
			} else {
				alert("登录失败!");
			}
		},
		error : function() {
		},
		complete : function() {
			spinner.spin();// 移除加载
		}
	});
}

