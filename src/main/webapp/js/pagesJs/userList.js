$(function(){
	
	$.ajax({
		type:"POST",
		url:"/bdxgroup-project/user/userList",
		data:{},
		success:function(result){
			console.log(result);
			if(result.meta.message == "ok"){
				layer.tips('framework测试成功！数据已从数据库中取出！', '', {
					  tips: [1, '#3595CC'],
					  time: 1000
				});
				var res = result.data;
				var info = "";
				for(var i = 0;i<res.length;i++){
					info += '<tr><td>'+res[i].id +'</td><td>'+res[i].userName+'</td><td>'+res[i].password+'</td></tr>';
				}
				$("#showUserInfo").append(info);
			}
		}
	});
})