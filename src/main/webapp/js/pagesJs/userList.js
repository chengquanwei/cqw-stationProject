$(function(){
	
	$.ajax({
		type:"POST",
		url:"/bdxgroup-project/user/userList",
		data:{},
		success:function(result){
			console.log(result);
		}
	});
})