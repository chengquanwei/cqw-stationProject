$(function(){
	//点击博客标题跳转页面
	$("#blog-title1,#blog-title2").click(function(){
		var id = $(this).attr("blogId");
		window.location.href="blog-single.html?id="+id; 
	})
	
	//加载文章内容
	getAllArticle();
	
	/**
	 * @author cqw
	 * @date 2017年7月24日22:27:52
	 * @description 新建博客
	 */
//	addArticle();
	function addArticle(){
		$.ajax({
			type:"POST",
			url:"/yszcblog-project/article/addArticle",
			data:{
				title:"标题测试",
				article:"内容测试",
				type:"1",
				tagName:"cs,测试,java,GC"
			},
			success:function(result){
				console.log(result);
				if(result.meta.message == "ok"){
					layer.alert("新建成功！");
				}else{}
			}
		});
	}
});

/**
 * @author cqw
 * @date 2017年7月27日23:13:59
 * @description 加载文章内容
 */
function getAllArticle(){
	//查询
	$.ajax({
		type:"POST",
		url:"/yszcblog-project/article/getAllArticle",
		data:{},
		success:function(result){
			console.log(result);
			if(result.meta.message == "ok"){
				var res = result.data;
				for(var i = 0;i<2;i++){
					var tagLists = res[i].tags;
					var info = "";
					for(var k = 0;k<tagLists.length;k++){
						info += '<li><a href="#">'+tagLists[k].name+'</a></li>';
					}
					$("#blog-tags"+(i+1)).html(info);
					$("#blog-userName"+(i+1)).html(res[i].user.userName);
					$("#blog-title"+(i+1)).html(res[i].title).attr("blogId",res[i].id);
					$("#blog-content"+(i+1)).html(res[i].article);
					$("#blog-dateTime"+(i+1)).html(format(res[i].createdTime));
				}
			}else{
				layer.tips('测试失败！', '', {
					  tips: [1, 'red'],
					  time: 2000
				});
			}
		}
	});
}



