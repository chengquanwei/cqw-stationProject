/**
 * @author cqw
 * @date 2017年7月27日22:59:27
 * 
 * @document：
 * 			1.方法：	format(timestamp) : 时间戳转换为时间格式
 * 							param  : 传入timestamp(时间戳)
 * 							return : 返回dataTime(格式：yyyy-MM-dd hh:mm:ss)
 * 									 异常处理：当传入参数为空时返回：0000-00-00 00:00:00
 */
//*******************************提供公共的js方法********************************************
$(function(){
	
})

/**
 * @author cqw
 * @date 2017年7月22日16:34:56
 * @description 时间戳转换为时间格式
 */
 function format(timestamp) {
	if(timestamp != null){
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
	}else{
		 return '0000-00-00 00:00:00';
	}
	
       
}