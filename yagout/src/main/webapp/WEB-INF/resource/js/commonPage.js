function searchPage(pageNo, pageSize, url, param, target) {
    if (!param && param == "") {
        param = "{}";
    }
    var params = {pageNo: pageNo, rows: pageSize, params: param};
    var spinner;
    $.ajax({
        url: url, data: params,
        beforeSend: function () {
            spinner= commonLoad(target);
        },

        success: function (data) {
            $("#" + target).html(data);
        }, error: function () {
            $("#" + target).html("查询异常");
        },
        complete: function () {
            spinner.spin();//移除加载
        }
    });
}


// function createInput(name,value) {
//     var i = document.createElement("input");
//     i.type = "hidden";
//     i.value = value;
//     i.name = name;
//     return i;
// }