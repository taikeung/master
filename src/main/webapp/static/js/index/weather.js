//请求天气
$.ajax({
	url:'/weather/101280601',
	type:'post',
	dataType:'json',
	success:function(result){
		if(result.code==0){
			var data = result.data;
			var city = data.city;
			var low = data.temp1;
			var high = data.temp2;
			var weather = data.weather;
			var img1 = data.img1;
			var img2 = data.img2;
			var ptime = data.ptime;
			
			$cityTr = $('<tr><td>地址：</td><td>'+city+'</td></tr>');
			$lowTr = $('<tr><td>最低温度：</td><td>'+low+'</td></tr>');
			$highTr = $('<tr><td>最高温度：</td><td>'+high+'</td></tr>');
			$weatherTr = $('<tr><td>天气：</td><td>'+weather+'</td></tr>');
			
			$('#weather table').append($cityTr)
							   .append($lowTr)
							   .append($highTr)
							   .append($weatherTr);
			
			var weatherImgBaseUrl = "http://m.weather.com.cn/img/";
			$('#weather').append('<img src="'+weatherImgBaseUrl+img1+'">');
			$('#weather').append('<img src="'+weatherImgBaseUrl+img2+'">');
			
			$('#deadTime').text('截止至'+ptime);
		}
	},
	error:function(){
		alert('Woo~请求失败了');
	}
});