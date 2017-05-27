<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>学生信息展示</title>
    </head>
    <body>
    	<h1>学生信息展示:</h1>
    	<hr>
    	<div class="course_state",style="background-image: ">
			<ul>
				<li><span>学生姓名：</span> <em>${student.name }</em></li>
				<li ><span>学生性别：</span> <em><span>${student.sex }</span></em></li>
				<li><span>学生年龄：</span> <em>${student.age }</em></li>
				<li><span>学生院系：</span> <em>${student.address }</em></li>
			</ul>
		</div>
		<p>${msg}</p> 
 	</body>
</html>