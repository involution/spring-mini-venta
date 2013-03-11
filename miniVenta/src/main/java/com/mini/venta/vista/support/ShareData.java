package com.mini.venta.vista.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ShareData {

	private Map<String, Object> mapdata;
	
	public ShareData() {
		mapdata = new HashMap<String, Object>();
	}
	
	public Map<String, Object> getMapData() {
		return mapdata;
	}
	
	public void setMapData(String key, Object object) {
		this.mapdata.put(key, object);
	}
}
