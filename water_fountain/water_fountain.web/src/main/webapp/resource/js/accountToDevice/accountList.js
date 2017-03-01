function searchAccount(url) {
	var param = new Object();
	var accountName = $("#accountName").val();
	if (accountName && accountName != "") {
		param.accountName = accountName;
	}
	var telephone = $("#telephone").val();
	if (telephone && telephone != "") {
		param.telephone = telephone;
	}
	var deviceName = $("#deviceName").val();
	if (deviceName && deviceName != "") {
		param.deviceName = deviceName;
	}

	searchPage(1, 10, url, JSON.stringify(param), "accountListDiv");
}

function clearSearch() {
	$("#accountName").val('');
	$("#telephone").val('');
	$("#deviceName").val('');
}