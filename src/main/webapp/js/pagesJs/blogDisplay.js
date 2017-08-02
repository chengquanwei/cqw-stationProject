$(function(){
	var id = getQueryString("id");
	getArticleInfoById(id);
})

/**
 * @author cqw
 * @date 2017年8月2日16:31:54
 * @description 根据博客id获取博客内容
 * @param id
 */
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
				
				var info = "";
				for(var k = 0;k<res.tags.length;k++){
					info += '<li><a href="#">'+res.tags[k].name+'</a></li>';
				}
				$("#blog-display-tags").html(info);
			}else{
				console.log("获取博客内容失败！");
			}
		}
	});
}