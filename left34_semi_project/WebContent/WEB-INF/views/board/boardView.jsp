<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!DOCTYPE html>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/frame.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/boardView.css" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4d9befe9bbff1160082ea828e900ce9c"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer"></script>
<body class="ng-scope">
    <main class="pg-restaurant ng-scope">
        <article class="contents">
            <!-- 레스토랑 상세 이미지 슬라이드 -->
            <aside class="restaurant-photos">
                <div class="list-photo_wrap owl-carousel owl-theme" style="opacity: 1; display: block;">
                    <div class="owl-wrapper-outer">
                        <div class="owl-wrapper" style="width: 3000px; left: 0px; display: block; transition: all 0ms ease 0s; transform: translate3d(0px, 0px, 0px);">
                            <div class="owl-item" style="width: 300px;">
                                <figure class="list-photo">
                                    <figure class="restaurant-photos-item">
                                        <img src="https://mp-seoul-image-production-s3.mangoplate.com/268918/512536_1490184275055_16308?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80" alt="" class="center-croping" onerror="">
                                        <div class="last_image">
                                            <p class="txt">
                                                                        
                                            사진 더보기
                    
                                            </p>
                                            <span class="arrow-white"></span>
                                        </div>
                                    </figure>
                                </figure>
                            </div>
                            <div class="owl-item" style="width: 300px;">
                                <figure class="list-photo">
                                    <figure class="restaurant-photos-item" role="img">
                                        <img src="https://mp-seoul-image-production-s3.mangoplate.com/479674_1577394694974854.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80" alt="" class="center-croping">
                                        <div class="last_image">
                                            <p class="txt">
                                                
                                            사진 더보기
                    
                                            </p>
                                            <span class="arrow-white"></span>
                                        </div>
                                    </figure>
                                </figure>
                            </div>
                            <div class="owl-item" style="width: 300px;">
                                <figure class="list-photo">
                                    <figure class="restaurant-photos-item" role="img">
                                        <img src="https://mp-seoul-image-production-s3.mangoplate.com/479674_1577394697152263.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80" alt="" class="center-croping">
                                        <div class="last_image">
                                            <p class="txt">
                                                
                                            사진 더보기
                    
                                            </p>
                                            <span class="arrow-white"></span>
                                        </div>
                                    </figure>
                                </figure>
                            </div>
                            <div class="owl-item" style="width: 300px;">
                                <figure class="list-photo">
                                    <figure class="restaurant-photos-item" role="img">
                                        <img src="https://mp-seoul-image-production-s3.mangoplate.com/479674_1577394698145112.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80" alt="" class="center-croping">
                                        <div class="last_image">
                                            <p class="txt">
                                                
                                            사진 더보기
                    
                                            </p>
                                            <span class="arrow-white"></span>
                                        </div>
                                    </figure>
                                </figure>
                            </div>
                            <div class="owl-item" style="width: 300px;">
                                <figure class="list-photo">
                                    <figure class="restaurant-photos-item" role="img">
                                        <img src="https://mp-seoul-image-production-s3.mangoplate.com/479674_1577394698795774.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80" alt="" class="center-croping">
                                        <div class="last_image">
                                            <p class="txt">
                                                
                                            사진 더보기
                    
                                            </p>
                                            <span class="arrow-white"></span>
                                        </div>
                                    </figure>
                                </figure>
                            </div>
                        </div>
                    </div>
                    <div class="owl-controls clickable" style="display: block;">
                        <div class="owl-buttons">
                            <div class="owl-prev">
                                <button class="btn-nav prev" style="display: none;"></button>
                            </div>
                            <div class="owl-next">
                                <button class="btn-nav next"></button>
                            </div>
                        </div>
                    </div>
                </div>
            </aside>
            
            <!-- 레스토랑 상세 정보 -->
            <div class="column-wrapper">
                
                <!-- 컨텐츠 영역 -->
                <div class="column-contents">
                    <div class="inner">
                        <!-- 레스토랑 상세 -->
                        <section class="restaurant-detail">
                            <header>
                                <div class="restaurant_title_wrap">
                                    <span class="title">
                                            <h1 class="restaurant_name">백정돈공장</h1>
                                        <strong class="rate-point">
                                            <span>4.6</span>
                                        </strong>
                                        <p class="branch"></p>
                                    </span>
                                    <div class="restaurant_action_button_wrap">
                                        <button class="review_writing_button">
                                            <i class="review_writing_button_icon"></i>
                                            <span class="review_writing_button_text">리뷰쓰기</span>
                                        </button>
                                        <div class="wannago_wrap">
                                            <button class="btn-type-icon favorite wannago_btn " data-restaurant_uuid="268918" data-action_id=""></button>
                                            <p class="wannago_txt">가고싶다</p>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="status
                                branch_none
                                ">
                                <span class="cnt hit">11,871</span>
                                <span class="cnt review">10</span>
                                <span class="cnt favorite">413</span>
                              </div>
                            </header>

                                <!-- 상세 정보 -->
                                <table class="info no_menu">
                                <caption>레스토랑 상세 정보</caption>

                                <tbody>
                                <tr class="only-desktop">
                                    <th>주소</th>
                                    <td>서울시 성동구 성수동2가 310-1</td>
                                </tr>

                                <tr class="only-desktop">
                                    <th>전화번호</th>
                                    <td>02-462-8295</td>
                                </tr>

                                <tr>
                                    <th>음식 종류</th>
                                    <td>
                                    <span>고기 요리</span>
                                    </td>
                                </tr>

                                <tr>
                                    <th>가격대</th>
                                    <td>만원-2만원</td>
                                </tr>

                                <tr>
                                    <th>주차</th>
                                    <td>주차공간없음 </td>
                                </tr>

                                <tr>
                                    <th style="vertical-align:top;">영업시간</th>
                                    <td>17:00 - 24:00</td>
                                </tr>

                                <tr>
                                    <th>휴일</th>
                                    <td>일</td>
                                </tr>

                                </tbody>
                            </table>

                                <p class="update_date">
                                업데이트
                                : 2019. 5. 31
                                </p>

                            <div id="reviewListFocusId"></div>

                        </section>
                        <section class="restaurant_introduce_section">
                            <div class="RestaurantIntroduceSection"></div>
                        </section>
                    </div>
                </div>
                
                <!-- 사이드 영역 -->
                <div class="side-wrap">
                    <div class="column-side">
                        <!--지도-->
                        <div class="map-container" style="position: relative; overflow: hidden; background: url('https://https://ssl.pstatic.net/static/maps/mantle/1x/pattern_1.png') 0px 0px repeat transparnet;">
                            <div class="map_layer" id="map">
                                <script>
                                // 이미지 지도에서 마커가 표시될 위치입니다 
                                var markerPosition  = new kakao.maps.LatLng(37.545405, 127.050109); 

                                // 이미지 지도에 표시할 마커입니다
                                // 이미지 지도에 표시할 마커는 Object 형태입니다
                                var marker = {
                                    position: markerPosition
                                };

                                var staticMapContainer  = document.getElementById('map'), // 이미지 지도를 표시할 div  
                                    staticMapOption = { 
                                        center: new kakao.maps.LatLng(37.545405, 127.050109), // 이미지 지도의 중심좌표
                                        level: 3, // 이미지 지도의 확대 레벨
                                        marker: marker // 이미지 지도에 표시할 마커 
                                    };    

                                // 이미지 지도를 생성합니다
                                var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
                                </script>
                            </div>
                        </div>
                        <div class="inner">
                            <!-- 주변 인기 식당 -->
                            <section class="module near-rastaurant NearByRestaurantList">
                                <span class="title NearByRestaurantList__Title">주변 인기 식당</span>
                                <ul class="list-restaurants type-single NearByRestaurantList__List">
                                    <li class="NearByRestaurantItem NearByRestaurantList__Item">
                                        <div class="NearByRestaurantItem__PictureAndContent">
                                            <a href="" class="NearByRestaurantItem__PictureLink">
                                                <img alt="" class="NearByRestaurantItem__Picture loaded" src="https://mp-seoul-image-production-s3.mangoplate.com/49369_1428403105589?fit=around|383:383&crop=383:383;*,*&output-format=jpg&output-quality=80" data-was-processed="true">
                                            </a>
                                            <div class="NearByRestaurantItem__Content">
                                                <div class="NearByRestaurantItem__NameWrap">
                                                    <a href="" class="NearByRestaurantItem__Name">소문난성수감자탕</a>
                                                    <span class="NearByRestaurantItem__Rating">4.1</span>
                                                </div>
                                                <div class="NearByRestaurantItem__MetroAndCuisine">
                                                    <span class="NearByRestaurantItem__Metro">왕십리/성동</span>
                                                    <span class="NearByRestaurantItem__SubCuisine">탕 / 찌개 / 전골</span>
                                                </div>
                                                <div class="NearByRestaurantItem__InfoWrap">
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            음식 종류
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--SubCuisine">탕 / 찌개 / 전골</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            위치
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--Metro">왕십리 / 성동</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            가격대
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--PriceRange">만원 미만</dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="NearByRestaurantItem NearByRestaurantList__Item">
                                        <div class="NearByRestaurantItem__PictureAndContent">
                                            <a href="" class="NearByRestaurantItem__PictureLink">
                                                <img alt="" class="NearByRestaurantItem__Picture loaded" src="https://mp-seoul-image-production-s3.mangoplate.com/49369_1428403105589?fit=around|383:383&crop=383:383;*,*&output-format=jpg&output-quality=80" data-was-processed="true">
                                            </a>
                                            <div class="NearByRestaurantItem__Content">
                                                <div class="NearByRestaurantItem__NameWrap">
                                                    <a href="" class="NearByRestaurantItem__Name">소문난성수감자탕</a>
                                                    <span class="NearByRestaurantItem__Rating">4.1</span>
                                                </div>
                                                <div class="NearByRestaurantItem__MetroAndCuisine">
                                                    <span class="NearByRestaurantItem__Metro">왕십리/성동</span>
                                                    <span class="NearByRestaurantItem__SubCuisine">탕 / 찌개 / 전골</span>
                                                </div>
                                                <div class="NearByRestaurantItem__InfoWrap">
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            음식 종류
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--SubCuisine">탕 / 찌개 / 전골</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            위치
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--Metro">왕십리 / 성동</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            가격대
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--PriceRange">만원 미만</dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="NearByRestaurantItem NearByRestaurantList__Item">
                                        <div class="NearByRestaurantItem__PictureAndContent">
                                            <a href="" class="NearByRestaurantItem__PictureLink">
                                                <img alt="" class="NearByRestaurantItem__Picture loaded" src="https://mp-seoul-image-production-s3.mangoplate.com/49369_1428403105589?fit=around|383:383&crop=383:383;*,*&output-format=jpg&output-quality=80" data-was-processed="true">
                                            </a>
                                            <div class="NearByRestaurantItem__Content">
                                                <div class="NearByRestaurantItem__NameWrap">
                                                    <a href="" class="NearByRestaurantItem__Name">소문난성수감자탕</a>
                                                    <span class="NearByRestaurantItem__Rating">4.1</span>
                                                </div>
                                                <div class="NearByRestaurantItem__MetroAndCuisine">
                                                    <span class="NearByRestaurantItem__Metro">왕십리/성동</span>
                                                    <span class="NearByRestaurantItem__SubCuisine">탕 / 찌개 / 전골</span>
                                                </div>
                                                <div class="NearByRestaurantItem__InfoWrap">
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            음식 종류
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--SubCuisine">탕 / 찌개 / 전골</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            위치
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--Metro">왕십리 / 성동</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            가격대
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--PriceRange">만원 미만</dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="NearByRestaurantItem NearByRestaurantList__Item">
                                        <div class="NearByRestaurantItem__PictureAndContent">
                                            <a href="" class="NearByRestaurantItem__PictureLink">
                                                <img alt="" class="NearByRestaurantItem__Picture loaded" src="https://mp-seoul-image-production-s3.mangoplate.com/49369_1428403105589?fit=around|383:383&crop=383:383;*,*&output-format=jpg&output-quality=80" data-was-processed="true">
                                            </a>
                                            <div class="NearByRestaurantItem__Content">
                                                <div class="NearByRestaurantItem__NameWrap">
                                                    <a href="" class="NearByRestaurantItem__Name">소문난성수감자탕</a>
                                                    <span class="NearByRestaurantItem__Rating">4.1</span>
                                                </div>
                                                <div class="NearByRestaurantItem__MetroAndCuisine">
                                                    <span class="NearByRestaurantItem__Metro">왕십리/성동</span>
                                                    <span class="NearByRestaurantItem__SubCuisine">탕 / 찌개 / 전골</span>
                                                </div>
                                                <div class="NearByRestaurantItem__InfoWrap">
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            음식 종류
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--SubCuisine">탕 / 찌개 / 전골</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            위치
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--Metro">왕십리 / 성동</dd>
                                                    </dl>
                                                    <dl class="NearByRestaurantItem__Info">
                                                        <dt class="NearByRestaurantItem__InfoLabel">
                                                            가격대
                                                        </dt>
                                                        <dd class="NearByRestaurantItem__InfoValue NearByRestaurantItem__InfoValue--PriceRange">만원 미만</dd>
                                                    </dl>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </section>
                        </div>
                    </div>
                </div>
            </div>

        </article>
    </main>

    <!-- 이미지 클릭 시 -->
    <div id="mp20_gallery" class="on">
        <style>
            .fotorama1577680126536 .fotorama__nav--thumbs .fotorama__nav__frame{
            padding:2px;
            height:64px}
            .fotorama1577680126536 .fotorama__thumb-border{
            height:60px;
            border-width:2px;
            margin-top:2px}
        </style>
        <div class="fotorama--hidden"></div>
        <div class="picture_area fotorama fotorama1577680126536" data-auto="false">
            <div class="fotorama__wrap fotorama__wrap--css3 fotorama__wrap--slide fotorama__wrap--no-controls" style="width: 579.4px; min-width: 0px; max-width: 100%;">
                <div class="fotorama__stage" style="width: 579px; height: 530px;">
                    <div class="fotorama__stage__shaft fotorama__grab" style="transition-duration: 0ms; transform: translate3d(0px, 0px, 0px); width: 579px; margin-left: 0px;">
                        <div class="fotorama__stage__frame fotorama__loaded fotorama__loaded--img" style="left: -581px;">
                            <img src="https://mp-seoul-image-production-s3.mangoplate.com/882510_1516984909816099.jpg" alt="" class="fotorama__img" style="width: 579px; height: 433.967px; left: 0px; top: 48.0164px;">    
                        </div>
                        <div class="fotorama__stage__frame fotorama__loaded fotorama__loaded--img" style="left: 581px;">
                            <img src="https://mp-seoul-image-production-s3.mangoplate.com/1340_1577594020221350.jpg" alt="" class="fotorama__img" style="width: 397.5px; height: 530px; left: 90.75px; top: 0px;">
                        </div>
                    </div>
                    <div class="fotorama__arr fotorama__arr--prev" tabindex="0" role="button"></div>
                    <div class="fotorama__arr fotorama__arr--next" tabindex="0" role="button"></div>
                    <div class="fotorama__vidio-close"></div>
                </div>
                <div class="fotorama__nav-wrap">
                    <div class="fotorama__nav fotorama__nav--thumbs fotorama__shadows--right" style="width: 579px;">
                        <div class="fotorama__nav__shaft fotorama__grab" style="transition-duration: 0ms; transform: translate3d(0px, 0px, 0px);">
                            <div class="fotorama__thumb-border" style="transition-duration: 0ms; transform: translate3d(66px, 0px, 0px); width: 60px;"></div>
                            <div class="fotorama__nav__frame fotorama__nav__frame--thumb" tabindex="0" role="button" style="width: 64px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div ng-controller="mp20_gallery_controller" class="ng-scope">

        </div>
    </div>
    <div class="black_screen"></div>

    <%@ include file="/WEB-INF/views/common/footer.jsp" %>