<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.4.1.js"></script>
<link rel="styleSheet" href="<%=request.getContextPath() %>/css/frame.css" />
</head>
<body>
    <header>
        <div id="innerHead">
            <div class="headerWrapper">
                <form>
                    <div class="search__SearchBlock">
                        <input type="text" placeholder="지역, 식당 또는 음식을 입력하세요">
                        <button class="search__SearchButton">
                            <span></span>
                        </button>
                    </div>
                    <div class="realtimeKeyWord_rolling_base">
                        <h3 class="blind">급상승 검색어</h3>
                        <div class="realtimeKeyWord_rolling">
                            <ul class="ah_1">
                                <li class="ah_item">
                                    <a href="" class="ah_a">
                                        <span class="ah_r">1</span>
                                        <span class="ah_k">강남역</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <span class="ah_ico_open">
​
                    </span>
​
                </form>
                <h1 class="title__TitleWrapper">
                    <a href="" class="title__Link">
                        <i class="Header__LogoIcon"></i>
                    </a>
                </h1>
                <a href="/mypage/index" class="mypage__Link">
                    <span class="mypage__Icon"></span>
                </a>
            </div>
        </div>
    </header>
    <hr class="hide">
​
    <section>
        <div>

