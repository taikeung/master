package com.andy.grab;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andy.util.JsoupUtil;

import net.sf.json.JSONObject;

/**
 * @ClassName WeatherGrab
 * @Description 抓取天气信息(图片URL： http://m.weather.com.cn/img/b0.gif )
 * @author hudaqiang
 * @Date 2017年5月8日 下午1:53:12
 * @version 1.0.0
 */
public class WeatherGrab {
	
	private static final Logger logger = LoggerFactory.getLogger("WeatherGrab");
	
	public static JSONObject getCityWeather(String city) throws IOException{
		JSONObject retJson = new JSONObject();
		String url = "http://api.k780.com:88/?app=weather.future&weaid="+city+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
		try {
			Document doc = JsoupUtil.getHtmlDoc(url);
			String text = doc.text();
			
			//解析
			retJson = JSONObject.fromObject(text);
		} catch (IOException e) {
			logger.error("抓取"+city+"天气异常:"+e.getMessage());
			throw new IOException("请求天气URL："+url+"异常");
		}
		
		return retJson;
	}
}
