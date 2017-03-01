$(document).ready(function() {
	$.datetimepicker.setLocale('ch');
	$('#productDate').datetimepicker({
        format: 'Y/m/d',
        timepicker: true     //关闭时间选项
    });
});

function searchDevice(url) {
	var param = {};
	var accountNo = $("#accountNo").val();
	if (accountNo && accountNo != "") {
		param.accountNo = accountNo;
	}
	var telephone = $("#telephone").val();
	if (telephone && telephone != "") {
		param.telephone = telephone;
	}

	searchPage(1, 10, url, JSON.stringify(param), "deviceListDiv");
}

function searchDeviceState(deviceNo,url)
{
	var param={};
	param.deviceNo=deviceNo;
	searchPage(1, 10, url, JSON.stringify(param), "deviceStateListDiv");
}

function clearSearch() {
	$("#accountNo").val('');
	$("#telephone").val('');
}
