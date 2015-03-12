package com.jshop.action.backstage.utils;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonJson {
	
	public static String parseDataToJson(Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).registerTypeAdapter(java.sql.Date.class, new SQLDateTypeAdapter()).create();
		return gson.toJson(obj);
	}

}
