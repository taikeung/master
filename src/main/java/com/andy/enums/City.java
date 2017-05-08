package com.andy.enums;

/**
 * @ClassName City
 * @Description 城市
 * @author hudaqiang
 * @Date 2017年5月8日 下午2:15:04
 * @version 1.0.0
 */
public enum City {
	
	SHENZHEN("101280601","深圳"),
	WUHAN("101200101","武汉"),
	HUANGGANG("101200501","黄冈"),
	JINGZHOU("101200801","荆州"),
	JINHUA("101210901","金华");
	
	private String code; //城市代码
    private String name; //城市名称
	  
    //构造枚举值，比如City("shenzhen","101280601","深圳")  
    private City(String code,String name){  
    	this.code = code;
    	this.name = name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
