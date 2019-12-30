<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
div.container{
	float: left;
	width: 29%;
	height:300px;
    margin: 10px;
    padding: 10px;
	background:lightgrey;
	text-align:center;
}
table {
	border:1px solid;
	margin:auto;
}
td,th {
	border:1px solid;
}
span#time{
	text-decoration:underline;
	margin: 15px;
    display: block;
}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script>


$(document).ready(function(){ 
 	$.ajax({
 		url : "<%=request.getContextPath()%>/admin/adminchart",
 		type : "post",
 		success : function(data1){
 			google.charts.load('current', {'packages':['bar']});
 		 google.charts.setOnLoadCallback(drawChart);
 		function drawChart(){
 			 var data = new google.visualization.DataTable();
 			  data.addColumn('string', '이번주');
 			  data.addColumn('number', '접속수');
 			console.log(typeof(data1[0].visit_time));
 			console.log(typeof(data1[0].total));
 			  data.addRows([
 			    [data1[0].visit_time, (data1[0].total)],
 			    [data1[1].visit_time, (data1[1].total)],
 			    [data1[2].visit_time, (data1[2].total)],
 			    [data1[3].visit_time, (data1[3].total)],
 			    [data1[4].visit_time, (data1[4].total)],
 			    [data1[5].visit_time, (data1[5].total)],
 			    [data1[6].visit_time, (data1[6].total)]

 			  ]);
 			  var options ={
 			    title: '총 접속수',
 			    height: 450
 			  };
 			  var chart=new google.charts.Bar(document.getElementById('chart_div'));
 			  chart.draw(data, google.charts.Bar.convertOptions(options));
 			
 		}},
 		error : function(jqxhr, textStatus, errorThrown){
 			console.log("인기순위 ajax 처리 실패");
 			//에러로그
 			console.log(jqxhr);
 			console.log(textStatus);
 			console.log(errorThrown);
 		}
 	});
 });



$(document).ready(function(){
 	console.log("dd");
 	$.ajax({
 		url : "<%=request.getContextPath()%>/admin/adminvisit",
 		type : "post",
 		success : function(data){
 			//console.log("rankList:"+data);
			let $table = $("<table></table>") 
 			let html = "<tr><th>아이디</th><th>방문 시간</th><th>누적방문횟수</th></tr>";
 			for(var i in data){
 				var visit = data[i];						
 				html += "<tr><td>"+visit.id+"</td>";
 				html += "<td>"+visit.visit_time+"</td>";
 				html += "<td>"+visit.total+"</td></tr>";
 			}
			$table.append(html);
 			$("#visit").html($table);
 		},
 		error : function(jqxhr, textStatus, errorThrown){
 			console.log("인기순위 ajax 처리 실패");
 			//에러로그
 			console.log(jqxhr);
 			console.log(textStatus);
 			console.log(errorThrown);
 		}
 	});
 });
</script>
</head>
<body>

<div id="chart_div"></div>
	<h2>방문</h2>
	
	<div id="visit"></div>
</div>
</body>
</html>