package com.tistory.povia.jsontest.msg;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.JSONObject;

public class JsonGenerator {
	public void execute(){
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			int i=0;
			String nameOs = "os.name";
			String versionOs = "os.version";
			String archiOs = "os.arch";
			
			@Override
			public void run() {
//				File[] roots = File.listRoots();
				
				
				
				JSONObject object = new JSONObject();
				object.put("Date", LocalDateTime.now());
				object.put("사용 가능 프로세서 수", Runtime.getRuntime().availableProcessors());
				object.put("남은 메모리", Runtime.getRuntime().freeMemory());
				object.put("message", (++i)+"번째 메시지입니다.");
				
				
				System.out.println(object.toJSONString());
			}
		};
		
		timer.schedule(task, 0, 10000);
		
	}
}
