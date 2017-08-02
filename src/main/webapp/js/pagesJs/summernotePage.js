$(function(){
	var data ={	title:"",article:"",type:"",tagName:""};
	//summernote初始化
 	$('.summernote').summernote({
        height: 500,
        tabsize: 2,
        lang: 'zh-CN'
    });
 	
 	//保存操作
 	$("#preserve").click(function(){
 		var title = $("#title").val();
 		var articleCode = $('.summernote').summernote('code');
 		var tagName = $("#tagName").val();
 		//校验后赋值
 		data.title = title;
 		data.article = articleCode;
 		data.type = 1;
 		data.tagName = tagName;
 		//调用方法
 		var resData = addArticle(data);
 		
 	})
 	
 	/**
 	 * @author cqw
 	 * @date 2017年8月2日15:13:30
 	 * @description 新增博客
 	 */
	function addArticle(data){
		$.ajax({
			type:"POST",
			url:"/yszcblog-project/article/addArticle",
			data:data,
			success:function(result){
				console.log(result);
				if(result.meta.message == "ok"){
					layer.alert("新建成功！");
					$(".summernote").css("display","none");
			 		$("#concent").html(result.data.article);
				}else{}
			}
		});
	}
})