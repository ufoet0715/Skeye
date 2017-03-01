$(document).ready(function() {
	$.datetimepicker.setLocale('ch');
	$('#productDate').datetimepicker({
        format: 'Y/m/d',
        timepicker: true     //关闭时间选项
    });
});

function countDevice(url) {
	var isNull=0;
	
	var accountNo = $("#accountNo").val();
	if(accountNo && accountNo != "")
	{
		isNull++;
	}
	var deviceNo = $("#deviceNo").val();
	if(deviceNo && deviceNo != "")
	{
		isNull++;
	}
	var deviceName = $("#deviceName").val();
	if(deviceName && deviceName != "")
	{
		isNull++;
	}
	var productName = $("#productName").val();
	if(productName && productName != "")
	{
		isNull++;
	}
	var model = $("#model").val();
	if(model && model != "")
	{
		isNull++;
	}
	var productDate = $("#productDate").val();
	if(productDate && productDate != "")
	{
		isNull++;
	}
	
	if(isNull==6)
	{
		$.ajax({
			url : url,
			type : 'post',
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			data : {
				"accountNo" : accountNo,
				"deviceNo" : deviceNo,
				"deviceName" : deviceName,
				"productName" : productName,
				"model" : model,
				"productDate" : productDate
			},
			dataType : 'json',
			traditional : true,
			beforeSend : function() {
				spinner = commonLoad("countDiv");
			},
			success : function(data) {
				if (data.isSuccess) {
					alert("关联成功！");
				} else {
					alert("关联失败！");
				}
			},
			error : function() {
				alert("关联失败！");
			},
			complete : function() {
				spinner.spin();// 移除加载
			}
		});
	}
}
