package com.yz.utils;

import com.yz.vo.DustJson;

import net.sf.json.JSONObject;

public class TestMain {
	
	public static void main(String[] args) {
		
		String noiseData = "0n123123";
		if(noiseData!=null&&noiseData.length()>0&&noiseData.substring(0, 1).equals("0"))
		{
			noiseData = noiseData.substring(1, noiseData.length());
		}
		System.out.println(noiseData);

	}

}
