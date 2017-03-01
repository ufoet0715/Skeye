
function deleteCommon(checkBoxName,url,funcName) {
    var users=  $("input[name='"+checkBoxName+"']:checked");
    if(!users||users.length==0){
        alert("请选择要删除的记录");
        return false;
    }
    var checked = [];
    $("input[name='"+checkBoxName+"']:checked").each(function() {
        checked.push($(this).val());
    });
    $.ajax({
        type: "post",
        headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        url: url, data:JSON.stringify(checked), success: function (data) {
            if(data.isSuccess){
                alert("删除成功");
                if(funcName&&funcName!=''){
                    eval(funcName+"()");
                }
            }
        }, error: function () {
            alert("删除异常");
        }
    });


}
