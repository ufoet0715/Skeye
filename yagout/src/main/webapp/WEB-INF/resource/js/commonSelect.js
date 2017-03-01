function selectChange(id,url,funcName) {
    var html=$("#"+id).html();
    var spinner;
    if(!html||html==''){
        $.ajax({
            type: "post",
            url: url,
            beforeSend: function () {
                spinner= commonLoad(id);
            },
            success: function (data) {
                $("#"+id).html(data);
                if(funcName&&funcName!=''){
                    eval(funcName+"()");
                }
            },
            complete: function () {
                spinner.spin();//移除加载
            }
        });
    }
}