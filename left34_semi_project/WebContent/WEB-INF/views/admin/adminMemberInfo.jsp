<%@page import="user.model.vo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%List<User> list=(List<User>)request.getAttribute("list");
String pageBar=(String)request.getAttribute("pageBar");
User user1=(User)request.getAttribute("user1");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css"/>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>

<script>
$(function(){

	var $autoComplete = $("#autoComplete");
	$autoComplete.hide();//페이지 최초 로딩시 조회결과 ul태그는 안보임처리한다.
	
	$("#srchName").on('keyup', function(e){
		//방향키 제어 ArrowDown, ArrowUp, Enter
		console.log(e.key);
		
		var $sel = $(".sel");
		var $li = $autoComplete.children("li");

		if(e.key == 'ArrowDown'){
			
			if($sel.length == 0){
				$li.first().addClass("sel");
			}
			else{
				$sel.removeClass("sel")
					.next()
					.addClass("sel");
			}
		}
		else if(e.key == 'ArrowUp'){
			if($sel.length != 0){
				$sel.removeClass("sel")
					.prev()
					.addClass("sel");
			}
			else{
				$li.last().addClass("sel");
			}
			
		}
		else if(e.key == 'Enter'){
			var $mem = $("#tbl-find-Member");

			$mem.children().first().children().next().remove();
			$(this).val('');
			var test=$sel.text().split(':');
			console.log(test);
			var id=test[1].substr(0,test[1].indexOf('이름')-2);
			var name=test[2].substr(0,test[2].indexOf('성별')-2);
			var gender=test[3].substr(0,test[3].indexOf('나이')-2);
			var age=test[4].substr(0,test[4].indexOf('주소')-2);
			var address=test[5].substr(0,test[5].indexOf('전화번호')-2);
			var phone=test[6];
			var gender
			console.log(id);
			$autoComplete.hide()
						 .children()
						 .remove();
			var html='';
			html += "<tr><td>"+id+'</td>';
			html += "<td>"+name+'</td>';
			html += "<td>"+gender+'</td>';
			html += "<td>"+age+'</td>';
			html += "<td>"+address+'</td>';
			html += "<td>"+phone+'</td></tr>';
			$mem.children().first().append(html);
<%-- 			location.href="<%=request.getContextPath()%>/admin/Idfind?id="+id; --%>
		}
		else {
			var srchNameVal = $(this).val().trim();
			
			//공백 입력시 ajax요청 보내지 않음.
			if(srchNameVal.length == 0) return;
			
			$.ajax({
				url: "<%=request.getContextPath()%>/admin/UserFind",
				type: "post",
				//data: "srchName="+srchNameVal,
				data: {srchName: srchNameVal},//객체로 전달해도 jquery가 직렬화처리
				success: function(data){
					console.log(data);

					//조회된 결과가 없는 경우
					if(data.length==0){
						$autoComplete.hide();
						console.log("hide");
					}
					//조회결과가 있는 경우
					else{					
						var html = "";
						$(data).each((idx, user) => {
						
// 							html += '<li><span class="srchval">'+user.name+'</span></li>';
							
							console.log(user.age);
							html += "<li> 아이디:"+(user.id).replace(srchNameVal, '<span class="srchval">'+srchNameVal+'</span>');
							html += "&nbsp&nbsp이름:"+(user.name).replace(srchNameVal, '<span class="srchval">'+srchNameVal+'</span>');
							html += "&nbsp&nbsp성별:"+(user.gender).replace(srchNameVal, '<span class="srchval">'+srchNameVal+'</span>');
							html += "&nbsp&nbsp나이:"+(user.age).replace(srchNameVal, '<span class="srchval">'+srchNameVal+'</span>');
							html += "&nbsp&nbsp주소:"+(user.address).replace(srchNameVal, '<span class="srchval">'+srchNameVal+'</span>');
							html += "&nbsp&nbsp전화번호:"+(user.phone).replace(srchNameVal, '<span class="srchval">'+srchNameVal+'</span>')+"</li>";

							console.log(user.name);
						});
						$autoComplete.append().html(html).fadeIn(300);
						
						
					}
				},
				error: function(jqxhr, textStatus, errorThrown){
					console.log("ajax처리실패!", jqxhr, textStatus, errorThrown);
				}
			});//end of $.ajax
			
			
		}//end of else
	
		
			
		//이벤트버블링(자식 =>부모)을 이용한 처리
		//요소를 선택한 경우
		$autoComplete.on('click', 'li', e => {
			//화살표함수 내에서 this는 무조건 window
			$("#srchName").val($(e.target).text());
			var $mem = $("#tbl-find-Member");

			$mem.children().first().children().next().remove();
			$(this).val('');
			var test=$(e.target).text().split(':');
			console.log(test);
			var id=test[1].substr(0,test[1].indexOf('이름')-2);
			var name=test[2].substr(0,test[2].indexOf('성별')-2);
			var gender=test[3].substr(0,test[3].indexOf('나이')-2);
			var age=test[4].substr(0,test[4].indexOf('주소')-2);
			var address=test[5].substr(0,test[5].indexOf('전화번호')-2);
			var phone=test[6];
			var gender
			console.log(id);
			$autoComplete.hide()
						 .children()
						 .remove();
			var html='';
			html += "<tr><td>"+id+'</td>';
			html += "<td>"+name+'</td>';
			html += "<td>"+gender+'</td>';
			html += "<td>"+age+'</td>';
			html += "<td>"+address+'</td>';
			html += "<td>"+phone+'</td></tr>';
			$mem.children().first().append(html);
		}).on('mouseover','li', e=>{
			$(e.target).addClass("sel")
					   .siblings()
					   .removeClass("sel");
		}).on('mouseout','li', e=>{
			$(e.target).removeClass("sel");
		});		
	});
});
</script>
<section id="InfoFind-containter">
	<h2>[검색된 회원 정보]</h2>
	<div class="wrapper">
		<input type="text" id="srchName" />
		
		<ul id="autoComplete"></ul>
	</div>
	<table id="tbl-find-Member">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>성별</th>
		<th>나이</th>
		<th>주소</th>
		<th>전화번호</th>
	
		</tr>
		<%if(user1!=null){ %>
		<tr>
		<td><%=user1.getUserId() %></td>
		<td><%=user1.getName() %></td>
		<td><%=user1.getGender() %></td>
		<td><%=user1.getAge() %></td>
		<td><%=user1.getAddress() %></td>
		<td><%=user1.getPhone()%></td>
		</tr>
		<%} %>
		
	</table>
	
</section>
<section id="Info-containter">
	<h2>[가입회원 정보]</h2>
	<table id="tbl-Member">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>성별</th>
		<th>나이</th>
		<th>주소</th>
		<th>전화번호</th>	
		</tr>
		<%for(User u:list){ %>
		<tr>
		<td><%=u.getUserId() %></td>
		<td><%=u.getName() %></td>
		<td><%=u.getGender() %></td>
		<td><%=u.getAge() %></td>
		<td><%=u.getAddress() %></td>
		<td><%=u.getPhone()%></td>
		</tr>
		<%} %>
		
	</table>
	<div id='pageBar'>
	<%=pageBar %>
	</div>
</section>



