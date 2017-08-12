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
				var articles = "";
				var res = result.data;
				var artsLength = res.length;
//				for(var i = 0;i<artsLength;i++){
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
//				}
				$("#articles").html(articles);
			}else{
				console.log("获取博客内容失败！");
			}
		}
	});
}



//$(function(){
//	//加载文章内容
//	getAllArticle();
//})

/**
 * @author cqw
 * @date 2017年8月11日18:41:30
 * @description 加载文章内容
 */
//function getAllArticle(){
//	//查询
//	$.ajax({
//		type:"POST",
//		url:"/yszcblog-project/article/getAllArticle",
//		data:{},
//		success:function(result){
//			console.log(result);
//			if(result.meta.message == "ok"){
//				var articles = "";
//				var res = result.data;
//				var artsLength = res.length;
//				for(var i = 0;i<artsLength;i++){
//					var res = result.data[i];
//					var author = res.user.userName;
//					var createDate = format(res.createdTime);
//					var title = res.title;
//					var concent = res.article;
//					var id = res.id;
//					
//					var info = "";
//					for(var k = 0;k<res.tags.length;k++){
//						info += '<li><a href="#">'+res.tags[k].name+'</a></li>';
//					}
//					articles += '<div class="panel panel-default">'+
//								    	'<div class="panel-body">'+
//										  	'<div class="row">'+
//											    '<div class="col-md-12 category">'+
//											    	'<div class="input-group">'+
//														'<h3><a href="#" blogId='+id+'>'+title+'</a></h3>'+
//													'</div>'+
//											    '</div>'+
//											  '</div>'+
//											 '<div class="row separation20">'+
//											    '<div class="col-md-12 category">'+
//											    	'<div class="input-group">'+
//														'作者：<label>'+author+'</label>/'+
//														'创建时间：<label>'+createDate+'</label>/'+
//														'标签：<label class="tag-list">'+info+'</label>'+
//													'</div>'+
//											    '</div>'+
//											  '</div>'+
//											  '<div class="row separation20">'+
//											    '<div class="col-md-12">'+
//											    	'<div class="ellipsis">'+concent+'</div>'+
//											    '</div>'+
//											  '</div>'+
//											'</div>'+
//									   '</div>';
//				}
//				$("#articles").html(articles);
//			}else{
//				layer.tips('测试失败！', '', {
//					  tips: [1, 'red'],
//					  time: 2000
//				});
//			}
//		}
//	});
//}
