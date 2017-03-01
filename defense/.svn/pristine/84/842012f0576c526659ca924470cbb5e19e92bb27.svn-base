
function searchAutoComplete(id,url,searchName,filedName) {
    $('#'+id).autocomplete({
        source:function(query,process){
            var matchCount = this.options.items;//返回结果集最大数量
            var searchData={"rows":matchCount};
           var  paramsData={};
            paramsData[searchName]=query+'%';
            searchData.params=JSON.stringify(paramsData);
            $.ajax({
                type: "post",
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                url: url, data:JSON.stringify(searchData), success: function (data) {
                    if(data.isSuccess){
                        return process(data.data);
                    }
                }, error: function () {
                    alert("查询异常");
                }
            });
        },
        formatItem:function(item){
            return item[filedName];
        },
        setValue:function(item){
            return {'data-value':item[filedName],'real-value':item[filedName]};
        }
    });

}