package com.yz.utils;

import com.yz.vo.DustJson;

import net.sf.json.JSONObject;

public class TestMain {
	
	public static void main(String[] args) {
		
		DustJson dustJson = new DustJson();
		dustJson.setData("1");
		JSONObject jsonObject = JSONObject.fromObject(dustJson);
		System.out.println(jsonObject);
	}

}
