/**
 * 
 */

$(document).ready(function(){

	$.ajax({
		url:"/getStatistics",
		type:"get",
		dataType:"json",
		data:"",
		traditional:true,
		beforeSend:function(){
			$("body").mLoading("show");
		},
		success:function(data){
			
			var x_axis = new Array();
			var x_data = new Array();
			var length = data.length;
			
			for(var i = 0;i < length;i++){
				
				x_axis[i] = data[0]["function"];
				x_data[i] = data[0]["statistics"];
				
			}
			
			console.log(x_axis);
			console.log(x_data);
			
			init_chart(x_axis,x_data);
			
			
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
		
	})

})


function init_chart(x_axis,x_data){
	
    var myChart = echarts.init(document.getElementById('statistics_charts'));

    // 指定图表的配置项和数据
    var option = {
    	baseOption:{
    		itemStyle:{  
                normal:{  
                    color:'#000000',  
                  },
        },
        title: {
            text: '自动代码生成数量统计',
        },
        tooltip: {},
        legend: {
            data:['次数']
        },
        xAxis: {
            data: x_axis
        },
        yAxis: {},
        series: [{
            name: '次数',
            type: 'bar',
            data: x_data,
            barMaxWidth:30,
            label: {
                normal: {
                    show: true,
                    position: 'top',
                    textStyle: {
                      color: 'black'
                    }
                }
          	},
        }],
    },
    media: [ // 这里定义了 media query 的逐条规则。
        {
            query: {
            	maxWidth: 500
            },   // 这里写规则。
            option: {  
            	title: {
                    text: '自动代码生成数量统计',
//                    top:'90%',
                    left:'30%'
                    
                },
                legend: {
                	   right: 'right',              // legend 放置在右侧中间。
                	   top: 'middle',
                       orient: 'vertical' 
                },
            }
        },
       
    ]
        
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
	
}