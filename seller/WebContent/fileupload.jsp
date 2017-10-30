<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/seller/fileupload" enctype="multipart/form-data" method="post">
	seller <input type="text" name="seller"><br>
	price <input type="text" name="price"><br>
	title <input type="text" name="title"><br>
	textarea <input type="text" name="textarea"><br>
	file <input type="file" name="file"><br>
	<input type="submit" value="go">
</form>

	private String time;
	
	private String seller;
	private String product_num;
	private String price;
	
	private String title;
	private String file_name;
	private File file;
	
	private String textarea;
	private String status;

</body>
</html>