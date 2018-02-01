<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body{
     background: url(${pageContext.request.contextPath}/images/backImage2.jpg);
}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/add.action" method="post">
姓名：<input type="text" name="name">
性别：<select name="gender">
     <option value=''>请选择</option>
     <option>男</option>
     <option>女</option>
     <option value=''>保密</option>
     </select>
年龄：<input type="text" name="age">
住址：<input type="text" name="address">
<input type="submit" value="添加">
</form>
</body>
</html>