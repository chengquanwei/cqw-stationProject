<!DOCTYPE html">  
<html>  
    <head>  
	     <title>Freemarker测试案例</title>  
    </head>  
    <body>  
       <#list uList as user>  
			username : ${user.userName}<br/>  
			password : ${user.password}  <br/>  
		</#list>  
    </body>  
</html>  