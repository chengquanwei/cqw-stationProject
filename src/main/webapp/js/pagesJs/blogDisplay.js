$(function(){
	var id = getQueryString("id");
	getArticleInfoById(id);
})


/**
 * @author cqw
 * @date 2017年7月27日22:25:07
 * @description 根据名字获取url后的参数
 * @param name
 * @returns
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) 
		return unescape(r[2]); 
	return null; 
} 

function getArticleInfoById(id){
	$.ajax({
		type:"POST",
		url:"/yszcblog-project/article/getArticleInfoById",
		data:{
			id:id
		},
		success:function(result){
			console.log(result);
			if(result.meta.message == "ok"){
				var res = result.data;
				$("#blog-display-author").html(res.user.userName);
				$("#blog-display-date").html(format(res.createdTime));
				$("#blog-display-title").html(res.title);
				$("#blog-display-content").html(res.article);
				
			}else{
				console.log("获取博客内容失败！");
			}
		}
	});
}