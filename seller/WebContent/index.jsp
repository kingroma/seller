<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="width:1280px;height:100%">
	<div style="margin-left:400px;margin-top:200px;">
		<div style="width:300px;height:200px;border:3px #abcdef solid;">
			<form action="/seller/login" method="post">
			<div style="font-size:8pt;">Login</div>
			<div style="margin-top:30px;">
				<table>
					<tr>
						<td style="width:80px;text-align:center;">ID
						</td>
						<td>
							<input style="width:150px;"type="text" name="id">
						</td>
					</tr>
					<tr>
						<td style="width:80px;text-align:center;">PW
						</td>
						<td>
							<input style="width:150px;"type="password" name="pw">
						</td>
					</tr>
				</table>
			</div>
			<div style="margin-top:30px;margin-left:40px;">
				<input type="submit" style="width:200px;height:30px;" value="login">			
			</div>
			</form>
		</div>
		
	</div>
</body>
</html>