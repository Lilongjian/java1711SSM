<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="../common/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
       #location{
       margin:50px auto;
       }
 </style>
<script src="/Java1711Web/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>
 <script type="text/javascript">
 function refreshCode(){
	$("#codeImg").attr("src","/Java1711SSM/checkImg?" + Math.random()); 
 }
 </script>
 
 <style>
			
			.qq{
				background: #CCCCFF; width: 500px; height: 350px;
				left: 50%;position: absolute;margin-left: -250px;
				top:  50%;position: absolute;margin-top: -150px;
				 border:7px outset chartreuse;
			}
			.ww{
				background: antiquewhite; width: 450px; height: 300px;
				left: 25px;position: absolute;
				top: 25px;position: absolute;
				
				
			}
			.ee{
				margin-left:180px ;
				margin-top: 20px;
				color: #0000FF;
				font-size:20px ;
				
			}
			.rr{
				margin-left: 100px;
				margin-top: 30px;
				color: #0000FF;
				
			}
			.yy{
				border-style:dashed ;
				border-color:#FFFF00 ;
				color: gainsboro;
				border-left-width:3px ;
			}
			.hh{
				border-style:dashed ;
				border-color:#FFFF00 ;
				border-width:3px ;
			}
			vv{font-size:3px ;
				
			}
			.uu{
				width: 60px; height: 30px; background: antiquewhite;
				margin-left:40px ;
				-moz-box-shadow:2px 2px 5px #333333; -webkit-box-shadow:2px 2px 5px #333333;
				 box-shadow:2px 2px 5px #333333;
				
				
			}
			.uu:hover{
				background-color: #7FFFD4;
				
			}
			.oo{
				width: 60px; height: 30px; background: antiquewhite;
				margin-left:20px ;
				margin-top: 5px;
				-moz-box-shadow:2px 2px 5px #333333; -webkit-box-shadow:2px 2px 5px #333333;
				 box-shadow:2px 2px 5px #333333;
			}
			.oo:hover{
				background-color: #7FFFD4;
			}
			nini{
				color: black;
			}
			.ss{
				margin-left: -20px;
				margin-top:35px ;
			}
			.pp{
				margin-top:-220px ;
				margin-left: 130px;
			}
			#shouge:hover{
				color: crimson;
			}
			button{
			margin-left:100px ;
			}
			body{
		   	background-color: #jfoe00;
		   }
			
		</style>
		
</head>
<body>
      <div class="qq">
      <div class="ww">
      <div class="ee"><b>学生管理系统</b></div>
      <form action="${pageContext.request.contextPath}/login/signIn" method="post" id="location">
      <div class="rr">
	  <div class="form-group">
	    <label for="exampleInputEmail1">用户名：</label>
	    <input type="text" name="name">
	   </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">&nbsp;&nbsp;&nbsp;密码：</label>
	    <input type="password" name="password"><br/>
	  </div>
	  验证码：<input type="text" name="checkCode">&nbsp;&nbsp;<img src="${ctx}/checkImg" id="codeImg" onclick="refreshCode()"><br>
	                              
	  <br>
	  <button type="submit" class="btn btn-default" class="uu" >登录</button>
	  </div>
	</form>
	</div>
	</div>
	
</body>
</html>