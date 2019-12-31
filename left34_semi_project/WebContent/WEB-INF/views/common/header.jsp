<%@page import="restaurant.model.vo.Restaurant, java.util.List, user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Restaurant> list = (List)request.getAttribute("foodList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="<%=request.getContextPath() %>/js/jquery-3.4.1.js"></script>
<script src="<%=request.getContextPath() %>/js/slick.min.js"></script>
<link rel="styleSheet" href="<%=request.getContextPath() %>/css/frame.css" />
<link rel="styleSheet" href="<%=request.getContextPath() %>/css/slick.css" />
<script>
$(function(){
	$('.headerImg').slick({
		  infinite: true,
		  speed: 200,
		  slidesToShow: 1,
		  adaptiveHeight: true,
		  autoplay: true,
		  autoplaySpeed: 2000
	  });
	
	var $autoSearch = $("#search_AutoSearch");
	$autoSearch.hide();
	
	$("#searchFood").on('keyup',function(e){
	
		var $sel = $(".sel");
		var $li = $autoSearch.children("li");
		
		if(e.key == "ArrowDown"){
			
			if($sel.length ==0){
				$li.first().addClass("sel");
			}
			else{
				$sel.removeClass("sel")
					.next()
					.addClass("sel")
			}
		}
		else if(e.key=='ArrowUp'){
			if($sel.length != 0){
				$sel.removeClass("sel")
					.prev()
					.addClass("sel");
			}
			else{
				$li.last().addClass("sel");
			}
		}
		else if(e.key =='Enter'){
			$(this).val($sel.text());
			$autoSearch.hide()
					   .children()
					   .remove();
		}
		else{
			var srchFoodVal =$(this).val().trim();
			
			if(srchFoodVal.length ==0) return;
			
			$.ajax({
				url:"<%=request.getContextPath()%>/restaurant/autoSearch",
				type:"get",
				data:{srchFood : srchFoodVal},
				success : function(data){
					console.log(data);
					
					if(data.trim().length==0){
						$autoSearch.hide();
					}
					else{
						var dataArr = data.split("^");
						var html = "";
						$.each(dataArr, (idx, val)=>{
							html += "<li>"+val.replace(srchFoodVal, '<span class="srchval">'+srchFoodVal+'</span>')+"</li>";
						});
						$autoSearch.html(html).fadeIn(300);
					}
				},
				error:function(jqxhr,textStatus, errorThrown){
					console.log("ajax처리실패!",jqxhr, textStatus, errorThrown);
				}
			});
		}
		
		$autoSearch.on('click','li',e=>{
			console.log($(e.target).text().search('/'));
			var $name = $(e.target).text().search('/');
			
			$('#searchFood').val($(e.target).text().substr(0,$name));
			$autoSearch.hide()
					   .children()
					   .remove();
		}).on('mouseover','li',e=>{
			$(e.target).addClass("sel")
					   .siblings()
					   .removeClass("sel");
		}).on('mouseout','li',e=>{
			$(e.target).removeClass("sel");
		});
		
	});
	/* var $recentpage = $(".recent-page");
	$recentpage.find("ul ul").hide();
	$recentpage.find("li.recent-page-title > ul").show(); */
});
function submit(){
	console.log($("#searchFood").val());
	var $searchKeyword = $("#searchFood").val().trim();
	
	if($searchKeyword.length==0){
		alert("검색어를 입력해주세요.");
		return;
	}else{
		location.href="<%=request.getContextPath()%>/searchList?searchKeyword="+$searchKeyword;
		
	}
	
}

/* $(".recent_login").on('click',function(){ */
function recentLogin(){
	<%--  if(memberLoggedIn != null){
		 alert("로그인이 필요합니다.");
		 location.href="<%=request.getContextPath()%>/uesr/uesrLogin"
		 return;
	 } --%>
	$(".recent_login").css('box-shadow','rgba(0,0,0,0.5) 0 0 0 9999px, rgba(0,0,0,0.5) 2px 2px 3px 3px').css('z-index','100');
	$.ajax({
		url:"<%=request.getContextPath()%>/restaurant/recentRestaurant?userId=ckdxor1014",
		type:"get",
		dataType:"json",
		success:data=>{
			console.log(data);
			
			let $recent = $("<div class='recent_food'></div>");
			let html="";
			
			html += "<i class='recent_triangle'></i>";
			html += "<ul><li class='active'><a href=''>최근본 맛집</a><ul>";
			
			$(data).each((idx,recent)=>{
				html += "<li><a href='<%=request.getContextPath() %>/user/userRecent?userId=ckdxor1014&&r_name="+recent.r_name+"'>";
				html += "<img class='recent_foodimg' src='<%=request.getContextPath()%>/images/"+recent.imgName+"'/></a>";
				html += "<div class='food_name'>"+recent.rName+"</div>";
				html += "<div class='food_grade'>"+recent.grade+"</div>";
				html += "<div class='food_location'>"+recent.location+"</div>";
				html += "<div class='food_type'>"+recent.type+"</div></li>";
			});
			html += "</ul></li><li><a onclick='wishRecent();' href=''>가고싶다</a>";
			html += "<ul><li><img class='recent_starimg' src='<%=request.getContextPath()%>/images/recent_star.png'/>";
			html += "<div class='wishtext'>격하게 가고싶다.</div>";
			html += "<div class='wishtext2'>식당의 '별' 아이콘을 누르면 가고싶은 곳을 쉽게 저장할 수 있습니다.</div></li></ul></li></ul>";
			html += "<div class='recentBottom'><a href='<%=request.getContextPath()%>/user/logout' class='logoutbutton'>logout</a></div>";
			
			$recent.append(html);
			$(".notice").html($recent);
			var $tab_list = $(".recent_food");
		    $tab_list.find("ul ul").hide();
		    $tab_list.find("li.active > ul").show();
		    
		    function tabMenu(e){
		        e.preventDefault();
		        var $this = $(this);
		        $this.next("ul").show().parent("li").addClass("active").siblings("li").removeClass("active").find(">ul").hide();
		    }
		    $tab_list.find("ul>li>a").click(tabMenu).focus(tabMenu);
		},
		error: (jqxhr, textStatus, errorThrown)=>{
			console.log(jqxhr, textStatus, errorThrown);
		}
	});
};

function wishRecent(){
	$.ajax({
		url:"<%=request.getContextPath()%>/restaurant/wishRestaurant?userId=ckdxor1014",
		type:"get",
		dataType:"json",
		success:data=>{
			console.log(data);
			let $recent = $("<div class='recent_food'></div>");
			let html="";
			
			html += "<i class='recent_triangle'></i>";
			html += "<ul><li ><a href='' onclick='recentLogin();'>최근본 맛집</a>";
			html += "</li><li class='active'><a onclick='wishRecent();' href=''>가고싶다</a><ul>";
			
			$(data).each((idx,recent)=>{
				html += "<li><a href='<%=request.getContextPath() %>/user/userRecent?userId=ckdxor1014&&r_name="+recent.r_name+"'>";
				html += "<img class='recent_foodimg' src='<%=request.getContextPath()%>/images/"+recent.imgName+"'/></a>";
				html += "<div class='food_name'>"+recent.rName+"</div>";
				html += "<div class='food_grade'>"+recent.grade+"</div>";
				html += "<div class='food_location'>"+recent.location+"</div>";
				html += "<div class='food_type'>"+recent.type+"</div></li>";
			});
			html += "</ul></li></ul><div class='recentBottom'><a href='<%=request.getContextPath()%>/user/logout' class='logoutbutton'>logout</a></div>";
			$recent.append(html);
			$(".notice").html($recent);
			var $tab_list = $(".recent_food");
		    $tab_list.find("ul ul").hide();
		    $tab_list.find("li.active > ul").show();
		    
		    function tabMenu(e){
		        e.preventDefault();
		        var $this = $(this);
		        $this.next("ul").show().parent("li").addClass("active").siblings("li").removeClass("active").find(">ul").hide();
		    }
		    $tab_list.find("ul>li>a").click(tabMenu).focus(tabMenu);
		},
		error: (jqxhr, textStatus, errorThrown)=>{
			console.log(jqxhr, textStatus, errorThrown);
		}
	})
}


</script>


</head>
<body>
	<div id="innerHead">
		<div class="headerWrapper">
			<div class="header_title">
				<a href="<%=request.getContextPath()%>"> 
				<img src="images/title.png" />
				</a>
			</div>
			<div class="search__SearchBlock">
				<input type="text" id="searchFood" name="searchKeyword" placeholder="지역, 식당 또는 음식을 입력하세요" />
				<ul id="search_AutoSearch"></ul>
				<span id="searchIcon"></span>
			</div>
			<span> <input type="button" class="click_SearchButton" onclick="submit();" value="검색" />
			</span>
			<h3 class="blind">급상승 검색어</h3>
			<ul class="ah_1">
				<li class="ah_item"><a href="" class="ah_a"> <span
						class="ah_r">1</span> <span class="ah_k">강남역</span>
				</a></li>
			</ul>
			<span class="ah_ico_open"></span>
			<nav>
				<div class="container">
					<ul class="tab_menu">
						<div>
							<li><a href="#">검색순위</a></li>
						</div>
						<div>
							<li><a href="#">맛집리스트</a></li>
						</div>
						<%-- 								<% if(memberLoggedIn != null && "admin".equals(memberLoggedIn.getMemberId())){ %> --%>
						<!-- <div>
									<li><a href="<%=request.getContextPath()%>/admin/adminForm">관리자페이지</a></li>
								</div> -->
						<%-- 								<%}else{ %> --%>
						<div>
							<li><a href="<%=request.getContextPath()%>/user/userForm">마이페이지</a></li>
						</div>
						<%-- <%}%> --%>

						<div>
							<li><img src="images/mypageicon.png" class="recent_login"
								onclick="recentLogin();" /></li>
						</div>
					</ul>
				</div>
			</nav>
			<div class="notice"></div>
		</div>
	</div>
	<hr class="hide">
    
    
    <div class="bodyStart">
		<div class="ImgPosition">
			<div class="headerImg">
				<div>
					<img src="images/headerimg01.png" alt="사진1">
				</div>
				<div>
					<img src="images/headerimg02.png" alt="사진1">
				</div>
				<div>
					<img src="images/headerimg03.png" alt="사진1">
				</div>
				<div>
					<img src="images/headerimg01.png" alt="사진1">
				</div>
				<div>
					<img src="images/headerimg02.png" alt="사진1">
				</div>
				<div>
					<img src="images/headerimg03.png" alt="사진1">
				</div>
			</div>
		</div>