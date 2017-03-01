 function getjqGridTable(gridParams,isSubGrid){
	if(isSubGrid == undefined){
		isSubGrid=true;
	}
	if(gridParams.sortname == undefined){
		gridParams.sortname = "";
	}
	if(gridParams.multiselect == undefined){
		gridParams.multiselect = true;
	}
	var oTable1 = $('#'+gridParams.id).jqGrid( {
		"url" : gridParams.url,
		"prmNames": {
			page:"iDisplayStart",
			rows:"iDisplayLength", 
			sort: "sidx",
			order: "sord",
			search:"_search",
			nd:"nd", 
			npage:null
		},
		"jsonReader" : { 
			root : "aaData",
			page: "page",
		    records: "iTotalRecords",//总行数  
		},
		"postData" : {
			'params': gridParams.param
		},
		"mtype" : "post",
		"datatype" : "json",
		"viewrecords" : true,
		"rowNum":10,
		"rowList":[10,20,30],
		"pager" : "#"+gridParams.pager,
		"altRows": true,
		"colNames" : gridParams.colums,
		"colModel" : gridParams.models,
		"multiselect": gridParams.multiselect,
	    "multiboxonly": true,
	    "caption": gridParams.title,
	    "height": 350,
	    "autowidth" : true,
	    "sortname" : gridParams.sortname,
	    "sortable":true,
	    "sortorder":'desc',
        "subGrid" : isSubGrid,
		"subGridOptions" : {
			plusicon : "ace-icon fa fa-plus center bigger-110 blue",
			minusicon  : "ace-icon fa fa-minus center bigger-110 blue",
			openicon : "ace-icon fa fa-chevron-right center orange"
		},
		"subGridRowExpanded": function (subgridDivId, rowId) {
			if(gridParams.subGridUrl != null && gridParams.subGridUrl != undefined){
				var subgrid_table_id;  
	            subgrid_table_id = subgridDivId + "_t";   //根据subgrid_id定义对应的子表格的table的id  
	            $("#" + subgridDivId).html("<table id='"+subgrid_table_id+"'class='scroll'></table>");  
	            $("#" + subgrid_table_id).jqGrid({  
	                url: gridParams.subGridUrl,  //子表格数据对应的url，注意传入的contact.id参数  
	                mtype:"post",
	                datatype: "json",  
	                postData : {
	        			'id': rowId
	        		},
	                colNames: gridParams.expandColNames,  
	                colModel: gridParams.expandColModel,  
	                prmNames: {search: "search"},  
	                viewrecords: true,  
	                height: "100%",
	                autowidth:false,
				});
			}
		},
		"onSelectAll":function(rowid, status) { //点击全选时触发事件
			var rowIds = jQuery('#'+gridParams.id).jqGrid('getDataIDs');//获取jqgrid中所有数据行的id
			 	for(var k=0; k<rowIds.length; k++) {
			 		var curRowData = jQuery('#'+gridParams.id).jqGrid('getRowData', rowIds[k]);//获取指定id所在行的所有数据.
					if(curRowData.userName == "admin"){
						$('#'+gridParams.id).jqGrid("setSelection",rowIds[k],false);
					}
			 	}
	 	},
		"onSelectRow": function(rowId, status, e){
			var curRowData = jQuery('#'+gridParams.id).jqGrid('getRowData', rowId);
				if(curRowData.userName == "admin"){
					$('#'+gridParams.id).jqGrid("setSelection",rowId,false);
				}
		 	},
		"loadComplete" : function() {
			var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
				enableTooltips(table);
			}, 0);

		},
		"editurl": gridParams.updateUrl
    });
	
	
	$(window).triggerHandler('resize.jqGrid');
	
	jQuery(grid_selector).jqGrid('navGrid',pager_selector,
			{
				edit: gridParams.edit,
				editicon : 'ace-icon fa fa-pencil blue',
				addfunc : function(){
					if(gridParams.addFunction != undefined){
						addFunction();
					}else{
						return false;
					}
				},
				add: gridParams.add,
				addicon : 'ace-icon fa fa-plus-circle purple',
				del: gridParams.del,
				delfunc : gridParams.delfunc,
				delicon : 'ace-icon fa fa-trash-o red',
				search: gridParams.search,
				searchicon : 'ace-icon fa fa-search orange',
				refresh: gridParams.refresh,
				refreshicon : 'ace-icon fa fa-refresh green',
				view: gridParams.view,
				viewicon : 'ace-icon fa fa-search-plus grey',
			},
			{
				recreateForm: true,
				closeAfterEdit:true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
					.wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			},
			{
				closeAfterAdd: true,
				recreateForm: true,
				viewPagerButtons: false,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
					.wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			},
			{
				recreateForm: true,
				beforeShowForm : function(e) {
					var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_delete_form(form);
					form.data('styled', true);
				},
				onClick : function(e) {
					alert(1);
				}
			},
			{
				recreateForm: true,
				afterShowSearch: function(e){
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
					style_search_form(form);
				},
				afterRedraw: function(){
					style_search_filters($(this));
				},
				multipleSearch: true
			},
			{
				recreateForm: true,
				beforeShowForm: function(e){
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />');
					var selectedIds = $('#'+gridParams.id).jqGrid("getGridParam", "selarrrow");
					showFunction(selectedIds);
				}
			}
		)
    return oTable1;
 }
 
 function updatePagerIcons(table) { 
     var replacement =  
     {  
       'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',  
       'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',  
       'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',  
       'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'  
     };  
     $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){  
        var icon = $(this);  
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));  

        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);  
    	});

      // if( $("[name='subGridCellTd']")&&  $("[name='subGridCellTd']").length>0){
      //     $("[name='subGridCellTd']").each(function(){
      //         var $aa = $('<a style="cursor:pointer;" class="ui-sghref"><span class="ui-icon ace-icon fa fa-plus center bigger-110 blue"></span></a>');
      //         $aa.on('click',function(){
      //               $(this).parents("tr:first").find("[name='subGridCellTd']").click();
      //             });
      //        $(this).parents("tr:first").find("td:last").append($aa);
      //             $(this).hide();
      //     });
      // }

 }
 
 function bindDatePlug() {  
	    $(".time").addClass('Wdate');  
	    $(".time").on('focus', function() {  
	        WdatePicker({  
	            skin : 'whyGreen',  
	            dateFmt : 'yyyy-MM-dd HH:mm:ss',  
	            readOnly : true,  
	            maxDate : "%y-%M-%d %H:%m:%s"  
	        });  
	    });  
	}  
	  
	(function($) {    
	    // jqgrid插件  
	    $.hd_jqGrid = function(){};  
	    $.extend($.hd_jqGrid, {  
	        defaults : {  
	            rightHtml : "<font color='green'>√</font>",  
	            wrongHtml : "<font color='red'>×</font>",  
	              
	            date_yyyy_MM_dd_HH_mm_ss : "yyyy-MM-dd HH:mm:ss",  
	            date_yyyy_MM_dd : "yyyy-MM-dd"  
	        },  
	          
	        dateTimeFormatter : function(cellvalue, fmt) {  
	            return (null != cellvalue && cellvalue > 0) ? $.method.dateFormat(cellvalue, fmt) : "";  
	        },  
	          
	        statusFormatter : function(cellvalue) {  
	            return cellvalue == 1 ? $.hd_jqGrid.defaults.rightHtml : $.hd_jqGrid.defaults.wrongHtml;  
	        }  
	    });  
	})(jQuery);  
	  
	  
	(function ($) {  
	    $.method = function(){};  
	    $.extend($.method, {          
	        dateFormat : function( time, fmt) { // author: meizz  
	            if(null == fmt || typeof fmt == "undefined" || $.trim(fmt).length == 0){  
	                fmt = "yyyy-MM-dd HH:mm:ss";  
	            }  
	              
	            if(typeof time == "number"){  
	                time = new Date(time);  
	            }  
	              
	            var o = {  
	                "M+" : time.getMonth() + 1, // 月份  
	                "d+" : time.getDate(), // 日  
	                "h+" : time.getHours(), // 小时  
	                "H+" : time.getHours(), // 小时  
	                "m+" : time.getMinutes(), // 分  
	                "s+" : time.getSeconds(), // 秒  
	                "q+" : Math.floor((time.getMonth() + 3) / 3), // 季度  
	                "S" : time.getMilliseconds() // 毫秒  
	            };  
	            if (/(y+)/.test(fmt)) {  
	                fmt = fmt.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));  
	            }  
	                  
	            for ( var k in o) {  
	                if (new RegExp("(" + k + ")").test(fmt)) {  
	                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	                }  
	            }  
	            return fmt;  
	        }  
	    });  
	})(jQuery);  
 
 
