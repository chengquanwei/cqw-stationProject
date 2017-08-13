var pageSize = 3;
$(function(){
	
	//加载文章内容
	getAllArticle(1);
	
})

/**
 * @author cqw
 * @date 2017年8月11日18:41:30
 * @description 加载文章内容
 */
function getAllArticle(pageNo){
	var pageInfo = 
	//查询
	$.ajax({
		type:"POST",
		url:"/yszcblog-project/article/getAllArticle",
		data:{
			pageNo:pageNo,
			pageSize:pageSize
		},
		success:function(result){
			console.log(result);
			if(result.meta.message == "ok"){
				var articles = "";
//				var resu = result.data.articlesPage;
				var pageInfo = result.data;
				var resu = pageInfo.list;
				
				var artsLength = resu.length;
				for(var i = 0;i<artsLength;i++){
					var res = resu[i];
					var author = res.user.userName;
					var createDate = format(res.createdTime);
					var title = res.title;
					var concent = res.article;
					var id = res.id;
					
					var info = "";
					for(var k = 0;k<res.tags.length;k++){
						info += '<li><a href="#">'+res.tags[k].name+'</a></li>';
					}
					articles += '<div class="panel panel-default">'+
								    	'<div class="panel-body">'+
										  	'<div class="row">'+
											    '<div class="col-md-12 category">'+
											    	'<div class="input-group">'+
														'<h3><a href=/yszcblog-project/pages/manage/back-blog-dislay.html?id='+id+'>'+title+'</a></h3>'+
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
											    	'<div class="ellipsis">'+concent+'</div>'+
											    '</div>'+
											  '</div>'+
											'</div>'+
									   '</div>';
				}
				$("#articles").html(articles);
				pageArticle(pageInfo);
			}else{
				layer.tips('测试失败！', '', {
					  tips: [1, 'red'],
					  time: 2000
				});
			}
		}
	});
}
/**
 * @author cqw
 * @description 分页插件进行分页
 * @param pageInfo
 */
function pageArticle(pageInfo){
	var element = $('#bp-element');
	  var options = {
		        bootstrapMajorVersion:3, //对应的bootstrap版本
		        currentPage: pageInfo.pageNum, //当前页数，这里是用的EL表达式，获取从后台传过来的值
		        numberOfPages: pageSize, //每页页数
		        totalPages:pageInfo.pages, //总页数，这里是用的EL表达式，获取从后台传过来的值
		        itemTexts: function (type, page, current) {//设置显示的样式，默认是箭头
		            switch (type) {
		                case "first":
		                    return "首页";
		                case "prev":
		                    return "上一页";
		                case "next":
		                    return "下一页";
		                case "last":
		                    return "末页";
		                case "page":
		                    return page;
		            }
		        },
		        //点击事件
		        onPageClicked: function (event, originalEvent, type, page) {
		           	getAllArticle(page);
		        }
		    };
	  element.bootstrapPaginator(options);
}
