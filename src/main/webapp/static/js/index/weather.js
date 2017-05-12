//请求天气
$.ajax({
	url:'/weather/101280601',
	type:'GET',
	dataType:'json',
	success:function(result){
		console.log(result);
		if(result.code==0){
			
			var datas = result.data.result;
			var citynm = datas[0].citynm;
			$('#city').text(citynm);
			
			for(var i=0;i<datas.length;i++){
				var $tb=$('<table></table>');
				var data = datas[i];
				var date = data.days; //日期
				var week = data.week; //星期
				//var citynm = data.citynm; //城市名称
				var temperature = data.temperature; //31℃/24℃
				var weather = data.weather; //天气
				var weather_icon = data.weather_icon;  //http://api.k780.com:88/upload/weather/d/7.gif
				var weather_icon1 = data.weather_icon1; //http://api.k780.com:88/upload/weather/n/7.gif
				
				var wind = data.wind; //无持续风向
				var winp = data.winp; //微风
				var temp_high = data.temp_high; // 31℃
				var temp_low = data.temp_low; //24℃
				
				var $dateTr = $('<tr><td>日期：</td><td>'+date+','+week+'</td></tr>');
				var $weatherTr = $('<tr><td>天气：</td><td>'+weather+'<img src="'+weather_icon+'"></td></tr>');
				var $lowTr = $('<tr><td>最低温度：</td><td>'+temp_low+'℃</td></tr>');
				var $highTr = $('<tr><td>最高温度：</td><td>'+temp_high+'℃</td></tr>');
				var $windTr = $('<tr><td>风向：</td><td>'+wind+','+winp+'</td></tr>');
				
				var $br=$("<br>");
				
				
				$tb.append($dateTr)
				   .append($weatherTr)
				   .append($lowTr)
				   .append($highTr)
				   .append($windTr);
				
				$('#detail').append($tb).append($br);
									
			}
		}
	},
	error:function(){
		alert('Woo~请求失败了');
	}
});