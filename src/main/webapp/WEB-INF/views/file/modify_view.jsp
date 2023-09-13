<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	id : ${dto.id } <br>
	name : ${dto.name } <br>
	imgName : ${dto.imgName} <br>
	<img src="download?file=${dto.imgName }" width="100" height="100"> <br>
	
	<form action="modi" method="post" enctype="multipart/form-data">
		<input type="text" name="id" value="${dto.id }" readonly> <br>
		<input type="text" name="name"  value="${dto.name }"> <br>
		<input type="file" name="file"> <br>
		<input type="submit" value="전송"> <br>
	</form>
	<a href="views">내용 확인</a>
	
	
</body>
</html>