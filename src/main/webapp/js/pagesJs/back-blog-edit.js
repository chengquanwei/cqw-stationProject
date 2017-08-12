$(function(){
	//summernote初始化
 	$('.summernote').summernote({
        height: 300,
        tabsize: 2,
        lang: 'zh-CN'
    });
 	//编辑回显
 	var id = sessionStorage.getItem("blogId");
 	getArticleInfoById(id);
 	
 	var data ={id:"",title:"",article:"",type:"",tagName:"",tagsId:""};
 	//保存操作
 	$("#preserve").click(function(){
 		var title = $("#title").val();
 		var articleCode = $('.summernote').summernote('code');
 		var tagName = $("#tagName").val();
 		var tagsId = $("#tagsId").val();
 		//校验后赋值
 		data.id = id;
 		data.title = title;
 		data.article = articleCode;
 		data.type = 1;
 		data.tagName = tagName;
 		data.tagsId = tagsId;
 		
 		//调用方法
 		updateArticle(data);
 	})
 	//取消
 	$("#cancel").click(function(){
 	 	var index = parent.layer.getFrameIndex(window.name); 
		parent.layer.close(index); //再执行关闭     
 	})

 	
})

 	/**
 	 * @author cqw
 	 * @date 2017年8月2日15:13:30
 	 * @description 新增博客
 	 */
	function updateArticle(data){
		$.ajax({
			type:"POST",
			url:"/yszcblog-project/article/updateArticle",
			data:data,
			success:function(result){
				console.log(result);
				if(result.meta.message == "ok"){
					console.log("修改成功！");
					//先得到当前iframe层的索引
					var index = parent.layer.getFrameIndex(window.name); 
					parent.layer.close(index); //再执行关闭     
				}else{
					console.log("修改失败！");
				}
			}
		});
	}
/**
 * @author cqw
 * @date 2017年8月12日19:00:53
 * @description 根据博客id 回显编辑内容
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
				var author = res.user.userName;
				var createDate = format(res.createdTime);
				var title = res.title;
				var concent = res.article;
				
				var info = "";
				var tagsId = "";
				for(var k = 0;k<res.tags.length;k++){
					info += res.tags[k].name +',';
					tagsId += res.tags[k].id +',';
				}
				console.log("tagsId:"+tagsId);
				$("#title").val(title);
		 		$("#tagName").val(info.substring(0,info.length-1));
		 		$("#tagsId").val(tagsId.substring(0,tagsId.length-1));
				$('.summernote').summernote('code', concent);
			}else{
				console.log("获取博客内容失败！");
			}
		}
	});
}