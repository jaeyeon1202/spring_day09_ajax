<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>	
	<script type="text/javascript">
		function getF(){
			$.ajax({
				url : "rest", 
				type : "get", 
				success : function(msg){$("#txt").html(msg)	}
			})
		}
		
		function postF(){
			$.ajax({
				url : "rest", 
				type : "post", 
				success : function(msg){$("#txt").html(msg)}
			})
		}
				
		function putF(){
			$.ajax({
				url : "rest", 
				type : "put", 
				success : function(msg){$("#txt").html(msg)	}
			})
		}
				
		function deleteF(){
			$.ajax({
				url : "rest", 
				type : "delete", 
				success : function(msg){$("#txt").html(msg)}
			})
		}
	</script>
</head>
<body>
	<h3 id="txt"></h3>
	<button onclick="getF()">get</button>
	<button onclick="postF()">post</button>
	<button onclick="putF()">put</button>
	<button onclick="deleteF()">delete</button>
</body>
</html>