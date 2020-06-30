package com.tistory.povia.jsontest.msg;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonGenerator {
	public void execute(){
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			int i=0;
//			String nameOs = "os.name";
//			String versionOs = "os.version";
//			String archiOs = "os.arch";
			OperatingSystemMXBean bean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
			RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
			@Override
			public void run() {
//				File[] roots = File.listRoots();
				
				
				
				JSONObject object = new JSONObject();
				JSONArray arr = new JSONArray();
				bean.getAvailableProcessors();
				object.put("Date", LocalDateTime.now());
				object.put("Os Name", bean.getName());
				object.put("Os Version", bean.getVersion());
				object.put("Avg System Load", bean.getSystemLoadAverage());
				object.put("Available Processers", bean.getAvailableProcessors());
				object.put("System Architecture", bean.getArch());
				object.put("Total Physical Memory", bean.getTotalPhysicalMemorySize());
				object.put("Free Physical Memory", bean.getFreePhysicalMemorySize());
				object.put("System CPU Load", bean.getSystemCpuLoad());
				arr.add(object);
				
				object = new JSONObject();
				object.put("Process CPU Load", bean.getProcessCpuLoad());
				object.put("Process CPU Time",bean.getProcessCpuTime());
//				object.put("Process Name",runtimeBean.getName());
//				object.put("Management Spec Version",runtimeBean.getManagementSpecVersion());
//				object.put("JVM Vendor", runtimeBean.getVmVendor());
//				object.put("Library Path", runtimeBean.getLibraryPath());
//				object.put("System Property", runtimeBean.getSystemProperties());
				
				arr.add(object);
				
				System.out.println(arr.toJSONString());
			}
		};
		
		timer.schedule(task, 0, 10000);
		
	}
}
