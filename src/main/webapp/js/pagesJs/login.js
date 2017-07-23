$(function(){
	
	$("#login").click(function(){
		var name = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			type:"POST",
			url:"/yszcblog-project/login/dologin",
			data:{
				"userName":name,
				"password":password
			},
			success:function(result){
				if(result.meta.message == "ok"){
//					layer.alert("登录成功！");
					window.location.href='/yszcblog-project/pages/userList.html';
				}else{
					layer.alert("登录失败！");
				}
			}
		});
	});
	
});