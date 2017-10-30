<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.manager.Admin_ProductManager" %>
<%@ page import="com.manager.Admin_SellerManager" %>
<%@ page import="com.product.Product" %>
<%@ page import="com.seller.Seller" %>
<%@ page import="com.common.ManagerStaticAttribute" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.order.Order" %>
<%@ page import="com.common.Categori" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a:hover{text-decoration:none;color:#999999;}
a:link{text-decoration:none;color:#999999;}
a:active{text-decoration:none;color:#999999;}
a:visited{text-decoration:none;color:#999999;}
.product_num_span{font-size:8pt;}
</style>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script>

$(document).ready(function(){
	//alert("TEST");
	
});

function menuOnClick(num){
	
	
	//alert(num);
	
	$('#myProduct').css("display","none");
	$('#upload').css("display","none");
	$('#order_list_show').css("display","none");
	$('#wantbuy').css("display","none");
	if(num==1){
		//alert("input:  1");
		$('#myProduct').css("display","block")
	}
	else if(num==2){
		//alert("input:  2");
		$('#upload').css("display","block");
	}
	else if(num==3){
		$('#order_list_show').css("display","block");
	}
	else if(num==4){
		$('#wantbuy').css("display","block");
	}
}

function showhiddenproduct(num){
	
	if($("#hidden_fix_"+num+"").css("display")=="block")
		$(".hidden_product_detail").css("display","none");
	else{
		$(".hidden_product_detail").css("display","none");
		
		$("#hidden_fix_"+num+"").css("display","block");
	}
}
function checkForm(){
	//alert($('#upload_title').value);
	
	//var upload_textarea = $('#upload_textarea');
	
	if($('#upload_title').val()==''){
		alert("제목을 입력해주세요.");
		return false;
	}
	if($('#upload_price').val()==''){
		alert("가격을 입력해주세요.");
		return false;
	}
	if($('#upload_file').val()==''){
		alert("파일 넣어주세요");
		return false;
	}
	if($('#upload_textarea').val()==''){
		alert("내용을 입력해주세요");
		return false;
	}
	
	
	
	/*
	var upload_textarea = document.upload_textarea;
	var upload_title = document.upload_title;
	var upload_price = document.upload_price;
	var upload_file = document.upload_file;
    // 아이디 입력 유무 체크
    if(upload_title.value == '') {
        window.alert("제목을 입력하시오");
        document.upload_title.focus();
        document.getElementById('upload_title').select();
        return false; // 아이디 입력이 안되어 있다면 submint 이벤트를 중지
    }
   */

	return true;
}

function order_status_change_btn(input){
	$('.order_status_change_btn').css("display","none");
	
	if(input=='x'){
		
	}else{
		$('#order_status_change_btn_'+input+'').css("display","block");
	}
}

function order_comment_show(input){
	$('.order_comment_show_btn').css("display","none");
	
	if(input=='x'){
		
	}else{
		$('#order_comment_show_btn_'+input+'').css("display","block");
	}
}
</script>
<%
		
	
	String id =null;
	if(request.getSession().getAttribute("id")==null)
		response.sendRedirect("index.jsp");
	else
		id = request.getSession().getAttribute("id").toString();
	
	ArrayList<Product> product_list = (ArrayList<Product>)request.getAttribute("product_list");
	if(product_list==null)
		product_list = new ArrayList<Product>();
	
	String product_path = ManagerStaticAttribute.dataUrl+"/product";
	
	Seller s = (Seller)request.getAttribute("seller");
	
	Categori categori_list = new Categori();
	
	
	
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="width:1280px;height:100%;margin:0px 0px 0px 0px">
	<div id="ibody">
		<div id="header">
			<div id="topHeader" style="padding-left:50px;font-size:8pt;border-bottom:3px #abcdef solid;">
				안녕! <%=request.getSession().getAttribute("id") %> 
				
			</div>
			<div>
				<div style="margin-left:50px;font-size:9pt;">
					내가 판매중인 상품
				</div>
				<div style="width:1280px;height:150px;overflow-y:scroll;overflow-x:hidden;">
				
					<%
					for(int i = 0 ; i < product_list.size() ; i ++){
						%>
							<div style="float:left;margin-top:10px;">
								<a target="_blank" href="<%=ManagerStaticAttribute.buyerUrl %>/showproduct?product_num=<%=product_list.get(i).getProduct_num()%>">
									<span class="product_num_span"style="margin-left:30px;z-index:2">
										<%=product_list.get(i).getProduct_num() %>
									</span>
									<br>
							
								
									<img style="margin-left:30px;border:1px black solid;width:100px;height:100px;" 
									src="<%=product_path+"/"+product_list.get(i).getProduct_num()+"/"+product_list.get(i).getFile_name()%>">
								</a>
							</div>
							
						<%	}	%>
					<div style="margin-bottom:5px;">
					</div>
				</div>
			</div>
			<div style="margin-top:30px;border:2px #abcdef solid;">
			
			</div>
		</div>
		
		<div id="body">
			<div style="float:left;width:50px;height:300px;"></div>
			
			<div id="left" style="float:left;width:150px;height:200px;background-color:#bdcaef;">
				<div>
					<table style="font-size:9pt;">
						<tr>
							<td>
								<div onclick="menuOnClick(1)" style="color:white;cursor:pointer;text-align:center;width:140px;height:30px;margin-top:10px;margin-bottom:5px;">
									내상품들 보기
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div onclick="menuOnClick(2)" style="color:white;cursor:pointer;text-align:center;width:140px;height:30px;margin-top:10px;margin-bottom:5px;">
									상품 올리기
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div onclick="menuOnClick(3)" style="color:white;cursor:pointer;text-align:center;width:140px;height:30px;margin-top:10px;margin-bottom:5px;">
									주문 내역
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div onclick="menuOnClick(4)" style="color:white;cursor:pointer;text-align:center;width:140px;height:30px;margin-top:10px;margin-bottom:5px;">
									판매 문의
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="right" style="float:left;width:1000px;height:100%;background-color:#e2e2e2;">
				<div id="myProduct" style="display:block;">
					<div>
						<div style="margin-left:5px;margin-top:5px;font-size:6pt;">내상품들보기</div>
					</div>
					<div>
						<table style="font-size:8pt;">
							<tr>
								<td style="width:1px;height:1px;"></td>
								<td style="font-size:9pt;text-align:center;width:120px;height:15px;">
									올린시간
								</td>
								<td style="font-size:9pt;text-align:center;width:100px;height:15px;">
									상품번호
								</td>
								<td style="font-size:9pt;text-align:center;width:50px;height:15px">
									상태
								</td>
								<td style="font-size:9pt;text-align:center;width:100px;height:15px;">
									카테고리
								</td>
								<td style="font-size:9pt;text-align:center;width:200px;height:15px;">
									제목
								</td>
								<td style="font-size:9pt;text-align:center;width:100px;height:15px;">
									가격
								</td>
								<td style="font-size:9pt;text-align:center;width:200px;height:15px;">
									내용
								</td>
								<td style="font-size:9pt;text-align:center;width:50px;height:15px;">
									수정
								</td>
								
							</tr>
							<%for(int i = product_list.size()-1 ; i >= 0 ; i--){
								if(product_list.get(i).getCategori()==null)
									product_list.get(i).setCategori("null");
								%>
								<tr style="border:1px black solid;">
									<td style="width:1px;height:1px;">
										<div id="hidden_fix_<%=product_list.get(i).getProduct_num()%>" class="hidden_product_detail" style="display:none;margin-top:5px;position:absolute;width:600px;height:400px;z-index:2;background-color:white;border:2px #abcdef groove;">
											<div style="padding-left:20px;padding-top:20px;">
												<div>
													<span style="font-size:8pt"><%=product_list.get(i).getProduct_num() %></span>
													<span onclick="showhiddenproduct('<%=product_list.get(i).getProduct_num() %>')" style="cursor:pointer;width:50px;height:20px;margin-left:500px">창닫기</span>
													<form method="post" action = "/seller/fixproduct">
														<input type="text" style="display:none;" name="seller_name" value="<%=id%>">
														<input type="text" style="display:none;" name="product_num" value="<%=product_list.get(i).getProduct_num()%>">
														<table>
															<tr>
																<td style="width:150px;height:20px;text-align:center;">
																	제목 : 
																</td>
																<td>
																	<input name="title" style="width:200px;height:20px;"type="text" value="<%=product_list.get(i).getTitle()%>">
																</td>
															</tr>
															<tr>
																<td style="width:150px;height:20px;text-align:center;">
																	가격 : 
																</td>
																<td>
																	<input name="price"style="width:100px;height:20px;"type="text" value="<%=product_list.get(i).getPrice()%>">
																</td>
															</tr>
															<tr>
																<td style="width:150px;height:20px;text-align:center;">
																	카테고리 : 
																</td>
																<td>
																	<%
																	String list_categori = product_list.get(i).getCategori();
																	
																	%>
																	<input name="categori" style="" type="radio" value="<%=categori_list.getList().get(0)%>" 
																	<%
																	if(list_categori.equals(categori_list.getList().get(0))){
																		%>checked<%
																	}
																	%>><%=categori_list.getList().get(0)%>
																	<input name="categori" style="margin-left:20px;" type="radio" value="<%=categori_list.getList().get(1)%>"
																	<%
																	if(list_categori.equals(categori_list.getList().get(1))){
																		%>checked<%
																	}
																	%>>
																	<%=categori_list.getList().get(1)%>
																	<input name="categori" style="margin-left:20px;" type="radio" value="<%=categori_list.getList().get(2)%>"
																	<%
																	if(list_categori.equals(categori_list.getList().get(2))){
																		%>checked<%
																	}
																	%>
																	><%=categori_list.getList().get(2)%>
															
																</td>
															</tr>
															
															<tr>
																<td style="width:150px;height:20px;text-align:center;">
																	상태 : [[<%if(product_list.get(i).getStatus().equals("ing")){
																		%>판매중<%
																	}else {%>판매완료<%} %>]]
																</td>
																<td>
																	
																	<input name="status"style="" type="radio" value="ing"
																	<%if(product_list.get(i).getStatus().equals("ing")){ 
																	//%> 
																	checked
																	<%} %>
																	> 판매중
																	
																	<input name="status"style="" type="radio" value="finish"
																	<%if(product_list.get(i).getStatus().equals("finish")){ 
																	//%> 
																	checked
																	<%} %>
																	>판매완료
																</td>
															</tr>
														</table>
														<div>
															<textarea name="textarea" style="font-size:9pt;width:500px;height:200px;resize:none;"><%=product_list.get(i).getTextarea()%></textarea>
														</div>
														<div>
															<input style="margin-top:10px;margin-left:400px;width:150px;height:30px;"type="submit" value="고쳐 올리기">
														</div>
														
													</form>
												</div>
											</div>
										</div>
									</td>
									<td style="border:1px white solid;text-align:center;">
										<div style="width:120px;height:15px;overflow:hidden;"><%=product_list.get(i).getTime() %></div>
									</td>		
									<td style="border:1px white solid;text-align:center;">
										<div style="width:100px;height:15px;overflow:hidden;"><%=product_list.get(i).getProduct_num() %></div>
									</td>
									<td style="border:1px white solid;text-align:center;">
										<div style="width:50px;height:15px;overflow:hidden;">
										<%if(product_list.get(i).getStatus().equals("ing")){
											%>판매중<%
										}else{%>판매완료<%}
										%>
										</div>
									</td>
									
									<td style="border:1px white solid;text-align:center;">
										<div style="width:100px;height:15px;overflow:hidden;"><%=product_list.get(i).getCategori() %></div>
									</td>
									<td style="border:1px white solid;text-align:center;">
										<div style="width:200px;height:15px;overflow:hidden;"><a title="상품 페이지 바로가기"style="color:black;text-decoration:underline;"target="_blank" href="<%=ManagerStaticAttribute.buyerUrl %>/showproduct?product_num=<%=product_list.get(i).getProduct_num()%>"><%=product_list.get(i).getTitle() %></a></div>
									</td>
									<td style="border:1px white solid;text-align:center;">
										<div style="width:100px;height:15px;overflow:hidden;"><%=product_list.get(i).getPrice() %></div>
									</td>
									<td style="resize: none;width:100px;height:15px;border:1px white solid;text-align:center;overflow:hidden;">
										<div style="overflow:hidden;width:199px;height:15px;"><%=product_list.get(i).getTextarea() %></div>
									</td>
									<td style="align:center;border:1px white solid;">
										<button onclick="showhiddenproduct('<%=product_list.get(i).getProduct_num() %>')" style="width:50px;height:15px;font-size:7pt;">수정</button>
									</td>
								</tr>
								<%
							}
							%>
							<tr>
								
							</tr>
						</table>
						<div style="margin-top:3px;margin-bottom:3px;">
						
						</div>
					</div>
				</div>
				<!-- 내상품 보기  -->
				
				<!-- 상품 올리기  -->
				<div id="upload" style="display:none;">
					<div>
						<form id="upload_form" action="/seller/fileupload" enctype="multipart/form-data" method="post" onsubmit="return checkForm();">
							<!-- seller <input type="text" name="seller"><br> -->
							<table style="font-size:8pt">
								<tr>
									<td style="width:100px;height:15px;text-align:center">
										제목
									</td>
									<td>
										<input id="upload_title" style="width:300px;height:15px;"type="text" name="title">
									</td>
								</tr>
								<tr>
									<td style="width:100px;height:15px;text-align:center">
										가격
									</td>
									<td>
										<input id="upload_price" style="width:100px;height:15px;"type="text" name="price">
									</td>
								</tr>
								<tr>
									<td style="width:100px;height:15px;text-align:center">
										카테고리
									</td>
									<td>
										
										<input name="categori" style="" type="radio" value="<%=categori_list.getList().get(0)%>" checked><%=categori_list.getList().get(0)%>
										<input name="categori" style="margin-left:20px;" type="radio" value="<%=categori_list.getList().get(1)%>"><%=categori_list.getList().get(1)%>
										<input name="categori" style="margin-left:20px;" type="radio" value="<%=categori_list.getList().get(2)%>"><%=categori_list.getList().get(2)%>
										
									</td>
								</tr>
								<tr>
									<td style="width:100px;height:30px;text-align:center">
										파일
									</td>
									<td>
										<input id="upload_file" style="width:200px;height:30px;"type="file" name="file"><span style="font-size:7pt;color:red">*이미지파일만 / 무조건 올려야함</span>
										
									</td>
								</tr>
							</table>
							<div style="margin-left:50px;">
								<textarea id="upload_textarea" name="textarea" style="font-size:9pt;width:500px;height:200px;resize:none;"></textarea>
							</div>
							<!-- 
								title <input type="text" name="title"><br>
								price <input type="text" name="price"><br>
								file <input type="file" name="file"><br>												
								textarea <input type="text" name="textarea"><br>
							 -->
							<div style="margin-left:600px;">
								<input type="submit" value="올리기">
							</div>
							
							<div style="margin-top:20px;margin-bottom:20px;">
							</div>
						</form>
					</div>
				</div>
				<!-- 상품올리기 -->
				
				<%
				//product_list
				ArrayList<Order> order_list = s.getOrder();
				
				%>	
				<!-- 주문 내역 -->
				<div id="order_list_show" style="display:none;">
					주문 내역<br>
					<%for(int i = 0 ; i < product_list.size() ; i ++){
						
						%>
						<table style="font-size:9pt;">
							<tr>
								<td style="width:100px;text-align:center;">
									상품번호 : <%=product_list.get(i).getProduct_num() %>
								</td>
								<td style="width:100px;text-align:center;">
									카테고리 : <%=product_list.get(i).getCategori() %>
								</td>
								<td style="width:100px;text-align:center;">
									가격 : <%=product_list.get(i).getPrice() %>
								</td>
								<td style="width:200px;text-align:center;">
									제목 : <%=product_list.get(i).getTitle() %>
								</td>
							</tr>
						</table>
						
						<%
						if(order_list!=null){
							for(int j = 0 ; j < order_list.size() ; j ++){
								if(product_list.get(i).getProduct_num().equals(order_list.get(j).getProduct_num())){
									%>
									<table style="font-size:9pt;margin-left:30px;">
										<tr>
											<td>
												<span style="font-size:9pt;color:#abcdef">▶</span>
											</td>
											<td style="border:1px dotted white;width:150px;height:20px;overflow:hidden;">
												[주문일]<br><%=order_list.get(j).getOrder_date() %>
											</td>
											<td style="border:1px dotted white;width:100px;height:20px;overflow:hidden;">
												[주문번호]<br><%=order_list.get(j).getOrder_num() %>
											</td>
											<td style="border:1px dotted white;width:150px;height:20px;overflow:hidden;"> 
												[구매자]<br><%=order_list.get(j).getBuyer() %>(<%=order_list.get(j).getBuyer_phone() %>)
												<div style="position:absolute;display:none;">
													
												</div>
											</td>
											<td style="border:1px dotted white;width:170px;">
												[언급내용]<br><%=order_list.get(j).getOrder_comment() %>
											</td>
											<td style="border:1px dotted white;width:100px;height:20px;overflow:hidden;">
												[언급가격]<br><%=order_list.get(j).getPrice() %>
											</td>
											<td style="border:1px dotted white;width:80px;height:20px;overflow:hidden;">
											<%if(order_list.get(j).getStatus().equals("ing")){
												%>
												주문 확인중
												<br>
												<button onclick="order_status_change_btn('<%=order_list.get(j).getOrder_num()%>')" 
												style="width:70px;"type="button" >변경</button>
												<div class="order_status_change_btn" 
												id="order_status_change_btn_<%=order_list.get(j).getOrder_num() %>" 
												style="display:none;position:absolute; width:130px;height:85px;background-color:white;border:1px solid black;padding:3px;">
												<div style="height:20px;text-align:right;"><button onclick="order_status_change_btn('x')">X</button></div>
													<div>
														<form method="post" action="/seller/orderstatuschange">
															<input type="text" style="display:none" value="<%=order_list.get(j).getOrder_num() %>" name="order_num">
															<input type="text" style="display:none" value="<%=order_list.get(j).getBuyer() %>" name="buyer_id">
															<input type="text" style="display:none" value="<%=order_list.get(j).getSeller() %>" name="seller_id">
															<input type="text" style="display:none" value="<%=order_list.get(j).getProduct_num() %>" name="product_num">
															취소 : <input type="radio" name="status_radio" value="cancel" checked> 
															<br>
															거래 종료 : <input type="radio" name="status_radio" value="done"><br>
															<div style="text-align:right">
																<input type="submit" value="변경">	
															</div>
														</form>
													</div>
												</div>
												<%
											} %>
											<%if(order_list.get(j).getStatus().equals("cancel")){
												%>
												<span style="color:red;">취소됨</span>
												<%
											} %>
											<%if(order_list.get(j).getStatus().equals("done")){
												%>
												<span style="color:green;">거래 종료</span>
												<%
											} %>
											</td>
											<td style="border:1px dotted white;width:80px;height:40px;overflow:hidden;">
												<button onclick="order_comment_show('<%=order_list.get(j).getOrder_num() %>')" style="font-size:9pt;width:80px;height:40px;">문의글
												<br>보기
												<%if(order_list.get(j).getComment()!=null){ 
													int order_list_size_check_num = 0;
													
													for(int order_list_size_check = 0 ; order_list_size_check < order_list.get(j).getComment().size() ; order_list_size_check++){
														if(order_list.get(j).getComment().get(order_list_size_check).getReply().equals("")|
																order_list.get(j).getComment().get(order_list_size_check).getReply().equals(" ")){
															order_list_size_check_num++;
														}
													}
												%>
													(<span style="color:red;">
													<%=order_list_size_check_num%></span>)
												<%} %>
												</button>
											</td>
										</tr>
									</table>
									<div class="order_comment_show_btn" id="order_comment_show_btn_<%=order_list.get(j).getOrder_num() %>" 
									style="display:none;margin-left:550px;position:absolute;width:400px;padding-top:10px;padding-bottom:10px;background-color:white;border:1px dotted black;">
										<div style="padding:10px;">
											<!-- <form> -->
												<!-- //comment 정보 정리하기 -->
												<div style="text-align:right;">
													<button onclick="order_comment_show('x')">X</button>
												</div> 
												<%if(order_list.get(j).getComment()!=null){ 
													
												%>
													
													<%for(int z = 0 ; z < order_list.get(j).getComment().size() ; z ++){ %>
														<table style="border:1px solid black;margin-top:5px;margin-bottom:5px;font-size:8pt;">
															<tr>
																<td style="text-align:center;width:80px;">
																	문의 내용 :
																</td>
																<td style="width:300px;">
																	<%if(order_list.get(j).getComment().get(z).getTextarea()!=null){ %>
																		<%=order_list.get(j).getComment().get(z).getTextarea() %>
																	<%} %>
																</td>
															</tr>
															
															<tr>
																<td style="text-align:center;width:80px;">
																	▶답변 : 
																</td>
																<td style="width:300px;">
																	<%
																	if(order_list.get(j).getComment().get(z).getReply()!=null|order_list.get(j).getComment().get(z).getReply().equals("")){%>
																		<div><%=order_list.get(j).getComment().get(z).getReply() %></div>
																	<%} 
																	else
																	{
																		%><input type="text" style="width:100px;"><%
																	}
																	%>
																	<div style="">
																	</div>
																</td>
															</tr>
															<tr>
																<td style="text-align:center;width:80px;">
																	답변변경 : 
																</td>
																<td>
																	<form action="/seller/replyorder" method="post">
																	
																		<input style="display:none;" name="seller_id" value="<%=order_list.get(j).getSeller() %>"> 
																		<input style="display:none;" name="buyer_id" value="<%=order_list.get(j).getBuyer() %>">
																		<input style="display:none;" name="product_num" value="<%=order_list.get(j).getProduct_num() %>">
																		<input style="display:none;" name="order_num" value="<%=order_list.get(j).getOrder_num() %>">
																		
																		<input style="display:none;" name="order_comment_num" value="<%=z %>">
																		
																		<input style="width:200px;height:20px;" type="text" name="reply" value=" ">
																		<input type="submit" style="font-size:8pt;width:40px;height:20px;"value="완료">
																	</form>
																</td>
															</tr>
															
														</table>
													<%} %>
												<%} %>
												
											<!-- </form> -->
										</div>
									</div>
								<%
									
								}
							}
						}
					}%>
					
					<div style="margin-bottom:20px;">
					</div>
				</div>
				<!-- 주문 내역 -->
				
				<!-- 판매 문의글 -->
				<div id="wantbuy"style="display:none;">
					판매 문의글 want buy
				</div> 
				<!-- 판매 문의글 -->
			</div>
			
			
			<div id="center" style="float:right;width:1px;height:300px;background-color:yellow;">
				
			</div>
		</div>
	</div>
</body>
</html>