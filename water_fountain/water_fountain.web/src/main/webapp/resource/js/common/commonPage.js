
function searchPage(pageIndex, pageSize, url, param, target) {
	if (!param && param == "") {
		param = "{}";
	}
	var params = {
		"pageIndex" : pageIndex,
		"pageSize" : pageSize,
		"params" : param
	};
	var spinner;
	$.ajax({
		url : url,
		type:'post',
		contentType:"application/x-www-form-urlencoded; charset=utf-8", 
		data : params,
		beforeSend : function() {
			spinner = commonLoad(target);
		},
		success : function(data) {
			$("#" + target).html(data);
		},
		error : function() {
			$("#" + target).html("查询异常");
		},
		complete : function() {
			spinner.spin();
		}
	});
}