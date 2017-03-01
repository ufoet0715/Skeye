$(document).ready(function() {
	$.datetimepicker.setLocale('ch');
	$('#productDate').datetimepicker({
        format: 'Y/m/d',
        timepicker: true     //关闭时间选项
    });
	$("#deviceForm").submit(function() {
		insertDevice();
	});
});

function insertDevice() {
	var deviceNo = $("#deviceNo").val();
	var deviceName = $("#deviceName").val();
	var productName = $("#productName").val();
	var model = $("#model").val();
	var productDate = new Date($("#productDate").val());
	
	$.ajax({
		url : $("#deviceForm").action,
		type : 'post',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			"deviceNo" : deviceNo,
			"deviceName" : deviceName,
			"productName" : productName,
			"model" : model,
			"productDate" : productDate
		},
		dataType : 'json',
		traditional : true,
		beforeSend : function() {
			spinner = commonLoad("deviceForm");
		},
		success : function(data) {
			if (data.isSuccess) {
				alert("添加成功！");
			} else {
				alert("添加失败！");
			}
		},
		error : function() {
		},
		complete : function() {
			spinner.spin();// 移除加载
		}
	});
}