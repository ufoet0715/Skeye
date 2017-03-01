function searchDevice(url) {
	var param = new Object();
	var deviceNo = $("#deviceNo").val();
	if (deviceNo && deviceNo != "") {
		param.deviceNo = deviceNo;

	}
	var deviceState = $("#deviceState").val();
	if (deviceState && deviceState != "") {
		param.deviceState = deviceState;
	}
	var waterTemperature = $("#waterTemperature").val();
	if (waterTemperature && waterTemperature != "") {
		param.waterTemperature = waterTemperature;
	}

	searchPage(
			1,
			10,
			url,
			JSON.stringify(param), "deviceListDiv");
}

function clearSearch() {
	$("#deviceNo").val('');
	$("#deviceState").val('');
	$("#waterTemperature").val('');
}