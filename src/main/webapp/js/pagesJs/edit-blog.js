$(function(){
	var id = getQueryString("id");
	getArticleInfoById(id);
})

/**
 * @author cqw
 * @date 2017年8月12日17:35:36
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
				var articles = "";
				var res = result.data;
				var artsLength = res.length;
					var res = result.data;
					var author = res.user.userName;
					var createDate = format(res.createdTime);
					var title = res.title;
					var concent = res.article;
					
					var info = "";
					for(var k = 0;k<res.tags.length;k++){
						info += '<li><a href="#">'+res.tags[k].name+'</a></li>';
					}
					articles += '<div class="panel panel-default">'+
								    	'<div class="panel-body">'+
										  	'<div class="row">'+
											    '<div class="col-md-12 category">'+
											    	'<div class="input-group">'+
														'<h3><a href="#">'+title+'</a></h3>'+
													'</div>'+
											    '</div>'+
											  '</div>'+
											 '<div class="row separation20">'+
											    '<div class="col-md-12 category">'+
											    	'<div class="input-group">'+
														'作者：<label>'+author+'</label>/'+
														'创建时间：<label>'+createDate+'</label>/'+
														'标签：<label class="tag-list">'+info+'</label>'+
													'</div>'+
											    '</div>'+
											  '</div>'+
											  '<div class="row separation20">'+
											    '<div class="col-md-12">'+
											    	'<div class="">'+concent+'</div>'+
											    '</div>'+
											  '</div>'+
											'</div>'+
									   '</div>';
				$("#articles").html(articles);
			}else{
				console.log("获取博客内容失败！");
			}
		}
	});
}
