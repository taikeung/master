package com.andy.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.grab.WeatherGrab;

import net.sf.json.JSONObject;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/weather")
public class WeatherAction {
	private static final Logger logger = LoggerFactory.getLogger("WeatherAction");
	
	@ApiIgnore
	@ResponseBody
	@RequestMapping(value = "/{city}",method = RequestMethod.GET)
	public JSONObject getWeatherByCity(@PathVariable(value = "city")String city){
		JSONObject retJson = new JSONObject(); 
		try {
			JSONObject dataJson = WeatherGrab.getCityWeather(city);
			retJson.put("code", "0");
			retJson.put("msg", "请求成功");
			retJson.put("data", dataJson);
		} catch (IOException e) {
			retJson.put("code", "-1");
			retJson.put("msg", e.getMessage());
			retJson.put("data", "");
		}
		
		return retJson;
	}
}
