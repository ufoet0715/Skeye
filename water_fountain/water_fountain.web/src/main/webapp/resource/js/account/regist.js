$("#registForm").submit(function()
   {
	   insertAccount();
   }
);

var isHave = 0;
var isPassword = false;
function checkAccountNo(url) {
	var accountNo = $("#accountNo").val();
	if (accountNo != null && accountNo != "") {
		$.ajax({
			url : url,
			type:'post',
			contentType:"application/x-www-form-urlencoded; charset=utf-8", 
			data : {
				"accountNo" : accountNo
			},
			dataType : 'json',
			traditional : true,
			beforeSend : function() {
				spinner = commonLoad("registForm");
			},
			success : function(data) {
				if (data.isSuccess) {
					$("#accountMessage").html("已有该账户！");
					isHave = 2;
				} else {
					$("#accountMessage").html("没有该账户！");
					isHave = 1;
				}
			},
			error : function() {
			},
			complete : function() {
				spinner.spin();// 移除加载
			}
		});
	}
}

function checkPasswordAgain() {
	var password = $("#password").val();
	var passwordAgain = $("#passwordAgain").val();
	if (password != passwordAgain) {
		$("#passwordMessage").html("确认密码有误！");
		isPassword = false;
	} else {
		$("#passwordMessage").html("");
		isPassword = true;
	}

}

function insertAccount() {
	var accountNo = $("#accountNo").val();
	var accountName = $("#accountName").val();
	var password = $("#password").val();
	var telephone = $("#telephone").val();

	if ((accountNo != null && accountNo != "")
			&& (accountName != null && accountName != "")
			&& (password != null && password != "")
			&& (telephone != null && telephone != "") && (isHave == 1)
			&& isPassword) {

		$.ajax({
			url : $("#registForm").action,
			data : {
				"accountNo" : accountNo,
				"accountName" : accountName,
				"password" : password,
				"telephone" : telephone
			},
			dataType : 'json',
			traditional : true,
			beforeSend : function() {
				spinner = commonLoad("registForm");
			},
			success : function(data) {
				if (data.isSuccess) {
					alert("注册成功！");
				} else {
					alert("注册失败！");
				}
			},
			error : function() {
			},
			complete : function() {
				spinner.spin();// 移除加载
			}
		});
	} else {
		alert("注册失败！");
	}
}

