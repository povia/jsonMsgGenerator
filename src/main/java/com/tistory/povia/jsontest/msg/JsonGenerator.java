package com.tistory.povia.jsontest.msg;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;

public class JsonGenerator {
	public void execute(){
		JSONObject object = new JSONObject();
		object.put("No", 1);
		object.put("message", "안녕하세요!");
		object.put("Date", LocalDateTime.now());
		
		System.out.println(object.toJSONString());
	}
}
