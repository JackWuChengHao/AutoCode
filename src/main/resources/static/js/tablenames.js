/**
 * 
 */
$(document).ready(function() {

	$('#database_table').bootstrapTable({
		url: '/gettables',         //请求后台的URL（*）
		method: 'get',                      //请求方式（*）

		//    toolbar: '#toolbar',                //工具按钮用哪个容器
		striped: true,                      //是否显示行间隔色
		cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
//		singleSelect    : true,                     // 单选checkbox
		   pagination: true,                   //是否显示分页（*）
		//   sortable: false,                     //是否启用排序
		//   sortOrder: "asc",                   //排序方式
		//     queryParams: oTableInit.queryParams,//传递参数（*）
	     sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
		     pageNumber: 1,                       //初始化加载第一页，默认第一页
		     pageSize: 10,                       //每页的记录行数（*）
		     pageList: [10, 25, 50, 100,400],        //可供选择的每页的行数（*）
		     search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		//     contentType: "application/x-www-form-urlencoded",
		//    strictSearch: true,
		showColumns: true,                  //是否显示所有的列
		    showRefresh: true,                  //是否显示刷新按钮
		//   minimumCountColumns: 2,             //最少允许的列数
		clickToSelect: true,                //是否启用点击选中行
		//     height: 700,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		//     uniqueId: "no",                     //每一行的唯一标识，一般为主键列
		//      showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
		//      cardView: false,                    //是否显示详细视图
		//      detailView: false,                   //是否显示父子表
		columns: [{
			checkbox: true
		},
		{
			field:'id',
			title:'ID'
		},
		{
			field: 'name',
			title: 'TableName'
		}
		],
	});
	
	$("#submitGenerateInfo").on("click",sendGenerateInfo);
	

});


function sendGenerateInfo(){
	
	var a = $("#database_table").bootstrapTable('getSelections'); 
	
	console.log(a);
	
	if(a.length<=0){  
		swal({
		    text: '请至少选择一行数据',
		    confirmButtonText: '了解',
		    animation: false,
		    confirmButtonColor: '#343a40',
		    animation: false,
		    customClass: 'animated jello'
		})
		return;
   }else{  
	
	var b=JSON.stringify( a ); 
	
	var c = $("#packagename").val();
	
	if(!$("#packagename").val()){
		swal({
		    text: '请输入包名',
		    confirmButtonText: '了解',
		    animation: false,
		    confirmButtonColor: '#343a40',
		    animation: false,
		    customClass: 'animated jello'
		})
		return;
	}
		
   }
	
	$.ajax({
			url:"/getCode",
			type:"post",
			dataType:"json",
			data:"",
			traditional:true,
			data: {"datalist":b,"packagename":c}, 
			beforeSend:function(){
				$("body").mLoading("show");
			},
			success:function(data){
				
				$("#download_link").attr("href","/files/"+data+".zip");
				
				$("#download_link")[0].click();
				
			},
			failed:function(){
				swal({
				    text: '网络出现了一些问题',
				    confirmButtonText: '了解',
				    animation: false,
				    confirmButtonColor: '#343a40'
				})
			},
			complete:function(){
				$("body").mLoading("hide");
			}
	}
	);

}
