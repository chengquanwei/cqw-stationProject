$(function(){
	
	$.ajax({
		type:"POST",
		url:"/yszcblog-project/article/getAllArticle",
		data:{},
		success:function(result){
			console.log(result);
			if(result.meta.message == "ok"){
				layer.tips('测试成功！数据已从数据库中取出！', '', {
					  tips: [1, '#3595CC'],
					  time: 2000
				});
				
				var res = result.data;
				var info = "";
				for(var i = 0;i<res.length;i++){
					var creadTime =res[i].createdTime==null?'0000-0-0 00:00:00':format(res[i].createdTime)
					info += 
						'<tr><td>'+res[i].title +'</td></tr>'+
						'<tr><td>'+res[i].article +'</td></tr>'+
						'<tr><td>'+ creadTime +'</td></tr>';
				}
				$("#articleList").html(info);
			}else{
				layer.tips('测试失败！', '', {
					  tips: [1, 'red'],
					  time: 2000
				});
			}
		}
	});
})

// 将当前时间换成时间格式字符串
/**
 * @author cqw
 * @date 2017年7月22日16:34:56
 * @description 时间戳转换为时间格式
 */
 function format(timestamp) {
	var newDate = new Date();
	newDate.setTime(timestamp);
	var format = 'yyyy-MM-dd hh:mm:ss';
       var date = {
              "M+": newDate.getMonth() + 1,
              "d+": newDate.getDate(),
              "h+": newDate.getHours(),
              "m+": newDate.getMinutes(),
              "s+": newDate.getSeconds(),
              "q+": Math.floor((newDate.getMonth() + 3) / 3),
              "S+": newDate.getMilliseconds()
       };
       if (/(y+)/i.test(format)) {
              format = format.replace(RegExp.$1, (newDate.getFullYear() + '').substr(4 - RegExp.$1.length));
       }
       for (var k in date) {
              if (new RegExp("(" + k + ")").test(format)) {
                     format = format.replace(RegExp.$1, RegExp.$1.length == 1
                            ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
              }
       }
       return format;
}

