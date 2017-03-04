var ztreeSetting;
var zNodes;
var nodeKey;

function loadZtree(url, id,func,selectNode) {
	var params = {};
	$.ajax({
		type : "post",
		dataType : "json",
		traditional : true,
		async : false,
		data : params,
		url : url,
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		success : function(data, textStatus) {
			if (data) {
				zNodes  =data;
				loadTree(id,func,selectNode);
			}
		}
	});
}

function loadTree(id,func,selectNode) {
	if (zNodes) {
		$.fn.zTree.init($("#" + id), ztreeSetting, zNodes);
		var zTree = $.fn.zTree.getZTreeObj(id);
		zTree.setting.callback.onClick =func; 
		if(selectNode){
			var node = zTree.getNodeByParam(nodeKey,selectNode);  
			zTree.selectNode(node,true);//指定选中ID的节点  
			zTree.expandNode(node, true, false);//指定选中ID节点展开
			
		}
	}
}


