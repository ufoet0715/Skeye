$(document).ready(function() {
	$.datetimepicker.setLocale('ch');
	$('#time').datetimepicker({
		format : 'Y/m/d H:i:s'
	}),
	$("#stateForm").submit(function(){
		saveDeviceState();
    });
});

function saveDeviceState() {
	var deviceNo = $("#deviceNo").val();
	var deviceState = $("#deviceState").val();
	var waterTemperature = $("#waterTemperature").val();
	var time = new Date($("#time").val());
    
	$.ajax({
		url : $("#stateForm").action,
		type : 'post',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
    		"deviceNo" : deviceNo,
			"deviceState" : deviceState,
			"waterTemperature" : waterTemperature,
			"time" : time
        },
		dataType : 'json',
		traditional : true,
		beforeSend : function() {
			spinner = commonLoad("stateForm");
		},
		success : function(data){
			if(data.isSuccess)
			{
				alert("操作成功！");
			}
			else
			{
				alert("操作失败！");
			}
		},
		error : function() {
			alert("操作失败！");
		},
		complete : function() {
			spinner.spin();// 移除加载	
		}
	});	
}
