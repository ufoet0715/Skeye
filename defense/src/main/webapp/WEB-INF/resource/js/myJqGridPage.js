var macType={};
macType.stationTrust='保护终端';
function getjqGridTable(gridParams, isSubGrid) {
	if (isSubGrid == undefined) {
		isSubGrid = true;
	}
	var oTable1 = $('#' + gridParams.id).jqGrid(
			{
				"url" : gridParams.url,
				"prmNames" : {
					page : "iDisplayStart",
					rows : "iDisplayLength",
					sort : "sidx",
					order : "sord",
					search : "_search",
					nd : "nd",
					npage : null
				},
				"jsonReader" : {
					root : "aaData",
					page : "page",
					records : "iTotalRecords",// 总行数
				},
				"postData" : {
					'params' : gridParams.param
				},
				"mtype" : "post",
				"datatype" : "json",
				"viewrecords" : true,
				"rowNum" : 10,
				"rowList" : [ 10, 20, 30 ],
				"pager" : "#" + gridParams.pager,
				"altRows" : true,
				"colNames" : gridParams.colums,
				"colModel" : gridParams.models,
				"multiselect" : true,
				"multiboxonly" : true,
				"caption" : gridParams.title,
				"height" : 380,
				"width" : 1150,
				"subGrid" : isSubGrid,
				"subGridOptions" : {
					plusicon : "ace-icon fa fa-plus center bigger-110 blue",
					minusicon : "ace-icon fa fa-minus center bigger-110 blue",
					openicon : "ace-icon fa fa-chevron-right center orange"
				},
				"subGridRowExpanded" : function(subgridDivId, rowId) {
					if (gridParams.subGridUrl != null
							&& gridParams.subGridUrl != undefined) {
						var subgrid_table_id;
						subgrid_table_id = subgridDivId + "_t"; // 根据subgrid_id定义对应的子表格的table的id
						// var subgrid_pager_id;
						// subgrid_pager_id = subgridDivId + "_pgr"
						// //根据subgrid_id定义对应的子表格的pager的id
						// 动态添加子报表的table和pager <div
						// id='"+subgrid_pager_id+"'class='scroll'></div>
						$("#" + subgridDivId).html(
								"<table id='" + subgrid_table_id
										+ "'class='scroll'></table>");
						// 创建jqGrid对象
						$("#" + subgrid_table_id).jqGrid({
							url : gridParams.subGridUrl, // 子表格数据对应的url，注意传入的contact.id参数
							mtype : "post",
							datatype : "json",
							postData : {
								'id' : rowId
							},
							colNames : gridParams.expandColNames,
							colModel : gridParams.expandColModel,
							prmNames : {
								search : "search"
							},
							// pager: subgrid_pager_id,
							viewrecords : true,
							height : "100%",
							autowidth : true,
						// rowNum: 5,
						});
					}
				},
				"loadComplete" : function() {
					var table = this;
					setTimeout(function() {
						enableTooltips(table);
					}, 0);
				}
			});

	$(window).triggerHandler('resize.jqGrid');

	jQuery(grid_selector).jqGrid('navGrid', pager_selector, {
		editfunc : function(){
			var ids=$(this).jqGrid('getGridParam','selarrrow');
			var mac=$(this).jqGrid('getRowData',ids[0]).mac;
			editStation(mac);
		}, // (2) 点击编辑按钮，则调用openDialogEdit方法
		editicon : 'ace-icon fa fa-pencil blue',
		addfunc : function(){
			addStation();
		}, // (1) 点击添加按钮，则调用openDialog4Adding方法
		addicon : 'ace-icon fa fa-plus-circle purple',
		delfunc : openDialogDelete, // (3) 点击删除按钮，则调用openDialog4Deleting方法
		delicon : 'ace-icon fa fa-trash-o red',
		search : true,
		searchicon : 'ace-icon fa fa-search orange',
		refresh : true,
		refreshicon : 'ace-icon fa fa-refresh green',
		view : true,
		viewicon : 'ace-icon fa fa-search-plus grey',
		alerttext : "请选择需要操作的数据行!" // (4) 当未选中任何行而点击编辑、删除、查看按钮时，弹出的提示信息
	},
	{}, // edit options
	{}, // add options
	{}, // delete options
	{
		multipleSearch : true
	} // search options - define multiple search
	);
	return oTable1;
}
function openDialogDelete() {
	alert(111);
}